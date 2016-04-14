/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;
import model.UserProfiles;
/**
 *
 * @author Jasim
 */
@Local
public interface UserSessionBeanLocal {

    public void UserSessionBean();

    public String getUsername();

    public void setUsername(String username);

    public String getPassword();

    public void setPassword(String password);

    public UserProfiles getUser();

    public void setUser(UserProfiles user);

    public Boolean UserValidity();

    public Boolean UserProfile();


}
