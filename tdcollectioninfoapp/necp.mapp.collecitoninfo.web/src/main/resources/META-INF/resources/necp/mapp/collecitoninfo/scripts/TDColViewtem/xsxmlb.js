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
	    	}
    		param.xmxh=options.xmxh;
    		this.openParam = param;
		},
		/**
		 * 渲染.
		 * 基础控件渲染和统一渲染页面控件
		 */
		render: function() {
			//渲染页面控件
			renderUtil.pageRender($.proxy(this.afterRender, this));
		},
		/**
		 * 渲染后.
		 */
		afterRender: function(map, base) {
			//通过指针调用控件ID即可获取控件对象
			base(this);
			this.setUI();
			//绑定事件
			this.bindEvent();
			this.loadData();
		},

		setUI:function(){
			var _this =this;
			var winH = $(window).height();
			_this.root.setHeight(winH - 250);

//			var data ={} ;
//			data['gid'] = 'gid';
//			data['mxxh'] = 'mxxh';
//			data['xmxh'] = 'xmxh';
//			data['char01'] = 'char01';
//			data['char02'] = 'char02';
//			data['char03'] = 'char03';
//			data['char04'] = 'char04';
//			data['char05'] = 'char05';
//			data['char06'] = 'char06';
//			data['char07'] = 'char07';
//			data['char08'] = 'char08';
//			data['char09'] = 'char09';
//			data['char10'] = 'char10';
//			data['char11'] = 'char11';
//			data['char12'] = 'char12';
//			data['char13'] = 'char13';
//			data['char14'] = 'char14';
//			data['char15'] = 'char15';
//			data['long_char01'] = 'long_char01';
//			data['long_char02'] = 'long_char02';
//			data['long_char03'] = 'long_char03';
//			data['long_char04'] = 'long_char04';
//			data['long_char05'] = 'long_char05';
//			data['num01'] = 'num01';
//			data['num02'] = 'num02';
//			data['num03'] = 'num03';
//			data['num04'] = 'num04';
//			data['num05'] = 'num05';
//			data['long_num01'] = 'long_num01';
//			data['long_num02'] = 'long_num02';
//			data['long_num03'] = 'long_num03';
//			data['long_num04'] = 'long_num04';
//			data['long_num05'] = 'long_num05';
//			data['date01'] = 'date01';
//			data['date02'] = 'date02';
//			data['date03'] = 'date03';
//			data['date04'] = 'date04';
//			data['date05'] = 'date05';
//			data['ownerid'] = 'ownerid';
//			data['f_bizstate'] = 'f_bizstate';
//			_this.root.addTransIDName('zdmc',data);
		       //绑定编辑事件
		    _this.root.bind('onCanEditing',function(grd, fieldName, canEdit) {
		           //列只读
		           if(fieldName == 'xsxh' || fieldName == 'xmxh') {
		               return false;
		           }
		           return canEdit;
		       });
				
		},
		/**
		 * 绑定事件.
		 */
		bindEvent: function() {
			var _this =this;
			$("body").on("click", "#addBtn", function(e) {
				_this.addData();
			});
			$("body").on("click", "#delBtn", function(e) {
				_this.delData()
			});
			$("body").on("click", "#upMoveBtn", function(e) {
				_this.moveRow(-1)
			});
			$("body").on("click", "#downMoveBtn", function(e) {
				_this.moveRow(1)
			});
			$("body").on("click", "#exportBtn", function(e) {
				_this.updateSfty(0,"启用")
			});
		},
		moveRow:function(moveType){
            this.root.moveRecord(moveType);
		},	
		addData:function(){
			var _this = this;
			var data = _this.root.value();
			var addData = {gid:'',xsxh:'',xmxh:_this.openParam.xmxh,zdmc:'',xsmc:'',zdlx:0,zdz:'',sfcxtj:0};
			data.add(addData);
			 _this.root.value(data);
			
		},
		delData:function(){
			var _this = this;
			var data = _this.root.getSelectedRowData();
			if (data == null) {
				ecpUtils.notify("请先选择一条记录进行删除");
				return;
			}
			var gid = _this.root.getSelectRowIds();
			if(gid !=null && gid !=""){
				var url = "/necp/mapp/collecitoninfo/service/tDColViewtem/deleteGid?gid="
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
								} else {
									dialog
											.dialog({
												title : '提示',
												content : result.errorMsg
											});
								}
							});
			}
            _this.root.delRecord();
			
			
		},
		/**
		 * 获取页面数据模型.
		 */
		loadData: function() {
			var _this = this;
			var xmxh = _this.openParam.xmxh;
			if(xmxh != null){
				var url = "/necp/mapp/collecitoninfo/query/tDColViewtem/findColViewtemByXmxh?xmxh="+xmxh;
				 ecpService.RemoteService.doGetAsync(url, null, function (result) {
					 if (result.isSuccess()) {
						 var data = result.data;
						 if(data == null){
								ecpUtils.notify("未找到数据");
						 }else{
							 _this.root.value(data);
						 }
					 } else {
						 dialog.dialog({title: '提示',content:result.errorMsg});
					 }
				 });
			}else {
				ecpUtils.notify("程序错误，未找到对应的收集项目信息。");
			}
				 
		},
		saveData: function(fun) {
			var _this = this;
			_this.root.post();
			var data = _this.root.value();
			var xmxh = ""+_this.openParam.xmxh;
			var url = "/necp/mapp/collecitoninfo/service/tDColViewtem/saveData?xmxh="+xmxh;
			 ecpService.RemoteService.doPostAsync(url, data, function (result) {
				 if (result.isSuccess()) {
						if(fun){
							fun.call();
						}
				 } else {
					 dialog.dialog({title: '提示',content:result.errorMsg});
				 }
			 });
				
		},
		/**
		 * 绑定数据源.
		 */
		bindDataSource: function() {
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
	window.pageController=controller;
})
