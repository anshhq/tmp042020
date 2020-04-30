package com.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libraries_")
public class Library {

	private long libraryId;
	private String libraryName;

	public Library() {
	}

	public Library(String libraryName) {
		this.libraryName = libraryName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(long id) {
		this.libraryId = id;
	}

	@Column(name = "libraryName", nullable = false)
	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	/*
	 * @Column(name = "bookId", nullable = false) public String getBookId() { return
	 * bookId; } public void setBookId(String bookId) { this.bookId = bookId; }
	 */

	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", libraryName=" + libraryName + "]";
	}
}
