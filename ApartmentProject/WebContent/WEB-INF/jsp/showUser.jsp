<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show User</title>
</head>
<body>
	<center>
		<table>
			<tr>
				<td>
<!-- 					<a href="/ApartmentProject/user"><button type="button">Add User</button></a> -->
					<form method="GET" action="/ApartmentProject/user"commandName="user">
					<input type="submit" value="Add User" />
					</form>
				</td>
				<td>
					<form method="POST" action="/ApartmentProject/showUser"commandName="showUser">
					<input type="submit" value="Show User" />
					</form>
				</td>
				<td>
					<a href="/ApartmentProject/showRoom"><button type="button">Show Room</button></a>
<!-- 					<form method="POST" action="/ApartmentProject/showRoom"commandName="showRoom"> -->
<!-- 					<input type="submit" value="Show Room" /> -->
<!-- 					</form> -->
				</td>
				<td>
					<a href="/ApartmentProject/showInvoice"><button type="button">Show Invoice</button></a>
					<td><a href="/ApartmentProject/logOut"><button type="button">Log out</button></a></td>
				</td>

			</tr>
		</table>
	</center>
	<center>
		<table border="1">
			<tr>
				<td class="heading">User Id</td>
				<td class="heading">First Name</td>
				<td class="heading">Last Name</td>
				<td class="heading">Entry Date</td>
				<td class="heading">Room Number</td>
				<td class="heading">Edit</td>
				<td class="heading">Delete</td>
			</tr>
			<c:forEach var="user" items="${showUser}">
				<tr>
					<td>${user.u_id}</td>
					<td>${user.u_fname}</td>
					<td>${user.u_lname}</td>
					<td>${user.u_day} - ${user.u_month} - ${user.u_year}</td>
					<td>${user.r_id}</td>
					<td><a href="/ApartmentProject/editUser?id=${user.u_id}"><button type="button">Edit</button></a></td>
					<td><a href="/ApartmentProject/deleteUser?id=${user.u_id}"><button type="button">Delete</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>