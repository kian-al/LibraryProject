package ir.library.libraryproject.repository;

import ir.library.libraryproject.Model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByName(String name);

    Page<Book> findAll(Pageable pageable);
}
