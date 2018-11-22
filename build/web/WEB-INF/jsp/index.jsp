<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h2>Student Registration Form</h2>
        <hr/>

        <f:form commandName="index"  method="POST" action="index">
            Name: <f:input type="text" path="name" /><br/><br/>
            Password: <f:input type="password" path="password"/><br/><br/>
            Email: <f:input type="text" path="email"/><br/><br/>
            <input type="submit"/>
        </f:form>    
      <br/>
      <hr/><br/><h1>User List</h1>
            <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>password</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.password}"/></td>
                </tr>   

            </c:forEach>

        </table>

    </body>
</html>
