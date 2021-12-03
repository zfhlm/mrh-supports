package org.lushen.mrh.supports.enums;

import java.lang.reflect.ParameterizedType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * mybatis枚举转换器
 * 
 * @author hlm
 * @param <T>
 */
public abstract class GenericEnumMybatisHandler<T extends GenericEnum<?>> extends BaseTypeHandler<T> {

	private final Class<T> actualClass;

	@SuppressWarnings("unchecked")
	public GenericEnumMybatisHandler() {
		super();
		this.actualClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public final void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
		ps.setObject(i, toValue(parameter, jdbcType));
	}

	@Override
	public final T getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return parseValue(rs.getObject(columnName));
	}

	@Override
	public final T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return parseValue(rs.getObject(columnIndex));
	}

	@Override
	public final T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return parseValue(cs.getObject(columnIndex));
	}

	private final Object toValue(T parameter, JdbcType jdbcType) {
		if(jdbcType == JdbcType.VARCHAR || jdbcType == JdbcType.LONGVARCHAR) {
			return String.valueOf(parameter.getValue());
		}
		else if(jdbcType == JdbcType.BIGINT) {
			return parameter.getValue().longValue();
		}
		else if(jdbcType == JdbcType.INTEGER) {
			return parameter.getValue();
		}
		else if(jdbcType == JdbcType.SMALLINT) {
			return parameter.getValue().shortValue();
		}
		else if(jdbcType == JdbcType.TINYINT) {
			return parameter.getValue().byteValue();
		}
		throw new RuntimeException(String.format("non-mapping for jdbcType [%s]", jdbcType));
	}

	private final T parseValue(Object value) {
		if(value == null) {
			return null;
		}
		else if(value instanceof String) {
			return GenericEnum.fromValue(this.actualClass, (String)value);
		}
		else if(value instanceof Long) {
			return GenericEnum.fromValue(this.actualClass, ((Long)value).intValue());
		}
		else if(value instanceof Integer) {
			return GenericEnum.fromValue(this.actualClass, (Integer)value);
		}
		else if(value instanceof Short) {
			return GenericEnum.fromValue(this.actualClass, ((Short)value).intValue());
		}
		else if(value instanceof Byte) {
			return GenericEnum.fromValue(this.actualClass, ((Byte)value).intValue());
		}
		throw new RuntimeException(String.format("non-mapping for javaType [%s]", value.getClass().getName()));
	}

}
