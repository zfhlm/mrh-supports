package org.lushen.mrh.supports.enums;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Jackson 枚举类型序列化转换器
 * 
 * @author hlm
 */
@SuppressWarnings("rawtypes")
public class GenericEnumJacksonSerializer extends JsonSerializer<GenericEnum> {

	@Override
	public void serialize(GenericEnum basicEnum, JsonGenerator generator, SerializerProvider provider) throws IOException {
		if(basicEnum == null) {
			generator.writeNull();
		} else {
			generator.writeNumber(basicEnum.getValue());
		}
	}

}
