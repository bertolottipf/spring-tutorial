package tutorial.spring.controller;

import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Security {

  @Inject
  MessageSource messageSource;

  @RequestMapping(value = "/login", method=RequestMethod.GET)
  public String getLoginPage(@RequestParam Optional<String> error, Model model) {
    model.addAttribute("error", error);
    model.addAttribute("username", "");
    model.addAttribute("password", "");
    return "login";
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logoutPage(HttpServletRequest request, HttpServletResponse response,
      RedirectAttributes ra, Locale locale) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    ra.addFlashAttribute("flash_success", messageSource.getMessage("logout.successfully", null, locale));
    return "redirect:/login";
  }
}
