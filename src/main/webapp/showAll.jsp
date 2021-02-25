<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show All product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<form method="get">
    <input type="text" name="name">
    <input type="text" value="searchByName" name="action"  hidden>
    <input type="submit" value="Search">
</form>
<a href="product?action=createProduct">Create New</a>
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
            <td><a href="product?action=updateProduct&&id=${product.getId()}" type="button">Update</a> </td>
            <td><a href="" data-bs-toggle="modal" data-bs-target="#exampleModal"    type="button" >Delete</a> </td>
        </tr>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"> Confirm Delete Product</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Are you ready to delete this product
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary" onclick="confirmDelete(${product.getId()})" >Delete</button>
                    </div>
                </div>
            </div>
        </div>

    </c:forEach>
</table>

<!-- Button trigger modal -->
<%--<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">--%>
<%--    Launch demo modal--%>
<%--</button>--%>

<!-- Modal -->
<script>
    function confirmDelete (id){
        window.location.href = '/product?action=deleteProduct&id='+id;

    }

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>
