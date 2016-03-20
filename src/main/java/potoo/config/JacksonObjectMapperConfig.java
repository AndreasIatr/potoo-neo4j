package potoo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class JacksonObjectMapperConfig {

	@Bean
	@Primary
	public ObjectMapper jacksonObjectMapper() {
		Jackson2ObjectMapperFactoryBean bean = new Jackson2ObjectMapperFactoryBean();
		bean.setIndentOutput(true);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		bean.setObjectMapper(objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true));
		bean.setObjectMapper(objectMapper);
		bean.afterPropertiesSet();
		return bean.getObject();
	}
}
