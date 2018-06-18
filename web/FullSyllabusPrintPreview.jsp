<%-- 
    Document   : FullSyllabusPrintPreview
    Created on : Apr 28, 2017, 10:47:28 AM
    Author     : Nowshad Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Session" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <title>Full Syllabus_Admin</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css.map">
<link rel="stylesheet" href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/style.css"/>

<link rel="stylesheet" href="FrontEnd/css/footer-distributed-with-contact-form.css">

<script type="text/javascript" src="FrontEnd/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!--  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->




<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
  <script>
  $(function(){
    $("#courseTable").dataTable();
  })
  </script>
  <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
        <style>
            tr [rowspan="2"] {
                text-align: center;
            }
        </style>

        <style media="screen">
            .noPrint{ display: block; }
            .yesPrint{ display: block !important; }
        </style>

        <style media="print">

            @page { margin: 0; }
            body { margin: 1.6cm; }

            #printPageButton {
                display: none;
            }
            ht{
                align:ce
            }

            .noPrint{ display: none; }
            .yesPrint{ display: block !important; }
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
        <br/>
        <br/>

        <div class="container">
            <div>

            </div>
            <div class="page-header">

                <img height="50" width="50" style="float:left" src="FrontEnd/images/SUST_logo.png"/>
                <h1 align="center">
                    Shahjalal University of Science & Technology

                </h1>
                <h3 align="center">
                    Full Syllabus
                </h3>
                <h3 align="center">
                    PGD Result Processing System
                </h3>
                <h3 align="center">
                    Session:<c:out value="${sessionYearPrintPreview}" />

                </h3>
            </div>



            <table class="table table-bordered">

                <thead>

                    <tr>

                        <th>Semester  </th>
                        <th>Course Name </th>
                        <th>Course Credit</th>
                    </tr>

                </thead>


                <tbody>
                    <tr>
                        <td rowspan="2">First Semester</td>

                        <c:set var="isSelected" value="false" scope="page"/> 
                        <c:forEach items="${FullSyllabusPrintPreview}" var="course">

                            <c:if test="${course.getCourseSemester()==1 && (!isSelected)}">
                                <c:set var="previousCourseName" value="${course.getCourseName()}" scope="page"/> 
                                <td>
                                    <c:out value="${course.getCourseName()}" />
                                </td>
                                <td>
                                    <c:out value="${course.getCourseCredit()}" />
                                </td>    
                                <c:set var="isSelected" value="true" scope="page"/> 
                            </c:if>

                        </c:forEach>

                    </tr>

                    <tr>


                        <c:set var="isSelected" value="false" scope="page"/> 
                        <c:forEach items="${FullSyllabusPrintPreview}" var="course">

                            <c:if test="${course.getCourseSemester()==1 && (!isSelected) && (course.getCourseName()!=previousCourseName)}">
                                <td>
                                    <c:out value="${course.getCourseName()}" />
                                </td>
                                <td>
                                    <c:out value="${course.getCourseCredit()}" />
                                </td>    
                                <c:set var="isSelected" value="true" scope="page"/> 
                            </c:if>

                        </c:forEach>

                    </tr>

                    <tr>
                        <td rowspan="2">Second Semester</td>

                        <c:set var="isSelected" value="false" scope="page"/> 
                        <c:forEach items="${FullSyllabusPrintPreview}" var="course">

                            <c:if test="${course.getCourseSemester()==2 && (!isSelected)}">
                                <c:set var="previousCourseName" value="${course.getCourseName()}" scope="page"/> 
                                <td>
                                    <c:out value="${course.getCourseName()}" />
                                </td>
                                <td>
                                    <c:out value="${course.getCourseCredit()}" />
                                </td>    
                                <c:set var="isSelected" value="true" scope="page"/> 
                            </c:if>

                        </c:forEach>

                    </tr>

                    <tr>


                        <c:set var="isSelected" value="false" scope="page"/> 
                        <c:forEach items="${FullSyllabusPrintPreview}" var="course">

                            <c:if test="${course.getCourseSemester()==2 && (!isSelected) && (course.getCourseName()!=previousCourseName)}">
                                <td>
                                    <c:out value="${course.getCourseName()}" />
                                </td>
                                <td>
                                    <c:out value="${course.getCourseCredit()}" />
                                </td>    
                                <c:set var="isSelected" value="true" scope="page"/> 
                            </c:if>

                        </c:forEach>

                    </tr>

                    <tr>
                        <td rowspan="2">Third Semester</td>

                        <c:set var="isSelected" value="false" scope="page"/> 
                        <c:forEach items="${FullSyllabusPrintPreview}" var="course">

                            <c:if test="${course.getCourseSemester()==3 && (!isSelected)}">
                                <c:set var="previousCourseName" value="${course.getCourseName()}" scope="page"/> 
                                <td>
                                    <c:out value="${course.getCourseName()}" />
                                </td>
                                <td>
                                    <c:out value="${course.getCourseCredit()}" />
                                </td>    
                                <c:set var="isSelected" value="true" scope="page"/> 
                            </c:if>

                        </c:forEach>

                    </tr>

                    <tr>


                        <c:set var="isSelected" value="false" scope="page"/> 
                        <c:forEach items="${FullSyllabusPrintPreview}" var="course">

                            <c:if test="${course.getCourseSemester()==3 && (!isSelected) && (course.getCourseName()!=previousCourseName)}">
                                <td>
                                    <c:out value="${course.getCourseName()}" />
                                </td>
                                <td>
                                    <c:out value="${course.getCourseCredit()}" />
                                </td>    
                                <c:set var="isSelected" value="true" scope="page"/> 
                            </c:if>

                        </c:forEach>

                    </tr>

                    <tr>
                        <td rowspan="2">Fourth Semester</td>

                        <c:set var="isSelected" value="false" scope="page"/> 
                        <c:forEach items="${FullSyllabusPrintPreview}" var="course">

                            <c:if test="${course.getCourseSemester()==4 && (!isSelected)}">
                                <c:set var="previousCourseName" value="${course.getCourseName()}" scope="page"/> 
                                <td>
                                    <c:out value="${course.getCourseName()}" />
                                </td>
                                <td>
                                    <c:out value="${course.getCourseCredit()}" />
                                </td>    
                                <c:set var="isSelected" value="true" scope="page"/> 
                            </c:if>

                        </c:forEach>

                    </tr>

                    <tr>


                        <c:set var="isSelected" value="false" scope="page"/> 
                        <c:forEach items="${FullSyllabusPrintPreview}" var="course">

                            <c:if test="${course.getCourseSemester()==4 && (!isSelected) && (course.getCourseName()!=previousCourseName)}">
                                <td>
                                    <c:out value="${course.getCourseName()}" />
                                </td>
                                <td>
                                    <c:out value="${course.getCourseCredit()}" />
                                </td>    
                                <c:set var="isSelected" value="true" scope="page"/> 
                            </c:if>

                        </c:forEach>

                    </tr>

                </tbody>
            </table>
        </div>





        <button type="button" class="pull-right btn btn-primary " aria-label="Right Align" pull-right id="printPageButton" onclick="myFunction()">
            <span class="glyphicon glyphicon-print" aria-hidden="true"></span>        
            Print Full Syllabus
        </button>

        <script>
            function myFunction() {
                window.print();
            }
        </script>



    </div>

    <% } else {%>
    <%

        response.sendRedirect("login.jsp");
    %>
    <% }%>
</body>
</html>
