package tutorial.spring.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import tutorial.spring.model.Author;

/**
 * @author marco
 *
 */
public interface AuthorDao extends PagingAndSortingRepository<Author, Integer> {
  //Empty interface
}
