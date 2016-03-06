package tutorial.spring.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author cristian
 *
 */
@Entity
@Table(name="articles")
@Data
public class Article {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Size(min=1, max=200)
  @NotNull
  @Column(nullable=false)
  private String title;

  @NotNull @Size(min=1, max=5000)
  private String summary;

  @NotNull
  private Date date;

  @NotNull
  @ManyToOne(optional = false)
  private Author author;

  @ManyToMany
  @JoinTable(name = "articles_tags")
  private List<Tag> tags = new ArrayList<>();
}