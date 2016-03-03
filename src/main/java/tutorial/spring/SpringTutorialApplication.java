package tutorial.spring;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

import tutorial.spring.dao.ArticleDao;
import tutorial.spring.dao.AuthorDao;
import tutorial.spring.dao.TagDao;
import tutorial.spring.model.Article;
import tutorial.spring.model.Author;
import tutorial.spring.model.Tag;

@Slf4j
@SpringBootApplication
public class SpringTutorialApplication {

  @Bean
  public CommandLineRunner demo(ArticleDao articleDao, AuthorDao authorDao,
      TagDao tagDao) {

    return (args) -> {
      Author defaultAuthor = authorDao.findOne(1);
      Tag firstTag;
      Tag secondTag;
      if (tagDao.count() == 0L) {
        firstTag = new Tag();
        firstTag.setName("Spring");
        tagDao.save(firstTag);
        secondTag = new Tag();
        secondTag.setName("JPA");
        tagDao.save(secondTag);
      } else {
        firstTag = tagDao.findOne(1);
        secondTag = tagDao.findOne(2);
      }

      long counter = articleDao.count();
      log.info("there are {} articles.", counter);
      if (counter == 0L) {
        Article first = new Article();
        first.setDate(new Date());
        first.setTitle("Spring Boot");
        first.setSummary("Informazioni sul tutorial su spring boot");
        first.setAuthor(defaultAuthor);
        first.getTags().add(firstTag);

        Article second = new Article();
        second.setDate(new Date());
        second.setTitle("JPA");
        second.setSummary("Dettagli sul corso su Java Persistence API");
        second.setAuthor(defaultAuthor);
        second.getTags().add(secondTag);

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
