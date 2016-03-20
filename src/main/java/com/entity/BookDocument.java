package com.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="book_document")
public class BookDocument {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "book_document_id")
	private Integer id;	
	
	@Column(name="name", length=100, nullable=false)
	private String name;
	
	@Column(name="description", length=255)
	private String description;
	
	@Column(name="type", length=100, nullable=false)
	private String type;
	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="content", nullable=false)
	private byte[] content;

//	@OneToOne(optional = false)
//	@JoinColumn(name = "book_iddd")
//	private Book book;

	@OneToOne(optional = false)
	@JoinColumn(name = "book_iddd")
	private Book book;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BookDocument that = (BookDocument) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (description != null ? !description.equals(that.description) : that.description != null) return false;
		if (type != null ? !type.equals(that.type) : that.type != null) return false;
		if (!Arrays.equals(content, that.content)) return false;
		return !(book != null ? !book.equals(that.book) : that.book != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (content != null ? Arrays.hashCode(content) : 0);
		result = 31 * result + (book != null ? book.hashCode() : 0);
		return result;
	}


}
