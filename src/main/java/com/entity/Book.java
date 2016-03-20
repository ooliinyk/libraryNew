package com.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 15.03.2016.
 */
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_info")
    private String info;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_style")
    private String style;

    @OneToOne(optional = false, mappedBy="book")
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
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (info != null ? !info.equals(book.info) : book.info != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (style != null ? !style.equals(book.style) : book.style != null) return false;
        return !(bookDocument != null ? !bookDocument.equals(book.bookDocument) : book.bookDocument != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (bookDocument != null ? bookDocument.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", author='" + author + '\'' +
                ", style='" + style + '\'' +
                ", bookDocument=" + bookDocument +
                '}';
    }
}
