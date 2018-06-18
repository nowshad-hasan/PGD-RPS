/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.StudentInfo;
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nowshad
 */
public class StudentInfoServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         int session=Integer.parseInt(request.getParameter("session"));
         try
         {
             StudentInfo studentInfo=new StudentInfo();
             List<Student> students=studentInfo.studentList(session);
             System.out.println("size of student: "+students.size());
             request.setAttribute("students", students);
              RequestDispatcher rd=request.getRequestDispatcher("student.jsp");  
              RequestDispatcher requestDispatcher=request.getRequestDispatcher("PreviousStudentRegistration.jsp");
              requestDispatcher.forward(request, response);
        rd.include(request, response);
             
         }catch(SQLException ex)
         {
             ex.printStackTrace();
         }
        
        
    }

    

}
