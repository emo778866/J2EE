package com.hasanemo.entity;


import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bookId;
    private String title;
    private String author;
    private String isbn;

}
