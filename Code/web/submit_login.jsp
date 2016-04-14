<%-- 
    Document   : submit
    Created on : 26-Dec-2014, 21:21:27
    Author     : Jasim
--%>


<%@page import ="src.*" %>
<%@page import ="model.*" %>

<jsp:useBean id="user" scope="session" class="beans.UserSessionBean">
    <jsp:setProperty name="user" property="username" value='<%= request.getParameter("username") %>' ></jsp:setProperty>
    <jsp:setProperty name="user" property="password" value='<%= request.getParameter("pwd") %>' ></jsp:setProperty>
</jsp:useBean>


<%
    user.UserValidity();
    
    if(user == null){
        response.sendRedirect("login.jsp?message=Wrong%20username%20or%20password");
    } else {
        Logging.LogMe("Redirecting to main.jsp ", "submit_login.jsp");
        response.sendRedirect("main.jsp");
    }


%>
