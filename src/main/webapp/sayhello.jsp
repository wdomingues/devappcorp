<%-- 
    Document   : sayhello
    Created on : 10/17/2022, 15:09:20
    Author     : wdomingues@id.uff.br
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SayHello.jsp</title>
    </head>
    <header>
        <h1 style="text-align: center;">
            _______________________Aplicativo Hello World!_______________________
        </h1>
        <jsp:useBean id="myBean" class="hello.MessageBean"/>
        <% String lang = request.getParameter("lang"); %>
        <jsp:setProperty name="myBean" property="lang" value="<%=lang%>"/>
        <h5 style="text-align: center;"><jsp:getProperty name="myBean" property="msg2"/> <jsp:getProperty name="myBean" property="aut"/></h5>
            <br><br><br>
    </header>
    <body>
        <% String localTimeZone = request.getParameter("ltz"); %>
        <jsp:setProperty name="myBean" property="localTZ" value="<%=localTimeZone%>"/>
        <h2 style="text-align: center;"><jsp:getProperty name="myBean" property="msg"/>, <%=request.getParameter("nome")%>!</h2>
        <br><br>
        <h4 style="text-align: center;"><jsp:getProperty name="myBean" property="weekDayMsg"/> <jsp:getProperty name="myBean" property="weekDay"/>.</h4>
    </body>
    <footer>
        <h4 style="text-align: center;">
            <br><br><br><br><br><br><br><br><br><br>
            _______________________<jsp:getProperty name="myBean" property="footerMsg"/>_______________________
            <br>
            <h4 style="text-align: center;"><jsp:getProperty name="myBean" property="timeMsg"/></h4>
            <br>
        </h4>
    </footer>
</html>