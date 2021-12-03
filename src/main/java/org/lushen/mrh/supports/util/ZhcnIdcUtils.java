package org.lushen.mrh.supports.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * 身份证号码工具类
 * 
 * @author helm
 */
public class ZhcnIdcUtils {

	private static final Set<Integer> PROVINCES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(11, 12, 13, 14, 15, 21, 22, 23, 31, 32, 33, 34, 35, 36, 37, 41, 42, 43, 44, 45, 46, 50, 51, 52, 53, 54, 61, 62, 63, 64, 71, 81, 82, 91)));

	private static final char[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

	private static final int[] POWER_LIST = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

	/**
	 * 验证身份证号码格式是否正确
	 * 
	 * @param idCard
	 * @return
	 */
	public static final boolean isIdCard(String idCard) {
		int len = StringUtils.length(idCard);
		if(len == 15) {
			return is15IdCard(idCard);
		} else if(len == 18) {
			return is18IdCard(idCard);
		} else {
			return false;
		}
	}

	/**
	 * 验证15位身份证号码格式是否正确
	 * 
	 * @param idCard
	 * @return
	 */
	public static final boolean is15IdCard(String idCard) {

		//不是15位
		if(StringUtils.length(idCard) != 15) {
			return false;
		}

		//校验省代码(1、2位)
		if( ! PROVINCES.contains(getInt(idCard, 0, 2, -1))) {
			return false;
		}

		//校验市县代码(3、4、5、6位)
		if(getInt(idCard, 2, 6, -1) == -1) {
			return false;
		}

		//校验年份(7、8位)
		int year = getInt(idCard, 6, 8, -1) + 1900;
		if(year < 1900) {
			return false;
		}

		//校验月份(9、10位)
		int month = getInt(idCard, 8, 10, -1);
		if(month < 1 || month > 12) {
			return false;
		}

		//校验日期(11、12位)
		int day = getInt(idCard, 10, 12, -1);
		if(day < 1) {
			return false;
		}

		//校验生日合法性
		Calendar birthDay = Calendar.getInstance();
		birthDay.set(year, month-1, day);
		if(birthDay.get(Calendar.YEAR) != year || birthDay.get(Calendar.MONTH)+1 != month || birthDay.get(Calendar.DAY_OF_MONTH) != day) {
			return false;
		}

		//校验顺序号(13、14、15位)
		if(getInt(idCard, 12, 15, -1) == -1) {
			return false;
		}

		return true;
	}

	/**
	 * 验证18位身份证号码格式是否正确
	 * 
	 * @param idCard
	 * @return
	 */
	public static final boolean is18IdCard(String idCard) {

		//不是18位
		if(StringUtils.length(idCard) != 18) {
			return false;
		}

		//校验省代码(1、2位)
		if( ! PROVINCES.contains(getInt(idCard, 0, 2, -1))) {
			return false;
		}

		//校验市县代码(3、4、5、6位)
		if(getInt(idCard, 2, 6, -1) == -1) {
			return false;
		}

		//校验年份(7、8、9、10位)
		int year = getInt(idCard, 6, 10, -1);
		if(year < 1900) {
			return false;
		}

		//校验月份(11、12位)
		int month = getInt(idCard, 10, 12, -1);
		if(month < 1 || month > 12) {
			return false;
		}

		//校验日期(13、14位)
		int day = getInt(idCard, 12, 14, -1);
		if(day < 1) {
			return false;
		}

		//校验生日合法性
		Calendar birthDay = Calendar.getInstance();
		birthDay.set(year, month-1, day, 0, 0, 0);
		if(birthDay.get(Calendar.YEAR) != year || birthDay.get(Calendar.MONTH)+1 != month || birthDay.get(Calendar.DAY_OF_MONTH) != day) {
			return false;
		}
		if(birthDay.after(Calendar.getInstance())) {
			return false;
		}

		//校验顺序号(15、16、17位)
		if(getInt(idCard, 14, 17, -1) == -1) {
			return false;
		}

		//校验码(18位)
		int power = 0;
		for (int i = 0; i < idCard.length() - 1; i++) {
			power += (idCard.charAt(i) - '0') * POWER_LIST[i];
		}
		return idCard.charAt(17) == PARITYBIT[power % 11];
	}

	/**
	 * 15位身份证号码转换为18位身份证号码
	 * 
	 * @param idCard
	 * @return
	 */
	public static final String idCard15To18(String idCard) {

		if( ! is15IdCard(idCard)) {
			throw new IllegalArgumentException("错误的15位身份证号码!");
		}

		char[] chars = new char[18];

		//复制到对应位置
		for(int i=0, off=0; i<chars.length; i++) {
			if(i != 6 && i != 7 && i != 17) {
				chars[i] = idCard.charAt(off++);
			}
		}

		//补年份前两位
		chars[6] = '1';
		chars[7] = '9';

		//补校验码
		int power = 0;
		for (int i = 0; i < chars.length - 1; i++) {
			power += (chars[i] - '0') * POWER_LIST[i];
		}
		chars[17] = PARITYBIT[power % 11];

		return new String(chars);
	}

	/**
	 * 18位身份证号码转换为15位身份证号码
	 * 
	 * @param idCard
	 * @return
	 */
	public static final String idCard18To15(String idCard) {

		if( ! is18IdCard(idCard)) {
			throw new IllegalArgumentException("错误的18位身份证号码!");
		}

		//年份必须19XX(7、8位)
		if(getInt(idCard, 6, 8, -1) != 19) {
			throw new IllegalArgumentException("不能转换非1900-1999年份的身份证号码!");
		}

		char[] chars = new char[15];

		//填充到对应位置
		for(int i=0, off=0; i<idCard.length(); i++) {
			if(i != 6 && i != 7 && i != 17) {
				chars[off++] = idCard.charAt(i);
			}
		}

		return new String(chars);
	}

	/**
	 * 读取身份证号码生日
	 * 
	 * @param idCard
	 * @param format
	 * @return
	 */
	public static final String getBirthDate(String idCard, String format) {
		Date birth = getBirthDate(idCard);
		return new SimpleDateFormat(format).format(birth);
	}

	/**
	 * 读取身份证号码生日
	 * 
	 * @param idCard
	 * @return
	 */
	public static final Date getBirthDate(String idCard) {
		StringBuilder sb = new StringBuilder(8);
		if(is18IdCard(idCard)) {
			sb.append(idCard.substring(6, 14));
		} else if(is15IdCard(idCard)) {
			sb.append("19");
			sb.append(idCard.substring(6, 12));
		} else {
			throw new IllegalArgumentException("错误的身份证号码!");
		}
		try {
			return new SimpleDateFormat("yyyyMMdd").parse(sb.toString());
		} catch (Exception cause) {
			throw new RuntimeException("身份证号码生日读取错误!", cause);
		}
	}

	/**
	 * 读取身份证号码性别
	 * 
	 * @param idCard
	 * @return 1为男性, 2为女性
	 */
	public static final int getSex(String idCard) {
		int sex = 0;
		if(is15IdCard(idCard)) {
			sex = getInt(idCard, 14);
		}
		else if(is18IdCard(idCard)) {
			sex = getInt(idCard, 16);
		}
		else {
			throw new IllegalArgumentException("错误的身份证号码!");
		}
		return (sex % 2 == 0? 2 : 1);
	}

	/**
	 * 获取身份证号码中的指定区间数值, 如果失败返回默认值
	 * 
	 * @param idCard		身份证号码
	 * @param fromInclude	起始位置
	 * @param toExclude		结束位置
	 * @param defValue		获取失败返回默认值
	 * @return
	 */
	private static final int getInt(String idCard, int fromInclude, int toExclude, int defValue) {
		int number = 0;
		for(int index=fromInclude, off=0, size = toExclude-fromInclude; index<toExclude; index++, off++) {
			char ch = idCard.charAt(index);
			if(ch < '0' || ch > '9') {
				return defValue;
			} else {
				number += (ch-48)*Math.pow(10, size-off-1);
			}
		}
		return number;
	}

	/**
	 * 获取指定位置的数值
	 * 
	 * @param idCard
	 * @param index
	 * @return
	 */
	private static final int getInt(String idCard, int index) {
		return idCard.charAt(index) - 48;
	}

}
