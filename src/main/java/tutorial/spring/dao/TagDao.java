package tutorial.spring.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import tutorial.spring.model.Tag;

/**
 * @author cristian
 *
 */
public interface TagDao extends PagingAndSortingRepository<Tag, Integer> {

}
