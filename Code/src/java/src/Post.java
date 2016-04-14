/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import beans.UserSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tweets;

/**
 *
 * @author Jasim
 */
@WebServlet(urlPatterns = {"/post"})
public class Post extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Logging.LogMe("*", "Post.doPost()");


        UserSessionBean user = (UserSessionBean) request.getSession().getAttribute("user");
        String TweetString = (String) request.getParameter("TweetText");
        //String testthis = (String) request.getParameter("TweetText");


        if (user == null) {
            Logging.LogMe("User is null.", "Post.doPost()");
            return;
        }
        
        if(TweetString == null || TweetString == ""){
            Logging.LogMe("Error with tweet string", "Post.doPost()");
            return;
        }

        Tweets tweet = new Tweets();

        Date dNow = new Date();
        SimpleDateFormat ft
                = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        tweet.setCreatedAt(ft.format(dNow));
        tweet.setGeoLat(null);
        tweet.setGeoLong(null);
        tweet.setTweetText(TweetString);
        tweet.setUserProfileId(user.getUser());

        PersistanceFunctions.AddTweet(tweet);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
