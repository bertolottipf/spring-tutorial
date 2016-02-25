package tutorial.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tutorial.spring.dao.ArticleDao;
import tutorial.spring.model.Article;

import javax.inject.Inject;

@Controller
public class Application {

  @Inject
  ArticleDao articleDao;

  @RequestMapping("/")
  public String index(Model model) {
    final Iterable<Article> articles = articleDao.findAll();
    model.addAttribute("articles", articles);
    return "index";
  }

  @RequestMapping("/article/{id}")
  public String article(@PathVariable Integer id, Model model) {
    final Article article = articleDao.findOne(id);
    model.addAttribute("article", article);
    return "article";
  }
}
