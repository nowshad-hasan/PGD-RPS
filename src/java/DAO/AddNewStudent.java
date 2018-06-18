/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.activation.DataSource;
import javax.servlet.http.Part;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Nowshad Hasan
 */
public class AddNewStudent {

    private DBConnection dbConnection;
    private Connection connection;

    private DataSource dataSource;

    private String sql,data,studentName,studentDept,studentRegistration,studentSession;
    private int studentReg,addStudentResult,sessionID;

    private PreparedStatement preparedStatement;
    
    private boolean addStudentUpdate=true;

    public AddNewStudent() {
        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();
    }
    
    public boolean AddNewStudentExcel(Part sourceFile)
    {
        SessionInfo sessionInfo=new SessionInfo();
        
        try
        {
            
            sql="insert into student_table(student_name,student_dept,student_reg,session_id) values(?,?,?,?)";
            
                    InputStream fileInputStream=sourceFile.getInputStream();
           XSSFWorkbook xSSFWorkbook=new XSSFWorkbook(fileInputStream);
           XSSFSheet sheet1= xSSFWorkbook.getSheetAt(0);
            data=sheet1.getRow(1).getCell(0).getStringCellValue();
//           System.out.println(sheet1.getRow(0).getCell(0).getStringCellValue());
            int rowCount=sheet1.getLastRowNum();
            
            for(int i=1;i<=rowCount;++i)
            {
                studentName=sheet1.getRow(i).getCell(0).getStringCellValue();
                studentDept=sheet1.getRow(i).getCell(1).getStringCellValue();
                studentReg=(int) sheet1.getRow(i).getCell(2).getNumericCellValue();
                studentSession=  sheet1.getRow(i).getCell(3).getStringCellValue(); ;
                System.out.println("Student Data: "+studentName+" "+studentDept+" "+studentSession);
                sessionID=sessionInfo.getSessionID(studentSession);
                System.out.println("From Add New Student "+sessionID);
                
                studentRegistration=Integer.toString(studentReg);
                
            preparedStatement=connection.prepareStatement(sql);
        
        preparedStatement.setString(1, studentName);
        preparedStatement.setString(2,studentDept);
        preparedStatement.setString(3, studentRegistration);
        preparedStatement.setInt(4, sessionID);
        
        addStudentResult=preparedStatement.executeUpdate();
        
        if(addStudentResult!=0 && addStudentUpdate==true)
            addStudentUpdate=true;
        else
            addStudentUpdate=false;
                
            }
            
            
           xSSFWorkbook.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        System.out.println("From Java Class: "+data);
        
        return addStudentUpdate;

        
    }

}
