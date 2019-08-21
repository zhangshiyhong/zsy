/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context;

import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColItem;

import org.springframework.web.bind.annotation.RequestBody;

import com.ygsoft.necp.component.genentity.spec.IGenEntityContext;

/**
 * ITDColItemContext场景接口类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:06:41<br>
 * @since JDK 1.8.0_152
 */
public interface ITDColItemContext extends IGenEntityContext<TDColItem, String> {

	
	TDColItem addColItem(@RequestBody TDColItem addVO);
}
