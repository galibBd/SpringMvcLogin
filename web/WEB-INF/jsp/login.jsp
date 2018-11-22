<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Student Login Form</h2>
        <hr/>
        
        <f:form commandName="login"  method="POST" action="login">
            Name: <f:input type="text" path="name" /><br/><br/>
            Password <f:input type="password" path="password"/><br/><br/>
             <input type="submit"/>
        </f:form>  
             
             <a href="index.htm">please register first!</a>
    </body>
</html>
