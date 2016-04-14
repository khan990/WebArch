<%-- 
    Document   : postbox
    Created on : 22-Jan-2015, 18:36:16
    Author     : Jasim
--%>


<%@ page import="java.io.*,java.util.*" %>
<%@ page import="src.*" %>
<%@ page  import="beans.*" %>
<%! UserSessionBean user;%>
<%
    user = (UserSessionBean) pageContext.findAttribute("user");
    if (user == null) {
        Logging.LogMe("Not logged in... (user == null)", "postbox.jsp");
        response.sendRedirect("login.jsp?message=Please%20login%20to%20access%20secure%20page");
    } else {
        Logging.LogMe("(user != null)", "postbox.jsp");
    }

%>

<div class="container" style="background-color: #F5F5F5; margin-top: 15px; margin-bottom: 15px">
    <%--   <form role="form" action="post" name="TweetPost" id="TweetPost" method="POST" > --%>
    <div class="row" style="margin-top: 15px; margin-bottom: 15px">
        <div class="col-md-2">
            <% if (((UserSessionBean) pageContext.findAttribute("user")).getUser().getProfileImageUrl() == null) { %>
            <img class="thumbnail" style="margin-left: auto; margin-right: auto" src="img/Unknown.png" width="50"   alt="Unknown"/>
            <% } else {%>
            <img class="thumbnail" style="margin-left: auto; margin-right: auto" src="<%= ((UserSessionBean) pageContext.findAttribute("user")).getUser().getProfileImageUrl()%>" width="50"   alt="Unknown"/>
            <% }%>
        </div>
        <div class="col-md-10">
            <textarea class="span6" id="TweetText" name="TweetText" style="resize: none; width: 100%" rows="3" maxlength="140" placeholder="What's up?" required></textarea>
        </div>
    </div>
    <div class="row" style="margin-top: 15px; margin-bottom: 15px">
        <button type="submit" style="margin-left: calc(100% - 100px - 15px); margin-right: auto; width: 100px "  class="btn btn-primary" onclick="SendTweet()">
            Post
        </button>
    </div>
    <%-- </form> --%>
</div>

<script>
    function SendTweet() {
        var tweetText = document.getElementById("TweetText");
        var text = tweetText.value;

        var xmlHttp = null;
        xmlHttp = new XMLHttpRequest();
        xmlHttp.open("POST", "post?TweetText=" + text, false);
        xmlHttp.send(null);

        tweetText.value = "";
    }
</script>