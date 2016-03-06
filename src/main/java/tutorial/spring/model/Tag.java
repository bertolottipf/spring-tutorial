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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

  @Size(min=1, max=200)
  @NotNull
  private String name;

  @ManyToMany(mappedBy = "tags")
  private List<Article> articles = new ArrayList<>();

  @Override
  public String toString() {
    return name;
  }
}