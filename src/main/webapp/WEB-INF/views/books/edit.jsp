<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Book</title>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<h2>Edit Book</h2>
<form action="/books/edit" method="post">
    <input type="hidden" name="id" value="${book.id}"/>
    Title: <input type="text" name="title" value="${book.title}" required/><br/>
    Genre: <input type="text" name="genre" value="${book.genre}" required/><br/>
    Author:
    <select name="authorId" required>
        <c:forEach var="author" items="${authors}">
            <option value="${author.id}" <c:if test="${author.id == book.author.id}">selected</c:if>>${author.name}</option>
        </c:forEach>
    </select><br/>
    <input type="submit" value="Update Book"/>
</form>
<a href="/books">Back to List</a>
</body>
</html>