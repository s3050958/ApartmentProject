<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Invoice</title>
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
				<td class="heading">Invoice Id</td>
				<td class="heading">Room Number</td>
				<td class="heading">Name</td>
				<td class="heading">Last name</td>
				<td class="heading">Water Price</td>
				<td class="heading">Light Price</td>
				<td class="heading">Room Price</td>
				<td class="heading">Total Price</td>
				<td class="heading">Status</td>
				<td class="heading">Paid</td>
<!-- 				<td class="heading">Delete</td> -->
			</tr>
			<c:forEach var="invoice" items="${showInvoice}">
				<tr>
					<td>${invoice.i_id}</td>
					<td>${invoice.r_id}</td>
					<td>${invoice.u_fname}</td>
					<td>${invoice.u_lname}</td>
					<td>${invoice.i_water}</td>
					<td>${invoice.i_light}</td>
					<td>${invoice.r_price}</td>
					<td>${invoice.i_total}</td>
					<td>${invoice.i_status}</td>
					<td><a href="/ApartmentProject/paid?id=${invoice.i_id}"><button type="button">Paid</button></a></td>
<%-- 					<td><a href="/ApartmentProject/deleteUser?id=${invoice.i_id}"><button type="button">Delete</button></a></td> --%>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>