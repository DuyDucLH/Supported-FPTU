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
        <form action="PhatNTHE171818_VarCalculateController">
            <table>
                <c:forEach var="i" begin="1" end="${n}">
                    <tr>
                        <td>x${i} =</td>
                        <td><input type="text" name="x${i}" required></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <c:if test="${i!=n}">
                                <select name="operations${i}">
                                    <option value="+">+</option>
                                    <option value="-">-</option>
                                </select>
                                <br/>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <c:if test="${msgErr!=null}">
                <p style="color: red;">${msgErr}</p>
            </c:if>
            <input type="hidden" name="n" value="${n}">
            <p><input type="submit" value="Submit"></p>
        </form>

        <c:if test="${resultString!=null}">
            <c:forEach var="value" items="${arrVar}" varStatus="loop">
                x${loop.index + 1} = <span class="numberValue">${value}</span> <br/>
            </c:forEach>
            <p style="color: red; font-weight: bold">
                <c:forEach var="value" items="${arrOp}" varStatus="loop">
                    x${loop.index + 1} ${value}
                </c:forEach> x${arrVar.size()}
                = ${result} = <span class="numberValue">${resultNum}</span>
            </p>
        </c:if>
        <a href="PhatNTHE171818_index.jsp">Back to main page</a>
    </body>

    <script>
        const numberValues = document.getElementsByClassName('numberValue');
        for (let item of numberValues) {
            const numberString = item.innerText;
            const number = parseFloat(numberString);
            if (number === Math.floor(number)) {
                item.innerHTML = Math.floor(number).toString();
            }
        }
    </script>
</html>
