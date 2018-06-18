/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataSource;

/**
 *
 * @author nowshad
 */
public class CourseInfo {

    private DBConnection dbConnection;
    private Connection connection;

    private DataSource dataSource;

    private String sql;

    private PreparedStatement preparedStatement;

    public CourseInfo() {
        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();

    }

    public List<Course> courseListByRegistrationID(int registrationID) throws SQLException {

        sql = "SELECT lab_credit,theory_credit,course_status,course_name,semester,course_credit,user_name,session_year,total_class,term_test_marks,final_exam_marks,lab_marks from course_table,"
                + "registration_table,session_table,user_table WHERE registration_table.course_id=course_table.course_id"
                + " and registration_table.session_id=session_table.session_id and registration_table.user_id="
                + "user_table.user_id and registration_table.registration_id=?";

        List<Course> Courses = new ArrayList<Course>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registrationID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Course course = new Course();
                course.setCourseName(resultSet.getString("course_name"));
                course.setCourseCredit(resultSet.getInt("course_credit"));
                course.setCourseSemester(resultSet.getString("semester"));
                course.setCourseTeacher(resultSet.getString("user_name"));
                course.setCourseSessionYear(resultSet.getString("session_year"));
                course.setTotalClass(resultSet.getInt("total_class"));
                course.setTermTestMarks(resultSet.getInt("term_test_marks"));
                course.setFinalExamMarks(resultSet.getInt("final_exam_marks"));
                course.setLabMarks(resultSet.getInt("lab_marks"));
                course.setThoeryCredit(resultSet.getInt("lab_credit"));
                course.setLabCredit(resultSet.getInt("lab_credit"));
                course.setCourseStatus(resultSet.getString("course_status"));
                Courses.add(course);

                System.out.println("OK from CourseInfo class By RegistrationID " + resultSet.getString("course_name") + " " + resultSet.getInt("course_credit")
                +" "+ resultSet.getString("semester")+resultSet.getString("user_name")+resultSet.getString("session_year"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Courses;
    }

    public List<Course> courseListBySemester(String semester) throws SQLException {

        sql = "select course_name,course_credit,semester from course_table\n"
                + "where current_semester_status=\"yes\"\n"
                + "and semester=?";

        List<Course> Courses = new ArrayList<Course>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, semester);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Course course = new Course();
                course.setCourseName(resultSet.getString("course_name"));
                course.setCourseCredit(resultSet.getInt("course_credit"));
                course.setCourseSemester(resultSet.getString("semester"));
                //course.setCourseTeacher(resultSet.getString("user_name"));

                Courses.add(course);

                System.out.println("OK from CourseInfo class " + resultSet.getString("course_name") + " " + resultSet.getInt("course_credit"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Courses;
    }

    public List<Course> courseListBySessionYear(int sessionID) throws SQLException {

        sql = "select total_class,term_test_marks,final_exam_marks,lab_marks,course_name,course_credit,semester,user_name,theory_credit,lab_credit,course_status,registration_id from course_table,registration_table,session_table,user_table \n"
                + "where current_semester_status=\"yes\" and course_table.course_id=registration_table.course_id\n"
                + "and session_table.session_id=registration_table.session_id and user_table.user_id=registration_table.user_id and session_table.session_id=?";

        List<Course> Courses = new ArrayList<Course>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, sessionID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Course course = new Course();
                course.setCourseName(resultSet.getString("course_name"));
                course.setCourseCredit(resultSet.getInt("course_credit"));
                course.setCourseSemester(resultSet.getString("semester"));
                course.setCourseTeacher(resultSet.getString("user_name"));
                course.setRegistrationID(resultSet.getInt("registration_id"));
                course.setThoeryCredit(resultSet.getInt("theory_credit"));
                course.setLabCredit(resultSet.getInt("lab_credit"));
                course.setCourseStatus(resultSet.getString("course_status"));
                course.setTotalClass(resultSet.getInt("total_class"));
                course.setTermTestMarks(resultSet.getInt("term_test_marks"));
                course.setFinalExamMarks(resultSet.getInt("final_exam_marks"));
                course.setLabMarks(resultSet.getInt("lab_marks"));
                //course.setCourseTeacher(resultSet.getString("user_name"));

                Courses.add(course);

                System.out.println("OK from CourseInfo class and Syllabus  " + resultSet.getString("course_name") + " " + resultSet.getInt("course_credit")
                        + " " + resultSet.getString("user_name") + " " + resultSet.getInt("registration_id"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Courses;
    }

    public List<Course> teacherCourseList(String userEmail) throws SQLException {

        sql = "select course_name,session_year,course_credit,semester,registration_id from user_table,\n"
                + "session_table,course_table,registration_table where user_table.user_id=\n"
                + "registration_table.user_id and registration_table.session_id=session_table\n"
                + ".session_id and course_table.course_id=registration_table.course_id and\n"
                + "user_table.user_email=?;";

        List<Course> Courses = new ArrayList<Course>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userEmail);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Course course = new Course();
                course.setCourseName(resultSet.getString("course_name"));
                course.setCourseCredit(resultSet.getInt("course_credit"));
                course.setCourseSemester(resultSet.getString("semester"));
                course.setCourseSessionYear(resultSet.getString("session_year"));
                course.setRegistrationID(resultSet.getInt("registration_id"));

                Courses.add(course);

                System.out.println("OK from CourseInfo class " + resultSet.getString("course_name") + " " + resultSet.getInt("course_credit") + " " + resultSet.getString("session_year")
                        + " " +resultSet.getInt("registration_id")+" "+ resultSet.getString("semester"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Courses;
    }

}
