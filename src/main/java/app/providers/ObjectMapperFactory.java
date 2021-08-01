package app.providers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//import bla-bla-bla.DateUtil;

public class ObjectMapperFactory {

	public static ObjectMapper getInstance() {

		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
		
		mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
		
        JavaTimeModule module = new JavaTimeModule();
        
        return mapper;
	}
}