package com.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by user on 15.03.2016.
 */
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;



//    @NotNull
    @NotEmpty
    @Column(name = "book_name")
    private String name;

//    @NotNull
    @NotEmpty
    @Column(name = "book_info")
    private String info;

//    @NotNull
    @NotEmpty
    @Column(name = "book_author")
    private String author;

//        @NotNull
    @NotEmpty
    @Column(name = "book_style")
    private String style;

    @OneToOne(optional = false, mappedBy = "book")
    BookDocument bookDocument;

    public Book() {
    }

    public Book(String name, String info, String author, String style, BookDocument bookDocument) {
        this.name = name;
        this.info = info;
        this.author = author;
        this.style = style;
//        this.bookDocument = bookDocument;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public BookDocument getBookDocument() {
        return bookDocument;
    }

    //
    public void setBookDocument(BookDocument bookDocument) {
        this.bookDocument = bookDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (!name.equals(book.name)) return false;
        if (!info.equals(book.info)) return false;
        if (!author.equals(book.author)) return false;
        if (!style.equals(book.style)) return false;
        return bookDocument.equals(book.bookDocument);
//
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + info.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + style.hashCode();
        return result;
    }
}
