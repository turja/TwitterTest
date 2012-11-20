<%--
  Created by IntelliJ IDEA.
  User: tushar
  Date: Apr 12, 2010
  Time: 3:57:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglib.jsp"%>
<html>
  <head><title>Simple jsp page</title></head>
  <body>
    <h3>User Login was successful!</h3>
    <%
        //pageContext.setAttribute("users",  new String[]{"red","green","blue","orange","black"} );
    %>
    <table>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.userName}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><c:out value="${user.sex}" /></td>
                <td><c:out value="${user.department}" /></td>
                <td><c:out value="${user.salary}" /></td>                
            </tr>                                          
        </c:forEach>
        
    </table>
  </body>
</html>