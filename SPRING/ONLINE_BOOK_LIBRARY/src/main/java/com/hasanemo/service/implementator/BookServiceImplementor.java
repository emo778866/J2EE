package com.hasanemo.service.implementator;

import com.hasanemo.entity.Book;
import com.hasanemo.model.BookRequestModel;
import com.hasanemo.repository.BookRepository;
import com.hasanemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImplementor implements BookService {

    private final BookRepository bookRepository;

    public Book registerBook(BookRequestModel bookRequestModel) {
        Book book = Book.builder()
                .title(bookRequestModel.getTitle())
                .author(bookRequestModel.getAuthor())
                .isbn(bookRequestModel.getIsbn())
                .build();
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book deleteBook(Long id) {
        Book book = bookRepository.findByBookId(id);
        if (book != null) {
            bookRepository.delete(book);
        }
        return book;
    }

    @Override
    public Book findBookByAuthorAndTitle(String authorName, String bookName) {
        return bookRepository.findByAuthorAndTitle(authorName, bookName);
    }

    @Override
    public Book updateBook(Long id, BookRequestModel bookRequestModel) {
        Book book = bookRepository.findByBookId(id);
        if (book != null) {
            book.setTitle(bookRequestModel.getTitle());
            book.setAuthor(bookRequestModel.getAuthor());
            bookRepository.save(book);
        }
        return book;
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findByBookId(id);
    }

    @Override
    public List<Book> findBookByAuthorName(String authorName) {
        return bookRepository.findByAuthor(authorName);
    }

}
