/*
 * Copyright (C) 2005 - 2030 YGSoft.Inc All Rights Reserved.
 * YGSoft.Inc PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.
 */
package com.ygsoft.necp.mapp.topdesign.collecitoninfo.service.domain.model;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.ygsoft.ecp.core.framework.annotations.Topic;
import com.ygsoft.necp.component.genentity.domain.model.GenBizEntity;

/**
 * TDColItem的POJO类.<br>
 * 
 * @author 张世永 <br>
 * @version 1.0.0 2019-06-05 10:06:41<br>
 * @since JDK 1.8.0_152
 */
@Entity
@Table(name = "T_TD_COLITEM", indexes = {@Index(name = "UNI_ECP_SM_MXXH", columnList = "mxxh"),
@Index(name = "UNI_ECP_SM_XMXH", columnList = "xmxh"),
})
@Topic(classId = "bc335ab4842588ccfcaa7098d294b906", typeId = "be91843716e86f08084002adb02cbeba")
public class TDColItem extends GenBizEntity {
	/**
	 * 序列化版本.
	 */
	private static final long serialVersionUID = 1L;
													
	/**
	 * 明细序号.
	 */
	private int mxxh;
												
	/**
	 * 项目序号.
	 */
	private int xmxh;
												
	/**
	 * 字符串1.
	 */
	private String char01;
												
	/**
	 * 字符串2.
	 */
	private String char02;
												
	/**
	 * 字符串3.
	 */
	private String char03;
												
	/**
	 * 字符串4.
	 */
	private String char04;
												
	/**
	 * 字符串5.
	 */
	private String char05;
												
	/**
	 * 字符串6.
	 */
	private String char06;
												
	/**
	 * 字符串7.
	 */
	private String char07;
												
	/**
	 * 字符串8.
	 */
	private String char08;
												
	/**
	 * 字符串9.
	 */
	private String char09;
												
	/**
	 * 字符串10.
	 */
	private String char10;
												
	/**
	 * 字符串11.
	 */
	private String char11;
												
	/**
	 * 字符串12.
	 */
	private String char12;
												
	/**
	 * 字符串13.
	 */
	private String char13;
												
	/**
	 * 字符串14.
	 */
	private String char14;
												
	/**
	 * 字符串15.
	 */
	private String char15;
												
	/**
	 * 长字符串1.
	 */
	private String long_char01;
												
	/**
	 * 长字符串2.
	 */
	private String long_char02;
												
	/**
	 * 长字符串3.
	 */
	private String long_char03;
												
	/**
	 * 长字符串4.
	 */
	private String long_char04;
												
	/**
	 * 长字符串5.
	 */
	private String long_char05;
												
	/**
	 * 数字1.
	 */
	private int num01;
												
	/**
	 * 数字2.
	 */
	private int num02;
												
	/**
	 * 数字3.
	 */
	private int num03;
												
	/**
	 * 数字4.
	 */
	private int num04;
												
	/**
	 * 数字5.
	 */
	private int num05;
												
	/**
	 * 长数字1.
	 */
	private BigDecimal long_num01;
												
	/**
	 * 长数字2.
	 */
	private BigDecimal long_num02;
												
	/**
	 * 长数字3.
	 */
	private BigDecimal long_num03;
												
	/**
	 * 长数字4.
	 */
	private BigDecimal long_num04;
												
	/**
	 * 长数字5.
	 */
	private BigDecimal long_num05;
												
	/**
	 * 日期1.
	 */
	private Date date01;
												
	/**
	 * 日期2.
	 */
	private Date date02;
												
	/**
	 * 日期3.
	 */
	private Date date03;
												
	/**
	 * 日期4.
	 */
	private Date date04;
												
	/**
	 * 日期5.
	 */
	private Date date05;
	
	/**
     * 明细序号的get方法
     * @return mxxh
     */
	@Column(name = "MXXH", nullable = false)
    public int getMxxh() {
        return mxxh;
    }
		
    /**
     * 设置明细序号.
     * @param mxxh
     */
    public void setMxxh(final int newMxxh) {
		this.mxxh = newMxxh;
	}
	
	/**
     * 项目序号的get方法
     * @return xmxh
     */
	@Column(name = "XMXH", nullable = false)
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
     * 字符串1的get方法
     * @return char01
     */
	@Column(name = "CHAR01", nullable = true, length = 200)
    public String getChar01() {
        return char01;
    }
		
    /**
     * 设置字符串1.
     * @param char01
     */
    public void setChar01(final String newChar01) {
		this.char01 = newChar01;
	}
	
	/**
     * 字符串2的get方法
     * @return char02
     */
	@Column(name = "CHAR02", nullable = true, length = 200)
    public String getChar02() {
        return char02;
    }
		
    /**
     * 设置字符串2.
     * @param char02
     */
    public void setChar02(final String newChar02) {
		this.char02 = newChar02;
	}
	
	/**
     * 字符串3的get方法
     * @return char03
     */
	@Column(name = "CHAR03", nullable = true, length = 200)
    public String getChar03() {
        return char03;
    }
		
    /**
     * 设置字符串3.
     * @param char03
     */
    public void setChar03(final String newChar03) {
		this.char03 = newChar03;
	}
	
	/**
     * 字符串4的get方法
     * @return char04
     */
	@Column(name = "CHAR04", nullable = true, length = 200)
    public String getChar04() {
        return char04;
    }
		
    /**
     * 设置字符串4.
     * @param char04
     */
    public void setChar04(final String newChar04) {
		this.char04 = newChar04;
	}
	
	/**
     * 字符串5的get方法
     * @return char05
     */
	@Column(name = "CHAR05", nullable = true, length = 200)
    public String getChar05() {
        return char05;
    }
		
    /**
     * 设置字符串5.
     * @param char05
     */
    public void setChar05(final String newChar05) {
		this.char05 = newChar05;
	}
	
	/**
     * 字符串6的get方法
     * @return char06
     */
	@Column(name = "CHAR06", nullable = true, length = 200)
    public String getChar06() {
        return char06;
    }
		
    /**
     * 设置字符串6.
     * @param char06
     */
    public void setChar06(final String newChar06) {
		this.char06 = newChar06;
	}
	
	/**
     * 字符串7的get方法
     * @return char07
     */
	@Column(name = "CHAR07", nullable = true, length = 200)
    public String getChar07() {
        return char07;
    }
		
    /**
     * 设置字符串7.
     * @param char07
     */
    public void setChar07(final String newChar07) {
		this.char07 = newChar07;
	}
	
	/**
     * 字符串8的get方法
     * @return char08
     */
	@Column(name = "CHAR08", nullable = true, length = 200)
    public String getChar08() {
        return char08;
    }
		
    /**
     * 设置字符串8.
     * @param char08
     */
    public void setChar08(final String newChar08) {
		this.char08 = newChar08;
	}
	
	/**
     * 字符串9的get方法
     * @return char09
     */
	@Column(name = "CHAR09", nullable = true, length = 200)
    public String getChar09() {
        return char09;
    }
		
    /**
     * 设置字符串9.
     * @param char09
     */
    public void setChar09(final String newChar09) {
		this.char09 = newChar09;
	}
	
	/**
     * 字符串10的get方法
     * @return char10
     */
	@Column(name = "CHAR10", nullable = true, length = 200)
    public String getChar10() {
        return char10;
    }
		
    /**
     * 设置字符串10.
     * @param char10
     */
    public void setChar10(final String newChar10) {
		this.char10 = newChar10;
	}
	
	/**
     * 字符串11的get方法
     * @return char11
     */
	@Column(name = "CHAR11", nullable = true, length = 200)
    public String getChar11() {
        return char11;
    }
		
    /**
     * 设置字符串11.
     * @param char11
     */
    public void setChar11(final String newChar11) {
		this.char11 = newChar11;
	}
	
	/**
     * 字符串12的get方法
     * @return char12
     */
	@Column(name = "CHAR12", nullable = true, length = 200)
    public String getChar12() {
        return char12;
    }
		
    /**
     * 设置字符串12.
     * @param char12
     */
    public void setChar12(final String newChar12) {
		this.char12 = newChar12;
	}
	
	/**
     * 字符串13的get方法
     * @return char13
     */
	@Column(name = "CHAR13", nullable = true, length = 200)
    public String getChar13() {
        return char13;
    }
		
    /**
     * 设置字符串13.
     * @param char13
     */
    public void setChar13(final String newChar13) {
		this.char13 = newChar13;
	}
	
	/**
     * 字符串14的get方法
     * @return char14
     */
	@Column(name = "CHAR14", nullable = true, length = 200)
    public String getChar14() {
        return char14;
    }
		
    /**
     * 设置字符串14.
     * @param char14
     */
    public void setChar14(final String newChar14) {
		this.char14 = newChar14;
	}
	
	/**
     * 字符串15的get方法
     * @return char15
     */
	@Column(name = "CHAR15", nullable = true, length = 200)
    public String getChar15() {
        return char15;
    }
		
    /**
     * 设置字符串15.
     * @param char15
     */
    public void setChar15(final String newChar15) {
		this.char15 = newChar15;
	}
	
	/**
     * 长字符串1的get方法
     * @return long_char01
     */
	@Column(name = "LONG_CHAR01", nullable = true, length = 4000)
    public String getLong_char01() {
        return long_char01;
    }
		
    /**
     * 设置长字符串1.
     * @param long_char01
     */
    public void setLong_char01(final String newLong_char01) {
		this.long_char01 = newLong_char01;
	}
	
	/**
     * 长字符串2的get方法
     * @return long_char02
     */
	@Column(name = "LONG_CHAR02", nullable = true, length = 4000)
    public String getLong_char02() {
        return long_char02;
    }
		
    /**
     * 设置长字符串2.
     * @param long_char02
     */
    public void setLong_char02(final String newLong_char02) {
		this.long_char02 = newLong_char02;
	}
	
	/**
     * 长字符串3的get方法
     * @return long_char03
     */
	@Column(name = "LONG_CHAR03", nullable = true, length = 4000)
    public String getLong_char03() {
        return long_char03;
    }
		
    /**
     * 设置长字符串3.
     * @param long_char03
     */
    public void setLong_char03(final String newLong_char03) {
		this.long_char03 = newLong_char03;
	}
	
	/**
     * 长字符串4的get方法
     * @return long_char04
     */
	@Column(name = "LONG_CHAR04", nullable = true, length = 4000)
    public String getLong_char04() {
        return long_char04;
    }
		
    /**
     * 设置长字符串4.
     * @param long_char04
     */
    public void setLong_char04(final String newLong_char04) {
		this.long_char04 = newLong_char04;
	}
	
	/**
     * 长字符串5的get方法
     * @return long_char05
     */
	@Column(name = "LONG_CHAR05", nullable = true, length = 4000)
    public String getLong_char05() {
        return long_char05;
    }
		
    /**
     * 设置长字符串5.
     * @param long_char05
     */
    public void setLong_char05(final String newLong_char05) {
		this.long_char05 = newLong_char05;
	}
	
	/**
     * 数字1的get方法
     * @return num01
     */
	@Column(name = "NUM01", nullable = true)
    public int getNum01() {
        return num01;
    }
		
    /**
     * 设置数字1.
     * @param num01
     */
    public void setNum01(final int newNum01) {
		this.num01 = newNum01;
	}
	
	/**
     * 数字2的get方法
     * @return num02
     */
	@Column(name = "NUM02", nullable = true)
    public int getNum02() {
        return num02;
    }
		
    /**
     * 设置数字2.
     * @param num02
     */
    public void setNum02(final int newNum02) {
		this.num02 = newNum02;
	}
	
	/**
     * 数字3的get方法
     * @return num03
     */
	@Column(name = "NUM03", nullable = true)
    public int getNum03() {
        return num03;
    }
		
    /**
     * 设置数字3.
     * @param num03
     */
    public void setNum03(final int newNum03) {
		this.num03 = newNum03;
	}
	
	/**
     * 数字4的get方法
     * @return num04
     */
	@Column(name = "NUM04", nullable = true)
    public int getNum04() {
        return num04;
    }
		
    /**
     * 设置数字4.
     * @param num04
     */
    public void setNum04(final int newNum04) {
		this.num04 = newNum04;
	}
	
	/**
     * 数字5的get方法
     * @return num05
     */
	@Column(name = "NUM05", nullable = true)
    public int getNum05() {
        return num05;
    }
		
    /**
     * 设置数字5.
     * @param num05
     */
    public void setNum05(final int newNum05) {
		this.num05 = newNum05;
	}
	
	/**
     * 长数字1的get方法
     * @return long_num01
     */
	@Column(name = "LONG_NUM01", nullable = true, length = 18, scale = 2)
    public BigDecimal getLong_num01() {
        return long_num01;
    }
		
    /**
     * 设置长数字1.
     * @param long_num01
     */
    public void setLong_num01(final BigDecimal newLong_num01) {
		this.long_num01 = newLong_num01;
	}
	
	/**
     * 长数字2的get方法
     * @return long_num02
     */
	@Column(name = "LONG_NUM02", nullable = true, length = 18, scale = 2)
    public BigDecimal getLong_num02() {
        return long_num02;
    }
		
    /**
     * 设置长数字2.
     * @param long_num02
     */
    public void setLong_num02(final BigDecimal newLong_num02) {
		this.long_num02 = newLong_num02;
	}
	
	/**
     * 长数字3的get方法
     * @return long_num03
     */
	@Column(name = "LONG_NUM03", nullable = true, length = 18, scale = 2)
    public BigDecimal getLong_num03() {
        return long_num03;
    }
		
    /**
     * 设置长数字3.
     * @param long_num03
     */
    public void setLong_num03(final BigDecimal newLong_num03) {
		this.long_num03 = newLong_num03;
	}
	
	/**
     * 长数字4的get方法
     * @return long_num04
     */
	@Column(name = "LONG_NUM04", nullable = true, length = 18, scale = 2)
    public BigDecimal getLong_num04() {
        return long_num04;
    }
		
    /**
     * 设置长数字4.
     * @param long_num04
     */
    public void setLong_num04(final BigDecimal newLong_num04) {
		this.long_num04 = newLong_num04;
	}
	
	/**
     * 长数字5的get方法
     * @return long_num05
     */
	@Column(name = "LONG_NUM05", nullable = true, length = 18, scale = 2)
    public BigDecimal getLong_num05() {
        return long_num05;
    }
		
    /**
     * 设置长数字5.
     * @param long_num05
     */
    public void setLong_num05(final BigDecimal newLong_num05) {
		this.long_num05 = newLong_num05;
	}
	
	/**
     * 日期1的get方法
     * @return date01
     */
	@Column(name = "DATE01", nullable = true)
    public Date getDate01() {
        return date01;
    }
		
    /**
     * 设置日期1.
     * @param date01
     */
    public void setDate01(final Date newDate01) {
		this.date01 = newDate01;
	}
	
	/**
     * 日期2的get方法
     * @return date02
     */
	@Column(name = "DATE02", nullable = true)
    public Date getDate02() {
        return date02;
    }
		
    /**
     * 设置日期2.
     * @param date02
     */
    public void setDate02(final Date newDate02) {
		this.date02 = newDate02;
	}
	
	/**
     * 日期3的get方法
     * @return date03
     */
	@Column(name = "DATE03", nullable = true)
    public Date getDate03() {
        return date03;
    }
		
    /**
     * 设置日期3.
     * @param date03
     */
    public void setDate03(final Date newDate03) {
		this.date03 = newDate03;
	}
	
	/**
     * 日期4的get方法
     * @return date04
     */
	@Column(name = "DATE04", nullable = true)
    public Date getDate04() {
        return date04;
    }
		
    /**
     * 设置日期4.
     * @param date04
     */
    public void setDate04(final Date newDate04) {
		this.date04 = newDate04;
	}
	
	/**
     * 日期5的get方法
     * @return date05
     */
	@Column(name = "DATE05", nullable = true)
    public Date getDate05() {
        return date05;
    }
		
    /**
     * 设置日期5.
     * @param date05
     */
    public void setDate05(final Date newDate05) {
		this.date05 = newDate05;
	}
}
