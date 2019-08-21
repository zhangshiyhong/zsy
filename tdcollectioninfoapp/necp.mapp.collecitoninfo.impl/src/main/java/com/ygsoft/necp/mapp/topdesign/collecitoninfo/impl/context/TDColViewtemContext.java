/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ygsoft.ecp.core.framework.annotations.Topic;
import com.ygsoft.necp.component.genentity.context.EntityContext;
import com.ygsoft.necp.component.genentity.spec.GenEntityContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.tool.ColUtil;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context.ITDColViewtemContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.dao.ITDColViewtemDao;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColViewtem;

/**
 * TDColViewtem场景类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:48:31<br>
 * @since JDK 1.8.0_152
 */
@Service
@Transactional
//@EventSource
@Topic(classId = "bc335ab4842588ccfcaa7098d294b906", typeId = "6dd4f19c06de306f8fbab5bd17847bc3")
@EntityContext(classId = "bc335ab4842588ccfcaa7098d294b906", typeId = "6dd4f19c06de306f8fbab5bd17847bc3")
public class TDColViewtemContext extends GenEntityContext<TDColViewtem, String, ITDColViewtemDao>
		implements ITDColViewtemContext {

	@Autowired
	ITDColViewtemContext context;
	/**
	 * {@inheritDoc}
	 * 
	 * @see com.ygsoft.necp.core.service.dcispec.GeneralContext#newModel()
	 */
	@Override
	protected TDColViewtem newModel() {
		return new TDColViewtem();
	}

	@Override
	public void saveData(int xmxh, List<TDColViewtem> dataList) {

		Map<String,Object> paramMap = new HashMap();
		paramMap.put("xmxh", xmxh);
		List<TDColViewtem> exitDataList =  context.findTop1000(paramMap, "xmxh", "");
		this.getDao().deleteAll(exitDataList);
		int beginXmxh = 0;
		for (TDColViewtem tdColViewtem : dataList) {
			int gid  = ++beginXmxh;
			tdColViewtem.setGid(ColUtil.CreateGIdByXmxh(xmxh, beginXmxh));
			tdColViewtem.setXsxh(gid);	
		}
		this.saveList(dataList);
		
	}
	
}
