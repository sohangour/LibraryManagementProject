package com.montran.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.montran.dao.BookRecordDAO;
import com.montran.form.DeleteIssueBookForm;
import com.montran.pojo.Member;

public class DeleteIssueBookAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DeleteIssueBookForm deleteForm = (DeleteIssueBookForm) form;
		BookRecordDAO dao = new BookRecordDAO();
		int memberCode = dao.getBookRecord(deleteForm.getBookCode());
		int result = dao.deleteIssueBook(deleteForm.getBookCode());
		if (result > 0) {
			dao.updateMemberDetails(memberCode);
		} else {
			ActionErrors errors = new ActionErrors();
			errors.add("memberCodeError", new ActionMessage("error.notFound"));
			saveErrors(request, errors);
			return mapping.findForward("failure");
		}
		return mapping.findForward("success");
	}
}
