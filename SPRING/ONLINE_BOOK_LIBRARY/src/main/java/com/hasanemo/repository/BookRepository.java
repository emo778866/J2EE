package com.hasanemo.repository;

import com.hasanemo.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByBookId(Long BookId);

    Book findByAuthorAndTitle(String authorName, String bookName);

    @Query("SELECT b FROM Book b WHERE b.author = :authorName")
    List<Book> findByAuthor(@Param("authorName") String authorName);

}
