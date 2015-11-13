<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Option</title>
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
				</td>

			</tr>
		</table>
	</center>
</body>
</html>