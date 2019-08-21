package com.ygsoft.necp.mapp.topdesign.collecitoninfo.impl.tool;

public class ColUtil {
	/**
	 * 创建gid
	 * @param xmxh
	 * @param mxxh
	 * @return
	 */
	public static String  CreateGIdByXmxh(int xmxh, int mxxh) {
		return String.valueOf((xmxh * 10000) + mxxh);
	}
}
