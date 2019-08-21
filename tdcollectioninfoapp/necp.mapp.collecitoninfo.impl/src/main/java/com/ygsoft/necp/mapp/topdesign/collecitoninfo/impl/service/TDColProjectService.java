/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.necp.component.genentity.spec.GenEntityService;
import com.ygsoft.necp.core.service.dcispec.EcpPostMapping;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context.ITDColProjectContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColProject;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.service.ITDColProjectService;

/**
 * TDColProjectService服务类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:48:31<br>
 * @since JDK 1.8.0_152
 */
@RestController
@RequestMapping("/necp/mapp/collecitoninfo/service/tDColProject")
public class TDColProjectService extends GenEntityService<TDColProject, ITDColProjectContext>
		implements ITDColProjectService {
	@EcpPostMapping("saveData")
	public void saveData(@RequestBody List<TDColProject> saveData) {
		getContext().saveData(saveData);
	}

	@EcpPostMapping("deleteByProjectId")
	public void deleteByProjectId(String gid) {
		getContext().deleteByProjectId(gid);
	}
}
