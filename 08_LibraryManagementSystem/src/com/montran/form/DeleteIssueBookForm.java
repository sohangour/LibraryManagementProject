package com.montran.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DeleteIssueBookForm extends ActionForm {

	private int bookCode;

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		if (getBookCode() == 0) {
			errors.add("bookCode", new ActionMessage("error.label.bookCode"));
		}
		return errors;
	}
}
