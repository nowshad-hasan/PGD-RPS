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
public class Student {

    private String studentSession,studentName, studentDept, studentReg;
    private int  studentID;

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentDept() {
        return studentDept;
    }

    public String getStudentReg() {
        return studentReg;
    }

    public String getStudentSession() {
        return studentSession;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }

    public void setStudentReg(String studentReg) {
        this.studentReg = studentReg;
    }

    public void setStudentSession(String studentSession) {
        this.studentSession = studentSession;
    }

}
