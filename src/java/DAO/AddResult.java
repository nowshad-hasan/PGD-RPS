/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nowshad
 */
public class AddResult {
    
    private DBConnection dbConnection;
    private Connection connection;
    private String sql;
    private double ansResult;
    
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    private boolean checkAddResult;
    
    public AddResult()
    {
        
        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();
        
    }
    
    public boolean AddCourseResult(int studentID,int session,int courseID,int attendance,int termTest,int finalExam)
    {
        sql="insert into result_table(student_id,session_id,course_id,attendance,term_test,final_exam)values(?,?,?,?,?,?)";
        
        try{
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,studentID);
        preparedStatement.setInt(2, session);
        preparedStatement.setInt(3, courseID);
        preparedStatement.setInt(4, attendance);
        preparedStatement.setInt(5, termTest);
        preparedStatement.setInt(6, finalExam);
        
        int i=preparedStatement.executeUpdate();
        
        if(i!=0)
            checkAddResult=true;
        else
            checkAddResult=false;
        
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return checkAddResult;
    }
    
}
