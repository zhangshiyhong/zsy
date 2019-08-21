/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.necp.component.genentity.spec.GenEntityQueryService;
import com.ygsoft.necp.core.service.dcispec.EcpGetMapping;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context.ITDColViewtemContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColViewtem;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.service.ITDColViewtemQueryService;

/**
 * TDColViewtemQueryService查询服务类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:48:31<br>
 * @since JDK 1.8.0_152
 */
@RestController
@RequestMapping("/necp/mapp/collecitoninfo/query/tDColViewtem")
public class TDColViewtemQueryService extends GenEntityQueryService<TDColViewtem, ITDColViewtemContext>
		implements ITDColViewtemQueryService {
	@Autowired
	ITDColViewtemContext context;
	
	@EcpGetMapping("findColViewtemByXmxh")
	@ResponseBody
	public List<TDColViewtem> findColViewtemByXmxh(@RequestParam String xmxh){
		Map paramMap = new HashMap();
		paramMap.put("xmxh", xmxh);
		return context.findTop1000(paramMap, "xsxh", "");
	}

}
