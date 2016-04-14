<%-- 
    Document   : logout
    Created on : 28-Jan-2015, 17:17:44
    Author     : Jasim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:remove var="user" scope="application"></c:remove>
    
<%
  
  session.invalidate();
  response.sendRedirect("login.jsp");
  
%>
