/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Result;
import entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nowshad
 */
public class ResultInfo {

    private DBConnection dbConnection;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String sql;
    private double ansResult;

    public static int savedCourseID = 0, savedSession = 0;

    public ResultInfo() {
        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();
    }

    public List<Result> resultListByRegistrationID(int registrationID) throws SQLException {

        List<Result> results = new ArrayList<Result>();

        sql = "select student_table.student_id,student_reg,student_name,attendance,term_test,final_exam from result_table,student_registration_table,"
                + "student_table,registration_table where result_table.student_registration_id=student_registration_table.student_registration_id"
                + " and student_registration_table.student_id=student_table.student_id and student_registration_table.registration_id="
                + "registration_table.registration_id and registration_table.registration_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registrationID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                ansResult = calculateCGPA(resultSet.getInt("attendance"), resultSet.getInt("term_test"), resultSet.getInt("final_exam"));

                Result result = new Result();
                result.setStudentID(resultSet.getInt("student_id"));
                result.setStudentReg(resultSet.getString("student_reg"));
                result.setStudentName(resultSet.getString("student_name"));
                // result.setSession(resultSet.getString("session_year"));
                //  result.setCourseName(resultSet.getString("course_name"));
                result.setAttendence(resultSet.getInt("attendance"));
                result.setTermTest(resultSet.getInt("term_test"));
                result.setFinalExam(resultSet.getInt("final_exam"));

                result.setCGPA(ansResult);
                result.setGrade(calculateGrade(ansResult));

                results.add(result);

                System.out.println("OK from StudentInfo class By  RegistrationID " + resultSet.getInt("student_id")
                        + resultSet.getString("student_reg") + " " + resultSet.getString("student_name")
                        + resultSet.getInt("attendance") + " " + resultSet.getInt("term_test") + " " + resultSet.getInt("final_exam"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;

    }

    public List<Result> resultListByRegistrationIDNew(int registrationID) throws SQLException {
        List<Result> results = new ArrayList<Result>();

        sql = "select student_table.student_id,student_name,student_dept,student_reg,AT,TT,Final,Lab from student_table,"
                + "registration_table,student_registration_table WHERE student_table.student_id="
                + "student_registration_table.student_id and registration_table.registration_id=student_registration_table.registration_id"
                + " and student_registration_table.registration_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registrationID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                ansResult = calculateCGPA(resultSet.getInt("AT"), resultSet.getInt("TT"), resultSet.getInt("Final"));

                Result result = new Result();
                result.setStudentID(resultSet.getInt("student_id"));
                result.setStudentReg(resultSet.getString("student_reg"));
                result.setStudentName(resultSet.getString("student_name"));
                // result.setSession(resultSet.getString("session_year"));
                //  result.setCourseName(resultSet.getString("course_name"));
                result.setAttendence(resultSet.getInt("AT"));
                result.setTermTest(resultSet.getInt("TT"));
                result.setFinalExam(resultSet.getInt("Final"));
                result.setLabExam(resultSet.getInt("Lab"));
                result.setCGPA(ansResult);
                result.setGrade(calculateGrade(ansResult));

                results.add(result);

                System.out.println("OK from StudentInfo class By  RegistrationID " + resultSet.getInt("student_id")
                        + resultSet.getString("student_reg") + " " + resultSet.getString("student_name")
                        + resultSet.getInt("AT") + " " + resultSet.getInt("TT") + " " + resultSet.getInt("Final"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public List<Result> resultListByRegistrationIDShowNew(int registrationID) throws SQLException {
        
        //System.out.println("SHOW");

        int totalClass = 0, totalTermTestMarks = 0, totalFinalMarks = 0, totalLabMarks = 0,theoryCredit=0,labCredit=0,courseCredit=0;

        sql = "SELECT course_credit,theory_credit,lab_credit,total_class,term_test_marks,final_exam_marks,lab_marks FROM "
                + "registration_table,course_table where registration_table.course_id=course_table.course_id and registration_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registrationID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalClass = resultSet.getInt("total_class");
                totalTermTestMarks = resultSet.getInt("term_test_marks");
                totalFinalMarks = resultSet.getInt("final_exam_marks");
                totalLabMarks = resultSet.getInt("lab_marks");
                theoryCredit=resultSet.getInt("theory_credit");
                labCredit=resultSet.getInt("lab_credit");
                courseCredit=resultSet.getInt("course_credit");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        
        System.out.println("Total Class "+totalClass+" Total Term Test"+totalTermTestMarks+" Total Final Marks "+totalFinalMarks+" Totyal Lab Marks "+totalLabMarks
        +" Theory Credit "+theoryCredit+" Lab Credit "+labCredit+" Course Credit "+courseCredit);

        List<Result> results = new ArrayList<Result>();

        sql = "select student_table.student_id,student_name,student_dept,student_reg,AT,TT,Final,Lab from student_table,"
                + "registration_table,student_registration_table WHERE student_table.student_id="
                + "student_registration_table.student_id and registration_table.registration_id=student_registration_table.registration_id"
                + " and student_registration_table.registration_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registrationID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                //ansResult = calculateCGPA(resultSet.getInt("AT"), resultSet.getInt("TT"), resultSet.getInt("Final"));

                Result result = new Result();
                result.setStudentID(resultSet.getInt("student_id"));
                result.setStudentReg(resultSet.getString("student_reg"));
                result.setStudentName(resultSet.getString("student_name"));
                // result.setSession(resultSet.getString("session_year"));
                //  result.setCourseName(resultSet.getString("course_name"));

                int AT = resultSet.getInt("AT");
                int TT = resultSet.getInt("TT");
                int Final = resultSet.getInt("Final");
                int Lab = resultSet.getInt("Lab");
                
                System.out.println("AT "+AT+" TT "+TT+" Final "+Final+" Lab "+Lab);

                int attendanceResult = (AT*10 / totalClass) ;
                int termTestResult = (TT*20 / totalTermTestMarks) ;
                int finalExamResult = (Final * 70/ totalFinalMarks) ;
                int labExamResult = (Lab * 70 / totalLabMarks) ;
                int theoryExamResult = attendanceResult + termTestResult + finalExamResult;
                
                
                double theoryExamCGPA=calculateCGPA(theoryExamResult);
                String theoryExamGrade=calculateGrade(theoryExamCGPA);
                
                double labExamCGPA=calculateCGPA(labExamResult);
                String labExamGrade=calculateGrade(labExamCGPA);

                double courseCGPA = ((theoryExamCGPA*theoryCredit)+(labExamCGPA*labCredit))/courseCredit;
                String courseGrade=calculateGrade(courseCGPA);

                result.setAttendanceResult(attendanceResult);
                result.setTermTestResult(termTestResult);
                result.setFinalExamResult(finalExamResult);
                result.setLabExamResult(labExamResult);
                result.setTheoryExamResult(theoryExamResult);
                result.setTheoryExamCGPA(theoryExamCGPA);
                result.setLabExamCGPA(labExamCGPA);
                result.setTheoryExamGRade(theoryExamGrade);
                result.setLabExamGrade(labExamGrade);
                result.setCourseCGPA(courseCGPA);
                result.setCourseGrade(courseGrade);
                
                System.out.println(attendanceResult+" "+termTestResult+" "+finalExamResult+" "+labExamResult);
                
                //result.setCGPA(ansResult);
                //result.setGrade(calculateGrade(ansResult));

                results.add(result);

//                System.out.println("OK from StudentInfo class By  RegistrationID " + resultSet.getInt("student_id")
//                        + resultSet.getString("student_reg") + " " + resultSet.getString("student_name")
//                        + resultSet.getInt("AT") + " " + resultSet.getInt("TT") + " " + resultSet.getInt("Final"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public List<Result> resultList(int session, int courseID) throws SQLException {
        List<Result> results = new ArrayList<Result>();

        sql = "select student_name,student_reg,session_year,course_name,attendance,term_test,final_exam from result_table,"
                + "student_table,course_table,session_table where student_table.student_id=result_table.student_id and "
                + "course_table.course_id=result_table.course_id and session_table.session_id=? and course_table.course_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, session);
            preparedStatement.setInt(2, courseID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                ansResult = calculateCGPA(resultSet.getInt("attendance"), resultSet.getInt("term_test"), resultSet.getInt("final_exam"));

                Result result = new Result();
                result.setStudentName(resultSet.getString("student_name"));
                result.setStudentReg(resultSet.getString("student_reg"));
                result.setSession(resultSet.getString("session_year"));
                result.setCourseName(resultSet.getString("course_name"));
                result.setAttendence(resultSet.getInt("attendance"));
                result.setTermTest(resultSet.getInt("term_test"));
                result.setFinalExam(resultSet.getInt("final_exam"));

                result.setCGPA(ansResult);
                result.setGrade(calculateGrade(ansResult));

                results.add(result);

//             System.out.println("OK from StudentInfo class "+resultSet.getString("student_name")+" "+resultSet.getString("student_reg")+
                //                   resultSet.getInt("student_session")+" "+resultSet.getString("student_dept")+" "+resultSet.getInt("student_id"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;

    }

    public List<Result> resultList(int studentID) throws SQLException {
        sql = "select course_name,attendance,term_test,final_exam from result_table,course_table,student_table where student_table."
                + "student_id=result_table.student_id and course_table.course_id=result_table.course_id and student_table.student_id=?";

        List<Result> results = new ArrayList<Result>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                ansResult = calculateCGPA(resultSet.getInt("attendance"), resultSet.getInt("term_test"), resultSet.getInt("final_exam"));

                Result result = new Result();

                result.setCourseName(resultSet.getString("course_name"));
                result.setAttendence(resultSet.getInt("attendance"));
                result.setTermTest(resultSet.getInt("term_test"));
                result.setFinalExam(resultSet.getInt("final_exam"));

                result.setCGPA(ansResult);
                result.setGrade(calculateGrade(ansResult));

                results.add(result);

//             System.out.println("OK from StudentInfo class "+resultSet.getString("student_name")+" "+resultSet.getString("student_reg")+
                //                   resultSet.getInt("student_session")+" "+resultSet.getString("student_dept")+" "+resultSet.getInt("student_id"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public List<Result> studentRegistrationListByRegistrationID(int registrationID) {
        List<Result> studentRegistrationInfo = new ArrayList<Result>();
        sql = "SELECT * FROM `student_registration_table` WHERE registration_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registrationID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Result result = new Result();
                result.setStudentRegistrationID(resultSet.getInt("student_registration_id"));
                result.setStudentID(resultSet.getInt("student_id"));

                studentRegistrationInfo.add(result);

                System.out.println("OK from StudentInfo class " + resultSet.getInt("student_registration_id") + " " + resultSet.getInt("student_id"));
                //                   resultSet.getInt("student_session")+" "+resultSet.getString("student_dept")+" "+resultSet.getInt("student_id"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return studentRegistrationInfo;
    }

    public boolean updateCourseResultByStudentRegistrationID(int studentRegistrationID, int attendance, int termTest, int finalExam) {
        int updateResult = 0;

        sql = "UPDATE `result_table` SET attendance = " + attendance + ", term_test = " + termTest + ",\n"
                + " final_exam = " + finalExam + " WHERE student_registration_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentRegistrationID);

            updateResult = preparedStatement.executeUpdate();
            System.out.println("Boolean Value" + updateResult);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (updateResult == 1) {
            return true;
        } else {
            return false;
        }

    }

    public List<Result> resultListTableGenerate(int session, int courseID) throws SQLException {
        savedCourseID = courseID;
        savedSession = session;
        List<Result> results = new ArrayList<Result>();

        sql = "SELECT student_name,student_reg,session_year from \n"
                + "student_table,session_table where student_table.session_id=session_table.session_id and session_table.session_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, session);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Result result = new Result();
                result.setStudentName(resultSet.getString("student_name"));
                result.setStudentReg(resultSet.getString("student_reg"));

                results.add(result);

//             System.out.println("OK from StudentInfo class "+resultSet.getString("student_name")+" "+resultSet.getString("student_reg")+
                //                   resultSet.getInt("student_session")+" "+resultSet.getString("student_dept")+" "+resultSet.getInt("student_id"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;

    }

    public double calculateCGPA(int attendance, int termTest, int finalExam) {
        int summation = attendance + termTest + finalExam;
        double ans = 0;

        if (summation >= 80 && summation <= 100) {
            ans = 4;

        } else if (summation >= 75 && summation < 80) {
            ans = 3.75;
        } else if (summation >= 70 && summation < 75) {
            ans = 3.50;
        } else if (summation >= 65 && summation < 70) {
            ans = 3.25;
        } else if (summation >= 60 && summation < 65) {
            ans = 3;
        } else if (summation >= 55 && summation < 60) {
            ans = 2.75;
        } else if (summation >= 50 && summation < 55) {
            ans = 2.5;
        } else if (summation >= 45 && summation < 50) {
            ans = 2.25;
        } else if (summation >= 40 && summation < 45) {
            ans = 2;
        } else {
            ans = 0;
        }
        return ans;
    }

        public double calculateCGPA(int summation) {
        
        double ans = 0;

        if (summation >= 80 && summation <= 100) {
            ans = 4;

        } else if (summation >= 75 && summation < 80) {
            ans = 3.75;
        } else if (summation >= 70 && summation < 75) {
            ans = 3.50;
        } else if (summation >= 65 && summation < 70) {
            ans = 3.25;
        } else if (summation >= 60 && summation < 65) {
            ans = 3;
        } else if (summation >= 55 && summation < 60) {
            ans = 2.75;
        } else if (summation >= 50 && summation < 55) {
            ans = 2.5;
        } else if (summation >= 45 && summation < 50) {
            ans = 2.25;
        } else if (summation >= 40 && summation < 45) {
            ans = 2;
        } else {
            ans = 0;
        }
        return ans;
    }
    
    
    public String calculateGrade(double CGPA) {
        String Grade = null;

        if (CGPA == 4) {
            Grade = "A+";
        } else if (CGPA == 3.75) {
            Grade = "A";
        } else if (CGPA == 3.5) {
            Grade = "A-";
        } else if (CGPA == 3.25) {
            Grade = "B+";
        } else if (CGPA == 3) {
            Grade = "B";
        } else if (CGPA == 2.75) {
            Grade = "B-";
        } else if (CGPA == 2.5) {
            Grade = "C+";
        } else if (CGPA == 2.25) {
            Grade = "C";
        } else if (CGPA == 2) {
            Grade = "C-";
        } else {
            Grade = "F";
        }
        return Grade;
    }

}
