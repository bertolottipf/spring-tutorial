package tutorial.spring;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

import tutorial.spring.dao.ArticleDao;
import tutorial.spring.model.Article;

@Slf4j
@SpringBootApplication
public class SpringTutorialApplication {

  @Bean
  public CommandLineRunner demo(ArticleDao dao) {

    return (args) -> {
      long counter = dao.count();
      log.info("there are {} articles.", counter);
      if (counter == 0L) {
        Article first = new Article();
        first.setDate(new Date());
        first.setTitle("Spring Boot");
        first.setSummary("Informazioni sul tutorial su spring boot");

        Article second = new Article();
        second.setDate(new Date());
        second.setTitle("JPA");
        second.setSummary("Dettagli sul corso su Java Persistence API");

        log.info("save new articles");
        dao.save(first);
        dao.save(second);
      }
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringTutorialApplication.class, args);
  }
}
