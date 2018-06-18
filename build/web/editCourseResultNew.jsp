<%-- 
    Document   : editCourseResultNew
    Created on : May 10, 2017, 12:48:36 PM
    Author     : Nowshad Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Result</title>
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
            $(function () {
                $("#resultTableByCourse").dataTable();
            });
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
                Course-wise Result Information New (EDIT)
            </h3>
        </div>
        <br/>

        <div class="container">

            Session:<c:out value="${registrationInfo.getCourseSessionYear()}" />
            <br/>
            Total Class:   <c:out value="${registrationInfo.getTotalClass()}" /><br/>
            Term Test Marking:   <c:out value="${registrationInfo.getTermTestMarks()}" /><br/>
            Final Exam Marking:   <c:out value="${registrationInfo.getFinalExamMarks()}" /><br/>
            Lab Exam Marking:   <c:out value="${registrationInfo.getLabMarks()}" /><br/>
            Course Status:   <c:out value="${registrationInfo.getCourseStatus()}" /><br/>
            Theory Credit:   <c:out value="${registrationInfo.getThoeryCredit()}" /><br/>
            Lab Credit:   <c:out value="${registrationInfo.getLabCredit()}" /><br/>
            Registration ID:   <c:out value="${registrationID}" /><br/>
            Course Name:   <c:out value="${registrationInfo.getCourseName()}" /><br/>
            Course Semester:   <c:out value="${registrationInfo.getCourseSemester()}" /><br/>
            Course Teacher:   <c:out value="${registrationInfo.getCourseTeacher()}" /><br/>
            Course Full Credit:   <c:out value="${registrationInfo.getCourseCredit()}" /><br/>

            <br/>
            <br/>
            <br/>












            <form method="get" action="EditResultServlet">
                <table id="resultTableByCourse">


                    <caption style="color:black" >Course Result Table</caption>

                    <thead>

                        <tr>
                            <th>Registration No.</th>
                            <th>Student Name</th>

                            <c:choose>
                                <c:when test="${ registrationInfo.getCourseStatus()=='all' || registrationInfo.getCourseStatus()=='theory'}">
                                    <th>Number Of Classes</th>
                                    <th>Term Test</th>
                                    <th>Final Exam</th>
                                    </c:when>
                                </c:choose>

                            <c:choose>
                                <c:when test="${ registrationInfo.getCourseStatus()=='all' || registrationInfo.getCourseStatus()=='lab'}">
                                    <th>Lab Exam</th>
                                    </c:when>
                                </c:choose>


                        </tr>

                    </thead>


                    <tbody>




                        <c:forEach items="${resultInfoByCourse}" var="result">

                            <tr>

                                <td>
                                    <c:out value="${result.getStudentReg()}"/>
                                </td>
                                <td>
                                    <c:out value="${result.getStudentName()}"/>
                                </td>   



                                <c:choose>
                                    <c:when test="${ registrationInfo.getCourseStatus()=='all' || registrationInfo.getCourseStatus()=='theory'}">
                                        <td>
                                            <input name="<c:out value="${result.getStudentID()}"/>" type="number"  value="<c:out value="${result.getAttendence()}"/>" required min="0" max="10"> 
                                        </td>   


                                        <td>
                                            <input name="<c:out value="${result.getStudentID()}"/>" type="number" value="<c:out value="${result.getTermTest()}"/>" required min="0" max="20">
                                        </td>
                                        <td>
                                            <input name="<c:out value="${result.getStudentID()}"/>" type="number" value="<c:out value="${result.getFinalExam()}"/>" required min="0" max="70">
                                        </td>
                                    </c:when>
                                </c:choose>

                                <c:choose>
                                    <c:when test="${ registrationInfo.getCourseStatus()=='all' || registrationInfo.getCourseStatus()=='lab'}">

                                        <td>
                                            <input name="<c:out value="${result.getStudentID()}"/>" type="number" value="<c:out value="${result.getLabExam()}"/>" required min="0" max="60">
                                        </td>
                                    </c:when>
                                </c:choose>


                            </tr>
                        </c:forEach>

                    </tbody>


                </table>
                <br/>
                <input type="hidden" name="registrationID" value="<c:out value="${registrationID}"/>">
                <input type="hidden" name="actionName" value="editCourseResult">
                <button type="submit" class="btn btn-primary" >Update Result</button>
            </form>



        </div>

        <% } else {%>
        <%

            response.sendRedirect("login.jsp");
        %>
        <% }%>
    </body>
</html>
