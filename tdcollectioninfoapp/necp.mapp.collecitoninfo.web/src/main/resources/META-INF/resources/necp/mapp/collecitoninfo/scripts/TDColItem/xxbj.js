require(["ecp.service", "ecp.utils.render", 'ecp.model','ecp.utils','ecp.component.dialog'], 
		function(ecpService, renderUtil, ecpModel, ecpUtils, dialog) {
	"use strict";
	// 日志对象
	var log = ecpService.Log;
	/**
	 * 声明函数对象.
	 */
	var PageController = function() {
		//初始化页面
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
			this.initOpenParam();
			var openParam = this.openParam;
			var titleData = openParam.titleData;
			var isize = titleData.length;
			for(var i =0;i<isize;i++){
				 var curData = titleData[i];
				 var xsmc = curData.xsmc;
				 var zdmc = curData.zdmc;
				 
				 
				 var html="";
				 var divField = "shortFieldDiv";
				 var zdmcLowStr = zdmc.toLowerCase();
				 
				 if(zdmcLowStr.indexOf('long_char') >= 0){//日期
						html=createTextAreaHtml(curData);	
						divField = "mainDiv";
				 } else {
					 html=createTextHtml(curData);
				 } 
				 
				
				 $("#"+divField).append(html);
			}
					
			function createTextHtml(viewItemVO){
				var textField ='<input type="text" class="form-control input_underline xxbj__6" autocomplete="off" com="ecp-text" id="【zdid】" ng-model="【zdid】">';
				var numberField ='<input type="text" id="【zdid】" '
					+'datatype="number" class="form-control input_underline ecp-component-numberBox xxbj__6" '
					+'data-option="{\'mask\':\'*#\',\'textAlign\':\'right\',\'borderClass\':\'form-control input_underline\',\'required\':false,\'thousandsSeparator\':true,\'ng-model\':\'【zdid】\',\'scale\':0}"'
					+' com="ecp-component-numberBox" ng-model="【zdid】">';
				var dateField = '<input readonly="" id="【zdid】" class="datepicker form-control input_underline xxbj__12" datatype="date" '
					+'data-inputer="{\'moduleName\':\'qzz.idatepicker\',\'renderFn\':\'qzzdatepicker\'}" type="text" '
					+'data-option="{\'height\':\'28px\',\'underLine\':true,\'width\':\'100%\',\'cyctype\':\'day\',\'fontSize\':\'14px\',\'disabled\':false,\'readOnly\':false,\'showTime\':false,\'disInput\':false,\'ecpDate\':false,\'idkey\':\'id\',\'capkey\':\'text\','
					+'\'ng-model\':\'【zdid】\',\'scale\':0,\'mask\':\'*#\',\'typeId\':\'\',\'classId\':\'\',\'id\':\'【zdid】\'}" com="ecp-qzzdatepicker" ng-model="【zdid】">';
				
				var selectField ='<select class="entitySelectPlace select2-default ecp-component-comboBox form-control input_underline xxbj__15" '
					+'data-option="{\'idField\':\'id\',\'textField\':\'text\',\'data\':【data】,\'placeholder\':\'请选择...\',\'isShowMore\':false,\'forceShowMore\':false,\'pageSize\':\'40\',\'multiple\':false,\'borderClass\':\'form-control  input_underline\',\'noWidth\':true,\'needContext\':true,\'noCache\':false,\'allowClear\':true,\'width\':\'100%\'}" '
					+'com="ecp-select" id="【zdid】" fixdragtype="1" ng-model="【zdid】"><option>请选择...</option></select>'
				

				var xsmc = viewItemVO.xsmc;
				var zdmc = viewItemVO.zdmc;	
				var dataType = viewItemVO.zdlx;	
				var field = textField;
				if(dataType == "1"){
					var zdzs = viewItemVO.zdz.split(",");
					var isize = zdzs.length;
					var zdArray=[];
					for(var i = 0 ; i<isize; i++){
						var curData = {};
						curData.id=zdzs[i];
						curData.text=zdzs[i];
						zdArray.add(curData);
					}
					var zdDataStr = $.toJSON(zdArray).replaceAll('"', '\'');
					selectField = selectField.replaceAll('【data】', zdDataStr);
					field = selectField;
				}
				var html ='<div class="col-1 " candrop="ecp-col">'
					+'<div class="ellipsis xxbj__8" com="ecp-label" id="【bqid】"> 【xsmc】</div>'
					+'</div>'
					+'<div class="col-2" candrop="ecp-col">'
					+field
					+'</div>';

				html = html.replaceAll('【bqid】',zdmc+"_lable");
				html = html.replaceAll('【xsmc】',xsmc+":");
				html = html.replaceAll('【zdid】',zdmc);
				return html;
				
			}	
			function createTextAreaHtml(viewItemVO){
				var xsmc = viewItemVO.xsmc;
				var zdmc = viewItemVO.zdmc;
				 
				var html ='<div class="col-12" candrop="ecp-col">'
					+'<div class="padding-tb-3 xxbj__3" candrop="ecp-rect" >'
					+'<div class="col-12" candrop="ecp-col">'
					+'<div class="xxbj__3" candrop="ecp-rect">'
					+'<div class="col-12 xxbj__11" candrop="ecp-col">'
					+'<div class="ellipsis xxbj__12" com="ecp-label" id="【bqid】"> 【xsmc】</div>'
					+'</div>'
					+'</div>'
					+'</div>'
					+'<div class="col-12" candrop="ecp-col">'
					+'<div class="xxbj__3" candrop="ecp-rect">'
					+'<div class="col-12 xxbj__13" candrop="ecp-col">'
					+'<textarea class="form-control xxbj__14" rows="6"  com="ecp-textarea" id="【zdid】" ng-model="【zdid】"></textarea>'
					+'</div>'
					+'</div>'
					+'</div>'
					+'</div>'
					+'</div>';
				html = html.replaceAll('【bqid】',zdmc+"_lable");
				html = html.replaceAll('【xsmc】',xsmc);
				html = html.replaceAll('【zdid】',zdmc);
				return html;
				
			}	
		},
	    getUrlParam: function(name) {
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if (r != null) {
				return unescape(r[2]);
			}
			return "";
		},
		initOpenParam: function() {
			var options=window._options;
			var param={};
	    	if(options==null){
	    		options={};
	    		options.xmxh=1;
	    		options.gid=1;
	    		options.titleData=[
	    			{xsmc:"序号",zdmc:"mxxh"},
	    			{xsmc:"服务类型",zdmc:"char01"},
	    			{xsmc:"原有服务接口",zdmc:"char02"},
	    			{xsmc:"原服务方法及参数",zdmc:"char03"},
	    			{xsmc:"原服务描述",zdmc:"char04"},
	    			{xsmc:"新方法中文描述、方法、参数说明",zdmc:"long_char01"},
	    			{xsmc:"不提供服务原因",zdmc:"long_char02"},
	    			{xsmc:"服务提供项目组",zdmc:"char09"},
	    			{xsmc:"服务消费模块",zdmc:"char10"}	    			
	    		];
	    	}
    		param.xmxh=options.xmxh;
    		param.gid=options.gid;
    		param.titleData=options.titleData;
    		this.openParam = param;
		},
		/**
		 * 渲染.
		 * 基础控件渲染和统一渲染页面控件
		 */
		render: function() {
			//调用服务端进行渲染
			
			//渲染页面控件
			renderUtil.pageRender($.proxy(this.afterRender, this));
		},
		/**
		 * 渲染后.
		 */
		afterRender: function(map, base) {
			//通过指针调用控件ID即可获取控件对象
			base(this);
			//绑定事件
			this.bindEvent();
			this.loadData();
		},
		/**
		 * 绑定事件.
		 */
		bindEvent: function() {},
		/**
		 * 获取页面数据模型.
		 */
		loadData: function() {
			var _this = this;
			var gid = _this.openParam.gid;
			var xmxh = _this.openParam.xmxh;
			if(gid != null){
				var url = "/necp/mapp/collecitoninfo/query/tDColItem/find?gid="+gid;
				 ecpService.RemoteService.doGetAsync(url, null, function (result) {
					 if (result.isSuccess()) {
						 var data = result.data;
						 if(data == null){
								ecpUtils.notify("未找到数据");
						 }else{
//							 _this.TdColItem= data;
							 _this.dataModel = data;
							 _this.bindDataSource();
						 }
					 } else {
						 dialog.dialog({title: '提示',content:result.errorMsg});
					 }
				 });
			}else {
				_this.dataModel={};
				 _this.bindDataSource();
			}
				
		},
		saveData: function(fun) {
			var date = this.dataModel;
			if(date.gid != null){
				var url = "/necp/mapp/collecitoninfo/service/tDColItem/update";
				 ecpService.RemoteService.doPostAsync(url, date, function (result) {
					 if (result.isSuccess()) {
							if(fun){
								fun.call();
							}
					 } else {
						 dialog.dialog({title: '提示',content:result.errorMsg});
					 }
				 });
			} else {
				date.xmxh = this.openParam.xmxh;
				var url = "/necp/mapp/collecitoninfo/service/tDColItem/addColItem";
				 ecpService.RemoteService.doPostAsync(url, date, function (result) {
					 if (result.isSuccess()) {
							if(fun){
								fun.call();
							}
					 } else {
						 dialog.dialog({title: '提示',content:result.errorMsg});
					 }
				 });
			}
				
		},
		/**
		 * 绑定数据源.
		 */
		bindDataSource: function() {
			this.dataSource = new ecpModel.DataSource();
			this.dataSource.dataModel = this.dataModel||{};
			this.dataSource.bind($("body"));
		}
	}
	/**
	 * 开始执行.
	 */
	var controller = new PageController();
	controller.render();

	window.pageController=controller;
})
