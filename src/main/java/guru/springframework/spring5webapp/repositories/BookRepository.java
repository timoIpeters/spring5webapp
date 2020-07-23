package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.domain.Book;

//repository for our Book entity
public interface BookRepository extends CrudRepository<Book, Long> {
}
