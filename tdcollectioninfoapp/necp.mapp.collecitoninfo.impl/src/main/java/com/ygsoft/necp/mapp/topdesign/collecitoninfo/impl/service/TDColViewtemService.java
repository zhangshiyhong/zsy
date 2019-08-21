/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ygsoft.necp.component.genentity.spec.GenEntityService;
import com.ygsoft.necp.core.service.dcispec.EcpPostMapping;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context.ITDColViewtemContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColViewtem;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.service.ITDColViewtemService;

/**
 * TDColViewtemService服务类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:48:31<br>
 * @since JDK 1.8.0_152
 */
@RestController
@RequestMapping("/necp/mapp/collecitoninfo/service/tDColViewtem")
public class TDColViewtemService extends GenEntityService<TDColViewtem, ITDColViewtemContext>
		implements ITDColViewtemService {
	/**
	 *  保存数据，先删后插.
	 * @param xmxh
	 * @param dataList
	 */
	@EcpPostMapping("saveData")
	public void saveData(@RequestParam int xmxh,@RequestBody List<TDColViewtem> dataList) {
		this.getContext().saveData(xmxh, dataList);
	}
}
