<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Add User</title>
</head>
<body>
	<center>
		<table>
			<tr>
				<td>
					<a href="/ApartmentProject/user"><button type="button">Add User</button></a>
<%-- 					<form method="GET" action="/ApartmentProject/user"commandName="user"> --%>
<!-- 					<input type="submit" value="Add User" /> -->
<%-- 					</form> --%>
				</td>
				<td>
					<a href="/ApartmentProject/showUser"><button type="button">Show User</button></a>
<%-- 					<form method="POST" action="/ApartmentProject/showUser"commandName="showUser"> --%>
<!-- 					<input type="submit" value="Show User" /> -->
<%-- 					</form> --%>
				</td>
				<td>
					<a href="/ApartmentProject/showRoom"><button type="button">Show Room</button></a>
<%-- 					<form method="POST" action="/ApartmentProject/showRoom"commandName="showRoom"> --%>
<!-- 					<input type="submit" value="Show Room" /> -->
<%-- 					</form> --%>
				</td>
				<td>
					<a href="/ApartmentProject/showInvoice"><button type="button">Show Invoice</button></a>
				</td>

			</tr>
		</table>


	<h2><font color="red">Your selected room is not available.</font></h2>
	<h2>Add Customer Information</h2>
	<form:form method="POST" action="/ApartmentProject/addUser"
		commandName="addUser">
		<table border="0">
			<tr>
				<td><form:label path="u_fname">Name</form:label></td>
				<td><form:input path="u_fname" /></td>
			</tr>
			<tr>
				<td><form:label path="u_lname">Last name</form:label></td>
				<td><form:input path="u_lname" /></td>
			</tr>
			<tr>
				<td><form:label path="u_day">Day</form:label></td>
				<td>
				<form:select path="u_day">
				
				<% for(int i=1;i<=31;i++)
				{
					out.print("<option value=\"" + i + "\">"+ i + "</option>");
				}
				%>
				</form:select>
				</td>
				<td><form:label path="u_month">Month</form:label></td>
				<td><form:select path="u_day">
				
				<% for(int i=1;i<=12;i++)
				{
					out.print("<option value=\"" + i + "\">"+ i + "</option>");
				}
				%>
				</form:select></td>
				<td><form:label path="u_year">Year</form:label></td>
				<td><form:select path="u_day">
				
				<% for(int i=2015;i<=2025;i++)
				{
					out.print("<option value=\"" + i + "\">"+ i + "</option>");
				}
				%>
				</form:select></td>
			</tr>
			<tr>
				<td><form:label path="r_id">Room Number</form:label></td>
				<td><form:select path="r_id">
						<c:forEach var="room" items="${room}">

							<option value="${room.r_id}">${room.r_id}</option>

						</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	</center>
</body>
</html>