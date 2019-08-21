/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import com.ygsoft.necp.component.genentity.spec.IGenEntityContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColProject;

/**
 * ITDColProjectContext场景接口类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:53:47<br>
 * @since JDK 1.8.0_152
 */
public interface ITDColProjectContext extends IGenEntityContext<TDColProject, String> {
	/**
	 * 查询所有的项目.
	 * @return
	 */
	List<TDColProject> findAllProject();
	

	/**
	 * 根据条件获取列表
	 * @param paramMap
	 * @return
	 */
	List<TDColProject> findListByOption(final Map paramMap);
	/**
	 * 批量保存数据
	 * @param saveData
	 */
	void saveData(List<TDColProject> saveData);
	/**
	 * 删除项目及其从表数据
	 * @param gid
	 */
	void deleteByProjectId(String gid); 
}
