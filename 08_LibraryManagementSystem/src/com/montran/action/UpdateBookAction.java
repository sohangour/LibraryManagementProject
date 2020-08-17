package com.montran.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.montran.dao.BookRecordDAO;
import com.montran.form.UpdateBookForm;
import com.montran.pojo.Book;
import com.montran.pojo.BookIssueRecord;

public class UpdateBookAction extends Action {
	private static int i = 0;
	Date dueDate;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In Action Class");

		UpdateBookForm bookForm = (UpdateBookForm) form;
		BookRecordDAO dao = new BookRecordDAO();
		BookIssueRecord bookIssueRecord = null;
		Book book = null;
		ActionErrors errors;
		if (request.getParameter("getBookData") != null) {
			bookIssueRecord = dao.getRecord(bookForm.getBookCode());
			i = 1;
			try {
				bookForm.setSerialNo(bookIssueRecord.getSerialNo());
				bookForm.setBookTitle(bookIssueRecord.getBook().getBookTitle());
				bookForm.setBookAuthor(bookIssueRecord.getBook().getBookAuthor());
				bookForm.setMemberName(bookIssueRecord.getMember().getMemberName());
				bookForm.setDueDate(bookIssueRecord.getDueDate().toString());
			} catch (Exception e) {
				i = 0;

				bookForm.setSerialNo("");
				bookForm.setBookTitle("");
				bookForm.setBookAuthor("");
				bookForm.setMemberName("");
				bookForm.setDueDate("");
				System.out.println("Exception");
				errors = new ActionErrors();
				errors.add("fillDetailError", new ActionMessage("error.recordNotFound"));
				saveErrors(request, errors);
			}
		} else if (request.getParameter("updateBook") != null && i == 1) {
			bookIssueRecord = dao.getRecord(bookForm.getBookCode());
			dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(bookForm.getDueDate());
			if (dueDate.compareTo(bookIssueRecord.getDueDate()) <= 0) {
				System.out.println("smaller than database");
				errors = new ActionErrors();
				errors.add("fillDetailError", new ActionMessage("error.updatedate"));
				saveErrors(request, errors);
			} else {
				System.out.println("Greater than database");
				dao.updateBookIssueRecord(bookIssueRecord.getSerialNo(), dueDate);
				return mapping.findForward("success");
			}

		} else {
			errors = new ActionErrors();
			errors.add("fillDetailError", new ActionMessage("error.getDetail"));
			saveErrors(request, errors);
		}
		return mapping.findForward("failure");
	}

}
