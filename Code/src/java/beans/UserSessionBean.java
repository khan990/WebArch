/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateful;
import model.Followers;
import model.UserProfiles;
import src.Logging;
import src.PersistanceFunctions;

/**
 *
 * @author Jasim
 */
@Stateful
public class UserSessionBean implements UserSessionBeanLocal {
    private UserProfiles user;

    
    @Override
    public void UserSessionBean(){
        user = null;
    }
    
    
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    
    private String username;
    private String password;

    @Override
    public UserProfiles getUser() {
        return user;
    }

    @Override
    public void setUser(UserProfiles user) {
        this.user = user;
    }

    
    @Override
    public Boolean UserValidity(){
        
        Logging.LogMe("Checking user validity", "UserSessionBean.java UserValidity()");
        
        if(username == null || password == null){
            username = null;
            password = null;
            Logging.LogMe("Checking user validity = incomplete", "UserSessionBean.java UserValidity()");
            return false;
        }
        
        List<UserProfiles> temp_user = PersistanceFunctions.getProfile(username);
        
        if(temp_user.get(0) == null){
            username = null;
            password = null;
            Logging.LogMe("Checking user validity = No user", "UserSessionBean.java UserValidity()");
            return false;
        }
        
        if (temp_user.get(0).getPassword().equals(password)){
            user = temp_user.get(0);
            Logging.LogMe("Checking user validity = True", "UserSessionBean.java UserValidity()");
            return true;
        }
        
        Logging.LogMe("Checking user validity = false (multiple reasons)", "UserSessionBean.java UserValidity()");
        return false;
    }
    
    @Override
    public Boolean UserProfile(){
        Logging.LogMe("*", "UserSessionBean.java UserProfile()");
        if(username == null){
            return null;
        }
        
        List<UserProfiles> temp_user = PersistanceFunctions.getProfile(username);
        
        if(temp_user.get(0) == null){
            username = null;
            return null;
        }
        
        user = temp_user.get(0);
        return true;
    }
    
    public String PrintMyFollowers(){
        Logging.LogMe("*", "UserSessionBean.java PrintMyFollowers()");
        
        List<Followers> followers = PersistanceFunctions.getAllFollowers();
        String followerElement = "<h2>Followers</h2>\n";
        
        for(Followers follower : followers){
            if(user.getUserProfilesId() == follower.getFollowerUserProfileId().getUserProfilesId()){
                followerElement += "<div style=\"margin-top: 15px; margin-left: auto; margin-right: auto; padding-bottom: 50px\" class=\"text-center\">" +
                    "<img class=\"thumbnail\" style=\"margin-top: 15px; margin-left: auto; margin-right: auto\" src=\"" + follower.getFolloweeUserProfileId().getProfileImageUrl() + "\" width=\"150\" alt=\"Unknown\">" + 
                    "<p style=\"font-weight: bold\">" + follower.getFolloweeUserProfileId().getFname() + " " + follower.getFolloweeUserProfileId().getLname() + "</p>" + 
                    "<a href=\"profile.jsp?who=" + follower.getFolloweeUserProfileId().getScreenName() + "\">" + "@" + follower.getFolloweeUserProfileId().getScreenName() + "</a>" + 
                    "</div>\n";
            }
        }
        return followerElement;
    }
    
    public String PrintMyFollowing(){
        Logging.LogMe("*", "UserSessionBean.java PrintMyFollowing()");
        
        List<Followers> followers = PersistanceFunctions.getAllFollowers();
        String followerElement = "<h2>Following</h2>\n";
        
        for(Followers follower : followers){
            if(user.getUserProfilesId() == follower.getFolloweeUserProfileId().getUserProfilesId()){
                followerElement += "<div style=\"margin-top: 15px; margin-left: auto; margin-right: auto; padding-bottom: 50px\" class=\"text-center\">" +
                    "<img class=\"thumbnail\" style=\"margin-top: 15px; margin-left: auto; margin-right: auto\" src=\"" + follower.getFollowerUserProfileId().getProfileImageUrl() + "\" width=\"150\" alt=\"Unknown\">" + 
                    "<p style=\"font-weight: bold\">" + follower.getFollowerUserProfileId().getFname() + " " + follower.getFollowerUserProfileId().getLname() + "</p>" + 
                    "<a href=\"profile.jsp?who=" + follower.getFollowerUserProfileId().getScreenName() + "\">" + "@" + follower.getFollowerUserProfileId().getScreenName() + "</a>" + 
                    "</div>\n";
            }
        }
        return followerElement;
    }

}
