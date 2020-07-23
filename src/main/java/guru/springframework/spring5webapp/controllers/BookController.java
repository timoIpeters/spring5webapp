package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

//turns the java class into a Spring MVC controller
@Controller
public class BookController {

  private final BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  //map to a specific url
  //method invoked, when we do an action against the url /books
  @RequestMapping("/books")
  //parameter model which is being passed to the view
  public String getBooks(Model model){
    //at runtime, when there is a /books request the getBooks method is invoked which gets a model
    //that model gets a book attribute which has a list of books from the database assigned to it
    model.addAttribute("books", bookRepository.findAll());

    //view name
    return "books/list";
  }
}
