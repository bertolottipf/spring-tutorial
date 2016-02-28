package tutorial.spring.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

  @NotNull
  @Column(nullable=false)
  private String title;

  private String summary;

  private Date date;
}