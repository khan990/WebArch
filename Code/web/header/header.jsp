<%-- 
    Document   : header
    Created on : 25-Dec-2014, 22:16:47
    Author     : Jasim
--%>
<%@page import="beans.UserSessionBean" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Web Architecture Twitter</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <% if (((UserSessionBean) pageContext.findAttribute("user")) == null) { %>
                <li><a href="http://localhost:8080/wa_twitter/">Home</a></li>
                    <% } else { %>
                <li><a href="http://localhost:8080/wa_twitter/main.jsp">My Home</a></li>
                    <% } %>
                <li><a href="aboutus.jsp">About Us</a></li>
                <%-- <li><a href="contactus.jsp">Contact Us</a></li> --%>
            </ul>
        </div>

        <div>

            <ul class="nav navbar-right navbar-nav">
                <% if (((UserSessionBean) pageContext.findAttribute("user")) == null) { %>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
                    <% } else { %>
                <li><a href="logout.jsp">Logout</a></li>
                    <% }%>
            </ul>
        </div>
    </div>
</nav>
<div>
    <span><br/><br/><br/><br/></span>
</div>
