package mx.gigabyte.labs.document.analyzer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import mx.gigabyte.labs.document.analyzer.domain.ObjectMapperFactory;
import mx.gigabyte.labs.document.analyzer.domain.model.enums.DocumentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new DocumentTypeConverter());
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(customJsonObjectConverter());
    converters.add(new StringHttpMessageConverter());
  }

  private static class DocumentTypeConverter implements Converter<String, DocumentType> {
    @Override
    public DocumentType convert(String documentType) {
      return DocumentType.valueOf(documentType);
    }
  }

  @Bean
  static ObjectMapper jsonObjectMapper() {
    return ObjectMapperFactory.getObjectMapper();
  }

  @Bean
  MappingJackson2HttpMessageConverter customJsonObjectConverter() {
    return new MappingJackson2HttpMessageConverter(jsonObjectMapper());
  }
}
