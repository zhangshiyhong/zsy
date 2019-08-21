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
		initPage: function() {
			// todo
			var winH = $(window).height();
			$(".gridRect").css('height', winH - 320);
		},
		/**
		 * 渲染. 基础控件渲染和统一渲染页面控件
		 */
		render: function() {
			// 渲染页面控件
			renderUtil.pageRender($.proxy(this.afterRender, this));
			

		},
		/**
		 * 渲染后.
		 */
		afterRender: function(map) {
			if (map) {
				for (var i in map) {
					this[i] = map[i];
				}
			}

			var _this = this;
			var winH = $(window).height();
			_this.root.setHeight(winH - 250);
			// 绑定事件
			this.bindEvent();
			this.getPageDataModel();
			this.queryData();
		},
		/**
		 * 绑定事件.
		 */
		bindEvent: function() {
			var _this = this;
			var grid_root = _this["root"]
			var me = _this
			if (grid_root) {
				var gridData_root = grid_root.value();
				var pageSize_root = grid_root.getPageSize();
				grid_root.setTotalRecord(gridData_root.length, false);
				grid_root.value(gridData_root.slice(0, pageSize_root));
				grid_root.bind("onPageChanged", function(pageCount, pageSize, pageIndex) {
					var data = gridData_root.slice(pageSize * (pageIndex - 1), pageSize + pageSize * (pageIndex - 1));
					grid_root.value(data);
				});
				me.afterLoadDataTasks = me.afterLoadDataTasks || [];
				me.afterLoadDataTasks.push(function() {
					grid_root.value(gridData_root.slice(0, pageSize_root));
				})
			}
			
			

			$("body").on("click", "#queryBtn", function(e) {
				_this.queryData();
			});
			$("body").on("click", "#addBtn", function(e) {
				_this.addData();
			});
			$("body").on("click", "#stopBtn", function(e) {
				_this.updateSfty(1,"停用")
			});
			$("body").on("click", "#startBtn", function(e) {
				_this.updateSfty(0,"启用")
			});
			$("body").on("click", "#delBtn", function(e) {
				var gid = _this.root.getSelectRowIds();
				if (gid == null || gid == "") {
					ecpUtils.notify("请先选择一条记录进行删除");
					return;
				}
				var url = "/necp/mapp/collecitoninfo/service/tDColProject/deleteByProjectId?gid="
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
			$("body").on("click", "#setBtn", function(e) {
				_this.setData();
			});
			$("body").on("click", "#saveBtn", function(e) {
				_this.saveData();
			});
			$("body").on("click", "#exportBtn", function(e) {
				var fileName = "信息收集项目";
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
		},
		setData : function() {			
			var _this = this;
			var curData = _this.root.getSelectedRowData();
			if (curData == null || curData.length == 0) {
				ecpUtils.notify("请先选择一条记录进行设置");
				return;
			}
			var title = "设置显示数据";

			var param = {};
			param.xmxh = curData.xmxh;
			param.gid = curData.gid;
			param.xmxh = curData.xmxh;
			dialog
					.show({
						title : title, // 模态窗标题
						iframeMode : {
							url : '../TDColViewtem/xsxmlb.html', // 访问的页面地址
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
																	.indexOf("/TDColViewtem/xsxmlb.html") >= 0) {
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
		delData:function(){
			var _this = this;
			var data = _this.root.getSelectedRowData();
			if (data == null) {
				ecpUtils.notify("请先选择一条记录进行删除");
				return;
			}
			var gid = _this.root.getSelectRowIds();
			if(gid !=null || gid !=""){
				var url = "/necp/mapp/collecitoninfo/service/tDColProject/deleteGid?gid="
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
						            grid.delRecord();
								} else {
									dialog
											.dialog({
												title : '提示',
												content : result.errorMsg
											});
								}
							});
			} else {
	            grid.delRecord();
			}
			
			
		},
		addData:function(){
			var _this = this;
			var data = _this.root.value();
			var addData = {xmxh:'',xmmc:'','sfty':0};
			data.add(addData);
			 _this.root.value(data);
			
		},
		saveData:function(){
			var _this = this;
			_this.root.post();
			var data = _this.root.value();
			if (data == null || data.length == 0) {
				ecpUtils.notify("没有数据无需保存");
				return;
			}
			var isize = data.length;
			for(var i =0 ;i<isize ; i++){
				var curData = data[i];
				if(curData.xmmc == null || curData.xmmc ==""){
					ecpUtils.notify("项目名称不能为空");
					return;
				}
			}
			var url = "/necp/mapp/collecitoninfo/service/tDColProject/saveData";
			ecpService.RemoteService
					.doPostAsync(
							url,
							data,
							function(result) {
								if (result
										.isSuccess()) {
									ecpUtils
											.notify("保存 操作完成");
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
		},
		updateSfty:function(sfty,title){
			var _this = this;
			var data = _this.root.getSelectedRowData();
			if (data == null) {
				ecpUtils.notify("请先选择一条记录进行"+title);
				return;
			}
			data.sfty = sfty;
			var url = "/necp/mapp/collecitoninfo/service/tDColProject/update";
			ecpService.RemoteService
					.doPostAsync(
							url,
							data,
							function(result) {
								if (result
										.isSuccess()) {
									ecpUtils
											.notify(title+ " 操作完成");
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
		},
		queryData:function(){
			var _this =this;
			var param = {};
			var xmmc = $("#xmmc").val();
			if(xmmc != null & xmmc !=""){
				param.xmmc = xmmc;
			}
			var url = "/necp/mapp/collecitoninfo/query/tDColProject/findListByOption";
			ecpService.RemoteService.doPostAsync(url, param, function(
					result) {
				if (result.isSuccess()) {
					var data = result.data;
					_this["root"].value(data);
				} else {
					dialog.dialog({
						title : '提示',
						content : result.errorMsg
					});
				}
			});
		},
		/**
		 * 获取页面数据模型.
		 */
		getPageDataModel: function() {
			// @getPageDataModel
			// @getPageDataModel
		},
		/**
		 * 绑定数据源.
		 */
		bindDataSource: function() {
			var dataModelItems = this.pageDataModel.items || [];
			var dataModelItem = dataModelItems[0];
			this.dataSource = new ecpModel.DataSource();
			this.dataSource.dataModel = dataModelItem;
			this.dataSource.bind($("body"));
		}
	}
	/**
	 * 开始执行.
	 */
	var controller = new PageController();
	controller.render();
})
