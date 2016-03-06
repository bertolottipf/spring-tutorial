package tutorial.spring.security;

import lombok.Getter;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import tutorial.spring.model.Author;

/**
 * @author marco
 *
 */
public class RealUser extends User {

  @Getter
  private Author author;

  public RealUser(Author author) {
    super(author.getUsername(),
        author.getPassword(),
        AuthorityUtils.createAuthorityList("ADMIN"));
    this.author = author;
  }

  public Integer getId() {
    return author.getId();
  }
}