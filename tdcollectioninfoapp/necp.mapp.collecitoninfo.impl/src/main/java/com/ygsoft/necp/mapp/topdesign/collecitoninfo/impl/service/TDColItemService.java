/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.necp.component.genentity.spec.GenEntityService;
import com.ygsoft.necp.core.service.dcispec.EcpPostMapping;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context.ITDColItemContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColItem;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.service.ITDColItemService;

/**
 * TDColItemService服务类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:06:41<br>
 * @since JDK 1.8.0_152
 */
@RestController
@RequestMapping("/necp/mapp/collecitoninfo/service/tDColItem")
public class TDColItemService extends GenEntityService<TDColItem, ITDColItemContext>
		implements ITDColItemService {
	@Autowired
	ITDColItemContext context;
	
	
	@EcpPostMapping("addColItem")
	@ResponseBody
	public TDColItem addColItem(@RequestBody TDColItem addVO) {
		return context.addColItem(addVO);
	}
	
}
