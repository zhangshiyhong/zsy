/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.ygsoft.ecp.core.framework.annotations.Topic;
import com.ygsoft.ecp.service.EcpService;
import com.ygsoft.ecp.service.cache.ICache;
import com.ygsoft.necp.component.genentity.context.EntityContext;
import com.ygsoft.necp.component.genentity.spec.GenEntityContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.tool.ColUtil;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context.ITDColItemContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.dao.ITDColItemDao;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.dao.ITDColItemQueryDao;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColItem;

/**
 * TDColItem场景类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:06:41<br>
 * @since JDK 1.8.0_152
 */
@Service
@Transactional
//@EventSource
@Topic(classId = "bc335ab4842588ccfcaa7098d294b906", typeId = "be91843716e86f08084002adb02cbeba")
@EntityContext(classId = "bc335ab4842588ccfcaa7098d294b906", typeId = "be91843716e86f08084002adb02cbeba")
public class TDColItemContext extends GenEntityContext<TDColItem, String, ITDColItemDao>
		implements ITDColItemContext {

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.ygsoft.necp.core.service.dcispec.GeneralContext#newModel()
	 */
	@Override
	protected TDColItem newModel() {
		return new TDColItem();
	}
	@Autowired
	ITDColItemQueryDao iTDColItemQueryDao;
	


	public TDColItem addColItem(@RequestBody TDColItem addVO) {
		final int xmxh = addVO.getXmxh();
		final int mxxh = CreateMaxNo(xmxh);
		final String gid = ColUtil.CreateGIdByXmxh(xmxh, mxxh);
		addVO.setGid(gid);
		addVO.setMxxh(mxxh);
		this.add(addVO);

		final ICache<String, String> cache = EcpService.getCacheService("TDColItem");
		cache.put("xmxh" + xmxh, String.valueOf(mxxh));
		return addVO;
	}
	
	private int  CreateMaxNo(final int xmxh) {
		int maxNo = 0;
		final ICache<String, String> cache = EcpService.getCacheService("TDColItem");
		final String maxNoStr = cache.get("xmxh" + xmxh); 
		if (maxNoStr ==null) {
			maxNo = iTDColItemQueryDao.findMaxMxxh(xmxh);
		} else {
			maxNo = Integer.valueOf(maxNoStr);
		}

		maxNo ++;
		return maxNo;
	}
}
