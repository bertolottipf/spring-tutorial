package tutorial.spring.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import tutorial.spring.model.Tag;

/**
 * @author marco
 *
 */
public interface TagDao extends PagingAndSortingRepository<Tag, Integer> {

}
