<%-- 
    Document   : login
    Created on : 25-Dec-2014, 22:20:41
    Author     : Jasim
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header/headData.jsp" flush="true" ></jsp:include>
        </head>
        <body>
        <jsp:include page="header/header.jsp" flush="true" ></jsp:include>

            <div class="row" style="text-align: center">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">
                    <div class="container">
                    <p class="text-danger"> 
                    <% if( request.getParameter("message") != null) out.println(request.getParameter("message")); %>
                    </p>
                </div>
            </div>
            <div class="col-sm-4"></div>
        </div>
        <div class="container">
            <div class="jumbotron">
                <div class="row">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4">

                        <form action="submit_login.jsp" method="POST">
                            <div class="form-group">
                                <label for="text" >Username:</label>
                                <input type="text" class="form-control" id="username" name="username">
                            </div>
                            <div class="form-group">
                                <label for="pwd" >Password:</label>
                                <input type="password" class="form-control" id="pwd" name="pwd">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer/footer.jsp" flush="true" ></jsp:include>
    </body>
</html>
