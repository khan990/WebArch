/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jasim
 */
@XmlRootElement(name="tweets")
public class FrontEndTweets implements Serializable {
    
    
    private String tweet_text;
    private String created_at;
    private String screen_name;
    private String fname;
    private String lname;
    private String profile_image_url;
    
    
    public FrontEndTweets(String _tweet_text, String _created_at, String _screen_name, String _fname, String _lname, String _profile_image_url){
        this.tweet_text = _tweet_text;
        this.created_at = _created_at;
        this.screen_name = _screen_name;
        this.fname = _fname;
        this.lname = _lname;
        this.profile_image_url = _profile_image_url;
    }

    public String getTweet_text() {
        return tweet_text;
    }

    public void setTweet_text(String tweet_text) {
        this.tweet_text = tweet_text;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }
    
    
    
    

}
