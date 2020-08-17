<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Issue Book</title>
</head>
<body>
	<h3>Update Issue Book</h3>
	<hr>
	<html:form action="updateIssueBook" method="post">

		<table style="border-collapse: collapse;">

			<tr>
				<td><bean:message key="label.name.serialNo" /></td>
				<td><html:text property="serialNo" name="updateBookForm"
						readonly="true" /></td>

			</tr>


			<tr>
				<td><bean:message key="label.name.bookCode" /></td>
				<td><html:text property="bookCode" name="updateBookForm" /></td>
				<td><html:errors property="bookCodeError" /></td>

			</tr>
			<tr>
				<td><bean:message key="label.name.title" /></td>
				<td><html:text property="bookTitle" name="updateBookForm"
						readonly="true" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.name.author" /></td>
				<td><html:text property="bookAuthor" name="updateBookForm"
						readonly="true" /></td>

			</tr>

			<tr>
				<td><bean:message key="label.name.name" /></td>
				<td><html:text property="memberName" name="updateBookForm"
						readonly="true" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.name.duedate" /></td>
				<td><input type="date" name="dueDate"></td>
				<td><bean:write property="dueDate" name="updateBookForm" /></td>
			</tr>
			<tr>
				<td><html:submit property="getBookData">Get Details</html:submit></td>

				<td><html:submit property="updateBook">Update </html:submit></td>
			</tr>
		</table>

	</html:form>
	<html:errors property="fillDetailError" />
</body>
</html>