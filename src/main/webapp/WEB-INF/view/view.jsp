<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>
<h2>Products:</h2>
<table>
    <tr>
        <th>
            id
        </th>
        <th>
            Title
        </th>
        <th>
            Price
        </th>
    </tr>
    <c:forEach var="prod" items="${products}">
        <c:url var ="updateButton" value="/updateProduct">
            <c:param name="productId" value="${prod.id}"></c:param>
        </c:url>
        <c:url var ="deleteButton" value="/deleteProduct">
            <c:param name="productId" value="${prod.id}"></c:param>
        </c:url>
        <tr>
            <td>${prod.id}</td>
            <td>${prod.title}</td>
            <td>${prod.price}</td>
            <td>
                <input type="button" value="Update" onclick="window.location.href = '${updateButton}'">
            </td>
            <td>
                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'">
            </td>

        </tr>
    </c:forEach>
</table>
<br><br>
<input type="button" value="add" onclick="window.location.href = 'addProduct'"/>


</body>
</html>