
<%@page import="java.util.Date"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Issue New Book</title>

<style type="text/css">
td {
	padding: 4px;
}
</style>
</head>
<body>
	<%!String serialNo;%>
	<%
		Date date = new Date();
	serialNo = String.valueOf(date.getTime());
	%>

	<h3>Issue New Book</h3>
	<hr>
	<html:form action="newBookIssue" method="post">
		<table style="border-collapse: collapse;">
			<tr>
				<td><bean:message key="label.name.serialNo" /></td>
				<td><html:text property="serialNo" value="<%=serialNo%>"
						readonly="true" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.name.memberCode" /></td>
				<td><html:text property="memberCode" name="addNewBookForm" /></td>

				<td><html:submit property="getMemberData">Get Member Details</html:submit></td>
				<td><html:errors property="memberCodeError" /></td>
			</tr>

			<tr>
				<td><bean:message key="label.name.name" /></td>
				<td><html:text property="memberName" name="addNewBookForm"
						readonly="true" /></td>
			</tr>

			<tr>
				<td><bean:message key="label.name.bookCode" /></td>
				<td><html:text property="bookCode" name="addNewBookForm" /></td>

				<td><html:submit property="getBookData">Get Book Details</html:submit></td>
				<td><html:errors property="bookCodeError" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.name.title" /></td>
				<td><html:text property="bookTitle" name="addNewBookForm"
						readonly="true" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.name.author" /></td>
				<td><html:text property="bookAuthor" name="addNewBookForm"
						readonly="true" /></td>

			</tr>
			<tr>
				<td><bean:message key="label.name.duedate" /></td>
				<td><input type="date" name="dueDate"></td>
			</tr>
			<tr>
				<td><html:submit property="addBook">Add Book</html:submit></td>
			</tr>
		</table>

	</html:form>
	<html:errors property="fillDetailError" />
</body>
</html>