/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.ResultInfo;
import entity.Result;
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
public class IndividualResultServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int studentID=Integer.parseInt(request.getParameter("studentID"));
        
        try{
            ResultInfo resultInfo=new ResultInfo();
           List<Result> results=resultInfo.resultList(studentID);
           System.out.println("size of student: "+results.size());
             request.setAttribute("results", results);
              RequestDispatcher rd=request.getRequestDispatcher("IndividualResult.jsp");  
        rd.include(request, response);
        }
      catch(SQLException ex)
       {
           ex.printStackTrace();
       }
    }

    

}
