/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.boot;

import com.ygsoft.ecp.core.boot.Application;
import com.ygsoft.ecp.core.boot.run.ApplicationBuilder;
import com.ygsoft.ecp.core.boot.swagger.EnableEcpSwagger;

/**
 * 项目启动类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:06:41<br>
 * @since JDK 1.8.0_152
 */
//@MicroService(serviceRegisterUrl = "http://127.0.0.1:8761", contextPath = "/", port = 8080, region = "", name = "", vipAddress = "/necp/mapp/collecitoninfo")
//@MicroService(serviceRegisterUrl = "http://eureka.ygcloud.com", contextPath = "/", port = 8080, region = "necp", name = "mapp.collecitoninfo", vipAddress = "/necp/mapp/collecitoninfo")
@EnableEcpSwagger
//(basePackage = "com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.service")
//@DataSource
public class CollectionInfoMain extends Application {
	public static void main(String[] args) {
		new ApplicationBuilder(CollectionInfoMain.class).run(args);
	}
}
