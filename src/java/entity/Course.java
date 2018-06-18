/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 *
 * @author nowshad
 */
public class Course {

    private String courseName, courseSemester, courseTeacher, courseSessionYear, courseStatus;
    private int courseCredit, registrationID, thoeryCredit, labCredit,totalClass,termTestMarks,finalExamMarks,labMarks;
    

    public int getTotalClass() {
        return totalClass;
    }

    public void setTotalClass(int totalClass) {
        this.totalClass = totalClass;
    }

    public void setTermTestMarks(int termTestMarks) {
        this.termTestMarks = termTestMarks;
    }

    public void setFinalExamMarks(int finalExamMarks) {
        this.finalExamMarks = finalExamMarks;
    }

    public void setLabMarks(int labMarks) {
        this.labMarks = labMarks;
    }

    public int getTermTestMarks() {
        return termTestMarks;
    }

    public int getFinalExamMarks() {
        return finalExamMarks;
    }

    public int getLabMarks() {
        return labMarks;
    }

    public void setThoeryCredit(int thoeryCredit) {
        this.thoeryCredit = thoeryCredit;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setLabCredit(int labCredit) {
        this.labCredit = labCredit;
    }

    public int getThoeryCredit() {
        return thoeryCredit;
    }

    public int getLabCredit() {
        return labCredit;
    }

    public int getRegistrationID() {
        return registrationID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseSessionYear() {
        return courseSessionYear;
    }

    public String getCourseSemester() {
        return courseSemester;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setRegistrationID(int registrationID) {
        this.registrationID = registrationID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseSessionYear(String courseSessionYear) {
        this.courseSessionYear = courseSessionYear;
    }

    public void setCourseSemester(String courseSemester) {
        this.courseSemester = courseSemester;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

}
