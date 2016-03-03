package tutorial.spring;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

import tutorial.spring.dao.ArticleDao;
import tutorial.spring.dao.AuthorDao;
import tutorial.spring.model.Article;
import tutorial.spring.model.Author;

@Slf4j
@SpringBootApplication
public class SpringTutorialApplication {

  @Bean
  public CommandLineRunner demo(ArticleDao articleDao, AuthorDao authorDao) {

    return (args) -> {
      Author defaultAuthor = authorDao.findOne(1);

      long counter = articleDao.count();
      log.info("there are {} articles.", counter);
      if (counter == 0L) {
        Article first = new Article();
        first.setDate(new Date());
        first.setTitle("Spring Boot");
        first.setSummary("Informazioni sul tutorial su spring boot");
        first.setAuthor(defaultAuthor);

        Article second = new Article();
        second.setDate(new Date());
        second.setTitle("JPA");
        second.setSummary("Dettagli sul corso su Java Persistence API");
        second.setAuthor(defaultAuthor);

        log.info("save new articles");
        articleDao.save(first);
        articleDao.save(second);
      }
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringTutorialApplication.class, args);
  }
}
