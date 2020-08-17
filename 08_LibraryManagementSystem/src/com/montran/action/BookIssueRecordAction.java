package com.montran.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookRecordDAO;
import com.montran.pojo.BookIssueRecord;

public class BookIssueRecordAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BookRecordDAO dao = new BookRecordDAO();
		List<BookIssueRecord> list = dao.getAllRecord();
		request.setAttribute("listBook", list);
		return mapping.findForward("success");
	}

}
