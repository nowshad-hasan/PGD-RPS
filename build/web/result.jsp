<%-- 
    Document   : result
    Created on : Feb 8, 2017, 5:09:14 PM
    Author     : nowshad
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DAO.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>All Courses_Admin</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

        <link rel="stylesheet" href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
        <link rel="stylesheet" href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css.map">
        <link rel="stylesheet" href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>

        <link rel="stylesheet" href="FrontEnd/css/footer-distributed-with-contact-form.css">

        <!--        <script type="text/javascript" src="FrontEnd/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>-->

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
        <script language="JavaScript" type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script language="JavaScript" type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>




        <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">

        <script>
            $(document).ready(function () {
                $("#courseTableSemester").DataTable(
                        {
                            order: [[2, 'asc']]
                        }
                );

//        $("#editButton").click(function (){
//            var value=document.getElementById("editButton").value;
//            alert(value);
//        });
            });

//            window.onload = function() editResult(){
//                var value = document.getElementById("editButton").value;
//                alert(value);
//            }





        </script>


        <style>


            .button-container form,
            .button-container form div {
                display: inline;
            }

            .button-container button {
                display: inline;
                vertical-align: middle;
            }
        </style>

    </head>


    <body>

        <% if (session.getAttribute("mySession") == "MySession") { %>

        <nav class="navbar navbar-inverse navbar-fixed-top" >
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="">PGD RPS</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/home_admin.jsp">Home</a></li>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Courses
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/AddNewCourse.jsp">Add new Course</a></li>
                                <li><a href="${pageContext.request.contextPath}/courses.jsp">Show All Courses</a></li>

                            </ul>
                        </li>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Student
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/AddNewStudent.jsp">Add New Student</a></li>
                                <li><a href="${pageContext.request.contextPath}/student.jsp">Show All Student</a></li>

                            </ul>
                        </li>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Result
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/AddCourseResult.jsp">Add Course Result</a></li>
                                <li><a href="${pageContext.request.contextPath}/result.jsp">Show Course Result</a></li>

                            </ul>
                        </li>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Registration
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/NewCourseRegistration.jsp">New Course Registration</a></li>
                                <li><a href="${pageContext.request.contextPath}/PreviousRegistration.jsp">Previous Course Registration</a></li>

                            </ul>
                        </li>

                        <li><a href="${pageContext.request.contextPath}/logout.jsp" <span class="glyphicon glyphicon-log-out"></span>LOG OUT</a></li>

                    </ul>
                </div>
            </div>
        </nav>

        <div class="color_header">
            <h3 class="color_header_text">
                Result Information
            </h3>
        </div>

        <div class="container">


            <form method="post" action="SessionInfoServlet">

                <label for="sel1">Select Session (select one):</label>
                <select class="input-small form-control" id="sel1" name="sessionID">

                    <c:forEach items="${sessionYear}" var="session">
                        <option value="${session.getSessionID()}"><c:out value="${session.getSessionYear()}" /></option>
                    </c:forEach>

                </select>

                <br/>
                <input type="hidden" name="pageName" value="result" />
                <button type="submit" class="btn btn-primary">Show Syllabus</button>
                <br/>
                <br/>

            </form>


            <c:choose>
                <c:when test="${empty courses}">

                    <p style="color:black">Nothing to show.Please select semester for results</p>
                    <br />
                </c:when>    
                <c:otherwise>





                    <strong>
                        <h2 align="center">
                            Session:<c:out value="${sessionYearPrintPreview}" />

                        </h2>
                    </strong>






                    <table id="courseTableSemester">




                        <caption style="color:black" >Full Syllabus Table</caption>
                        <br/>
                        <thead>

                            <tr>


                                <th>Course Name </th>
                                <th>Course Teacher</th>
                                <th>Course Semester</th>
                                <th>Theory Credit</th>
                                <th>Lab Credit</th>
                                <th>Action</th>
                            </tr>

                        </thead>


                        <tbody>




                            <c:forEach items="${courses}" var="course">

                                <tr>

                                    <td>
                                        <c:out value="${course.getCourseName()}" />
                                    </td>
                                    <td>
                                        <c:out value="${course.getCourseTeacher()}" />
                                    </td>   
                                    <td>
                                        <c:out value="${course.getCourseSemester()}" />
                                    </td>   
                                    <td>
                                        <c:out value="${course.getThoeryCredit()}" />
                                    </td>
                                    <td>
                                        <c:out value="${course.getLabCredit()}" />
                                    </td>


                                    <td>
                                        <div class="button-container">
                                            <form method="get" action="ResultInfoServletNew" > 

                                                <input type="hidden" name="actionName" value="editResult" />


                                                <input type="hidden" name="courseName" value="${course.getCourseName()}">
                                                <input type="hidden" name="courseTeacher" value="${course.getCourseTeacher()}">
                                                <input type="hidden" name="courseSemester" value="${course.getCourseSemester()}">
                                                <input type="hidden" name="courseSessionYear" value="${sessionYearPrintPreview}">
                                                <input type="hidden" name="courseCredit" value="${course.getCourseCredit()}">
                                                <input type="hidden" name="theoryCredit" value="${course.getThoeryCredit()}">
                                                <input type="hidden" name="labCredit" value="${course.getLabCredit()}">
                                                <input type="hidden" name="numClass" value="${course.getTotalClass()}">
                                                <input type="hidden" name="termTestMarks" value="${course.getTermTestMarks()}">
                                                <input type="hidden" name="finalExamMarks" value="${course.getFinalExamMarks()}">
                                                <input type="hidden" name="labMarks" value="${course.getLabMarks()}">
                                                <input type="hidden" name="courseStatus" value="${course.getCourseStatus()}">


                                                <button type="submit" name="registrationID" class="btn btn-primary" value="${course.getRegistrationID()}">Edit Result</button>
                                            </form>
                                            <form method="get" action="ResultInfoServletNew">

                                                <input type="hidden" name="actionName" value="showResult" />


                                                <input type="hidden" name="courseName" value="${course.getCourseName()}">
                                                <input type="hidden" name="courseTeacher" value="${course.getCourseTeacher()}">
                                                <input type="hidden" name="courseSemester" value="${course.getCourseSemester()}">
                                                <input type="hidden" name="courseSessionYear" value="${sessionYearPrintPreview}">
                                                <input type="hidden" name="courseCredit" value="${course.getCourseCredit()}">
                                                <input type="hidden" name="theoryCredit" value="${course.getThoeryCredit()}">
                                                <input type="hidden" name="labCredit" value="${course.getLabCredit()}">
                                                <input type="hidden" name="numClass" value="${course.getTotalClass()}">
                                                <input type="hidden" name="termTestMarks" value="${course.getTermTestMarks()}">
                                                <input type="hidden" name="finalExamMarks" value="${course.getFinalExamMarks()}">
                                                <input type="hidden" name="labMarks" value="${course.getLabMarks()}">

                                                <button type="submit" name="registrationID" class="btn btn-success" value="${course.getRegistrationID()}">Show Result</button>
                                            </form>
                                        </div>

                                    </td>


                                </tr>
                            </c:forEach>





                        </tbody>




                    </table>


                </c:otherwise>
            </c:choose>

        </div>

        <% } else {%>
        <%

            response.sendRedirect("login.jsp");
        %>
        <% }%>





    </body>
</html>
