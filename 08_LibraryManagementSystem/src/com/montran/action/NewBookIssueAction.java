package com.montran.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
import com.montran.form.AddNewBookForm;
import com.montran.pojo.Book;
import com.montran.pojo.BookIssueRecord;
import com.montran.pojo.Member;

public class NewBookIssueAction extends Action {
	String serialNo;
	String memberName;
	int memberCode;
	int bookCode;
	Date dueDate;
	Book book;
	Member member;
	BookIssueRecord record;
	DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BookRecordDAO dao = new BookRecordDAO();
		AddNewBookForm addForm = (AddNewBookForm) form;
		Book book = null;
		Member member = null;
		ActionErrors errors = new ActionErrors();
		bookCode = addForm.getBookCode();
		memberCode = addForm.getMemberCode();
		
		if (request.getParameter("getMemberData") != null) {
			member = dao.getMember(memberCode);
			if (member == null) {
				errors.add("memberCodeError", new ActionMessage("error.memberCode"));
				saveErrors(request, errors);
			} else {
				addForm.setMemberCode(member.getMemberCode());
				addForm.setMemberName(member.getMemberName());

			}
			return mapping.findForward("getMemberData");
		} else if (request.getParameter("getBookData") != null) {

			book = dao.getBook(bookCode);
			if (book == null) {
				errors.add("bookCodeError", new ActionMessage("error.bookCode"));
				saveErrors(request, errors);
			} else {
				addForm.setBookCode(book.getBookCode());
				addForm.setBookTitle(book.getBookTitle());
				addForm.setBookAuthor(book.getBookAuthor());
			}
			return mapping.findForward("getMemberData");
		}

		else {
			serialNo = addForm.getSerialNo();
			dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(addForm.getDueDate());
			book = dao.getBook(bookCode);
			member = dao.getMember(memberCode);
			if (book != null && member != null) {

				if (book.getBookIssuable() == 0) {
					errors.add("fillDetailError", new ActionMessage("error.bookNotIssuable"));
					saveErrors(request, errors);
					return mapping.findForward("getMemberData");
				} else {
					int result = dao.bookAlreadyIssue(bookCode);
					if (result > 0) {
						errors.add("fillDetailError", new ActionMessage("error.alreayIssued"));
						saveErrors(request, errors);
						return mapping.findForward("getMemberData");
					} else {
						if (member.getTotalIssuedBook() < member.getLimitIssuedBook()) {
							dao.updateMemberDetail(memberCode);
							BookIssueRecord bookIssueRecord = new BookIssueRecord(serialNo, dueDate, member, book);
							dao.addBookIssue(bookIssueRecord);
							return mapping.findForward("success");

						} else {
							errors.add("fillDetailError", new ActionMessage("error.limitExceed"));
							saveErrors(request, errors);
							return mapping.findForward("getMemberData");
						}

					}
				}
			} else {
				errors.add("fillDetailError", new ActionMessage("error.fillInfo"));
				saveErrors(request, errors);

				return mapping.findForward("getMemberData");
			}

		}

	}
}
