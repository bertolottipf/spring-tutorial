## Synopsis

Tutorial in Italiano su Spring Boot e Spring MVC con utilizzo di Java Persistent API (JPA) ed Hibernate.

Il progetto contiene:
 - le slide per un'esercitazione sull'utilizzo di Spring, disponibili nei formati:
  - revealjs dentro il file slide-esercizione.zip
  - asciidoctor nella file src/docs/spring-training.adoc e src/docs/jpa-training.adoc
 - il codice sorgente degli esempi mostrati nell'esercitazione
  - (Applicazione Spring Boot per la gestione di un blog)

Le esercitazioni sono suddivise in tre fasi, corrispondenti ai branch:
 - first
 - second
 - third

Fare il checkout del branch desiderato in funzione del punto da cui si desidera partire.

Gli esempi sono basati sull'utilizzo di Java 8, Maven per la
risoluzione delle dipendenze e h2 come database e Spring Boot 1.3.

Le slide dell'esercitazione sono scritte con asciidoctor + revealjs.

## Code Example

La teoria e gli esercizi pratici guidano fino alla scrittura di una piccola applicazione
per la gestione di un Blog.
Sono presenti esempi di Controller, Entity JPA, DAO e viste realizzate con Freemarker e
Twitter Bootstrap per il template html/css.

```
  //Controller Articles.java
  //...
  @RequestMapping("/")
  public String list(Model model, @RequestParam("surname") Optional<String> surname,
      @RequestParam("tagName") Optional<String> tagName) {
    final Page<Article> articles;

    if (surname.isPresent()) {
      articles = articleDao.findByAuthorSurname(surname.get(), new PageRequest(0, PER_PAGE));
    } else if (tagName.isPresent()) {
      articles = articleDao.findByTagName(tagName.get(), new PageRequest(0, PER_PAGE));
    } else {
      articles = articleDao.findAll(new PageRequest(0, PER_PAGE));
    }

    model.addAttribute("articles", articles);
    return "index";
  }
  
  ...
  
  public interface ArticleDao extends PagingAndSortingRepository<Article, Integer> {

  /**
   * @param surname il cognome dell'autore da ricercare
   * @return la lista degli articoli il cui autore ha un determinato cognome
   */
  @Query("SELECT a FROM Article a WHERE a.author.surname = ?1")
  Page<Article> findByAuthorSurname(String surname, Pageable page);
  
```

## Installation

Per la parte dei sorgenti Java è possibile utilizzare questo progetto
come progetto Maven ed importarlo nel proprio editor preferito.

Le slide delle esercitazioni sono in ascidoctor + revealjs per
produrle seguire le istruzioni in src/docs/README.txt.

## Contributors

Marco Andreini <marco.andreini@gmail.com>

Cristian Lucchesi <cristian.lucchesi@gmail.com>, @criluc

## License

GNU GENERAL PUBLIC LICENSE
Version 3, 29 June 2007
