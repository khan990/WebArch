/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import beans.UserSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Followers;
import model.UserProfiles;

/**
 *
 * @author Jasim
 */
public class Follow extends HttpServlet {

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
        
        UserSessionBean user = (UserSessionBean) request.getSession().getAttribute("user");
        if(user == null){
            Logging.LogMe("User is null.", "Follow.doPost()");
            return;
        }
        
        Logging.LogMe("*", "Follow.doPost()");
        //Integer myUserId = Integer.parseInt((String) request.getParameter("my_user_name"));
        String OtherUserUname = ((String) request.getParameter("other_user_name"));
        
        //List<UserProfiles> user_me = PersistanceFunctions.getProfile(myUserId);
        UserProfiles user_other = PersistanceFunctions.getProfile(OtherUserUname).get(0);
        
        if(user_other == null){
            Logging.LogMe("No such user", "Follow.doPost()");
        }
        
        Followers follower = new Followers();
        follower.setFolloweeUserProfileId(user.getUser());
        follower.setFollowerUserProfileId(user_other);
        
        PersistanceFunctions.AddFollowers(follower);

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
