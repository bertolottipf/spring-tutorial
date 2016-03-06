package tutorial.spring.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import tutorial.spring.model.Author;

/**
 * @author marco
 *
 */
public interface AuthorDao extends PagingAndSortingRepository<Author, Integer> {

  List<Author> findByOrderBySurnameAsc();
  List<Author> findByUsername(String username);
}
