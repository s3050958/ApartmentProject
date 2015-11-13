<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Room Information</title>
</head>
<body>
	<h2>Update Room Information</h2>
	<form:form method="POST" action="/ApartmentProject/doEditRoom"
		commandName="editRoom">
		<table>
			<form:hidden path="r_id" />
			<tr>
				<td><form:label path="r_water">Water</form:label></td>
				<td><form:input path="r_water" /></td>
				<td>20B/Unit</td>
			</tr>
			<tr>
				<td><form:label path="r_light">Light</form:label></td>
				<td><form:input path="r_light" /></td>
				<td>9B/Unit</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>