package ir.library.libraryproject.Service.Book;

import ir.library.libraryproject.dto.request.BookRequest;
import ir.library.libraryproject.dto.response.BookResponse;

public interface BookService {

    BookResponse save(BookRequest bookRequest);
}
