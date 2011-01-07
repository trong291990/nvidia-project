<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <h1>Percentage of Marks</h1>
    <form action="index.jsp">
        <table border="1">
            <tbody>
                <tr>
                    <td>Enter Marks for Math :</td>
                    <td><input type="text" name="Math" value="${param.Math}" /></td>
                </tr>
                <tr>
                    <td>Enter Marks for English :</td>
                    <td><input type="text" name="English" value="${param.English}" /></td>
                </tr>
                <tr>
                     <td>Sum of Marks :</td>
                     <td>${param.Math +param.English}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Calculate" /></td>
                </tr>
            </tbody>
        </table>
        
    </form>
    
    
    
    </body>
</html>
