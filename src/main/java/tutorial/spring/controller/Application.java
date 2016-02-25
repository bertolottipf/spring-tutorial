package tutorial.spring.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tutorial.spring.dao.ArticleDao;
import tutorial.spring.model.Article;

import javax.inject.Inject;

@Controller
public class Application {

  @Inject
  ArticleDao articleDao;

  @RequestMapping("/")
  public String index(ModelAndView modelAndView) {
    Page<Article> articles = articleDao.findAll(new PageRequest(1, 20));
    modelAndView.addObject("articles", articles);
    return "index";
  }
}
