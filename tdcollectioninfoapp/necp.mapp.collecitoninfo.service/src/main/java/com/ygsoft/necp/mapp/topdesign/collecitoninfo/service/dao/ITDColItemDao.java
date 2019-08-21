/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.dao;

import org.springframework.stereotype.Repository;

import com.ygsoft.necp.component.genentity.spec.IGenEntityDao;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColItem;

/**
 * ITDColItemDao数据访问类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:06:41<br>
 * @since JDK 1.8.0_152
 */
@Repository
public interface ITDColItemDao extends IGenEntityDao<TDColItem, String> {
	
}
