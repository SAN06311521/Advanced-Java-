package com.BlobBySanya;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DisplayPhoto", urlPatterns = {"/displayphoto"})
public class DisplayPhoto extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");  
	            Connection con=DriverManager.getConnection("jdbc:Mysql://localhost/sanya","root","sanya"); 
	            PreparedStatement ps = con.prepareStatement("select PHOTO from imgstore where ImgName = ?");
	            String name = request.getParameter("imgname");
	            ps.setString(1,name);
	            ResultSet rs = ps.executeQuery();
	           if(rs.next()) {
	            Blob b = (Blob) rs.getBlob("PHOTO");
	            byte buf[] = b.getBytes(1, (int) b.length());
	            response.setContentType("image/png");
	            OutputStream os = response.getOutputStream();
	            os.write(buf);
	            os.close();
	           }
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	    }

}
