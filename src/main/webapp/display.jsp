<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><th>Empno</th><th>Empname</th><th>Empemail</th></tr>
<%List<Employee> emp=(List<Employee>)request.getAttribute("list");
for(Employee e:emp){
%>
<tr><td><%=e.getEid() %></td><td><%=e.getEname() %></td><td><%=e.getEemail() %></td></tr>
<%} %>

</table>
</body>
</html>
