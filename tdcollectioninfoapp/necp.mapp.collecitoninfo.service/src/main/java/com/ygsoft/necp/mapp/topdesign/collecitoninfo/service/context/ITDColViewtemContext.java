/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context;

import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColViewtem;

import java.util.List;

import com.ygsoft.necp.component.genentity.spec.IGenEntityContext;

/**
 * ITDColViewtemContext场景接口类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:53:47<br>
 * @since JDK 1.8.0_152
 */
public interface ITDColViewtemContext extends IGenEntityContext<TDColViewtem, String> {
	/**
	 * 保存数据，先删后插.
	 * @param xmxh
	 * @param dataList
	 */
	void saveData(int xmxh,List<TDColViewtem> dataList);
}
