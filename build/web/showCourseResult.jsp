<%-- 
    Document   : showCourseResult
    Created on : May 1, 2017, 8:09:56 AM
    Author     : Nowshad Hasan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Course" %>
<%@page import="entity.Result" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            $(function () {
                $("#resultTableByCourse").dataTable();
            })
        </script>
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
                Course-wise Result Information
            </h3>
        </div>

        <div class="container">

            </br>



            <c:choose>
                <c:when test="${empty registrationInfo}">

                    <p style="color:black">Nothing to show</p>
                    <br />
                </c:when>    
                <c:otherwise>




                    <c:forEach items="${registrationInfo}" var="registration">
                        <h3>
                            Course Name:  <b><c:out value="${registration.getCourseName()}" /></b>
                        </h3> 

                        <h3>
                            Course Teacher:   <b><c:out value="${registration.getCourseTeacher()}" /></b>
                        </h3>


                        <h4>
                            Session:  <b><c:out value="${registration.getCourseSessionYear()}" /></b>
                        </h4>

                        <h4>
                            Semester No:   <b><c:out value="${registration.getCourseSemester()}" /></b>
                        </h4>

                        <h4>
                            Course Credit:  <b> <c:out value="${registration.getCourseCredit()}" /></b>
                        </h4>

                    </c:forEach>



                    <table id="resultTableByCourse">

                        <caption style="color:black" >Course Result Table</caption>

                        <thead>

                            <tr>
                                <th>Registration No.</th>
                                <th>Student Name</th>
                                <th>Attendance</th>
                                <th>Term Test</th>
                                <th>Final Exam</th>
                            </tr>

                        </thead>


                        <tbody>




                            <c:forEach items="${resultInfoByCourse}" var="result">

                                <tr>

                                    <td>
                                        <c:out value="${result.getStudentReg()}" />
                                    </td>
                                    <td>
                                        <c:out value="${result.getStudentName()}" />
                                    </td>   
                                    <td>
                                        <c:out value="${result.getAttendence()}" />
                                    </td>   


                                    <td>
                                        <c:out value="${result.getTermTest()}" />
                                    </td>
                                    <td>
                                        <c:out value="${result.getFinalExam()}" />
                                    </td>


                                </tr>
                            </c:forEach>





                        </tbody>




                    </table>
                    <br/>
                    <br/>

                    <c:choose>
                        <c:when test="${empty alertMessageEditResult}">

                        </c:when>

                        <c:when test="${alertMessageEditResult=='success'}">

                            <div class="alert alert-success alert-dismissable fade in">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Success!</strong> Successfully updated course result.
                                <br/>
                            </div>

                        </c:when>

                        <c:when test="${alertMessageEditResult=='failure'}">

                            <div class="alert alert-danger alert-dismissable fade in">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Failure!</strong> Sorry, failed to update course result.
                            </div>

                        </c:when>

                    </c:choose>





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
