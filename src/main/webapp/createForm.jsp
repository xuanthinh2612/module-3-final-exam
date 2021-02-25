<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show All product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<form method="post">

    <table>
        <tr>
            <td>Product Name</td>
            <td><input name="name" type="text" ></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input name="price" type="text" ></td>
        </tr>
        <tr>
            <td>Number</td>
            <td><input name="number" type="text" ></td>
        </tr>
        <tr>
            <td>Color</td>
            <td><input name="color" type="text" ></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input name="description" type="text" ></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><input name= "id_category" type="text" ></td>
        </tr>


        </tr>


    </table>
    <button type="submit">Create</button>

</form>


<script>
    <%--let p_category = ${product.getId_category()}--%>

    <%--<c:forEach items="productCategory" var="category">--%>
    <%--<c:if test=" ${product.getId_category() = category.getId()}" >--%>
    <%--${category.getCategory_name()}--%>
    <%--</c:if>--%>
    <%--</c:forEach>--%>
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>
</body>
</html>
