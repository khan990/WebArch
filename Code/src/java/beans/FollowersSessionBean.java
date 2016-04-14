/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateful;
import model.Followers;
import src.Logging;
import src.PersistanceFunctions;
/**
 *
 * @author Jasim
 */
@Stateful
public class FollowersSessionBean implements FollowersSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    Followers followers;
    
    private Integer numOfFollowers;
    private Integer numOfFollowing;
    private Integer myUid;
    private Integer ifFollowingUid;

    @Override
    public Integer getMyUid() {
        return myUid;
    }

    @Override
    public void setMyUid(Integer MyUid) {
        this.myUid = MyUid;
    }

    @Override
    public Integer getIfFollowingUid() {
        return ifFollowingUid;
    }

    @Override
    public void setIfFollowingUid(Integer IfFollowingUid) {
        this.ifFollowingUid = IfFollowingUid;
    }

    @Override
    public Followers getFollowers() {
        return followers;
    }

    @Override
    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    @Override
    public Integer getNumOfFollowers() {
        return numOfFollowers;
    }

    @Override
    public void setNumOfFollowers(Integer NumOfFollowers) {
        this.numOfFollowers = NumOfFollowers;
    }

    @Override
    public Integer getNumOfFollowing() {
        return numOfFollowing;
    }

    @Override
    public void setNumOfFollowing(Integer NumOfFollowing) {
        this.numOfFollowing = NumOfFollowing;
    }

    /**
     *
     */
    public FollowersSessionBean(){
        numOfFollowers = 0;
        numOfFollowing = 0;
        followers = null;
        myUid = 0;
        ifFollowingUid = 0;
    }
    
    @Override
    public Boolean FindFollowing(){
        Logging.LogMe("*", "FollowersSessionBean.java FindFollowing()");
        
        if(myUid == 0){
            return false;
        }
        
        List<Followers> followers = PersistanceFunctions.getAllFollowers();
        if(followers.isEmpty()){
            return false;
        }
        
        for(Followers follower: followers){
            if(ifFollowingUid == follower.getFollowerUserProfileId().getUserProfilesId() && myUid == follower.getFolloweeUserProfileId().getUserProfilesId()){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Integer NumberOfFollowers(){
        Logging.LogMe("*", "FollowersSessionBean.java NumberOfFollowers()");
        if(ifFollowingUid == 0){
            return null;
        }
        
        List<Followers> followers = PersistanceFunctions.getAllFollowers();
        if(followers.isEmpty()){
            return null;
        }
        
        for(Followers follower: followers){
            if(ifFollowingUid == follower.getFollowerUserProfileId().getUserProfilesId()){
                numOfFollowers += 1;
            }
        }
        
        return numOfFollowers;
    }
    
    @Override
    public Integer NumberOfFollowing(){
        Logging.LogMe("*", "FollowersSessionBean.java NumberOfFollowing()");
        if(ifFollowingUid == 0){
            return null;
        }
        
        List<Followers> followers = PersistanceFunctions.getAllFollowers();
        if(followers.isEmpty()){
            return null;
        }
        
        for(Followers follower: followers){
            if(ifFollowingUid == follower.getFolloweeUserProfileId().getUserProfilesId() ){
                numOfFollowing += 1;
            }
        }
        
        return numOfFollowing;
    }
}
