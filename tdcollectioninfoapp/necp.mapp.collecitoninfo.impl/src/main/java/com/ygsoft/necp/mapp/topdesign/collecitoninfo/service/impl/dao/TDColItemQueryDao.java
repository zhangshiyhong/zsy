package com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.impl.dao;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ygsoft.ecp.service.tool.DBUtil;
import com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.dao.ITDColItemQueryDao;


@Repository
public class TDColItemQueryDao implements ITDColItemQueryDao{
	/**
	 * LOG.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(TDColItemQueryDao.class);

	@Override
	public int findMaxMxxh(int xmxh) {
		String sql = "SELECT MAX(MXXH) MXXH FROM {0}.T_TD_COLITEM WHERE XMXH= {1}";
		final Map<String, Object> params = new HashMap<String, Object>();
		final StringBuffer sbTemplate = new StringBuffer();
		
		final Object[] args = new Object[] {DBUtil.getShareSchema(), xmxh};
		String querySql =  MessageFormat.format(sql, args);
		List<Map> result = DBUtil.getSqlTemplate().findBySQLWithoutRowNumLimit(querySql, params, Map.class);
		Map map = result.get(0);
		int maxNo = 0;
		if(map !=null) {
			maxNo = Integer.valueOf(String.valueOf(map.get("mxxh")));
		} 
		return maxNo;
	}

}
