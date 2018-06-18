<%-- 
    Document   : incomplete_registration
    Created on : May 9, 2017, 8:17:08 AM
    Author     : Nowshad Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <h3 class="color_header_text">INCOMPLETE REGISTRATION</h3>
        </div>
        <br/>
        
        
        <div class="container">

            <div class="panel-group">

                <c:forEach items="${registrationStatus}" var="regStatus">
                    <div class="panel panel-info">
                        <div class="panel-heading">Incomplete Registration</div>
                        <div class="panel-body">Session Year:  <strong> <c:out value="${regStatus.getSessionYear()}" /> </strong><br/> 
                            <br/> 

                            <ul class="list-group">
                                <li class="list-group-item list-group-item-success">Session Registration <strong>COMPLETED!</strong></li>

                                <c:choose>
                                    <c:when test="${regStatus.getCourseRegistrationStatus()=='yes'}">
                                        <li class="list-group-item list-group-item-success">Syllabus Registration <strong>COMPLETED!</strong></li>
                                        </c:when>

                                    <c:when test="${regStatus.getCourseRegistrationStatus()=='no'}">

                                        <li class="list-group-item list-group-item-danger">Syllabus Registration <strong>NOT COMPLETED!</strong></li>

                                    </c:when>


                                </c:choose>

                                <c:choose>
                                    <c:when test="${regStatus.getStudentRegistrationStatus()=='yes'}">
                                        <li class="list-group-item list-group-item-success">Student Registration <strong>COMPLETED!</strong></li>
                                        </c:when>

                                    <c:when test="${regStatus.getStudentRegistrationStatus()=='no'}">

                                        <li class="list-group-item list-group-item-danger">Student Registration <strong>NOT COMPLETED!</strong></li>

                                    </c:when>


                                </c:choose>

                                <c:choose>
                                    <c:when test="${regStatus.getResultRegistrationStatus()=='yes'}">
                                        <li class="list-group-item list-group-item-success">Result Registration <strong>COMPLETED!</strong></li>
                                        </c:when>

                                    <c:when test="${regStatus.getResultRegistrationStatus()=='no'}">

                                        <li class="list-group-item list-group-item-danger">Result Registration <strong>NOT COMPLETED!</strong></li>

                                    </c:when>


                                </c:choose>


                            </ul>



                            <form action="IncompleteRegistrationServlet" method="get">

                                <input type="hidden" name="sessionYear" value="${regStatus.getSessionYear()}">
                                <input type="hidden" name="nextPage" value="${regStatus.getNextRegistrationStatus()}">
                                <input type="hidden" name="sessionID" value="${regStatus.getSessionID()}">

                                



                                    <button type="submit" class="btn btn-primary btn-lg pull-right" name="actionName" value="continue" >Continue</button>



                             
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
