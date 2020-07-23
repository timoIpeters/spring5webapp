package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.domain.Author;

//repository for our Author entity
//we provide the repository interface. Spring Data JPA provides the implementation of all those methods
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
