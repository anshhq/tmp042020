package com.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	private long bookId;
	private long libraryId;
	private String bookName;

	public Book() {
	}

	public Book(String bookName, long libraryId) {
		this.bookName = bookName;
		this.libraryId = libraryId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	@Column(name = "bookName", nullable = false)
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name = "libraryId", nullable = false)
	public long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(long libraryId) {
		this.libraryId = libraryId;
	}

	/*
	 * @Column(name = "bookId", nullable = false) public String getBookId() { return
	 * bookId; } public void setBookId(String bookId) { this.bookId = bookId; }
	 */

	@Override
	public String toString() {
		return "Library [bookId=" + bookId + ", bookName=" + bookName + ", libraryId= " + libraryId + "]";
	}
}
