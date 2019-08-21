/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.ygsoft.ecp.core.framework.annotations.Topic;
import com.ygsoft.necp.component.genentity.domain.model.GenBizEntity;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.types.SFTYPE;

/**
 * TDColProject的POJO类.<br>
 * 
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-15 10:09:15<br>
 * @since JDK 1.8.0_152
 */
@Entity
@Table(name = "T_TD_COLPROJECT", indexes = {})
@Topic(classId = "bc335ab4842588ccfcaa7098d294b906", typeId = "69dae87285e9b58ac438bd9aafb738b9")
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
	private SFTYPE sfty;
	
	/**
     * 项目序号的get方法
     * @return xmxh
     */
	@Column(name = "XMXH", nullable = true)
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
	@Column(name = "XMMC", nullable = true, length = 50)
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
	@Column(name = "SFTY", nullable = true)
    public SFTYPE getSfty() {
        return sfty;
    }
		
    /**
     * 设置是否停用.
     * @param spty
     */
    public void setSfty(final SFTYPE newSfty) {
		this.sfty = newSfty;
	}
}
