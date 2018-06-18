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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nowshad Hasan
 */
@WebServlet(name = "PreviousStudentRegistrationServlet", urlPatterns = {"/PreviousStudentRegistrationServlet"})
public class PreviousStudentRegistrationServlet extends HttpServlet {





    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         StudentInfo studentInfo=new StudentInfo();
        
        int sessionID=Integer.parseInt(request.getParameter("sessionID"));
        int courseID=Integer.parseInt(request.getParameter("courseID"));
        
        int registrationID=studentInfo.getRegistrationNumber(sessionID, courseID);
        
        String[] selectedItems = request.getParameterValues("selectedItems");
        
        for (String selectedItem : selectedItems) {
//    String mileage = request.getParameter("mileage_" + selectedItem);
//    // ...
            
            //System.out.println(selectedItem);
            int studentID=Integer.parseInt(selectedItem);
            System.out.println(studentID);
            
            studentInfo.registerPreviousStudent(studentID, registrationID);
            
}
        
//        System.out.println("FROM GET");
//        
//                 int session=Integer.parseInt(request.getParameter("session"));
//         try
//         {
//             StudentInfo studentInfo=new StudentInfo();
//             List<Student> students=studentInfo.studentList(session);
//             System.out.println("size of student: "+students.size());
//             request.setAttribute("students", students);
//              RequestDispatcher rd=request.getRequestDispatcher("PreviousStudentRegistration.jsp");  
//        rd.include(request, response);
//             
//         }catch(SQLException ex)
//         {
//             ex.printStackTrace();
//         }
        
        response.sendRedirect("home_admin.jsp");
        
    }

   

}
