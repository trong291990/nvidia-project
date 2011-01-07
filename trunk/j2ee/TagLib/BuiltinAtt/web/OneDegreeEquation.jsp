<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <h1>One Degree Equation Page Ax + B = 0 </h1>
    <c:forEach var="i" begin="10" end="20" step="2">
        <c:out value="${i}" />
    </c:forEach>
    <form action="OneDegreeEquation.jsp">
        <table border="1">
            <tbody>
                <tr>
                    <td>Enter value of A :</td>
                    <td><input type="text" name="A" value="${param.A}" /></td>
                </tr>
                <tr>
                    <td>Enter value of B :</td>
                    <td><input type="text" name="B" value="${param.B}" /></td>
                </tr>
                <tr>
                     <td>Result :</td>
                     <td>
                         <c:if test="${(param.A==0) && (param.B!=0)}">
                             There is no result ....!
                         </c:if>                        
                         <c:if test="${(param.A==0) && (param.B==0)}">
                             A lot of Result ....!
                         </c:if>
                         <c:if test="${param.A!=0}">
                              <c:out value="${-param.B/param.A}" />
                         </c:if>
                             
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Calculate" /></td>
                </tr>
            </tbody>
        </table>
    
    </form>
    </body>
</html>
