<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Room</title>
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
				<td><a href="/ApartmentProject/showInvoice"><button type="button">Show Invoice</button></a></td>
				<td><a href="/ApartmentProject/logOut"><button type="button">Log out</button></a></td>
				

			</tr>
		</table>
	</center>
	<center>
		<table border="1">
			<tr>
				<td class="heading">Room Number</td>
				<td class="heading">Status</td>
				<td class="heading">Water (Unit)</td>
				<td class="heading">Light (Unit)</td>
				<td class="heading">price</td>
				<td class="heading">Name</td>
				<td class="heading">Last Name</td>
				<td class="heading">Edit</td>
				<td class="heading">Confirm Invoice</td>
			</tr>
			<c:forEach var="room" items="${showRoom}">
				<tr>
					<td>${room.r_id}</td>
					<td>${room.r_status}</td>
					<td>${room.r_water}</td>
					<td>${room.r_light}</td>
					<td>${room.r_price}</td>
					<td>${room.u_fname}</td>
					<td>${room.u_lname}</td>
					<td><a href="/ApartmentProject/editRoom?id=${room.r_id}"><button type="button">Edit</button></a></td>
					<td><a href="/ApartmentProject/confirmInvoice?id=${room.r_id}"><button type="button">Confirm Invoice</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>