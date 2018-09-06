package io.douglastenn.beerservice.config.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

@Configuration
public class JacksonConfig {
    @Bean
    public JavaTimeModule javaTimeModule() {
        final JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(ISO_DATE_TIME));
        return javaTimeModule;
    }

    @Bean
    public ObjectMapper jsonObjectMapper(final JavaTimeModule javaTimeModule) {
        return Jackson2ObjectMapperBuilder
                .json()
                .serializationInclusion(NON_NULL)
                .featuresToDisable(WRITE_DATES_AS_TIMESTAMPS)
                .modules(javaTimeModule)
                .simpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .build();
    }
}
