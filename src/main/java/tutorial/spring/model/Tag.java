/**
 *
 */
package tutorial.spring.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author cristian
 *
 */
@Entity
@Table(name = "tags")
@Data
public class Tag {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  @ManyToMany(mappedBy = "tags")
  private List<Article> articles = new ArrayList<>();
}