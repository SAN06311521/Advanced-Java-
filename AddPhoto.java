package com.BlobBySanya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(name = "AddPhoto", urlPatterns = {"/addphoto"})
@MultipartConfig(maxFileSize = 16177215)
public class AddPhoto extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            Part p =  request.getPart("imgname");
            Scanner scanner  = new Scanner( p.getInputStream());
            String imgname = scanner.nextLine(); 
            
            
            Part photo =  request.getPart("addphoto");
                        
           
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:Mysql://localhost/sanya","root","sanya"); 
            PreparedStatement ps = con.prepareStatement("insert into imgstore values(?,?)");
            ps.setString(1, imgname);
            // size must be converted to integer type otherwise it will give error
            ps.setBinaryStream(2, photo.getInputStream(), (int)  photo.getSize());
            ps.executeUpdate();
            con.close();
            out.println("Image is added.");
        } 
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {            
            out.close();
        }
    }
}
