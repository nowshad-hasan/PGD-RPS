/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.CourseInfo;
import DAO.ResultInfo;
import entity.Course;
import entity.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nowshad Hasan
 */
public class ResultInfoServletNew extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String actionName = request.getParameter("actionName");
        int registrationID = Integer.parseInt(request.getParameter("registrationID"));

        System.out.println("Action " + actionName + "Registration ID " + registrationID);
        CourseInfo courseInfo = new CourseInfo();
        ResultInfo resultInfo = new ResultInfo();
        Course course = new Course();

        course.setCourseName(request.getParameter("courseName"));
        course.setTotalClass(Integer.parseInt(request.getParameter("numClass")));
        course.setTermTestMarks(Integer.parseInt(request.getParameter("termTestMarks")));
        course.setFinalExamMarks(Integer.parseInt(request.getParameter("finalExamMarks")));
        course.setLabMarks(Integer.parseInt(request.getParameter("labMarks")));
        course.setThoeryCredit(Integer.parseInt(request.getParameter("theoryCredit")));
        course.setCourseStatus(request.getParameter("courseStatus"));
        course.setLabCredit(Integer.parseInt(request.getParameter("labCredit")));
        course.setCourseSessionYear(request.getParameter("courseSessionYear"));
        course.setCourseSemester(request.getParameter("courseSemester"));
        course.setCourseTeacher(request.getParameter("courseTeacher"));
        course.setCourseCredit(Integer.parseInt(request.getParameter("courseCredit")));

        try {

            //List<Course> registrationInfo = courseInfo.courseListByRegistrationID(registrationID);
            //  List<Result> resultInfoByCourse = resultInfo.resultListByRegistrationIDNew(registrationID);
            //  System.out.printl n("Course Name "+registrationInfo.);
            //  System.out.println("All Registration Info "+courseInfo.courseListByRegistrationID(registrationID));
            if (actionName.equals("editResult") || actionName.equals("editResultPersonal")) {
                List<Result> resultInfoByCourse = resultInfo.resultListByRegistrationIDNew(registrationID);
                request.setAttribute("resultInfoByCourse", resultInfoByCourse);
            } else if (actionName.equals("showResult") || actionName.equals("showResultPersonal")) {
                List<Result> resultInfoByCourse = resultInfo.resultListByRegistrationIDShowNew(registrationID);
                request.setAttribute("resultInfoByCourse", resultInfoByCourse);
            }

            request.setAttribute("registrationInfo", course);
            //  request.setAttribute("resultInfoByCourse", resultInfoByCourse);
            request.setAttribute("registrationID", registrationID);
            if (actionName.equals("editResult")) {
                RequestDispatcher rd = request.getRequestDispatcher("editCourseResultNew.jsp");
                rd.forward(request, response);
            } else if (actionName.equals("showResult")) {
                //System.out.println("adsrtewr");
                RequestDispatcher rd = request.getRequestDispatcher("showCourseResultNew.jsp");
                rd.forward(request, response);
            } else if (actionName.equals("editResultPersonal")) {

                RequestDispatcher rd = request.getRequestDispatcher("editCourseResultPersonal.jsp");
                rd.forward(request, response);
            } else if (actionName.equals("showResultPersonal")) {

                RequestDispatcher rd = request.getRequestDispatcher("showCourseResultPersonal.jsp");
                rd.forward(request, response);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
