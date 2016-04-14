/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.UserProfiles;

/**
 *
 * @author Jasim
 */
@WebServlet(urlPatterns={"/submit_register"})
@MultipartConfig
public class Submit_Register extends HttpServlet {


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
        
        UserProfiles user = new UserProfiles();
        try {
            Part filePart = request.getPart("displayPicture");
            if(filePart != null){
                InputStream fileInput = filePart.getInputStream();
                String fileName = "F:\\Study Material\\MS\\Web Architecture\\Project\\WebArchProject\\WebArch_project\\web\\img\\" + request.getParameter("uname") + "_" + getFileName(filePart);
                OutputStream  outputFile = new FileOutputStream(fileName);
                BufferedOutputStream outfile = new BufferedOutputStream(outputFile);
                int read = 0;
                byte[] bytes = new byte[1024];
                
                while ((read = fileInput.read(bytes, 0, bytes.length)) != -1) {
			outfile.write(bytes, 0, read);
		}
                
                outfile.close();
                user.setProfileImageUrl("img/" + request.getParameter("uname") + "_" + getFileName(filePart));
                Logging.LogMe("Display picture should have been copied", "submit_register.java, doPost");
            } else {
                user.setProfileImageUrl("img/Unknown.png");
                Logging.LogMe("No image of user...", "register.register_check()");
            }
        } catch (IOException ex) {
            user.setProfileImageUrl(null);
        } catch (ServletException ex) {
            user.setProfileImageUrl(null);
        }
        user.setFname(request.getParameter("fname"));
        user.setLname(request.getParameter("lname"));
        user.setScreenName(request.getParameter("uname"));
        user.setEmail(request.getParameter("email"));
        user.setGender(request.getParameter("gender"));
        user.setCountry(request.getParameter("country"));
        user.setCity(request.getParameter("city"));
        user.setAddress(request.getParameter("address"));
        user.setDescription(request.getParameter("description"));
        user.setTimeZone(request.getParameter("timezone"));
        user.setPassword(request.getParameter("password"));
        
        Date dNow = new Date();
        SimpleDateFormat ft
                = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        
        user.setCreatedAt(dNow);
        user.setGeoLat("");
        user.setGeoLong("");
        user.setLastUpdate(dNow);
        
        PersistanceFunctions.AddProfile(user);
        
        Logging.LogMe("User added", "register.register_check()");
        response.sendRedirect("login.jsp");

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
    
    private static String getFileName(Part part) {
    for (String cd : part.getHeader("content-disposition").split(";")) {
        if (cd.trim().startsWith("filename")) {
            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
        }
    }
    return null;
}

}
