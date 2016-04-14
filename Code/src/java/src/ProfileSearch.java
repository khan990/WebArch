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

/**
 *
 * @author Jasim
 */
@WebServlet(urlPatterns = {"/ProfileSearch"})
@MultipartConfig
public class ProfileSearch extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        UserSessionBean user = (UserSessionBean) req.getSession().getAttribute("user");
        if(user == null){
            Logging.LogMe("User is null.", "ProfileSearch.doPost()");
            return;
        }
        
        List<String> unames;
        unames = PersistanceFunctions.getUsernames();
        Logging.LogMe("Got usernames of user: ", "ProfileSearch.doPost()");
        
        JSONArray Json_array = new JSONArray();
        
        List<String> sublist = new ArrayList<String>();
        
        for(String a_username: unames){
            if(a_username.matches(req.getParameter("search") + "(.*)")){
                sublist.add(a_username);
            }
        }
        
        Json_array.addAll(sublist);
        Logging.LogMe("Done usernames of users for search ", "ProfileSearch.doPost()");
        resp.getOutputStream().print(Json_array.toJSONString());
    }
    
    
}
