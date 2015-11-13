<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer Information</title>
</head>
<body>
<center>

	<table>
		<tr>
			<td><a href="/ApartmentProject/user"><button type="button">AddUser</button></a>
<%-- 					<form method="GET" action="/ApartmentProject/user"commandName="user"> --%>
<!-- 					<input type="submit" value="Add User" /> -->
<%-- 					</form> --%>
			</td>
			<td><a href="/ApartmentProject/showUser"><button type="button">Show User</button></a>
<%-- 					<form method="POST" action="/ApartmentProject/showUser"commandName="showUser"> --%>
<!-- 					<input type="submit" value="Show User" /> -->
<%-- 					</form> --%>
			</td>
			<td><a href="/ApartmentProject/showRoom"><button type="button">Show Room</button></a>
<%-- 					<form method="POST" action="/ApartmentProject/showRoom"commandName="showRoom"> --%>
<!-- 					<input type="submit" value="Show Room" /> -->
<%-- 					</form> --%>
			</td>
			<td><a href="/ApartmentProject/showInvoice"><button type="button">Show Invoice</button></a></td>
			<td><a href="/ApartmentProject/logOut"><button type="button">Log out</button></a></td>

		</tr>
	</table>
	
	
	<h2>Update Customer Information</h2>

	<form:form method="POST" action="/ApartmentProject/doEditUser" commandName="editUser" >
		<table>
			<form:hidden path="u_id" />
			<tr>
				<td><form:label path="u_fname">Name</form:label></td>
				<td><form:input path="u_fname" /></td>
			</tr>
			<tr>
				<td><form:label path="u_lname">Last name</form:label></td>
				<td><form:input path="u_lname" /></td>
			</tr>
			<tr>
				<td><form:label path="r_id">Room Number</form:label></td>
				<td><form:input path="u_rid" /></td>
				<td><form:select path="r_id">
						<c:forEach var="room" items="${room}">

							<option value="${room.r_id}">${room.r_id} (${room.r_price}) </option>

						</c:forEach>
				</form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</center>
</body>
</html>