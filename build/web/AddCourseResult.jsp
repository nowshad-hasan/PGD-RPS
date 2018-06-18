<%-- 
    Document   : AddResult
    Created on : Feb 9, 2017, 6:49:23 AM
    Author     : nowshad
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DAO.DBConnection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>All Courses_Admin</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
        <link rel="stylesheet" href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css.map">
        <link rel="stylesheet" href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>

        <link rel="stylesheet" href="FrontEnd/css/footer-distributed-with-contact-form.css">

        <script type="text/javascript" src="FrontEnd/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
        <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
        <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
        <script>
            $(function () {
                $("#addCourseResultTable").dataTable();
            })
        </script>
        <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">


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
                Add Course Result
            </h3>
        </div>


        <div class="container">


            <form method="get" action="SessionInfoServlet">

                <label for="sel1">Select Session (select one):</label>
                <select class="input-small form-control" id="sel1" name="sessionID">

                    <c:forEach items="${sessionYear}" var="session">
                        <option value="${session.getSessionID()}"><c:out value="${session.getSessionYear()}" /></option>
                    </c:forEach>

                </select>

                <br/>

                <button type="submit" class="btn btn-primary">Show Syllabus</button>
                <br/>

            </form>


            <form method="post" action="EditResultTableServlet">

                <select class="input-small form-control" name="courseID">
                    <c:forEach items="${coursesBySession}" var="session">
                        <option value="${session.getSessionID()}"><c:out value="${session.getSessionYear()}" /></option>
                    </c:forEach>
                </select>

                <br>

                <button class="btn btn-primary" type="submit">Add Results</button>
                <br/>

            </form>

            <c:choose>
                <c:when test="${empty results}">

                    <p style="color:white">Nothing to show.Please select session and course for student result info</p>
                    <br />
                </c:when>    
                <c:otherwise>
                    <form method="post" action="AddResultServlet" >
                        <table id="addCourseResultTable">
                            <caption style="color:black" >Result Table</caption>

                            <br/>
                            <thead>
                                <tr>

                                    <th> Name  </th>
                                    <th>Registration no. </th>


                                    <th>Attendance</th>
                                    <th>Term Test</th>
                                    <th>Final Exam</th>


                                </tr>
                            </thead>


                            <%
                                int i = 0;
                            %>

                            <tbody>
                                <c:forEach items="${results}" var="result">
                                    <%
                                        System.out.println(++i);
                                        String attendance = "attendance" + Integer.toString(i);
                                        String termTest = "termTest" + Integer.toString(i);
                                        String finalExam = "finalExam" + Integer.toString(i);
                                    %>
                                    <tr>
                                        <td> <c:out value="${result.getStudentName()}" /></td>
                                        <td><c:out value="${result.getStudentReg()}" /></td>

                                        <td>
                                            <input type="text" name="<%=attendance%>" >
                                        </td>
                                        <td>
                                            <input type="text" name="<%=termTest%>" >
                                        </td>
                                        <td>
                                            <input type="text" name="<%=finalExam%>" >
                                        </td>

                                    </tr>
                                </c:forEach>
                            </tbody>


                        </table>
                        <br>

                        <div style="text-align:center">  
                            <input class="btn btn-primary" type="submit" value="Submit" style="text-align: center;"></input>
                        </div> 


                    </form>
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
