<%-- 
    Document   : registration.jsp
    Created on : Dec 24, 2016, 10:51:23 AM
    Author     : nowshad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <title>Sign Up User</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <link rel="stylesheet" href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
        <link  href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css.map">
        <link rel="stylesheet" href="FrontEnd/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>

        <script src="FrontEnd/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="FrontEnd/javascript/script.js"></script>
    </head>
    <body>
        <div class="container">


            <div id="signupbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">Sign Up</div>
                        <div style="float:right; font-size: 85%; position: relative; top:-10px"><a 
                                id="signinlink"
                                href="${pageContext.request.contextPath}/login.jsp"
                                onclick="$('#signupbox').hide();
                                        $('#loginbox').show()">Sign In</a></div>
                    </div>
                    <div class="panel-body" >
                        <form name="signupForm" id="signupform" class="form-horizontal" role="form" action="RegistrationServlet" method="get">

                            <div id="signupalert" style="display:none" class="alert alert-danger">
                                <p>Error:</p>
                                <span></span>
                            </div>





                            <div class="form-group">
                                <label for="firstname" class="col-md-3 control-label">Full Name</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="name" placeholder="Full Name" required>
                                </div>
                            </div>
                            <!--                            <div class="form-group">
                                                            <label for="lastname" class="col-md-3 control-label">Last Name</label>
                                                            <div class="col-md-9">
                                                                <input type="text" class="form-control" name="lastname" placeholder="Last Name" required>
                                                            </div>
                                                        </div>-->

                            <div class="form-group">
                                <label for="email" class="col-md-3 control-label">Email</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="email" placeholder="Email Address" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password" class="col-md-3 control-label">Password</label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="password" placeholder="Password" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="sel1" class="col-md-3 control-label">Select Your Role:</label>
                                <div class="col-md-9">
                                    <select class="form-control" id="sel1" name="actingRole" required>
                                        <option value="1">Admin </option>
                                        <option value="2">Teacher</option>
                                        <option value="3">Office Staff</option>
                                    </select>
                                </div>

                            </div>

                            <input type="hidden" name="actionName" value="registration">

                            <div class="form-group">
                                <!-- Button -->
                                <div class="col-md-offset-3 col-md-9">
                                    <button onclick="ValidateEmail(document.signupForm.email)" id="btn-signup" type="submit" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>

                                </div>
                            </div>

                        </form>




                        <c:choose>
                            <c:when test="${empty validateEmailMessage}">

                            </c:when>

                            <c:when test="${validateEmailMessage=='validateEmailSuccess'}">

                                <div class="alert alert-success alert-dismissable fade in">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Success!</strong> Your email is successfully validated!!! An email will be sent when you are registered.
                                </div>

                            </c:when>

                            <c:when test="${validateEmailMessage=='validateEmailFailure'}">

                                <div class="alert alert-danger alert-dismissable fade in">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Failure!</strong> Your email can not be validated! Please sign up again with a valid email.
                                </div>

                            </c:when>

                        </c:choose>

                        <c:choose>
                            <c:when test="${empty registrationStatus}">

                            </c:when>

                            <c:when test="${registrationStatus=='registered'}">

                                <div class="alert alert-success alert-dismissable fade in">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Your are already registered!!!!</strong>
                                </div>

                            </c:when>

                            <c:when test="${registrationStatus=='rejected'}">

                                <div class="alert alert-danger alert-dismissable fade in">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Failure!</strong> Your email id is blocked. Please try with another email.
                                </div>

                            </c:when>

                        </c:choose>


                    </div>
                </div>
            </div>

        </div>
    </body>
</html>

