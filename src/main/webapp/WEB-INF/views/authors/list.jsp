<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Authors List</title>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<h2>Authors</h2>
<c:if test="${not empty success}"><div class="success">${success}</div></c:if>
<c:if test="${not empty error}"><div class="error">${error}</div></c:if>
<a href="/authors/add">Add Author</a>
<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Actions</th>
    </tr>
    <c:forEach var="author" items="${authors}">
        <tr>
            <td>${author.id}</td>
            <td>${author.name}</td>
            <td>${author.email}</td>
            <td><a href="/authors/edit/${author.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>