/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.ecp.service.tool.StringUtil;
import com.ygsoft.necp.component.genentity.spec.GenEntityQueryService;
import com.ygsoft.necp.core.service.dcispec.EcpPostMapping;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context.ITDColItemContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColItem;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.service.ITDColItemQueryService;

/**
 * TDColItemQueryService查询服务类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:06:41<br>
 * @since JDK 1.8.0_152
 */
@RestController
@RequestMapping("/necp/mapp/collecitoninfo/query/tDColItem")
public class TDColItemQueryService extends GenEntityQueryService<TDColItem, ITDColItemContext>
		implements ITDColItemQueryService {
	@Autowired
	ITDColItemContext context;

	@EcpPostMapping("findItemData")
	@ResponseBody
	public List<TDColItem> findItemData(@RequestBody final Map paramMap) {
		final Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("xmxh", paramMap.get("xmxh"));
		final String zds =  String.valueOf( paramMap.get("zds"));
		if (StringUtil.isNotEmpty(zds)) {
			zds.substring(0,zds.length()-1);//去掉最后一个“，”
			final String[] zdArray = zds.split(",");
			for (String zdstr : zdArray) {
				queryMap.put(zdstr, paramMap.get(zdstr));
			}
		}
		return context.findTop1000(queryMap, "mxxh", "");
	}

}
