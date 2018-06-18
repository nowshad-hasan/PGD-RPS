/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author nowshad
 */
public class Result {

    private String studentName, studentReg, session, courseName, Grade,theoryExamGRade,labExamGrade,courseGrade;

    private int attendence, termTest, finalExam, studentID, studentRegistrationID,labExam,attendanceResult,termTestResult,
            finalExamResult,theoryExamResult,labExamResult;

    public void setTheoryExamGRade(String theoryExamGRade) {
        this.theoryExamGRade = theoryExamGRade;
    }

    public void setLabExamGrade(String labExamGrade) {
        this.labExamGrade = labExamGrade;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public void setAttendanceResult(int attendanceResult) {
        this.attendanceResult = attendanceResult;
    }

    public void setTermTestResult(int termTestResult) {
        this.termTestResult = termTestResult;
    }

    public void setFinalExamResult(int finalExamResult) {
        this.finalExamResult = finalExamResult;
    }

    public void setTheoryExamResult(int theoryExamResult) {
        this.theoryExamResult = theoryExamResult;
    }

    public void setLabExamResult(int labExamResult) {
        this.labExamResult = labExamResult;
    }

    public void setTheoryExamCGPA(double theoryExamCGPA) {
        this.theoryExamCGPA = theoryExamCGPA;
    }

    public void setLabExamCGPA(double labExamCGPA) {
        this.labExamCGPA = labExamCGPA;
    }

    public void setCourseCGPA(double courseCGPA) {
        this.courseCGPA = courseCGPA;
    }

    public String getTheoryExamGRade() {
        return theoryExamGRade;
    }

    public String getLabExamGrade() {
        return labExamGrade;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public int getAttendanceResult() {
        return attendanceResult;
    }

    public int getTermTestResult() {
        return termTestResult;
    }

    public int getFinalExamResult() {
        return finalExamResult;
    }

    public int getTheoryExamResult() {
        return theoryExamResult;
    }

    public int getLabExamResult() {
        return labExamResult;
    }

    public double getTheoryExamCGPA() {
        return theoryExamCGPA;
    }

    public double getLabExamCGPA() {
        return labExamCGPA;
    }

    public double getCourseCGPA() {
        return courseCGPA;
    }
    private double theoryExamCGPA,labExamCGPA,courseCGPA;

    public void setLabExam(int labExam) {
        this.labExam = labExam;
    }

    public int getLabExam() {
        return labExam;
    }
    private double CGPA;

    public int getStudentID() {
        return studentID;
    }

    public int getStudentRegistrationID() {
        return studentRegistrationID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentReg() {
        return studentReg;
    }

    public String getSession() {
        return session;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getAttendence() {
        return attendence;
    }

    public int getTermTest() {
        return termTest;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public String getGrade() {
        return Grade;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setStudentRegistrationID(int studentRegistrationID) {
        this.studentRegistrationID = studentRegistrationID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentReg(String studentReg) {
        this.studentReg = studentReg;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }

    public void setTermTest(int termTest) {
        this.termTest = termTest;
    }

    public void setFinalExam(int finalExam) {
        this.finalExam = finalExam;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

}
