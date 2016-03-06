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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author cristian
 *
 */
@Entity
@Table(name = "authors")
@Data
public class Author {
  @Id
  @GeneratedValue
  private Integer id;

  @Size(min=2, max=250)
  @NotNull
  private String name;

  @Size(min=2, max=250)
  @NotNull
  private String surname;

  @OneToMany(mappedBy = "author")
  private List<Article> articles = new ArrayList<>();

  @Size(min=5, max=30)
  @NotNull
  private String username;

  @Size(min=5, max=30)
  @NotNull
  private String password;

  @Override
  public String toString() {
    return name + " " + surname;
  }
}
