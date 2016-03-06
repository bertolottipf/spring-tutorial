package tutorial.spring.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tutorial.spring.dao.ArticleDao;
import tutorial.spring.dao.AuthorDao;
import tutorial.spring.dao.TagDao;
import tutorial.spring.model.Article;
import tutorial.spring.model.Author;
import tutorial.spring.model.Tag;
import tutorial.spring.security.RealUser;

/**
 * @author marco
 *
 */
@Controller @Slf4j
public class Articles {

  public static int PER_PAGE = 10;

  @Inject
  ArticleDao articleDao;
  @Inject
  AuthorDao authorDao;
  @Inject
  TagDao tagDao;

  @RequestMapping("/")
  public String list(Model model, @RequestParam("surname") Optional<String> surname,
      @RequestParam("tagName") Optional<String> tagName) {
    final Page<Article> articles;

    if (surname.isPresent()) {
      articles = articleDao.findByAuthorSurname(surname.get(), new PageRequest(0, PER_PAGE));
    } else if (tagName.isPresent()) {
      articles = articleDao.findByTagName(tagName.get(), new PageRequest(0, PER_PAGE));
    } else {
      articles = articleDao.findByOrderByIdDesc(new PageRequest(0, PER_PAGE));
    }

    model.addAttribute("articles", articles);
    return "index";
  }

  @RequestMapping("/byAuthorSurname")
  public String listByAuthorSurname(Model model, @RequestParam("surname") String surname) {
    final Page<Article> articles = articleDao.findByAuthorSurname(surname, new PageRequest(0, PER_PAGE));
    model.addAttribute("articles", articles);
    return "index";
  }

  @RequestMapping("/article/{id:\\d+}")
  public String article(@PathVariable Integer id, Model model) {
    final Article article = articleDao.findOne(id);
    model.addAttribute("article", article);
    return "articles/article";
  }

  @RequestMapping(value="/article/save", method=RequestMethod.POST)
  public String create(@Valid Article article, BindingResult bindingResult,
      RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("flash_error",
          "Occorre correggere gli errori riportati.");
      return "articles/edit";
    }
    articleDao.save(article);
    return "redirect:/";
  }

  @RequestMapping("/article/new")
  public String edit(@AuthenticationPrincipal RealUser user, Model model) {
    final Article article = new Article();
    article.setDate(new Date());
    article.setAuthor(user.getAuthor());
    model.addAttribute("article", article);
    return "articles/edit";
  }

  @RequestMapping("/article/{id:\\d+}/edit")
  public String edit(@PathVariable Integer id, Model model) {
    final Article article = articleDao.findOne(id);
    model.addAttribute("article", article);
    return "articles/edit";
  }

  @RequestMapping("/article/{article:\\d+}/save")
  public String save(@Valid Article article, BindingResult bindingResult,
      RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("flash_error",
          "Occorre correggere gli errori riportati.");
      return "articles/edit";
    }
    articleDao.save(article);
    redirectAttributes.addFlashAttribute("flash_success",
        "Articolo salvato con successo.");
    return "redirect:/";
  }

  @ModelAttribute("authors")
  public List<Author> authors() {
    return authorDao.findByOrderBySurnameAsc();
  }

  @ModelAttribute("tags")
  public Iterable<Tag> tags() {
    return tagDao.findAll();
  }
}
