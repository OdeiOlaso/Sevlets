<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo 1</title>
<script>
function refresco(){
	location.reload();
}
setTimeout(refresco, 5000);
alert("<%= new Date()%>");
</script>
</head>
<body>
<h1><%= new Date() %></h1>
<% for(int i = 1; i <= 6; i++) {%>
<h<%=i %>>Prueba <%=i %></h<%=i %>>
<% } %>
</body>
</html>