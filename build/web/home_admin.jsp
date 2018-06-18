<%-- 
    Document   : home
    Created on : Dec 22, 2016, 6:35:15 PM
    Author     : nowshad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html >
<html lang="en">
    <head>
        <title>HOME(unauthorized)_Admin</title>
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

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">


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
                                <li><a href="${pageContext.request.contextPath}/RegistrationRequest.jsp">Registration Request
                                    <span class="badge">${fn:length(registrationRequest)}</span>
                                    </a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/full_registration.jsp">Full Registration</a></li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/incomplete_registration.jsp">Incomplete Registration
                                    <span class="badge">${fn:length(registrationStatus)}</span>
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li><a href="${pageContext.request.contextPath}/logout.jsp" <span class="glyphicon glyphicon-log-out"></span>LOG OUT</a></li>

                    </ul>
                </div>
            </div>
        </nav>



        <div class="color_header">
            <h3 class="color_header_text">ADMIN HOME</h3>
        </div>


        <br>
        <div class="container ">

            <div class="panel panel-primary">
                <div class="panel-heading">My Introduction</div>
                <div class="panel-body">
                    <c:out value="${role}">

                    </c:out>

                    <c:if test='${role == "admin"}'>
                        YES!!!
                    </c:if>

                </div>
            </div>


            <div class="panel panel-primary">
                <div class="panel-heading">All Courses</div>
                <div class="panel-body">
                    All courses will be displayed here.
                </div>
            </div>

            <div class="panel panel-primary">
                <div class="panel-heading">
                    Course Results
                </div>
                <div class="panel-body">
                    All  course results will be displayed here.
                </div>
            </div>

            <div class="panel panel-primary">
                <div class="panel-heading">
                    Cumulative Result
                </div>
                <div class="panel-body">
                    Cumalative result of all batch will be displayed here.
                </div>
            </div>l

        </div>



        <% } else {%>
        <%

            response.sendRedirect("login.jsp");
        %>
        <% }%>

    </body>
</html>
