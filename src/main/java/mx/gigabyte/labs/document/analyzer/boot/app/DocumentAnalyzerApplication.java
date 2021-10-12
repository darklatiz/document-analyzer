package mx.gigabyte.labs.document.analyzer.boot.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"mx.gigabyte.labs.document.analyzer.domain"})
@ComponentScan(basePackages = {"mx.gigabyte.labs.document.analyzer"})
@EnableJpaRepositories(basePackages = {"mx.gigabyte.labs.document.analyzer"})
public class DocumentAnalyzerApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(DocumentAnalyzerApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

  }
}
