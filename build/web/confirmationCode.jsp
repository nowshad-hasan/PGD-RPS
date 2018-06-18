<%-- 
    Document   : confirmationCode
    Created on : May 7, 2017, 9:37:27 PM
    Author     : Nowshad Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Confirmation Code</title>
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
            <div class="page-header">
                <h1>Confirm Your Email Account</h1>
            </div>
            <div>
                <p>Please check your email for confirmation code</p>
            </div>
            <form class="form-horizontal" method="get" action="RegistrationServlet">
                <div class="form-group form-group-lg col-xs-6">
                    <label class="col-sm-2 control-label" for="lg">Code</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" id="lg" name="codeConfirmation">
                    </div>
                </div>
                
                <input type="hidden" name="actionName" value="confirmation">
                
                <button type="submit" class="btn btn-primary btn-lg" >Validate Email</button>

            </form>
        </div>

    </body>
</html>
