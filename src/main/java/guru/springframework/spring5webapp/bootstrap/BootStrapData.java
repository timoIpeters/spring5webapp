package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

//CommandLineRunner -> spring looks for instances of this type. If it finds some, it runs them
//@Component -> tells spring framework to detect this as a spring managed component
@Component
public class BootStrapData implements CommandLineRunner {

  //dependency injection
  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(AuthorRepository authorRepository,
      BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    System.out.println("Started in Bootstrap");

    //add Publisher
    Publisher pub = new Publisher();
    pub.setName("Springer");
    pub.setCountry("Germany");
    pub.setCity("Cologne");
    pub.setPostalcode("46743");
    pub.setAddressLine1("some street");
    publisherRepository.save(pub);

    System.out.println("Publisher count: " + publisherRepository.count());

    //create author and book
    Author timo = new Author("Timo", "Peters");
    Book myBook = new Book("Book Title", "123456789");

    //add author and book
    timo.getBooks().add(myBook);
    myBook.getAuthors().add(timo);

    myBook.setPublisher(pub);
    pub.getBooks().add(myBook);

    //safe in the repository
    //saves book and author in the H2 Database
    authorRepository.save(timo);
    bookRepository.save(myBook);
    publisherRepository.save(pub);

    //second example
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "5495782459437");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);
    noEJB.setPublisher(pub);
    pub.getBooks().add(noEJB);
    authorRepository.save(rod);
    bookRepository.save(noEJB);
    publisherRepository.save(pub);

    //output when starting spring application
    System.out.println("Number of Books: " + bookRepository.count());
    System.out.println("Publisher Number of Books: " + pub.getBooks().size());
  }
}
