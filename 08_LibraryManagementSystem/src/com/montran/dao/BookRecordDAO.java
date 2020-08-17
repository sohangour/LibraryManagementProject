package com.montran.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.montran.pojo.Book;
import com.montran.pojo.BookIssueRecord;
import com.montran.pojo.Member;
import com.montran.util.SessionFactoryUtil;

public class BookRecordDAO {

	private SessionFactory factory = SessionFactoryUtil.getSessionFactory();
	private Session session;
	private Transaction transaction;

	public List<BookIssueRecord> getAllRecord() {
		session = factory.openSession();
		List<BookIssueRecord> listRecords = session.createQuery("from BookIssueRecord").list();
		session.close();
		return listRecords;
	}

	public void addBookIssue(BookIssueRecord bookIssueRecord) {
		System.out.println(bookIssueRecord);
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.save(bookIssueRecord);
		transaction.commit();
		session.close();

	}

	public Book getBook(int bookCode) {
		session = factory.openSession();
		Book book = new Book();
		book = session.get(Book.class, bookCode);
		session.close();
		if (book != null) {
			return book;
		}
		return null;
	}

	public Member getMember(int memberCode) {
		session = factory.openSession();
		Member member = new Member();
		member = session.get(Member.class, memberCode);
		session.close();
		if (member != null) {
			return member;
		}
		return null;
	}

	public int deleteIssueBook(int bookCode) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("delete from BookIssueRecord where book_code=:code");
		query.setParameter("code", bookCode);
		int result = query.executeUpdate();
		transaction.commit();
		session.close();
		return result;
	}

	public void updateMemberDetail(int memberCode) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Member member = session.load(Member.class, memberCode);

		member.setTotalIssuedBook(member.getTotalIssuedBook() + 1);

		transaction.commit();
		session.close();

	}

	public int bookAlreadyIssue(int bookCode) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from BookIssueRecord where book_code=:id");
		query.setParameter("id", bookCode);
		List<Book> list = query.list();
		int result = list.size();
		transaction.commit();
		session.close();

		return result;
	}

	public void updateMemberDetails(int memberCode) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Member member = session.load(Member.class, memberCode);
		member.setTotalIssuedBook(member.getTotalIssuedBook() - 1);
		transaction.commit();
		session.close();
	}

	public void updateBookIssueRecord(String serialNo, Date dueDate) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		BookIssueRecord issueRecord = session.load(BookIssueRecord.class, serialNo);
		issueRecord.setDueDate(dueDate);
		transaction.commit();
		session.close();
	}

	public int getBookRecord(int bookCode) {
		session = factory.openSession();
		Query query = session.createQuery("from BookIssueRecord where book_code=:code");
		query.setParameter("code", bookCode);
		BookIssueRecord record = (BookIssueRecord) query.uniqueResult();
		if (record != null) {
			return record.getMember().getMemberCode();
		}
		return 0;
	}

	public BookIssueRecord getRecord(int bookCode) {
		session = factory.openSession();
		Query query = session.createQuery("from BookIssueRecord where book_code=:code");
		query.setParameter("code", bookCode);
		BookIssueRecord record = (BookIssueRecord) query.uniqueResult();

		return record;
	}
}
