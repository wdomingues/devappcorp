<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Alô Mundo - Session</title>
</head>
<body>
<h1>
    <%
        Object msg = session.getAttribute("msg");
        if (msg == null) msg = "Alô, mundo!";
    %>
    <%= msg %>
</h1>
<br/>
<a href="AloMundoServlet">Alô Mundo Servlet</a>
</body>
</html>