/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.User;
import entity.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nowshad Hasan
 */
public class RegistrationInfo {

    private DBConnection dbConnection;
    private Connection connection;
    private PreparedStatement preparedStatement;
    
    private String sql;

    public RegistrationInfo() {
        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();
    }
    
    public List<User> registrationInfoByRegistrationID(int registrationID)
    {
        List<User> registrationInfoList = new ArrayList<User>();
        sql="SELECT course_name,semester,course_credit,user_name,session_year from course_table,registration_table,"
                + "session_table,user_table WHEREregistration_table.course_id=course_table.course_id and"
                + " registration_table.session_id=session_table.session_id and registration_table.user_id="
                + "user_table.user_id andregistration_table.registration_id=?";
        return registrationInfoList;
    }
    
    public int incompleteRegistration()
    {
        return 0;
    }

}
