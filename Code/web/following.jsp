<%-- 
    Document   : followers
    Created on : 30-Jan-2015, 22:28:14
    Author     : Jasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="src.*" %>
<%@ page  import="beans.*" %>
<%! UserSessionBean user;%>
<%
    user = (UserSessionBean) pageContext.findAttribute("user");
    if (user == null) {
        Logging.LogMe("Not logged in... (user == null)", "main.jsp");
        response.sendRedirect("login.jsp?message=Please%20login%20to%20access%20secure%20page");
    } else {
        Logging.LogMe("(user != null)", "main.jsp");
    }

%>
<html>
    <head>
        <jsp:include page="header/headData.jsp" flush="true" ></jsp:include>
        </head>
        <body>
        <jsp:include page="header/header.jsp" flush="true" ></jsp:include>
            <div class="container" style="background-color: #D3D3D3; margin-top: 15px; margin-bottom: 15px">
                <div class="row">
                    <div class="col-md-3 " style="text-align: center">
                        <div  style="text-align: center">
                        <% if (user.getUser().getProfileImageUrl() == null) { %>
                        <img class="thumbnail" style="margin-top: 15px; margin-left: auto; margin-right: auto" src="img/Unknown.png" width="150"   alt="Unknown"/>
                        <% } else {%>
                        <img class="thumbnail" style="margin-top: 15px; margin-left: auto; margin-right: auto" src="<%= user.getUser().getProfileImageUrl()%>" width="150"   alt="Unknown"/>
                        <% } %>
                    </div>

                    <div class="text-center">
                        <a href="<% out.print("profile.jsp?who=" + user.getUsername()); %>" > <% out.print(user.getUser().getFname() + " " + user.getUser().getLname());%> </a>
                    </div>



                    <div style="height: 30px" >

                    </div>


                    <div class="input-group" style="width: 100%; text-align: center">
                        <input class="form-control" type="text" name="SearchProfiles" id="SearchProfiles" onkeyup="LiveSearch(this.value)" placeholder="Search Profiles" >
                        <div id="livesearch_div"></div>
                    </div>                 
                </div>
                <div class="col-md-9"> 
                    <%= user.PrintMyFollowing()%>
                </div>
            </div>
        </div>
        <jsp:include page="footer/footer.jsp" flush="true" ></jsp:include>
        <script>
            function LiveSearch(string) {
                if (string.length === 0) {
                    document.getElementById("livesearch_div").innerHTML = "";
                    document.getElementById("livesearch_div").style.border = "0px";
                    return;
                }

                xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    var html_code = "";
                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        var json_object = xmlhttp.responseText;
                        var json_array = JSON.parse(json_object);
                        if (json_array.length > 10) {
                            for (i = 0; i < 10; i++) {
                                html_code += "<a href=\"profile.jsp?who=" + json_array[i] + "\">" + json_array[i] + "</a> <br/>";
                            }
                        } else {
                            for (i = 0; i < json_array.length; i++) {
                                html_code += "<a href=\"profile.jsp?who=" + json_array[i] + "\">" + json_array[i] + "</a> <br/>";
                            }
                        }

                        document.getElementById("livesearch_div").innerHTML = html_code;
                        document.getElementById("livesearch_div").style.border = "1px solid #A5ACB2";
                    }
                };
                xmlhttp.open("POST", "ProfileSearch?search=" + string, false);
                xmlhttp.send();
            }
        </script>
    </body>
</html>
