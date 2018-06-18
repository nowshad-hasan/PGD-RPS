/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.DBConnection;
import DAO.StudentInfo;
import DAO.UserInfo;
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nowshad Hasan
 */
public class RegistrationInfoServlet extends HttpServlet {

        private DBConnection dbConnection;
    private Connection connection;
    
        private String sql;
        private int session,courseID;
    
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public RegistrationInfoServlet()
    {
                super();
        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        System.out.println("Fro GET:");
//       
//        try{
//                    for(int i=15;i<=18;++i)
//        {
//                  sql="insert into student_registration_table\n" +
//"(student_registration_id,student_id,registration_id)\n" +
//"values (NULL,"+i+",17),(NULL,"+i+",18),(NULL,"+i+",19),(NULL,"+i+",20),(NULL,"+i+",21),(NULL,"+i+",22),\n" +
//"(NULL,"+i+",23),(NULL,"+i+",24);";
//                  
//                  preparedStatement=connection.prepareStatement(sql);
//                  
//                  int j=preparedStatement.executeUpdate();
//                  System.out.println("Fro GET: i :"+i);
//        }
//                    
//                    
//        }catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
        
        
        

        


        
        
        
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        StudentInfo studentInfo=new StudentInfo();
        UserInfo userInfo=new UserInfo();
        
        session=Integer.parseInt(request.getParameter("session"));
        courseID=Integer.parseInt(request.getParameter("courseID"));
        System.out.println("skj: "+session+" "+courseID);
        
        int registrationNO=studentInfo.getRegistrationNumber(session, courseID);
        String registeredTeacher=userInfo.getRegistrationTeacher(session, courseID);
        
        System.out.println("Previous Registration Number: "+registrationNO);
        
        System.out.println("Previous Registration Teacher: "+registeredTeacher);
        
        
        try
        {
                         List<Student> registeredStudents=studentInfo.registeredStudentList(registrationNO);
             System.out.println("size of student: "+registeredStudents.size());
             request.setAttribute("registeredStudents", registeredStudents);
             request.setAttribute("registeredTeacher", registeredTeacher);
              RequestDispatcher requestDispatcher=request.getRequestDispatcher("PreviousRegistration.jsp");  
        requestDispatcher.include(request, response);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
                     

        
    }



}
