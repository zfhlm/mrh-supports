package org.lushen.mrh.supports.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 枚举基础类
 * 
 * @author hlm
 * @param <E>
 */
@JsonSerialize(using=GenericEnumJacksonSerializer.class)
@JsonDeserialize(using=GenericEnumJacksonDeserializer.class)
public interface GenericEnum<E extends Enum<E>> {

	/**
	 * 获取枚举值
	 * 
	 * @return
	 */
	public Integer getValue();

	/**
	 * 获取枚举名称
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 转换枚举值为枚举类型
	 * 
	 * @param actualClass
	 * @param value
	 * @return
	 */
	public static <S extends GenericEnum<?>> S fromValue(Class<S> actualClass, String value) {
		if(value == null) {
			return null;
		} else {
			return fromValue(actualClass, Integer.valueOf(value));
		}
	}

	/**
	 * 转换枚举值为枚举类型
	 * 
	 * @param actualClass
	 * @param value
	 * @return
	 */
	public static <S extends GenericEnum<?>> S fromValue(Class<S> actualClass, Integer value) {
		if(value != null) {
			for(S contant : actualClass.getEnumConstants()) {
				if(contant.getValue().equals(value)) {
					return contant;
				}
			}
		}
		return null;
	}

}
