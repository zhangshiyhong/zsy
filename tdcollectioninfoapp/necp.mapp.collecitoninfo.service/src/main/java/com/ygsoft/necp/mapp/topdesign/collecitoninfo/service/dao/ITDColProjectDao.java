/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ygsoft.necp.component.genentity.spec.IGenEntityDao;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColProject;

/**
 * ITDColProjectDao数据访问类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:53:47<br>
 * @since JDK 1.8.0_152
 */
@Repository
public interface ITDColProjectDao extends IGenEntityDao<TDColProject, String> {
	
	@Query(value = " SELECT a.* FROM T_TD_COLPROJECT a WHERE a.gid IN(:gids)",
			nativeQuery = true)
	List<TDColProject> findDataByGid(@Param("gids")List gids);
	
	
	@Query(value = " SELECT MAX(XMXH) XMXH FROM T_TD_COLPROJECT",
			nativeQuery = true)
	String findMaxXmxh();
	
	

}
