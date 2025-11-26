package ir.library.libraryproject.Service.Book;

import ir.library.libraryproject.Model.Book;
import ir.library.libraryproject.dto.request.BookRequest;
import ir.library.libraryproject.dto.response.BookResponse;
import ir.library.libraryproject.exception.RuleException;
import ir.library.libraryproject.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {

        Optional<Book> findExistBook=
                bookRepository.findByName(bookRequest.getName());
        if (findExistBook.isPresent()){
            throw new RuleException("book.is.exist");
        }
        Book save = bookRepository.save(createBook(bookRequest));
        return createBookResponse(save);
    }

    @Override
    public Page<BookResponse> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(book->
                        BookResponse.builder()
                                .id(book.getId())
                                .name(book.getName())
                                .price(book.getPrice())
                                .build()
                );
    }

    @Override
    public List<BookResponse> findByName(String name) {
        return bookRepository.findByNameContains(name)
                .stream().map((book) ->
                        BookResponse.builder()
                            .id(book.getId())
                            .name(book.getName())
                            .price(book.getPrice())
                                .build())
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse findById(Long id) {
         return createBookResponse(findByIdReturnBook(id));
    }

    @Override
    @Transactional//This annotation: When you edit a book, it saves the edit in the database.
    public void deleted(Long id) {
        Book bookById=findByIdReturnBook(id);
        bookRepository.delete(bookById);
    }


    private Book createBook(BookRequest bookRequest){
        return Book.builder()
                .name(bookRequest.getName())
                .price(bookRequest.getPrice())
                .build();
    }
    private BookResponse createBookResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }

    private Book findByIdReturnBook(Long id){
        return bookRepository.findById(id)
                .orElseThrow(()->new RuleException("book.not.found"));
    }

}
