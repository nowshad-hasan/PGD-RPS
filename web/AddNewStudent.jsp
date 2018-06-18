<%-- 
    Document   : AddNewStudent
    Created on : Mar 23, 2017, 6:42:04 PM
    Author     : Nowshad Hasan
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Course" %>
<!DOCTYPE html>
<html>
    <head>
 <title>HOME(unauthorized)_Admin</title>
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

    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
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
<h3 class="color_header_text">Add New Student</h3>
    </div>
        
  <br>
  <br>
       
  <div class="container " >
      

<h2>Add a New Student</h2>
  <form action="AddStudentServlet" method="post">
    <div class="form-group">
      <label for="fullName">Full Name:</label>
      <input type="text" class="form-control" id="fullName" placeholder="Enter Full Name">
    </div>
    <div class="form-group">
      <label for="department">Department:</label>
      <input type="text" class="form-control" id="department" placeholder="Enter Department">
    </div>
          <div class="form-group">
      <label for="registrationNo">Registration No:</label>
      <input type="text" class="form-control" id="registrationNo" placeholder="Enter Registration No">
    </div>
                <div class="form-group">
      <label for="sessionYear">Session Year:</label>
      <input type="text" class="form-control" id="sessionYear" placeholder="Enter Session Year">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
<br>
<h3>Or Choose an Excel File</h3>

      
              <form action="AddStudentServlet" method="post" enctype="multipart/form-data">
    
    <input type="file" name="file"  accept=".xlsx" />
    <br>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
  </div>
  
  
  <% } else {%>
                <%
    
    response.sendRedirect("login.jsp");
%>
<% } %>
       

    </body>
</html>
