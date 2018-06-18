<%-- 
    Document   : RegistrationRequest
    Created on : May 7, 2017, 12:13:57 PM
    Author     : Nowshad Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
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
                            </ul>
                        </li>

                        <li><a href="${pageContext.request.contextPath}/logout.jsp" <span class="glyphicon glyphicon-log-out"></span>LOG OUT</a></li>

                    </ul>
                </div>
            </div>
        </nav>

        <div class="color_header">
            <h3 class="color_header_text">REGISTRATION REQUEST</h3>
        </div>
        <br/>

        <div class="container">


            <c:choose>
                <c:when test="${empty RejectionEmailSuccessMeassage}">

                </c:when>

                <c:when test="${RejectionEmailSuccessMeassage=='RejectionSuccess'}">

                    <div class="alert alert-success alert-dismissable fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Success!</strong> Successfully user registration is successfully rejected!!!
                    </div>

                </c:when>

                <c:when test="${RejectionEmailSuccessMeassage=='RejectionFailure'}">

                    <div class="alert alert-danger alert-dismissable fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Failure!</strong> User rejection is failed!
                    </div>

                </c:when>

            </c:choose>

            <c:choose>
                <c:when test="${empty RegistrationSuccessMeassage}">

                </c:when>

                <c:when test="${RegistrationSuccessMeassage=='RegistrationSuccess'}">

                    <div class="alert alert-success alert-dismissable fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Success!</strong> Successfully user registration is completed!!!
                    </div>

                </c:when>

                <c:when test="${RegistrationSuccessMeassage=='RegistrationFailure'}">

                    <div class="alert alert-danger alert-dismissable fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Failure!</strong> User Registration is failed!
                    </div>

                </c:when>

            </c:choose>

            <div class="panel-group">

                <c:forEach items="${registrationRequest}" var="user">
                    <div class="panel panel-info">
                        <div class="panel-heading">Name: <c:out value="${user.getUserName()}" /></div>
                        <div class="panel-body">Email: <c:out value="${user.getUserEmail()}" /> <br/> 
                            role: <c:out value="${user.getRoleName()}" /> <br/>


                            <form action="ValidateUserServlet" method="post">
                                <input type="hidden" name="userName" value="${user.getUserName()}">
                                <input type="hidden" name="userEmail" value="${user.getUserEmail()}">
                                <input type="hidden" name="userPass" value="${user.getUserPass()}">
                                <input type="hidden" name="userRoleID" value="${user.getRoleID()}">


                                <div class="row">

                                    <div class="col-xs-12">
                                        <button type="submit" class="btn btn-danger pull-right" name="actionName" value="declineAction" >Decline</button>
                                        <button type="submit" class="btn btn-primary pull-right" name="actionName" value="acceptAction"  >Accept</button>

                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </c:forEach>


            </div>



        </div>


        <% } else {%>
        <%

            response.sendRedirect("login.jsp");
        %>
        <% }%>
    </body>
</html>
