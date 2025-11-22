package ir.library.libraryproject.controller;

import ir.library.libraryproject.Service.Book.BookService;
import ir.library.libraryproject.dto.request.BookRequest;
import ir.library.libraryproject.dto.response.BookResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> save(@RequestBody @Valid BookRequest bookRequest){
        return ResponseEntity.ok(bookService.save(bookRequest));
    }
    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAll(Pageable pageable){
        return ResponseEntity.ok(bookService.findAll(pageable));
    }
    @GetMapping("/{bookname}")
    public ResponseEntity<List<BookResponse>> findByName(@PathVariable String bookname){
        return ResponseEntity.ok(bookService.findByName(bookname));
    }
}
