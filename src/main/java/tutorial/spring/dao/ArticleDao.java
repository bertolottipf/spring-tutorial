package tutorial.spring.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import tutorial.spring.model.Article;

/**
 * @author marco
 *
 */
public interface ArticleDao extends PagingAndSortingRepository<Article, Integer> {

}
