<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 2px;
}
</style>
<title>Home Page</title>
</head>
<body>
	<h3>List of All Issued Book</h3>
	<%
		if (request.getAttribute("listBook") != null && !request.getAttribute("listBook").toString().equals("[]")) {
	%>
	<table>
		<tr>
			<th>Serial Number</th>
			<th>Member Code</th>
			<th>Member Name</th>
			<th>Member Type</th>
			<th>Book Code</th>
			<th>Title</th>
			<th>Book Author</th>
			<th>Issue Date</th>
			<th>Due return date</th>
		</tr>


		<logic:iterate id="record" name="listBook">
			<tr>
				<td><bean:write name="record" property="serialNo" /></td>

				<td><bean:write name="record" property="member.memberCode" /></td>
				<td><bean:write name="record" property="member.memberName" /></td>
				<td><bean:write name="record" property="member.memberType" /></td>
				<td><bean:write name="record" property="book.bookCode" /></td>
				<td><bean:write name="record" property="book.bookTitle" /></td>
				<td><bean:write name="record" property="book.bookAuthor" /></td>
				<td><bean:write name="record" property="dateOfIssue" /></td>
				<td><bean:write name="record" property="dueDate" /></td>
			</tr>
		</logic:iterate>
	</table>
	<%
		} else {
	%>
	No Record Found !
	<%
		}
	%>
	<br>
	<br>
	<a href="newBookIssue.do">Issue New Book</a> &nbsp;
	<a href="updateBook.jsp">Update Book</a> &nbsp;
	<a href="deleteBook.jsp">Delete Book</a> &nbsp;

</body>
</html>