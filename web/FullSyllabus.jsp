<%-- 
    Document   : FullSyllabus
    Created on : Apr 27, 2017, 10:55:10 AM
    Author     : Nowshad Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Session" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Full Syllabus_Admin</title>
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
                Full Syllabus Information
            </h3>
        </div>
        <br>

        <div class="container">

            <form method="post" action="SessionInfoServlet">

                <label for="sel1">Select Session (select one):</label>
                <select class="input-small form-control" id="sel1" name="sessionID">

                    <c:forEach items="${sessionYear}" var="session">
                        <option value="${session.getSessionID()}"><c:out value="${session.getSessionYear()}" /></option>
                    </c:forEach>

                </select>

                <br/>
                <input type="hidden" name="pageName" value="FullSyllabus" />

                <button type="submit" class="btn btn-primary">Show Syllabus</button>
                <br/>

            </form>

            <c:choose>
                <c:when test="${empty courses}">

                    <p style="color:black">Nothing to show.Please select semester for results</p>
                    <br />
                </c:when>    
                <c:otherwise>



                    

                    
                    
                    <div class="table-responsive yesPrint" id="divToPrint">


                        <table class="table table-bordered" border="1">
                            <caption style="color:white" >Full Syllabus Table</caption>
                            <br/>
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
                                    <c:forEach items="${courses}" var="course">

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
                                    <c:forEach items="${courses}" var="course">

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
                                    <c:forEach items="${courses}" var="course">

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
                                    <c:forEach items="${courses}" var="course">

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
                                    <c:forEach items="${courses}" var="course">

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
                                    <c:forEach items="${courses}" var="course">

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
                                    <c:forEach items="${courses}" var="course">

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
                                    <c:forEach items="${courses}" var="course">

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



                    

                    

                    <a href="${pageContext.request.contextPath}/FullSyllabusPrintPreview.jsp" class="btn btn-primary" role="button">
                        Full Syllabus Print Preview
                    </a>



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
