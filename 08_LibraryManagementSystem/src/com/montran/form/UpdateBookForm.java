package com.montran.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateBookForm extends ActionForm {

	private String serialNo;
	private int memberCode;
	private String memberName;
	private int bookCode;
	private String bookTitle;
	private String bookAuthor;
	private String dueDate;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
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

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getBookCode() == 0 && request.getParameter("getBookData") != null) {
			errors.add("bookCodeError", new ActionMessage("error.label.bookCode"));
		}

		if (request.getParameter("updateBook") != null) {
			if (getBookCode() == 0) {
				errors.add("bookCodeError", new ActionMessage("error.label.bookCode"));
			} else if (getDueDate().equals("")) {
				errors.add("fillDetailError", new ActionMessage("error.dueDate"));
			}
		}

		return errors;
	}
}
