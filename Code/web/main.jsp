<%-- 
    Document   : main
    Created on : 03-Jan-2015, 23:58:16
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
            <script>
                var last_tweet = "";
                function ajaxing() {
                    var xmlHttp = null;
                    xmlHttp = new XMLHttpRequest();
                    xmlHttp.open("POST", "ajaxing?username=<%= user.getUsername()%>&last_tweet=" + last_tweet + "&mode=all", false);
                    xmlHttp.send(null);
                    return xmlHttp.responseText;
                }

                function write_recent_tweets() {
                    var json_text = ajaxing();
                    var json_object = JSON.parse(json_text);
                    for (i = 0; i < json_object.length; i++) {
                        if (i === 0)
                            last_tweet = json_object[i].created_at;
                        //Create_Twitter_Post("LatestTweets", json_object[i].profile_image_url, json_object[i].tweet_text);
                        New_Create_Twitter_Post("LatestTweets", json_object[i].profile_image_url, json_object[i].tweet_text, json_object[i].screen_name, json_object[i].created_at,
                                json_object[i].fname + " " + json_object[i].lname);
                    }
                }

                function tweets() {
                    var xmlHttp = null;
                    xmlHttp = new XMLHttpRequest();
                    xmlHttp.open("POST", "firsttweets?username=<%= user.getUsername()%>" + "&mode=all", false);
                    xmlHttp.send(null);
                    return xmlHttp.responseText;
                }

                function write_tweets() {
                    var json_text = tweets();
                    var json_object = JSON.parse(json_text);
                    for (i = 0; i < json_object.length; i++) {
                        if (i === 0)
                            last_tweet = json_object[i].created_at;
                        New_Create_Twitter_Post("twitterposts", json_object[i].profile_image_url, json_object[i].tweet_text, json_object[i].screen_name, json_object[i].created_at,
                                json_object[i].fname + " " + json_object[i].lname);
                    }
                    
                     setInterval(function () {
                     write_recent_tweets();
                     }, 10000);
                     
                }

                function New_Create_Twitter_Post(whichDiv, pic_link, text, screenName, createdAt, fullname) {
                    var twitter_div = document.createElement("div");    //<div class="container" style="margin: 15px; background-color: rgb(255, 255, 255);">
                    twitter_div.style.backgroundColor = "#FFFFFF";
                    twitter_div.style.margin = "15px";
                    twitter_div.className = "container";

                    var div_row = document.createElement("div");    //<div class="row" style="margin: 15px;">
                    div_row.style.margin = "15px";
                    div_row.className = "row";

                    //left column
                    var div_col_left = document.createElement("div");    //<div class="col-md-2">
                    div_col_left.className = "col-md-2";

                    var div_image = document.createElement("div");    //<div>
                    //image
                    var image = document.createElement("img");  //<img class="thumbnail" src="img/Unknown.png" width="50px" alt="Unknown" style="margin-left: auto; margin-right: auto;">
                    image.className = "thumbnail";
                    image.style.marginLeft = "auto";
                    image.style.marginRight = "auto";
                    if (pic_link === "" || pic_link === "null" || pic_link === "undefined" || pic_link === null)
                        image.setAttribute("src", "img/Unknown.png");
                    else
                        image.setAttribute("src", pic_link);
                    image.setAttribute("width", "50px");
                    image.setAttribute("alt", "Unknown");

                    var div_name = document.createElement("div");    //<div class="text-center">
                    div_name.className = "text-center";

                    var a_name = document.createElement("a");
                    a_name.setAttribute("href", "profile.jsp?who=" + screenName);
                    a_name.innerHTML = fullname;

                    div_image.appendChild(image);
                    div_col_left.appendChild(div_image);

                    div_name.appendChild(a_name);
                    div_col_left.appendChild(div_name);


                    //right column
                    var div_col_right = document.createElement("div");   //<div class="col-md-10">
                    div_col_right.className = "col-md-10";

                    var div_screenname = document.createElement("div"); //<div>
                    var a_screenname = document.createElement("a");     // <a href="nothing">@screen name</a>
                    a_screenname.setAttribute("href", "profile.jsp?who=" + screenName);
                    a_screenname.innerHTML = "@" + screenName;

                    var div_tweet = document.createElement("div");      //<div>
                    var p_text = document.createElement("p");           //<p style="font-weight: bold">this is demo2 tweet</p>
                    //p_text.style.font-weight = "bold";
                    p_text.setAttribute("style", "font-weight: bold");
                    var text_node = document.createTextNode(text);
                    p_text.appendChild(text_node);


                    var div_createdat = document.createElement("div");      //<div>
                    var p_createdat = document.createElement("p");          //<p class="text-right" >Tweeted at:</p>
                    p_createdat.className = "text-right";
                    var createdat_node = document.createTextNode("Tweeted at: " + createdAt);
                    p_createdat.appendChild(createdat_node);

                    div_col_right.appendChild(div_screenname);
                    div_col_right.appendChild(div_tweet);
                    div_col_right.appendChild(div_createdat);

                    div_screenname.appendChild(a_screenname);
                    div_tweet.appendChild(p_text);
                    div_createdat.appendChild(p_createdat);

                    div_row.appendChild(div_col_left);
                    div_row.appendChild(div_col_right);
                    twitter_div.appendChild(div_row);
                    if (whichDiv === "twitterposts")
                        document.getElementById("twitterposts").appendChild(twitter_div);
                    else {
                        var element = document.getElementById("twitterposts");
                        element.insertBefore(twitter_div, element.childNodes[0]);
                    }


                }

                function Create_Twitter_Post(whichDiv, pic_link, text) {
                    var twitter_div = document.createElement("div");    //<div class="container" style="margin: 15px; background-color: rgb(255, 255, 255);">
                    twitter_div.style.backgroundColor = "#FFFFFF";
                    twitter_div.style.margin = "15px";
                    twitter_div.className = "container";

                    var div_row = document.createElement("div");    //<div class="row" style="margin: 15px;">
                    div_row.style.margin = "15px";
                    div_row.className = "row";

                    var div_col_img = document.createElement("div");    //<div class="col-md-2">
                    div_col_img.className = "col-md-2";

                    //image
                    var image = document.createElement("img");  //<img class="thumbnail" src="img/Unknown.png" width="50px" alt="Unknown" style="margin-left: auto; margin-right: auto;">
                    image.className = "thumbnail";
                    image.style.marginLeft = "auto";
                    image.style.marginRight = "auto";
                    if (pic_link === "" || pic_link === "null" || pic_link === "undefined" || pic_link === null)
                        image.setAttribute("src", "img/Unknown.png");
                    else
                        image.setAttribute("src", pic_link);
                    image.setAttribute("width", "50px");
                    image.setAttribute("alt", "Unknown");

                    var div_col_text = document.createElement("div");   //<div class="col-md-10">
                    div_col_text.className = "col-md-10";

                    var tweet = document.createElement("p");            //<p>
                    var text = document.createTextNode(text);

                    tweet.appendChild(text);
                    div_col_text.appendChild(tweet);
                    div_col_img.appendChild(image);
                    div_row.appendChild(div_col_img);
                    div_row.appendChild(div_col_text);
                    twitter_div.appendChild(div_row);
                    if (whichDiv === "twitterposts")
                        document.getElementById("twitterposts").appendChild(twitter_div);
                    else {
                        var element = document.getElementById("twitterposts");
                        element.insertBefore(twitter_div, element.childNodes[0]);
                    }

                }

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
    </head>
    <body onload="write_tweets()">
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
                        <!-- <span class="input-group-addon" id="basic-addon1">@</span> -->
                        <input class="form-control" type="text" name="SearchProfiles" id="SearchProfiles" onkeyup="LiveSearch(this.value)" placeholder="Search Profiles" >
                        <div id="livesearch_div"></div>
                    </div>                 
                </div>
                <div class="col-md-9"> 
                    <jsp:include page="postbox.jsp" flush="true" ></jsp:include>
                    <jsp:include page="timelinebox.jsp" flush="true" ></jsp:include>
                    </div>
                </div>
            </div>
        <jsp:include page="footer/footer.jsp" flush="true" ></jsp:include>
    </body>
</html>
