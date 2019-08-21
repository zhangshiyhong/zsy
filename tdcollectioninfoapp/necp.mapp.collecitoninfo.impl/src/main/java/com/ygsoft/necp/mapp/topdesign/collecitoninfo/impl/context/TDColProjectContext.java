/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ygsoft.ecp.core.framework.annotations.Topic;
import com.ygsoft.ecp.service.tool.StringUtil;
import com.ygsoft.necp.component.genentity.context.EntityContext;
import com.ygsoft.necp.component.genentity.spec.GenEntityContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context.ITDColItemContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context.ITDColProjectContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.context.ITDColViewtemContext;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.dao.ITDColProjectDao;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColItem;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColProject;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model.TDColViewtem;
/**
 * TDColProject场景类.<br>
 *
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:48:31<br>
 * @since JDK 1.8.0_152
 */
@Service
@Transactional
//@EventSource
@Topic(classId = "bc335ab4842588ccfcaa7098d294b906", typeId = "69dae87285e9b58ac438bd9aafb738b9")
@EntityContext(classId = "bc335ab4842588ccfcaa7098d294b906", typeId = "69dae87285e9b58ac438bd9aafb738b9")
public class TDColProjectContext extends GenEntityContext<TDColProject, String, ITDColProjectDao>
		implements ITDColProjectContext {

	private static final Logger LOG = LoggerFactory.getLogger(TDColProjectContext.class);
	@Autowired
	ITDColItemContext icolItemContext;
	@Autowired
	ITDColViewtemContext icolViewItemContext;
	/**
	 * {@inheritDoc}
	 * 
	 * @see com.ygsoft.necp.core.service.dcispec.GeneralContext#newModel()
	 */
	@Override
	protected TDColProject newModel() {
		return new TDColProject();
	}

	/**
	 * 查询所有的项目.
	 * @return
	 */
	public List<TDColProject> findAllProject(){
//		return this.getDao().findAll();
		return findListByOption(new HashMap());
	}

	@Override
	public List<TDColProject> findListByOption(final Map paramMap) {
		
		
		Specification<TDColProject> option = new Specification<TDColProject>(){
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<TDColProject> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            	List<Predicate> predicateList = new ArrayList<Predicate>();
            	Predicate xmmcCond = null;
                final Object xmmc =paramMap.get("xmmc");
                if(xmmc != null && StringUtil.isNotEmpty("" +xmmc) ) {
                	xmmcCond = criteriaBuilder.like(root.get("xmmc"),"%"+xmmc+"%");
                	predicateList.add(xmmcCond);
                }
                Predicate sftyCond = null;
                final Object sfty =paramMap.get("sfty");
                if(sfty != null && StringUtil.isNotEmpty(""+ sfty)){
                	sftyCond = criteriaBuilder.equal(root.get("sfty"),sfty);
                	predicateList.add(sftyCond);
//                    query.where(sftyCond);
                }
                query.orderBy(criteriaBuilder.desc(root.get("xmxh")));
                
                //方式一  这种方式使用JPA的API设置了查询条件，所以不需要再返回查询条件Predicate给Spring Data Jpa，故最后return nul
                /*
               query.where(criteriaBuilder.and((Predicate[])predicateList.toArray(new Predicate[predicateList.size()])));
                return null;
                */
                //方式二：
                
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
		return this.getDao().findAll(option);
	}

	@Override
	public void saveData(List<TDColProject> saveData) {
		final List<TDColProject> preAddData = new ArrayList<TDColProject> ();
		List<TDColProject> addData = new ArrayList<TDColProject> ();
		final List<TDColProject> updateData = new ArrayList<TDColProject> ();
		List<String> gidsArray = new ArrayList<String> ();
		String gids = "";
		for (TDColProject curData : saveData) {
			final String gid = curData.getGid(); 
			if (StringUtil.isEmpty(gid)) {
				addData.add(curData);
			}else {
				preAddData.add(curData);
				gids += gid +",";
				gidsArray.add(gid);
			}
		}
		final int gidLength = gids.length();
		if(gidLength >0) {
			gids = gids.substring(0, gidLength-1);
		}
		if (gidsArray.size()>0) {
			final List<TDColProject> exitList = getDao().findDataByGid(gidsArray);
			for (TDColProject preExitObj : preAddData) {
				final String preGid = preExitObj.getGid();
				boolean isAdd = true;
				for (TDColProject exitObj : exitList) {
					final String exitgid = exitObj.getGid();
					if(exitgid.equals(preGid)) {
						preExitObj.setXmxh(exitObj.getXmxh());
						updateData.add(preExitObj);
						isAdd = false;
					}
				}
				if (isAdd) {
					addData.add(preExitObj);
				}
			}
		} else {
			addData = saveData;
		}
		//设置序号
		final String xmxh = this.getDao().findMaxXmxh();

		int xmxhInt = 0;
		if (xmxh != null) {
			xmxhInt =Integer.valueOf(xmxh);
		}
		for (TDColProject addObj : addData) {
			final int gid  = ++xmxhInt;
			addObj.setGid("" + gid);
			addObj.setXmxh(gid);
			addObj.setOwnerId("1111");
			addObj.setBizState(0);
		}
		//保存
		
		if (addData.size()>0) {
			this.getDao().saveAll(addData);
		}
		if (updateData.size()>0) {
			this.getDao().saveAll(updateData);
		}
	}

	@Override
	public void deleteByProjectId(String gid) {
		// TODO Auto-generated method stub
	    Optional<TDColProject> result = find(gid);
	    TDColProject prj = ((TDColProject)result.orElse(null));
	    if(prj != null) {
	    	//删除项目明细
	    	Map queryMap = new HashMap();
	    	queryMap.put("xmxh", prj.getXmxh());
	    	List<TDColItem> colItemList = icolItemContext.findTop1000(queryMap, "", "");
	    	icolItemContext.deleteList(colItemList);
	    	//删除显示
	    	queryMap = new HashMap();
	    	queryMap.put("xmxh", prj.getXmxh());
	    	List<TDColViewtem> colViewItemList = icolViewItemContext.findTop1000(queryMap, "", "");
	    	icolViewItemContext.deleteList(colViewItemList);
	    	//删除数据
	    	this.delete(prj);
	    }
		
	}
	
	
}
