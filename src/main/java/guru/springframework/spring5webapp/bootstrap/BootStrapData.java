package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

//CommandLineRunner -> spring looks for instances of this type. If it finds some, it runs them
//@Component -> tells spring framework to detect this as a spring managed component
@Component
public class BootStrapData implements CommandLineRunner {

  //dependency injection
  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public BootStrapData(AuthorRepository authorRepository,
      BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    //create author and book
    Author timo = new Author("Timo", "Peters");
    Book myBook = new Book("Book Title", "123456789");

    //add author and book
    timo.getBooks().add(myBook);
    myBook.getAuthors().add(timo);

    //safe in the repository
    //saves book and author in the H2 Database
    authorRepository.save(timo);
    bookRepository.save(myBook);

    //second example
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "5495782459437");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);
    authorRepository.save(rod);
    bookRepository.save(noEJB);

    //output when starting spring application
    System.out.println("Started in Bootstrap");
    System.out.println("Number of Books: " + bookRepository.count());
  }
}
