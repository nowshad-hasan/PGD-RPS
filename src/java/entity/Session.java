/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Nowshad Hasan
 */
public class Session {
    
    String sessionYear,courseRegistrationStatus,studentRegistrationStatus,resultRegistrationStatus,nextRegistrationStatus;
    int sessionID;

    public String getSessionYear() {
        return sessionYear;
    }

    public void setCourseRegistrationStatus(String courseRegistrationStatus) {
        this.courseRegistrationStatus = courseRegistrationStatus;
    }

    public void setStudentRegistrationStatus(String studentRegistrationStatus) {
        this.studentRegistrationStatus = studentRegistrationStatus;
    }

    public void setResultRegistrationStatus(String resultRegistrationStatus) {
        this.resultRegistrationStatus = resultRegistrationStatus;
    }

    public void setNextRegistrationStatus(String nextRegistrationStatus) {
        this.nextRegistrationStatus = nextRegistrationStatus;
    }

    public String getCourseRegistrationStatus() {
        return courseRegistrationStatus;
    }

    public String getStudentRegistrationStatus() {
        return studentRegistrationStatus;
    }

    public String getResultRegistrationStatus() {
        return resultRegistrationStatus;
    }

    public String getNextRegistrationStatus() {
        return nextRegistrationStatus;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionYear(String sessionYear) {
        this.sessionYear = sessionYear;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }
    
    
    
}
