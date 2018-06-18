/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.AddResult;
import DAO.ResultInfo;
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
public class AddResultServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       int courseID=ResultInfo.savedCourseID;
        int session=ResultInfo.savedSession;
        int studentID;
        
        String attendance,termTest,finalExam;
        int attendanceInt,termTestInt,finalExamInt;
        
        System.out.println(session+" "+courseID);
        
        try
         {
             StudentInfo studentInfo=new StudentInfo();
             AddResult addResult=new AddResult();
             List<Student> students=studentInfo.studentList(session);
             System.out.println("size of student: "+students.size());
             
             for(int counter=0,i=1;counter<students.size();++counter,++i)
             {
                 System.out.println(students.get(counter).getStudentID());
                 studentID=students.get(counter).getStudentID();
                 attendance="attendance"+Integer.toString(i);
                 termTest="termTest"+Integer.toString(i);
                 finalExam="finalExam"+Integer.toString(i);
                 
                 attendanceInt=Integer.parseInt(request.getParameter(attendance));
                 termTestInt=Integer.parseInt(request.getParameter(termTest));
                 finalExamInt=Integer.parseInt(request.getParameter(finalExam));
                 
                 System.out.println("att "+attendanceInt+" "+"TT "+termTestInt+" Final "+finalExamInt);
               boolean result=  addResult.AddCourseResult(studentID, session, courseID, attendanceInt, termTestInt, finalExamInt);
                 System.out.println(result);
                 
                 RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.jsp");
                 requestDispatcher.include(request, response);
                 
             }
             
             
             
         }catch(SQLException ex)
         {
             ex.printStackTrace();
         }
        
    }

    

}
