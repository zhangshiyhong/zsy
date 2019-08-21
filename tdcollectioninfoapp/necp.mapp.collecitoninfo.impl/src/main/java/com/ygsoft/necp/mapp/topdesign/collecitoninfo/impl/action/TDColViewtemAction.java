/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.action;

import org.springframework.stereotype.Component;

import com.ygsoft.ecp.core.framework.domain.AbstractBusinessAction;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.action.ITDColViewtemAction;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColViewtem;

/**
 * TDColViewtem动作类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:48:31<br>
 * @since JDK 1.8.0_152
 */
@Component
public class TDColViewtemAction extends AbstractBusinessAction<TDColViewtem> implements ITDColViewtemAction {
	
	/**
	 * TDColViewtemAction constructor.
	 * @param newBo newBo.
	 */
	public TDColViewtemAction(TDColViewtem newBo) {
		super(newBo);
	}
	
}
