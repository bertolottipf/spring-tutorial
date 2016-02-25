package tutorial.spring.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cristian
 *
 */
@Entity
@Table(name="articles")
@Data
public class Article {

  @Id
  @GeneratedValue
  private Integer id;

  private String title;

  private String summary;

  private Date date;
}