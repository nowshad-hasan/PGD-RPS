/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.AddNewStudent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Nowshad Hasan
 */
@WebServlet(name = "AddStudentServlet", urlPatterns = {"/AddStudentServlet"})
public class AddStudentServlet extends HttpServlet {




     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       System.out.println("From Get "+System.getProperty("user.dir"));
       
       try{
           File sourcecFile=new File("D:\\Book1.xlsx");
          // Part newFile=new File(request.getParameter("file"));
           Part newFile = request.getPart("file");
           System.out.println("FIle Name: "+newFile.getName());
//           if(newFile.exists())
//           {
//               System.out.println("File exists");
//           }
//           else 
//               System.out.println("File Not Found");
           FileInputStream fileInputStream=(FileInputStream) newFile.getInputStream();
           XSSFWorkbook xSSFWorkbook=new XSSFWorkbook(fileInputStream);
           XSSFSheet sheet1= xSSFWorkbook.getSheetAt(0);
           System.out.println(sheet1.getRow(0).getCell(0).getStringCellValue());
           xSSFWorkbook.close();
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
       
    }


   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       System.out.println("From Get "+System.getProperty("user.dir"));
       
       try{
          // File sourcecFile=new File("D:\\Book1.xlsx");
          // Part newFile=new File(request.getParameter("file"));
           Part sourceFile = request.getPart("file");
           
           AddNewStudent addNewStudent=new AddNewStudent();
           
           System.out.println("From servlet to Java Class: "+addNewStudent.AddNewStudentExcel(sourceFile));
           
//           System.out.println("FIle Name: "+sourceFile.getName());
////           if(newFile.exists())
////           {
////               System.out.println("File exists");
////           }
////           else 
////               System.out.println("File Not Found");
////           FileInputStream fileInputStream=(FileInputStream) newFile.getInputStream();
//           InputStream fileInputStream=sourceFile.getInputStream();
//           XSSFWorkbook xSSFWorkbook=new XSSFWorkbook(fileInputStream);
//           XSSFSheet sheet1= xSSFWorkbook.getSheetAt(0);
//           System.out.println(sheet1.getRow(0).getCell(0).getStringCellValue());
//           xSSFWorkbook.close();
           
           
           
           
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
        
    }



}
