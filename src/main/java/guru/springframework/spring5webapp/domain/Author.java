package guru.springframework.spring5webapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//tells hibernate that this is an entity
@Entity
public class Author {

  //JPA ID
  @Id//needed inside an Entity class
  @GeneratedValue(strategy = GenerationType.AUTO) //underlaying database is providing the generation of the id
  private Long id;


  private String firstName;
  private String lastName;

  //creates a many to many relationship between Book and Author
  //mapped by authors property of Book.java
  @ManyToMany(mappedBy = "authors")
  private Set<Book> books;

  public Author(){

  }

  public Author(String firstName, String lastName, Set<Book> books) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.books = books;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  //basic toString implementation (ALT+INSERT)
  @Override
  public String toString() {
    return "Author{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", books=" + books +
        '}';
  }

  //equals function based on id
  //used IntelliJ Default template to generate equals function
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Author author = (Author) o;

    return id != null ? id.equals(author.id) : author.id == null;
  }

  //hashCode function for the id
  //used IntelliJ Default template to generate hashCode function
  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
