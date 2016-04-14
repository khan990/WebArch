/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import beans.UserSessionBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Jasim
 */
@WebServlet(urlPatterns = {"/ajaxing"})
public class AjaxingLatestTweets extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        UserSessionBean user = (UserSessionBean) req.getSession().getAttribute("user");
        if(user == null){
            Logging.LogMe("User is null.", "AjaxingLatestTweets.doPost()");
            return;
        }

        if (req.getParameter("mode").equals("self") == false) {
            
            List<FrontEndTweets> tweets;
            tweets = PersistanceFunctions.getRecentFollowingTweets((String) req.getParameter("username"), (String) req.getParameter("last_tweet"));
            Logging.LogMe("getting recent Tweets for user: " + req.getParameter("username"), "AjaxingLatestTweets.doPost()");

            //JSONObject[] Json_objects = new JSONObject[tweets.size()];
            List<JSONObject> Json_objects = new ArrayList<JSONObject>();
            JSONArray Json_array = new JSONArray();

            for (FrontEndTweets tweet : tweets) {
                JSONObject Json_object = new JSONObject();
                Json_object.put("tweet_text", tweet.getTweet_text());
                Json_object.put("created_at", tweet.getCreated_at());
                Json_object.put("screen_name", tweet.getScreen_name());
                Json_object.put("fname", tweet.getFname());
                Json_object.put("lname", tweet.getLname());
                Json_object.put("profile_image_url", tweet.getProfile_image_url());

                Json_objects.add(Json_object);
            }

            Json_array.addAll(Json_objects);
            Logging.LogMe("got recent Tweets for user: " + req.getParameter("username"), "AjaxingLatestTweets.doPost()");
            resp.getOutputStream().print(Json_array.toJSONString());
            
        } else {
            
            List<FrontEndTweets> tweets;
            tweets = PersistanceFunctions.getRecentFollowingTweetsSelf((String) req.getParameter("username"), (String) req.getParameter("last_tweet"));
            Logging.LogMe("getting self recent Tweets for user: " + req.getParameter("username"), "AjaxingLatestTweets.doPost()");

            //JSONObject[] Json_objects = new JSONObject[tweets.size()];
            List<JSONObject> Json_objects = new ArrayList<JSONObject>();
            JSONArray Json_array = new JSONArray();

            for (FrontEndTweets tweet : tweets) {
                JSONObject Json_object = new JSONObject();
                Json_object.put("tweet_text", tweet.getTweet_text());
                Json_object.put("created_at", tweet.getCreated_at());
                Json_object.put("screen_name", tweet.getScreen_name());
                Json_object.put("fname", tweet.getFname());
                Json_object.put("lname", tweet.getLname());
                Json_object.put("profile_image_url", tweet.getProfile_image_url());

                Json_objects.add(Json_object);
            }

            Json_array.addAll(Json_objects);
            Logging.LogMe("got self recent Tweets for user: " + req.getParameter("username"), "AjaxingLatestTweets.doPost()");
            resp.getOutputStream().print(Json_array.toJSONString());
        }
    }
}
