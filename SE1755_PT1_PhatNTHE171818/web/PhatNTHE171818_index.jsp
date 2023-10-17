<%-- Created on : Oct 2, 2023, 10:24:28 AM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="PhatNTHE171818_CalculateController" method="get">
            <p>Please input n = <input type="number" name="numVar" required></p>
            <c:if test="${msgErr!=null}">
                <p style="color: red;">${msgErr}</p>
            </c:if>
            <p><input type="submit" value="Submit"></p>
        </form>
    </body>
</html>
