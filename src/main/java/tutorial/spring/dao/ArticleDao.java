package tutorial.spring.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import tutorial.spring.model.Article;

/**
 * @author marco
 *
 */
public interface ArticleDao extends PagingAndSortingRepository<Article, Integer> {

  @Query("SELECT a FROM Article a JOIN a.tags t WHERE t.name = :tagName")
  List<Article> findByTagName(String tagName);
}
