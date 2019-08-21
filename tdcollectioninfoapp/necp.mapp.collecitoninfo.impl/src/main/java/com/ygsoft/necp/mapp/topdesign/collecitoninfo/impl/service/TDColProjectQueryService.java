/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.necp.component.genentity.spec.GenEntityQueryService;
import com.ygsoft.necp.core.service.dcispec.EcpGetMapping;
import com.ygsoft.necp.core.service.dcispec.EcpPostMapping;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context.ITDColProjectContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColProject;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.service.ITDColProjectQueryService;

/**
 * TDColProjectQueryService查询服务类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:48:31<br>
 * @since JDK 1.8.0_152
 */
@RestController
@RequestMapping("/necp/mapp/collecitoninfo/query/tDColProject")
public class TDColProjectQueryService extends GenEntityQueryService<TDColProject, ITDColProjectContext>
		implements ITDColProjectQueryService {
	
	@EcpGetMapping("findAllProject")
	@ResponseBody
	public List<TDColProject> findAllProject(){
		return this.getContext().findAllProject();
	}

//	@EcpPostMapping("findListByOption")
//	@ResponseBody
//	public List<TDColProject> findListByOption(@RequestParam final String param){
//		Map<String, String> paramMap = JSONUtil.fromJsonString(param, HashMap.class);
//		return this.getContext().findListByOption(paramMap);
//	}
	@EcpPostMapping("findListByOption")
	@ResponseBody
	public List<TDColProject> findListByOption(@RequestBody final Map paramMap){
//		Map<String, String> paramMap = JSONUtil.fromJsonString(param, HashMap.class);
		return this.getContext().findListByOption(paramMap);
	}
}
