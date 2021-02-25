<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show All product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<form method="get">
    <input type="search" name="name">
    <input type="text" value="searchByName" name="action"  hidden>
    <input type="submit" value="Search">
</form>
<table>
    <tr>
        <td>ID</td>
        <td>Product Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Color</td>
        <td>Description</td>
        <td>Category</td>
        <td>Action</td>
        <td></td>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getNumber()}</td>
            <td>${product.getColor()}</td>
            <td>${product.getDescription()}</td>
<%--            <td> <span onload="checkCategory()"> </span>--%>
            <td>${product.getId_category()}</td>
            <td><a href="product?action=updateProduct" type="button">Update</a>|<a href="product?action=deleteProduct" type="button">Delete</a>  </td>
        </tr>

    </c:forEach>
</table>

<script>
    <%--let p_category = ${product.getId_category()}--%>

    <%--<c:forEach items="productCategory" var="category">--%>
    <%--<c:if test=" ${product.getId_category() = category.getId()}" >--%>
    <%--${category.getCategory_name()}--%>
    <%--</c:if>--%>
    <%--</c:forEach>--%>
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>
