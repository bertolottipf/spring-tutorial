/**
 *
 */
package tutorial.spring.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author cristian
 *
 */
@Entity
@Table(name = "authors")
@Data @ToString(includeFieldNames = false, of = {"name", "surname"})
public class Author {
  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  private String surname;

  @OneToMany(mappedBy = "author")
  private List<Article> articles = new ArrayList<>();

}
