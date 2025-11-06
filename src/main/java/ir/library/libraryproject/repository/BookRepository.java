package ir.library.libraryproject.repository;

import ir.library.libraryproject.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
