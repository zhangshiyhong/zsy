require(
		[ "ecp.service", "ecp.utils.render", 'ecp.model',
				'ecp.component.comboBox', 'ecp.component.dialog', 'ecp.utils' , "ecp.export"],
		function(ecpService, renderUtil, ecpModel, comboBox, dialog, ecpUtils, ecpExport) {
			"use strict";
			// 日志对象
			var log = ecpService.Log;
			/**
			 * 声明函数对象.
			 */
			var PageController = function() {
				// 初始化页面
				this.initPage();
			}
			/**
			 * 通过原型定义相关方法，比如渲染、赋值等等.
			 */
			PageController.prototype = {
				/**
				 * 初始化页面.
				 */
				initPage : function() {
					// todo

				},
				getUrlParam : function(name) {
					var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
					var r = window.location.search.substr(1).match(reg);
					if (r != null) {
						return unescape(r[2]);
					}
					return "";
				},
				/**
				 * 渲染. 基础控件渲染和统一渲染页面控件
				 */
				render : function() {
					renderUtil.pageRender($.proxy(this.afterRender, this));
				},

				/**
				 * 渲染后.
				 */
				afterRender : function(map, base) {
					// 通过指针调用控件ID即可获取控件对象
					base(this);
					//
					this.setUI();
					// 绑定事件
					this.bindEvent();
					this.loadData();
				},
				/**
				 * 设置UI.
				 */
				setUI : function() {
					var _this = this;
					var winH = $(window).height();
					_this.root.setHeight(winH - 250);

					var xmxh = _this.getUrlParam("xmxh");
					if (xmxh != null && xmxh != "") {
						_this.resetTitle(xmxh);
					}
					var paramObj ={"sfty":0};
					var param=$.toJSON(paramObj);
					// 设置项目序号选择条件
//					var url = "/necp/mapp/collecitoninfo/query/tDColProject/findListByOption?param="+param;
					var url = "/necp/mapp/collecitoninfo/query/tDColProject/findListByOption";
					ecpService.RemoteService.doPostAsync(url, {"sfty":0}, function(
							result) {
						if (result.isSuccess()) {
							var datas = result.data;
							var isize = datas.length;
							var dataArray = [];
							var defaultObj = null
							for (var i = 0; i < isize; i++) {
								var curData = datas[i];
								var curObj = {};
								curObj.id = curData.xmxh;
								curObj.text = curData.xmmc;
								dataArray.add(curObj);
								if (xmxh != null && curObj.id == xmxh) {
									defaultObj = curObj;
								}
							}
							var option = {
								idField : 'id',
								textField : 'text',
								borderClass : 'form-control  input_underline',
								placeholder : '请选择...',
								data : dataArray
							}
							// 渲染通用下拉控件
							var cb = $('#xmlx').comboBox(option);
							if (defaultObj != null) {
								// 设置项目选择不可用
								cb.disable();
								$('#xmlx').comboBox(true).value([ defaultObj ])
							}
							//设置事件
							cb.bind('change', function() {
								var data = $('#xmlx').comboBox(true).value();
								if(data != null){
									_this.resetTitle(data.id);
								}
							})
						} else {
							dialog.dialog({
								title : '提示',
								content : result.errorMsg
							});
						}
					});

					_this.setBtnDisable();
				},
				isBtnUse:function(){
					var xmxh = this.getXmxh();
					if(xmxh ==null){
						return false;
					}
					return true;
				},
				/**
				 * 设置按钮权限
				 */
				setBtnDisable:function(){
					var _this =this;
					var qx = _this.getUrlParam("qx");
					if(qx == null || qx == ""){
						$("#addBtn").attr("disabled",true);
						$("#delBtn").attr("disabled",true);
					} else {
						var length = qx.length;
						isDisable(1,qx,"addBtn");
						var index = 3;
						var eleid = "delBtn";
						if(length>=index){
							isDisable(index,qx,eleid);
						}else {
							$("#"+eleid).attr("disabled",true);
						}
					}
					function isDisable(index,qx,btnid){
						var subQx = qx.substring(index-1,index);
						if(subQx == "1"){
							$("#"+btnid).attr("disabled",false);
						}else{
							$("#"+btnid).attr("disabled",true);
						}
					}
				},
				/**
				 * 设置表格列
				 */
				createColModelItem : function(zdmc) {
					var item = {};
					item.name = zdmc;
					var zdmcLowStr = zdmc.toLowerCase();
					if (zdmcLowStr.indexOf("num") >= 0) {// 整数
						item.item = "number";
						if (zdmcLowStr.indexOf("num") > 0) {// 浮点
							item.scale = 2;
						}
					} else if (zdmcLowStr.indexOf('date') >= 0) {// 日期
						item.editType = "date";
					} else {
						item.editType = "text";
					}
					return item;
				},
				/**
				 * 设置表头
				 */
				resetTitle : function(xmxh) {
					var _this = this;
					var url = "/necp/mapp/collecitoninfo/query/tDColViewtem/findColViewtemByXmxh?xmxh="
							+ xmxh;
					ecpService.RemoteService.doGetAsync(url, null, function(
							result) {
						if (result.isSuccess()) {
							var datas = result.data;
							_this.titleData = datas;//标题数据
							var queryConditonVO =[];//查询条件
							var isize = datas.length;
							var colNames = [];
							var colModels = [];
							for (var i = 0; i < isize; i++) {
								var curData = datas[i];
								colNames.add(curData.xsmc);
								var zdmc = curData.zdmc;
								var item = _this
										.createColModelItem(curData.zdmc);
								colModels.add(item);
								
								//设置查询条件
								if(curData.sfcxtj ==1){
									queryConditonVO.add(curData);
								}
							}
							_this.root.refreshTitle({
								"colNames" : colNames,
								"colModels" : eval(colModels)
							});
							_this.root.value([]);
							_this.resetQueryCondition(queryConditonVO);
						} else {
							dialog.dialog({
								title : '提示',
								content : result.errorMsg
							});
						}
					});
				},
				/**
				 * 设置查询条件
				 */
				resetQueryCondition:function(queryConditonVO){
					var _this = this;
					var preLableDiv="lablediv_";
					var preCondDiv="conddiv_";
					var queryCond="queryCond_";
					_this.queryCond = queryCond;
					//删除查询条件
					$("div[id^="+preLableDiv+"]").remove();
					$("div[id^="+preCondDiv+"]").remove();
					var txtField = '<input type="text" class="form-control input_underline xxbj__6" autocomplete="off" com="ecp-text" id="【queryID】" >';
					var selectField = '<select id="【queryID】"  class="form-control  input_underline" ></select>';

					var ilength = queryConditonVO.length;
					var  maxNum = ilength;//最大条件数据
					var isize = maxNum>=ilength?ilength:maxNum;
					var subHtml = txtField;
					for(var i = 0 ;i<isize ;i++){
						var curData = queryConditonVO[i];
						var zdmc= curData.zdmc;
						var xsmc= curData.xsmc;
						var zdlx= curData.zdlx;
						var zdz= curData.zdz;
						if(zdlx == "1"){
							subHtml = selectField;
						}else {
							subHtml = txtField;
						}
						var html = '<div class="col-1" candrop="ecp-col" id="【lablediv】">'
							+'<div com="ecp-label"  class="ellipsis xxsj__6">【xsmc】：</div>'
							+'</div>'
							+'<div class="col-2" candrop="ecp-col" id="【conddiv】">'
							+ subHtml									
							+'</div>';
						var lablediv=preLableDiv+zdmc
						html = html.replaceAll('【lablediv】',lablediv);
						var conddiv=preCondDiv+zdmc
						html = html.replaceAll('【conddiv】',conddiv);

						html = html.replaceAll('【xsmc】',xsmc);
						var queryCondId=queryCond+zdmc
						html = html.replaceAll('【queryID】',queryCondId);
						$("#queryDiv").append(html);

						if(zdlx == "1"){
							setSelectData(queryCondId,zdz);
						}
					}
					function setSelectData(queryCondId,zdz){
						var zdzs = zdz.split(",");
						var isize = zdzs.length;
						var zdArray=[];
						for(var i = 0 ; i<isize; i++){
							var curData = {};
							curData.id=zdzs[i];
							curData.text=zdzs[i];
							zdArray.add(curData);
						}
						var option = {
								idField : 'id',
								textField : 'text',
								borderClass : 'form-control  input_underline',
								placeholder : '请选择...',
								data : zdArray
							}
							// 渲染通用下拉控件
							$('#'+queryCondId).comboBox(option);
					}
					
				},
				/**
				 * 绑定事件.
				 */
				bindEvent : function() {
					var _this = this;
					$("body").on("click", "#addBtn", function(e) {
						if(!_this.isBtnUse()){
							return ;
						}
						_this.openWindow();
					});
					$("body").on("click", "#queryBtn", function(e) {
						if(!_this.isBtnUse()){
							return ;
						}
						_this.queryData();
					});
					$("body").on("click", "#editBtn", function(e) {
						if(!_this.isBtnUse()){
							return ;
						}
						var gid = _this.root.getSelectRowIds();
						if (gid == null || gid == "") {
							ecpUtils.notify("请先选择一条记录");
							return;
						}
						_this.openWindow(gid);
					});
					$("body").on("click", "#exportBtn", function(e) {
						if(!_this.isBtnUse()){
							return ;
						}
						var xmlxObj = $("#xmlx").comboBox(true).value();
						if(xmlxObj == null){
							ecpUtils.notify("请选择项目类型后再导出！");
							return;
						}
						
						var fileName = xmlxObj.text;
				        var userData = [];
						userData.add(_this.root.getHeader(true, false));
						userData.add(_this.root.getDisplayAsArray());
						ecpExport.doExport({
							fileName:fileName,
							type: "xlsx",
							showExportFormat: false,
							chooseType: true,
							dataList: [{
								"userData": userData
							}]
						});
					});
					$("body")
							.on(
									"click",
									"#delBtn",
									function(e) {
										var gid = _this.root.getSelectRowIds();
										if (gid == null || gid == "") {
											ecpUtils.notify("请先选择一条记录进行删除");
											return;
										}
										var url = "/necp/mapp/collecitoninfo/service/tDColItem/deleteGid?gid="
												+ gid;
										ecpService.RemoteService
												.doPostAsync(
														url,
														null,
														function(result) {
															if (result
																	.isSuccess()) {
																ecpUtils
																		.notify("删除数据成功");
																_this
																		.queryData();
															} else {
																dialog
																		.dialog({
																			title : '提示',
																			content : result.errorMsg
																		});
															}
														});
									});
				},

				openWindow : function(gid) {
					var _this = this;
					var title = "修改";
					if (gid == null || gid == "") {
						title = "新增";
					}

					var xmxh = _this.getXmxh();
					var param = {};
					param.xmxh = xmxh;
					param.titleData = _this.titleData;
					if (gid != null) {
						param.gid = gid;
					}
					dialog
							.show({
								title : title, // 模态窗标题
								iframeMode : {
									url : 'xxbj.html', // 访问的页面地址
									options : param
								// 可选
								},
								showCloseButton : false, // 不显示关闭按钮
								otherButtons : [ '保存', '关闭' ], // 增加两个按钮
								otherButtonStyles : [ 'btn-default',
										'btn-primary' ], // 按钮样式,
								fullScreenMode : true, // 根据具体显示需要配置该参数，缺省该参数时建议配置width和height选项
								clickButton : function(sender, modal, index) {
									if (index == 1) { // 关闭按钮
										modal.modal('hide'); // 点击取消关闭模态窗
									}
									if (index == 0) { // 保存按钮
										$("iframe")
												.each(
														function() {
															var src = $(this)
																	.attr("src");
															if (src != null
																	&& src
																			.indexOf("xxbj.html") >= 0) {
																var subController = this.contentWindow.pageController;
																subController
																		.saveData(function() {
																			_this
																					.queryData();
																			modal
																					.modal('hide');
																			ecpUtils
																					.notify("保存成功");
																		})
															}
														});
									}
								}
							});
				},
				/**
				 * 查询数据.
				 */
				queryData : function() {
					var _this = this;
					var paramMap = this.getParamMap();
					var url = "/necp/mapp/collecitoninfo/query/tDColItem/findItemData";
					ecpService.RemoteService.doPostAsync(url, paramMap,
							function(result) {
								if (result.isSuccess()) {
									var datas = result.data;
									_this.root.value(datas);
								} else {
									dialog.dialog({
										title : '提示',
										content : result.errorCode
									});
								}
							});

				},
				getParamMap : function() {
					var _this =this;
					var param = {};
					param.xmxh = this.getXmxh();
					//TODO
					var zds="";
					var queryCond=_this.queryCond;
					$("input[id^="+queryCond+"]").each(function(i,item){
						var value = item.value;
						if(value != null && value!=""){
							var zdmc = item.id.replace(queryCond,"");
							param[zdmc] = value;
							zds+=zdmc+","
						}
					});
					$("select[id^="+queryCond+"]").each(function(i,item){
						var obj = $(item).comboBox(true).value();
						if(obj != null ){
							var zdmc = item.id.replace(queryCond,"");
							var value = obj.id;
							param[zdmc] = value;
							zds+=zdmc+","
						}
					});
					param.zds = zds
					return param;
				},

				getXmxh : function() {
					var id= 1;
					var obj = $('#xmlx').comboBox(true).value();
					if(obj != null){
						id = obj.id;
					} else {
						ecpUtils
								.notify("请选择项目");
						return ;
					}
					return id;
				},
				/**
				 * 获取页面数据模型.
				 */
				loadData : function() {

				},
				/**
				 * 绑定数据源.
				 */
				bindDataSource : function() {
					this.dataSource = new ecpModel.DataSource();
					this.dataSource.dataModel = this.dataModel;
					this.dataSource.bind($("body"));
				}
			}
			/**
			 * 开始执行.
			 */
			var controller = new PageController();
			controller.render();
		})
