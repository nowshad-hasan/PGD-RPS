/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.CourseInfo;
import DAO.DBConnection;
import DAO.SessionInfo;
import entity.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nowshad
 */
public class CourseInfoServlet extends HttpServlet {

       private static final long serialVersionUID = 1L;

    private DBConnection dbConnection;
    private Connection connection;
    
    private PrintWriter printWriter;
    
    public CourseInfoServlet()
    {
          super();
        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String semester=request.getParameter("semester");
        
        
        try{
        CourseInfo courseInfo=new CourseInfo();
       // SessionInfo sessionInfo=new SessionInfo();
            List<Course> courses=courseInfo.courseListBySemester(semester);
            System.out.println("dkufhvls "+courses.size());
        //    System.out.println("Session Year List Size "+sessionInfo.getSessionYear());
            request.setAttribute("courses", courses);
          //  session.setAttribute("sessionYear", sessionInfo.getSessionYear());
              RequestDispatcher rd=request.getRequestDispatcher("courses.jsp");  
        rd.include(request, response);
        
       // request.getRequestDispatcher("course.jsp").forward(request, response);
        
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
       
       
    }

    

}
