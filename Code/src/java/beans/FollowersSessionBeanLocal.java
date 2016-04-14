/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;
import model.Followers;

/**
 *
 * @author Jasim
 */
@Local
public interface FollowersSessionBeanLocal {

    public Boolean FindFollowing();

    public void setNumOfFollowing(Integer NumOfFollowing);

    public Integer getNumOfFollowing();

    public void setNumOfFollowers(Integer NumOfFollowers);

    public Integer getNumOfFollowers();

    public void setFollowers(Followers followers);

    public Followers getFollowers();

    public void setIfFollowingUid(Integer IfFollowingUid);

    public Integer getIfFollowingUid();

    public void setMyUid(Integer MyUid);

    public Integer getMyUid();

    public Integer NumberOfFollowing();

    public Integer NumberOfFollowers();
    
}
