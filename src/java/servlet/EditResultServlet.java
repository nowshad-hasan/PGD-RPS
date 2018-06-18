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
public class EditResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean updateResult = true;

        int attendance = 0, termTest = 0, finalExam = 0;

        int registrationID = Integer.parseInt(request.getParameter("registrationID"));
        String actionName = request.getParameter("actionName");

        ResultInfo resultInfo = new ResultInfo();
        CourseInfo courseInfo = new CourseInfo();
        List<Result> studentRegistrationInfo = resultInfo.studentRegistrationListByRegistrationID(registrationID);

        for (Result result : studentRegistrationInfo) {
            System.out.println("Studen_RegistrationID " + result.getStudentRegistrationID() + "StudentID " + result.getStudentID());
            String studentID = Integer.toString(result.getStudentID());
//            String[] markValues=Integer.parseInt(request.getParameterValues(Integer.toString(result.getStudentID())));
            String[] markValues = request.getParameterValues(studentID);
            for (int i = 0; i < markValues.length; ++i) {
                System.out.println("MarkValues " + markValues[i]);
                if (i == 0) {
                    attendance = Integer.parseInt(markValues[i]);
                } else if (i == 1) {
                    termTest = Integer.parseInt(markValues[i]);
                } else if (i == 2) {
                    finalExam = Integer.parseInt(markValues[i]);
                }
            }

            boolean value = resultInfo.updateCourseResultByStudentRegistrationID(result.getStudentRegistrationID(), attendance, termTest, finalExam);
            if (value == false && updateResult == true) {
                updateResult = false;
            }

        }

        if (updateResult) {
            request.setAttribute("alertMessageEditResult", "success");
        } else {
            request.setAttribute("alertMessageEditResult", "failure");

        }

        try {

            List<Course> registrationInfo = courseInfo.courseListByRegistrationID(registrationID);
            List<Result> resultInfoByCourse = resultInfo.resultListByRegistrationID(registrationID);
            request.setAttribute("registrationInfo", registrationInfo);
            request.setAttribute("resultInfoByCourse", resultInfoByCourse);
            request.setAttribute("registrationID", registrationID);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (actionName.equals("editCourseResult")) {
            RequestDispatcher rd = request.getRequestDispatcher("showCourseResult.jsp");
            rd.forward(request, response);
        } else if (actionName.equals("editCourseResultPersonal")) {
            RequestDispatcher rd = request.getRequestDispatcher("showCourseResultPersonal.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
