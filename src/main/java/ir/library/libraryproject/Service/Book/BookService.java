package ir.library.libraryproject.Service.Book;

import ir.library.libraryproject.dto.request.BookRequest;
import ir.library.libraryproject.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    BookResponse save(BookRequest bookRequest);

    Page<BookResponse> findAll(Pageable pageable);
}
