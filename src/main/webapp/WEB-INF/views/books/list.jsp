<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books List</title>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<h2>Books</h2>
<c:if test="${not empty success}"><div class="success">${success}</div></c:if>
<c:if test="${not empty error}"><div class="error">${error}</div></c:if>
<a href="/books/add">Add Book</a>
<table border="1">
    <tr>
        <th>ID</th><th>Title</th><th>Genre</th><th>Author</th><th>Actions</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.genre}</td>
            <td>${book.author.name}</td>
            <td><a href="/books/edit/${book.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>