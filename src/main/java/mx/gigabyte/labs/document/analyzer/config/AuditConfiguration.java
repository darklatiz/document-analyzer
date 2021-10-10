package mx.gigabyte.labs.document.analyzer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableJpaAuditing
public class AuditConfiguration {

//  @Bean
//  public AuditorAware<String> auditorProvider() {
//    return () -> Optional.of("Luigi-TheGod");
//  }

}
