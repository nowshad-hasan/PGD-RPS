/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.ResultInfo;

/**
 *
 * @author nowshad
 */
public class StudentInfo {

    private DBConnection dbConnection;
    private Connection connection;
    private String sql;

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public StudentInfo() {
        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();
    }

    public List<Student> studentList(int session) throws SQLException {

        sql = "select student_id,student_name,student_reg,student_dept,session_year from student_table,session_table where \n"
                + "student_table.session_id=session_table.session_id and session_table.session_id=?";

        List<Student> students = new ArrayList<Student>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, session);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentName(resultSet.getString("student_name"));
                student.setStudentReg(resultSet.getString("student_reg"));
                student.setStudentDept(resultSet.getString("student_dept"));
                student.setStudentSession(resultSet.getString("session_year"));
                student.setStudentID(resultSet.getInt("student_id"));

                students.add(student);

                System.out.println("OK from StudentInfo class " + resultSet.getString("student_name") + " " + resultSet.getString("student_reg")
                        + resultSet.getString("session_year") + " " + resultSet.getString("student_dept") + " " + resultSet.getInt("student_id"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public int getRegistrationNumber(int session, int courseID) {
        int registrationNumber = 0;
        sql = "select registration_id from registration_table where session_id=? and course_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, session);
            preparedStatement.setInt(2, courseID);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                registrationNumber = resultSet.getInt("registration_id");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return registrationNumber;
    }

    public List<Student> registeredStudentList(int registrationNo) throws SQLException {

        sql = "select student_name,student_reg,student_dept,session_year from student_table,\n"
                + "session_table,student_registration_table where student_table.session_id=\n"
                + "session_table.session_id and student_registration_table.student_id=\n"
                + "student_table.student_id and student_registration_table.registration_id=?";

        List<Student> students = new ArrayList<Student>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registrationNo);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentName(resultSet.getString("student_name"));
                student.setStudentReg(resultSet.getString("student_reg"));
                student.setStudentDept(resultSet.getString("student_dept"));
                student.setStudentSession(resultSet.getString("session_year"));
             //student.setStudentID(resultSet.getInt("student_id"));

                students.add(student);

                System.out.println("OK from StudentInfo class " + resultSet.getString("student_name") + " " + resultSet.getString("student_reg")
                        + resultSet.getString("session_year") + " " + resultSet.getString("student_dept"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public void registerPreviousStudent(int studentID, int registrationID) {
        sql = "insert into student_registration_table (student_registration_id,student_id\n"
                + ",registration_id) values (NULL,?,?); ";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentID);
            preparedStatement.setInt(2, registrationID);
            
            int i=preparedStatement.executeUpdate();
            System.out.println("Execute Update for Previous Student Registration: "+i);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
