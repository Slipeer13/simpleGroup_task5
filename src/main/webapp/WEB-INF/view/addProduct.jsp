<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>Add product</h2>
<form:form action="/saveOrUpdateProduct" modelAttribute="product">
    <form:hidden path="id"/>
    <br><br>
    Title  <form:input path="title"/>
    <br><br>
    Cost  <form:input path="price"/>
    <br><br>
    <input type="submit">
</form:form>

</body>
</html>