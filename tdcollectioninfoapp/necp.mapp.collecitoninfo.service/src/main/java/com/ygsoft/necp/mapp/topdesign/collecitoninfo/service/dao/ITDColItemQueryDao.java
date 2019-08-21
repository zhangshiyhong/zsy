/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.dao;

/**
 * ITDColItemDao数据访问类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:06:41<br>
 * @since JDK 1.8.0_152
 */


public interface ITDColItemQueryDao {
	/**
	 * 获取最大的项目序号
	 * @param xmxh
	 * @return
	 */
	int findMaxMxxh(int xmxh);
}
