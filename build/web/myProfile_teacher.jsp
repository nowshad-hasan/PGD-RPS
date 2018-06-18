<%-- 
    Document   : MyProfileTeacher
    Created on : May 2, 2017, 2:42:32 PM
    Author     : Nowshad Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <title>My Profile</title>
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
        <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
    </head>
    <body>
        <% if (session.getAttribute("mySession") == "MySession") {%>

        <nav class="navbar navbar-inverse navbar-fixed-top" >
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/home_teacher.jsp">PGD RPS</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/home_teacher.jsp">Home</a></li>

                        <li><a href="${pageContext.request.contextPath}/MyCourses.jsp">My Courses</a></li>



                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Result
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Add Course Result</a></li>
                                <li><a href="#">Show Course Result</a></li>

                            </ul>
                        </li>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <c:out value="${nameOfUser}"/>
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/myProfile_teacher.jsp">My Profile</a></li>


                            </ul>
                        </li>



                        <li><a href="${pageContext.request.contextPath}/logout.jsp" <span class="glyphicon glyphicon-log-out"></span>LOG OUT</a></li>

                    </ul>
                </div>
            </div>
        </nav>

        <div class="color_header">
            <h3 class="color_header_text">My Profile</h3>
        </div>
        <br>
        <div class="container">
            
              <div class="row">
    <div class="span4">
        <img style="float:left" width="200" height="200" src="FrontEnd/images/profile.png"/>
        
        
    </div>

                  <div class="col-xs-4">
                      
                      <div>
                          <h4>
                              Full Name:
                          </h4>
                          <br/>
                          
                      </div>
                      
                      <div>
                          <h4>
                              Email:
                          </h4>
                          <br/>
                      </div>
                      
                      
                      
                  </div>
            
        </div>
            <br/>
                              <div class="span4">
                      <button type="submit" class="btn btn-primary">Upload an image</button>
                  </div>
            </div>

        <% } else {%>
        <%

            response.sendRedirect("login.jsp");
        %>
        <% }%>

    </body>
</html>
