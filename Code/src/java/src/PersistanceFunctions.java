/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import dao.Wa_twitter_Dao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.jsp.PageContext;
import model.Followers;
import model.TweetMentions;
import model.TweetTag;
import model.Tweets;
import model.UserProfiles;
import org.hibernate.SQLQuery;

/**
 *
 * @author Jasim
 */
public class PersistanceFunctions {

    public static List<UserProfiles> getAllUserProfiles() {

        Logging.LogMe("Fetching profile list from db", "PersistanceFunctions.getAllUserProfiles");
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        //wa_twitter_dao.getCurrentSession().beginTransaction();
        //List<UserProfiles> users = (List<UserProfiles>) wa_twitter_dao.getCurrentSession().createQuery("SELECT u FROM model.UserProfiles u").list();
        List<UserProfiles> users = Collections.checkedList(wa_twitter_dao.getCurrentSession().createQuery("FROM model.UserProfiles").list(), UserProfiles.class);
        //wa_twitter_dao.getCurrentSession().getTransaction().commit();
        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("Fetched profile list from db ", "PersistanceFunctions.getAllUserProfiles");
        return users;
    }
    
    public static List<Followers> getAllFollowers() {

        Logging.LogMe("Fetching Followers list from db", "PersistanceFunctions.getAllFollowers");
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        //wa_twitter_dao.getCurrentSession().beginTransaction();
        //List<UserProfiles> users = (List<UserProfiles>) wa_twitter_dao.getCurrentSession().createQuery("SELECT u FROM model.UserProfiles u").list();
        List<Followers> followers = Collections.checkedList(wa_twitter_dao.getCurrentSession().createQuery("FROM model.Followers").list(), Followers.class);
        //wa_twitter_dao.getCurrentSession().getTransaction().commit();
        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("Fetched Followers list from db ", "PersistanceFunctions.getAllFollowers");
        return followers;
    }
    
    public static List<UserProfiles> getProfile(String Uname) {

        Logging.LogMe("Fetching a profile from db (Param: " + Uname + " )", "PersistanceFunctions.getProfile(String Uname)");
        String Query = "FROM UserProfiles u WHERE u.screenName = '" + Uname + "'";
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        //wa_twitter_dao.getCurrentSession().beginTransaction();
        //List<UserProfiles> users = (List<UserProfiles>) wa_twitter_dao.getCurrentSession().createQuery("SELECT u FROM model.UserProfiles u").list();
        List<UserProfiles> user =  wa_twitter_dao.getCurrentSession().createQuery(Query).list();
        //wa_twitter_dao.getCurrentSession().getTransaction().commit();
        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("Fetched a profile from db ", "PersistanceFunctions.getProfile(String Uname)");
        return user;
    }
    
    
    public static List<String> getUsernames() {

        Logging.LogMe("Fetching usernames of all profiles from db", "PersistanceFunctions.getUsernames");
        String Query = "SELECT u.screenName FROM UserProfiles u";
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        //wa_twitter_dao.getCurrentSession().beginTransaction();
        //List<UserProfiles> users = (List<UserProfiles>) wa_twitter_dao.getCurrentSession().createQuery("SELECT u FROM model.UserProfiles u").list();
        List<String> user =  wa_twitter_dao.getCurrentSession().createQuery(Query).list();
        //wa_twitter_dao.getCurrentSession().getTransaction().commit();
        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("Fetched usernames of all profiles from db ", "PersistanceFunctions.getUsernames");
        return user;
    }
    
    public static void RemoveFollower(Followers follower) {

        Logging.LogMe("Delete Followers from db", "PersistanceFunctions.RemoveFollower");
        String Query = "DELETE FROM Followers WHERE followers_id = :followersId";
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        //wa_twitter_dao.getCurrentSession().beginTransaction();
        //List<UserProfiles> users = (List<UserProfiles>) wa_twitter_dao.getCurrentSession().createQuery("SELECT u FROM model.UserProfiles u").list();
        SQLQuery query =  wa_twitter_dao.getCurrentSession().createSQLQuery(Query);
        query.setParameter("followersId", follower.getFollowersId());
        query.executeUpdate();
        //wa_twitter_dao.getCurrentSession().getTransaction().commit();
        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("Deleted Followers from db ", "PersistanceFunctions.RemoveFollower");
        return;
    }

    public static UserProfiles AddProfile(UserProfiles profile) {

        Logging.LogMe("Registering profile ", "PersistanceFunctions.AddProfile");
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        //wa_twitter_dao.openCurrentSession();

        wa_twitter_dao.openCurrentSessionwithTransaction();
        
        wa_twitter_dao.getCurrentSession().save(profile);
        wa_twitter_dao.getCurrentTransaction().commit();

        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("User has been added to profile table. ", "PersistanceFunctions.AddProfile");
        return profile;
    }
    
    public static Followers AddFollowers(Followers follower) {

        Logging.LogMe("Registering profile ", "PersistanceFunctions.AddFollowers");
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();

        wa_twitter_dao.getCurrentSession().save(follower);
        wa_twitter_dao.getCurrentTransaction().commit();

        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("User has been added to profile table. ", "PersistanceFunctions.AddFollowers");
        return follower;
    }
    
    public static Followers RemoveFollowers(Followers follower) {

        Logging.LogMe("Registering profile ", "PersistanceFunctions.RemoveFollowers()");
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();

        wa_twitter_dao.getCurrentSession().delete(follower);
        wa_twitter_dao.getCurrentTransaction().commit();

        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("User has been added to profile table. ", "PersistanceFunctions.RemoveFollowers()");
        return follower;
    }
    
    public static Tweets AddTweet(Tweets Tweet) {

        Logging.LogMe("Registering tweet ", "PersistanceFunctions.AddTweet()");
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();

        wa_twitter_dao.getCurrentSession().save(Tweet);
        wa_twitter_dao.getCurrentTransaction().commit();

        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("Tweet has been added to tweet table. ", "PersistanceFunctions.AddTweet()");

        return Tweet;
    }
    
    public static TweetMentions AddTweetMention(TweetMentions Mention) {

        Logging.LogMe("Registering profile ", "PersistanceFunctions.AddProfile");
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();

        wa_twitter_dao.getCurrentSession().save(Mention);
        wa_twitter_dao.getCurrentTransaction().commit();

        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("User has been added to profile table. ", "PersistanceFunctions.AddProfile");
        return Mention;
    }
    
    public static TweetTag AddTweetTag(TweetTag Tag) {

        Logging.LogMe("Registering profile ", "PersistanceFunctions.AddProfile");
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();

        wa_twitter_dao.getCurrentSession().save(Tag);
        wa_twitter_dao.getCurrentTransaction().commit();

        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("User has been added to profile table. ", "PersistanceFunctions.AddProfile");
        return Tag;
    }
    
    public static List<FrontEndTweets> getFirstFollowingTweets(Integer Id) {

        Logging.LogMe("Fetching First 10 tweets from db", "PersistanceFunctions.getFirstFollowingTweets");
        //String Query = "FROM UserProfiles u WHERE u.screenName = " + Integer.toString(Id) + "";
        String Query_String = "select tweets.tweet_text, tweets.created_at, user_profiles.screen_name, user_profiles.fname, user_profiles.lname, user_profiles.profile_image_url from wa_twitter.user_profiles " + 
        "inner join wa_twitter.tweets " + "on user_profiles.user_profiles_id = tweets.user_profile_id " + "inner join wa_twitter.followers " +
        "on followers.follower_user_profile_id = tweets.user_profile_id " + "where followers.followee_user_profile_id = :USER_ID " + "order by tweets.created_at desc " + 
        "limit :LIMIT";
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        //wa_twitter_dao.getCurrentSession().beginTransaction();
        //List<UserProfiles> users = (List<UserProfiles>) wa_twitter_dao.getCurrentSession().createQuery("SELECT u FROM model.UserProfiles u").list();
        SQLQuery query = wa_twitter_dao.getCurrentSession().createSQLQuery(Query_String);
        query.setParameter("USER_ID", Id);
        query.setParameter("LIMIT", 10);
        List<Object[]> result = query.list();
        //wa_twitter_dao.getCurrentSession().getTransaction().commit();
        wa_twitter_dao.closeCurrentSession();
        
        List<FrontEndTweets> tweets = new ArrayList<FrontEndTweets>();
        for(Object[] a_result: result){
            tweets.add(new FrontEndTweets((String) a_result[0], (String) a_result[1], (String) a_result[2], (String) a_result[3], (String) a_result[4], (String) a_result[5]));
        }
        
        Logging.LogMe("Fetched First 10 tweets from db", "PersistanceFunctions.getFirstFollowingTweets");
        return tweets;
    }
    
    
    public static List<FrontEndTweets> getFirstFollowingTweets(String  Uname) {

        Logging.LogMe("Fetching First 10 tweets from db", "PersistanceFunctions.getFirstFollowingTweets");
        //String Query = "FROM UserProfiles u WHERE u.screenName = " + Integer.toString(Id) + "";
        List<UserProfiles> user = PersistanceFunctions.getProfile(Uname);
        
        String Query_String = "select tweets.tweet_text, tweets.created_at, user_profiles.screen_name, user_profiles.fname, user_profiles.lname, user_profiles.profile_image_url from wa_twitter.user_profiles " + 
        "inner join wa_twitter.tweets " + "on user_profiles.user_profiles_id = tweets.user_profile_id " + "inner join wa_twitter.followers " +
        "on followers.follower_user_profile_id = tweets.user_profile_id " + "where followers.followee_user_profile_id = :USER_ID " + "order by tweets.created_at desc " + 
        "limit :LIMIT";
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        //wa_twitter_dao.getCurrentSession().beginTransaction();
        //List<UserProfiles> users = (List<UserProfiles>) wa_twitter_dao.getCurrentSession().createQuery("SELECT u FROM model.UserProfiles u").list();
        SQLQuery query = wa_twitter_dao.getCurrentSession().createSQLQuery(Query_String);
        query.setParameter("USER_ID", user.get(0).getUserProfilesId());
        query.setParameter("LIMIT", 10);
        List<Object[]> result = query.list();
        //wa_twitter_dao.getCurrentSession().getTransaction().commit();
        wa_twitter_dao.closeCurrentSession();
        
        List<FrontEndTweets> tweets = new ArrayList<FrontEndTweets>();
        for(Object[] a_result: result){
            tweets.add(new FrontEndTweets((String) a_result[0], (String) a_result[1], (String) a_result[2], (String) a_result[3], (String) a_result[4], (String) a_result[5]));
        }
        
        Logging.LogMe("Fetched First 10 tweets from db", "PersistanceFunctions.getFirstFollowingTweets");
        return tweets;
    }
    
    public static List<FrontEndTweets> getFirstFollowingTweetsSelf(String  Uname) {

        Logging.LogMe("Fetching First 10 tweets from db", "PersistanceFunctions.getFirstFollowingTweetsSelf");
        //String Query = "FROM UserProfiles u WHERE u.screenName = " + Integer.toString(Id) + "";
        List<UserProfiles> user = PersistanceFunctions.getProfile(Uname);
        
        String Query_String = "select tweets.tweet_text, tweets.created_at, user_profiles.screen_name, user_profiles.fname, user_profiles.lname, user_profiles.profile_image_url from wa_twitter.user_profiles " + 
                "inner join wa_twitter.tweets " + 
                "on user_profiles.user_profiles_id = tweets.user_profile_id " + 
                "where user_profiles.user_profiles_id = :USER_ID " + 
                "order by tweets.created_at desc " + 
                "limit :LIMIT";
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        //wa_twitter_dao.getCurrentSession().beginTransaction();
        //List<UserProfiles> users = (List<UserProfiles>) wa_twitter_dao.getCurrentSession().createQuery("SELECT u FROM model.UserProfiles u").list();
        SQLQuery query = wa_twitter_dao.getCurrentSession().createSQLQuery(Query_String);
        query.setParameter("USER_ID", user.get(0).getUserProfilesId());
        query.setParameter("LIMIT", 10);
        List<Object[]> result = query.list();
        //wa_twitter_dao.getCurrentSession().getTransaction().commit();
        wa_twitter_dao.closeCurrentSession();
        
        List<FrontEndTweets> tweets = new ArrayList<FrontEndTweets>();
        for(Object[] a_result: result){
            tweets.add(new FrontEndTweets((String) a_result[0], (String) a_result[1], (String) a_result[2], (String) a_result[3], (String) a_result[4], (String) a_result[5]));
        }
        
        Logging.LogMe("Fetched First 10 tweets from db", "PersistanceFunctions.getFirstFollowingTweetsSelf");
        return tweets;
    }
    
    public static List<FrontEndTweets> getRecentFollowingTweets(String  Uname, String DateTime) {

        Logging.LogMe("Fetching recent tweets from db", "PersistanceFunctions.getRecentFollowingTweets");
        //String Query = "FROM UserProfiles u WHERE u.screenName = " + Integer.toString(Id) + "";
        List<UserProfiles> user = PersistanceFunctions.getProfile(Uname);
        
        String Query_String = "select tweets.tweet_text, tweets.created_at, user_profiles.screen_name, user_profiles.fname, user_profiles.lname, user_profiles.profile_image_url from wa_twitter.user_profiles " + 
        "inner join wa_twitter.tweets " + "on user_profiles.user_profiles_id = tweets.user_profile_id " + "inner join wa_twitter.followers " +
        "on followers.follower_user_profile_id = tweets.user_profile_id " + "where followers.followee_user_profile_id = :USER_ID " + " && tweets.created_at > :DATE_TIME "+ "order by tweets.created_at ";
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        //wa_twitter_dao.getCurrentSession().beginTransaction();
        //List<UserProfiles> users = (List<UserProfiles>) wa_twitter_dao.getCurrentSession().createQuery("SELECT u FROM model.UserProfiles u").list();
        SQLQuery query = wa_twitter_dao.getCurrentSession().createSQLQuery(Query_String);
        query.setParameter("USER_ID", user.get(0).getUserProfilesId());
        query.setParameter("DATE_TIME", DateTime);
        List<Object[]> result = query.list();
        //wa_twitter_dao.getCurrentSession().getTransaction().commit();
        wa_twitter_dao.closeCurrentSession();
        
        List<FrontEndTweets> tweets = new ArrayList<FrontEndTweets>();
        for(Object[] a_result: result){
            tweets.add(new FrontEndTweets((String) a_result[0], (String) a_result[1], (String) a_result[2], (String) a_result[3], (String) a_result[4], (String) a_result[5]));
        }
        
        Logging.LogMe("Fetched " + Integer.toString(tweets.size()) + " recent tweets from db", "PersistanceFunctions.getRecentFollowingTweets");
        return tweets;
    }
    
    public static List<FrontEndTweets> getRecentFollowingTweetsSelf(String  Uname, String DateTime) {

        Logging.LogMe("Fetching recent tweets from db", "PersistanceFunctions.getRecentFollowingTweetsSelf");
        //String Query = "FROM UserProfiles u WHERE u.screenName = " + Integer.toString(Id) + "";
        List<UserProfiles> user = PersistanceFunctions.getProfile(Uname);
        
        String Query_String = "select tweets.tweet_text, tweets.created_at, user_profiles.screen_name, user_profiles.fname, user_profiles.lname, user_profiles.profile_image_url from wa_twitter.user_profiles " + 
                "inner join wa_twitter.tweets " + "on user_profiles.user_profiles_id = tweets.user_profile_id " + 
                "where user_profiles.user_profiles_id = :USER_ID " + " && tweets.created_at < :DATE_TIME "+ "order by tweets.created_at ";
        
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        //wa_twitter_dao.getCurrentSession().beginTransaction();
        //List<UserProfiles> users = (List<UserProfiles>) wa_twitter_dao.getCurrentSession().createQuery("SELECT u FROM model.UserProfiles u").list();
        SQLQuery query = wa_twitter_dao.getCurrentSession().createSQLQuery(Query_String);
        query.setParameter("USER_ID", user.get(0).getUserProfilesId());
        query.setParameter("DATE_TIME", DateTime);
        List<Object[]> result = query.list();
        //wa_twitter_dao.getCurrentSession().getTransaction().commit();
        wa_twitter_dao.closeCurrentSession();
        
        List<FrontEndTweets> tweets = new ArrayList<FrontEndTweets>();
        for(Object[] a_result: result){
            tweets.add(new FrontEndTweets((String) a_result[0], (String) a_result[1], (String) a_result[2], (String) a_result[3], (String) a_result[4], (String) a_result[5]));
        }
        
        Logging.LogMe("Fetched " + Integer.toString(tweets.size()) + " recent tweets from db", "PersistanceFunctions.getRecentFollowingTweetsSelf");
        return tweets;
    }

}
