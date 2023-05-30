package com.hasanemo.service;

import com.hasanemo.entity.Book;
import com.hasanemo.model.BookRequestModel;

import java.util.List;

public interface BookService {

    Book registerBook(BookRequestModel bookRequestModel);

    List<Book> getAllBooks();

    Book deleteBook(Long id);

    Book findBookByAuthorAndTitle(String authorName, String bookName);


    Book updateBook(Long id, BookRequestModel bookRequestModel);

    Book findBookById(Long id);

    List<Book> findBookByAuthorName(String authorName);

}
