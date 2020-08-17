package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member_master")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_code")
	private int memberCode;

	@Column(name = "member_name")
	private String memberName;

	@Column(name = "member_type")
	private String memberType;

	@Column(name = "issue_book_total")
	private int totalIssuedBook;

	@Column(name = "issue_book_limit")
	private int limitIssuedBook;

	public Member() {

	}

	

	public Member(int memberCode, String memberName, String memberType, int totalIssuedBook, int limitIssuedBook) {
		
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.memberType = memberType;
		this.totalIssuedBook = totalIssuedBook;
		this.limitIssuedBook = limitIssuedBook;
	}



	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public int getTotalIssuedBook() {
		return totalIssuedBook;
	}

	public void setTotalIssuedBook(int totalIssuedBook) {
		this.totalIssuedBook = totalIssuedBook;
	}

	public int getLimitIssuedBook() {
		return limitIssuedBook;
	}

	public void setLimitIssuedBook(int limitIssuedBook) {
		this.limitIssuedBook = limitIssuedBook;
	}

	@Override
	public String toString() {
		return "Member [memberCode=" + memberCode + ", memberName=" + memberName + ", memberType=" + memberType
				+ ", totalIssuedBook=" + totalIssuedBook + ", limitIssuedBook=" + limitIssuedBook + "]";
	}

}
