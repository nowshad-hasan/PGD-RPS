<%-- 
    Document   : AddNewCourse
    Created on : Mar 25, 2017, 6:44:19 PM
    Author     : Nowshad Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<h3 class="color_header_text">Add New Course</h3>
    </div>
  
    <br>
  <br>
  
  <div class="container">
      
        <form action="CourseInfoServlet" method="post">
    <div class="form-group">
      <label for="courseName">Course Name:</label>
      <input type="text" class="form-control" id="courseName" placeholder="Enter Course Name">
    </div>
    <div class="form-group">
      <label for="courseCredit">Course Credit</label>
      <input type="text" class="form-control" id="courseCredit" placeholder="Enter Course Credit">
    </div>
            
            
  <div class="form-group">
    <label for="semesterName">Semester Name:</label>
    <select class="form-control" id="semesterName">
      <option>First</option>
      <option>Second</option>
      <option>Third</option>
      <option>Fourth</option>
    </select>
  </div>
            

            
              <div class="form-group">
    <label for="validitySelection">Validity Selection:</label>
    <select class="form-control" id="validitySelection">
      <option>Yes</option>
      <option>No</option>
    </select>
    
  </div>
            <br>
            
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
      
  </div>
  
    </body>
</html>
