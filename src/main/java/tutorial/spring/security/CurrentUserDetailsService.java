package tutorial.spring.security;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tutorial.spring.dao.AuthorDao;
import tutorial.spring.model.Author;

import java.util.List;

import javax.inject.Inject;

@Service
@Slf4j
public class CurrentUserDetailsService implements UserDetailsService {

  @Inject
  AuthorDao authorDao;

  @Override
  @Transactional
  public RealUser loadUserByUsername(String username) throws UsernameNotFoundException {
    List<Author> results = authorDao.findByUsername(username);
    if (results.isEmpty()) {
      log.error("current user for {} not found", username);
      throw new UsernameNotFoundException("username " + username + " not found");
    } else {
      log.info("current user for {} found", results);
      return new RealUser(results.iterator().next());
    }
  }
}