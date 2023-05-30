package com.hasanemo.controller;

import com.hasanemo.entity.Book;
import com.hasanemo.exception.BookIdNotFoundException;
import com.hasanemo.model.BookRequestModel;
import com.hasanemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Object> registerBook(@RequestBody BookRequestModel bookRequestModel) {
        Book savedBook = bookService.registerBook(bookRequestModel);
        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> allBook() {
        List<Book> listOfBooks = bookService.getAllBooks();
        return new ResponseEntity<>(listOfBooks, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBookById(@PathVariable Long id) {
        Book deletedBook = bookService.deleteBook(id);
        if (deletedBook == null) {
            throw new BookIdNotFoundException("A book containing the id-" + id + " was not found in the database!");
        }
        return new ResponseEntity<>("The following book was deleted -\n" + deletedBook, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateBookById(@PathVariable Long id, @RequestBody BookRequestModel bookRequestModel) {
        Book updatedBook = bookService.updateBook(id, bookRequestModel);
        if (updatedBook == null) {
            throw new BookIdNotFoundException("A book containing the id-" + id + " was not found in the database!");
        }
        return new ResponseEntity<>("Updated information of the book is -\n" + updatedBook, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> bookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        if (book == null) {
            throw new BookIdNotFoundException("A book containing the id-" + id + " was not found in the database!");
        }
        return new ResponseEntity<>(book, HttpStatus.FOUND);
    }

    @GetMapping("/author/{authorName}")
    public ResponseEntity<Object> bookByAuthorName(@PathVariable String authorName) {
        List<Book> book = bookService.findBookByAuthorName(authorName);
        if (book.isEmpty()) {
            throw new BookIdNotFoundException("Any book by " + authorName + " was not found in the database!");
        }
        return new ResponseEntity<>(book, HttpStatus.FOUND);
    }

    @GetMapping("/{authorName}/{bookName}")
    public ResponseEntity<Object> findBookByAuthorAndTitle(@PathVariable String authorName, @PathVariable String bookName) {
        Book book = bookService.findBookByAuthorAndTitle(authorName, bookName);
        if (book == null) {
            throw new BookIdNotFoundException("No row found for author: " + authorName + " and book: " + bookName);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
