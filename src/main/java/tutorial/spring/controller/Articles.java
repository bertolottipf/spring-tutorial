package tutorial.spring.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import tutorial.spring.dao.ArticleDao;
import tutorial.spring.model.Article;

/**
 * @author marco
 *
 */
@Controller
public class Articles {

  public static int PER_PAGE = 10;

  @Inject
  ArticleDao articleDao;

  @RequestMapping("/")
  public String list(Model model, Optional<Integer> size) {
    final int perPage = size.orElse(PER_PAGE);
    final Page<Article> articles = articleDao.findAll(new PageRequest(0, perPage));
    model.addAttribute("articles", articles);
    return "index";
  }

  @RequestMapping("/byAuthorSurname")
  public String listByAuthorSurname(Model model, @RequestParam("surname") String surname) {
    final Page<Article> articles = articleDao.findByAuthorSurname(surname, new PageRequest(0, PER_PAGE));
    model.addAttribute("articles", articles);
    return "index";
  }

  @RequestMapping("/article/{id}")
  public String article(@PathVariable Integer id, Model model) {
    final Article article = articleDao.findOne(id);
    model.addAttribute("article", article);
    return "article";
  }

  @RequestMapping(value="/article", method=RequestMethod.POST)
  public String save(@Valid Article article, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("article", article);
      return "article";
    }
    return "redirect:/";
  }


}
