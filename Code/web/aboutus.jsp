<%-- 
    Document   : aboutus
    Created on : 25-Dec-2014, 22:20:01
    Author     : Jasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false" %>
<%@page import="beans.AboutUs" %>
<!DOCTYPE html>
<jsp:useBean id="aboutus" class="beans.AboutUs" ></jsp:useBean>
<html>
    <jsp:include page="header/headData.jsp" flush="true" ></jsp:include>
        <body>
        <jsp:include page="header/header.jsp" flush="true" ></jsp:include>
            <div class="container">
                <div class="jumbotron">
                    <p><%= aboutus.getText() %></p> 
                </div>

            </div>
        <jsp:include page="footer/footer.jsp" flush="true" ></jsp:include>
    </body>
</html>
