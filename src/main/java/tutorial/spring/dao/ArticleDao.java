package tutorial.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import tutorial.spring.model.Article;

/**
 * @author marco
 * @author cristian
 */
public interface ArticleDao extends PagingAndSortingRepository<Article, Integer> {

  /**
   * @param surname il cognome dell'autore da ricercare
   * @return la lista degli articoli il cui autore ha un determinato cognome
   */
  @Query("SELECT a FROM Article a WHERE a.author.surname = ?1")
  Page<Article> findByAuthorSurname(String surname, Pageable page);

  @Query("SELECT a FROM Article a JOIN a.tags t WHERE t.name = ?1")
  List<Article> findByTagName(String tagName);
}
