/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.bo;

import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.types.SFTYPE;

import com.ygsoft.necp.component.genentity.domain.model.GenBizEntity;

/**
 * TDColProject的BO类.<br>
 * 
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-15 10:09:15<br>
 * @since JDK 1.8.0_152
 */
public class TDColProject extends GenBizEntity {

	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
													
	/**
	 * 项目序号.
	 */
	private int xmxh;
															
	/**
	 * 项目名称.
	 */
	private String xmmc;
															
	/**
	 * 是否停用.
	 */
	private SFTYPE spty;
				
	/**
     * 项目序号的get方法
     * @return xmxh
     */
    public int getXmxh() {
        return xmxh;
    }
		
    /**
     * 设置项目序号.
     * @param xmxh
     */
    public void setXmxh(final int newXmxh) {
		this.xmxh = newXmxh;
	}
		
	/**
     * 项目名称的get方法
     * @return xmmc
     */
    public String getXmmc() {
        return xmmc;
    }
		
    /**
     * 设置项目名称.
     * @param xmmc
     */
    public void setXmmc(final String newXmmc) {
		this.xmmc = newXmmc;
	}
		
	/**
     * 是否停用的get方法
     * @return spty
     */
    public SFTYPE getSpty() {
        return spty;
    }
		
    /**
     * 设置是否停用.
     * @param spty
     */
    public void setSpty(final SFTYPE newSpty) {
		this.spty = newSpty;
	}
	
}
