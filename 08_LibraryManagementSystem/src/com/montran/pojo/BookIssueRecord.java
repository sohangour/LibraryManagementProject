package com.montran.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "book_issue_record")
public class BookIssueRecord {
	@Id
	@Column(name = "serial_no")
	private String serialNo;

	@Column(name = "date_of_issue", insertable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfIssue;

	@Column(name = "due_date")
	@Temporal(TemporalType.DATE)
	private Date dueDate;

	@OneToOne
	@JoinColumn(name = "member_code")
	private Member member;

	@OneToOne
	@JoinColumn(name = "book_code")
	private Book book;

	public BookIssueRecord() {

	}

	public BookIssueRecord(String serialNo, Date dueDate, Member member, Book book) {

		this.serialNo = serialNo;
		this.dueDate = dueDate;
		this.member = member;
		this.book = book;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookIssueRecord [serialNo=" + serialNo + ", dateOfIssue=" + dateOfIssue + ", dueDate=" + dueDate
				+ ", member=" + member + ", book=" + book + "]";
	}

}
