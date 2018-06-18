/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nowshad Hasan
 */
public class SessionInfo {

    private DBConnection dbConnection;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private int sessionID;
    private String sql, sessionYear;

    public SessionInfo() {
        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();
    }

    public int getSessionID(String session) {
        sql = "select session_id from session_table where session_year=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, session);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sessionID = resultSet.getInt("session_id");
                System.out.println("From Session " + sessionID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return sessionID;
    }

    public String getSessionYear(int sessionID) {
        sql = "select session_year from session_table where session_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, sessionID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sessionYear = resultSet.getString("session_year");
                System.out.println("From Session " + sessionYear);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sessionYear;
    }

    public String SessionYearByRegistrationID(int registrationID) {
        sql = "SELECT session_year from registration_table,session_table where registration_table.session_id="
                + "session_table.session_id and registration_table.registration_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registrationID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sessionYear = resultSet.getString("session_year");
                System.out.println("From Session By RegistrationID " + sessionYear);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sessionYear;
    }

    public List<Session> getSessionYear() {
        sql = "select session_id,session_year from session_table";
        List<Session> sessionYearList = new ArrayList<Session>();

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                sessionYearList.add(resultSet.getString("session_year"));
                Session session = new Session();
                session.setSessionID(resultSet.getInt("session_id"));
                session.setSessionYear(resultSet.getString("session_year"));
                sessionYearList.add(session);
                //System.out.println();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return sessionYearList;
    }

    public List<Session> getRegistrationStatus() {
        sql = "SELECT * FROM session_table where registration_status='no'";

        List<Session> registrationStatusList = new ArrayList<Session>();

        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                sessionYearList.add(resultSet.getString("session_year"));
                Session session = new Session();
                session.setSessionID(resultSet.getInt("session_id"));
                session.setSessionYear(resultSet.getString("session_year"));
                session.setCourseRegistrationStatus(resultSet.getString("course_registration"));
                session.setStudentRegistrationStatus(resultSet.getString("student_registration"));
                session.setResultRegistrationStatus(resultSet.getString("result_registration"));

                if (resultSet.getString("course_registration").equals("no")) {
                    
                    session.setNextRegistrationStatus("course");

                } else if (resultSet.getString("student_registration").equals("no")) {
                    
                    session.setNextRegistrationStatus("student");

                } else if (resultSet.getString("result_registration").equals("no")) {
                    
                    session.setNextRegistrationStatus("result");

                }
                
                System.out.println("session_id "+resultSet.getInt("session_id")+" session_year "+resultSet.getString("session_year")+
                        " course_registration "+resultSet.getString("course_registration")+" student_registration "
                        +resultSet.getString("student_registration")+" result_registration "+resultSet.getString("result_registration"));

                registrationStatusList.add(session);
                //System.out.println();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return registrationStatusList;

    }

}
