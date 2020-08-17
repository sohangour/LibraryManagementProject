<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete Issue Book</title>
</head>
<body>
	<h3>Delete Issue Book</h3>
	<hr>
	<html:form action="deleteIssueBook" method="post">

		<bean:message key="label.name.bookCode" />
		<html:text property="bookCode" />
		<html:errors />
		<br>
		<html:submit>Delete Issue Book</html:submit>
	</html:form>

</body>
</html>