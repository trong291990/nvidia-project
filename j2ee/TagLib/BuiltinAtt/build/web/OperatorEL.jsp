<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <h1>JSP Page about Operator EL</h1>
    <form action="OperatorEL.jsp">
        <table border="1">
            <thead>
                <tr>
                    <th>ConCept</th>
                    <th>EL Expression</th>
                    <th>Result</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Additional</td>
                    <td>${'${'}10 + 20}</td>
                    <td>${10 + 20 }</td>
                </tr>
                <tr>
                    <td>Multiply</td>
                    <td>${'${'}10 * 20}</td>
                    <td>${10*20}</td>
                </tr>
                <tr><input type="submit" value="Calculate" /></tr>
            </tbody>
        </table>
        
    </form>
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    
    </body>
</html>
