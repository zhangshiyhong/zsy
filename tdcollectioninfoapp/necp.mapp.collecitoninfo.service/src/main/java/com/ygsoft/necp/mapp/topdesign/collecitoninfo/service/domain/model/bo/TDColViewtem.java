/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.bo;

import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.types.ZDTYPE;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.types.SFTYPE;

import com.ygsoft.necp.component.genentity.domain.model.GenBizEntity;

/**
 * TDColViewtem的BO类.<br>
 * 
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-15 10:09:15<br>
 * @since JDK 1.8.0_152
 */
public class TDColViewtem extends GenBizEntity {

	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
													
	/**
	 * 显示编号.
	 */
	private int xsxh;
															
	/**
	 * 项目编号.
	 */
	private int xmxh;
															
	/**
	 * 字段名称.
	 */
	private String zdmc;
															
	/**
	 * 显示名称.
	 */
	private String xsmc;
															
	/**
	 * 字段类型.
	 */
	private ZDTYPE zdlx;
															
	/**
	 * 字段值.
	 */
	private String zdz;
															
	/**
	 * 是否查询条件.
	 */
	private SFTYPE sfcxtj;
				
	/**
     * 显示编号的get方法
     * @return xsxh
     */
    public int getXsxh() {
        return xsxh;
    }
		
    /**
     * 设置显示编号.
     * @param xsxh
     */
    public void setXsxh(final int newXsxh) {
		this.xsxh = newXsxh;
	}
		
	/**
     * 项目编号的get方法
     * @return xmxh
     */
    public int getXmxh() {
        return xmxh;
    }
		
    /**
     * 设置项目编号.
     * @param xmxh
     */
    public void setXmxh(final int newXmxh) {
		this.xmxh = newXmxh;
	}
		
	/**
     * 字段名称的get方法
     * @return zdmc
     */
    public String getZdmc() {
        return zdmc;
    }
		
    /**
     * 设置字段名称.
     * @param zdmc
     */
    public void setZdmc(final String newZdmc) {
		this.zdmc = newZdmc;
	}
		
	/**
     * 显示名称的get方法
     * @return xsmc
     */
    public String getXsmc() {
        return xsmc;
    }
		
    /**
     * 设置显示名称.
     * @param xsmc
     */
    public void setXsmc(final String newXsmc) {
		this.xsmc = newXsmc;
	}
		
	/**
     * 字段类型的get方法
     * @return zdlx
     */
    public ZDTYPE getZdlx() {
        return zdlx;
    }
		
    /**
     * 设置字段类型.
     * @param zdlx
     */
    public void setZdlx(final ZDTYPE newZdlx) {
		this.zdlx = newZdlx;
	}
		
	/**
     * 字段值的get方法
     * @return zdz
     */
    public String getZdz() {
        return zdz;
    }
		
    /**
     * 设置字段值.
     * @param zdz
     */
    public void setZdz(final String newZdz) {
		this.zdz = newZdz;
	}
		
	/**
     * 是否查询条件的get方法
     * @return sfcxtj
     */
    public SFTYPE getSfcxtj() {
        return sfcxtj;
    }
		
    /**
     * 设置是否查询条件.
     * @param sfcxtj
     */
    public void setSfcxtj(final SFTYPE newSfcxtj) {
		this.sfcxtj = newSfcxtj;
	}
	
}
