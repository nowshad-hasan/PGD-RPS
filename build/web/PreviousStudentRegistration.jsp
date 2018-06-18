<%-- 
    Document   : PreviousStudentRegistration
    Created on : Mar 27, 2017, 10:28:50 AM
    Author     : Nowshad Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Student" %>
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
                $("#studentInfo").dataTable();
            })
        </script>
        <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
    </head>
    <body>
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
                Previous Student Registration
            </h3>
        </div>



        <!--            <label for="sel1">Select list (select one):</label>
              <select class="input-small form-control" id="sel1" name="semester">
                <option value="1">First</option>
                <option value="2">Second</option>
                <option value="3">Third</option>
                <option value="4">Fourth</option>
              </select>
                   
                    <br/>
        
                   <button type="submit" class="btn btn-primary">Show Course</button>
                    <br/>-->

        <div class="container">

            <form method="post" action="StudentInfoServlet">

                <label style="color:white">Session :</label>

                <select class="input-small form-control" name="session">

                    <option value="1">2012-13</option>
                    <option value="2">2013-14</option>
                    <option value="3">2014-15</option>


                </select>


                <button class="btn btn-primary" type="submit">Show Students</button>
                <br/>

            </form>





            <c:choose>
                <c:when test="${empty students}">

                    <p style="color:black">Nothing to show.Please select session for students info</p>
                    <br />
                </c:when>    
                <c:otherwise>

                    <form method="post" action="PreviousStudentRegistrationServlet">




                        <table id="studentInfo">
                            <caption style="color:black" >Students Table</caption>

                            <br/>
                            <thead>
                                <tr>

                                    <th> Name  </th>
                                    <th>Registration no. </th>
                                    <th>Dept</th>
                                    <th>Session</th>
                                    <th>Action</>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${students}" var="student">
                                    <tr>
                                        <td> <c:out value="${student.getStudentName()}" /></td>
                                        <td><c:out value="${student.getStudentReg()}" /></td>
                                        <td><c:out value="${student.getStudentDept()}"/> </td>
                                        <td><c:out value="${student.getStudentSession()}"/> </td>
                                        <td align="center">  
                                            <input type="checkbox" name="selectedItems"   
                                                   value="${student.getStudentID()}"
                                                   />  
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>
                                                <label style="color:black">Select Session To Register :</label>

                        <select class="input-small form-control" name="sessionID">

                            <option value="1">2012-13</option>
                            <option value="2">2013-14</option>
                            <option value="3">2014-15</option>


                        </select>
                        <br>
                        <label style="color:black">Select Course To Register :</label>
                        <select class="input-small form-control" name="courseID">

                            <option value="1">C Theory</option>
                            <option value="2">Java</option>
                            <option value="3">Networking</option>
                            <option value="4">Data Structure</option>
                            <option value="5">Algorithm</option>
                            <option value="6">Compiler</option>
                            <option value="7">Discrete Mathmatics</option>
                            <option value="8">Database</option>
                            


                        </select>
                        <br>
                        <br>

                        <button class="btn btn-primary" type="submit">Add Previous Students</button>

                    </form>
                </c:otherwise>
            </c:choose>


        </div>
    </body>
</html>
