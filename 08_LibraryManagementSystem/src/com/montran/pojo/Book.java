package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_master")
public class Book {

	@Id
	@Column(name = "book_code")
	private int bookCode;

	@Column(name = "book_title")
	private String bookTitle;

	@Column(name = "book_author")
	private String bookAuthor;

	@Column(name = "book_issuable")
	private int bookIssuable;

	public Book() {

	}

	public Book(int bookCode, String bookTitle, String bookAuthor, int bookIssuable) {

		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookIssuable = bookIssuable;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookIssuable() {
		return bookIssuable;
	}

	public void setBookIssuable(int bookIssuable) {
		this.bookIssuable = bookIssuable;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", bookIssuable=" + bookIssuable + "]";
	}

}
