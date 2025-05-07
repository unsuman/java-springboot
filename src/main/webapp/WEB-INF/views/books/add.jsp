<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<h2>Add Book</h2>
<form action="/books/add" method="post">
    Title: <input type="text" name="title" required/><br/>
    Genre: <input type="text" name="genre" required/><br/>
    Author:
    <select name="authorId" required>
        <c:forEach var="author" items="${authors}">
            <option value="${author.id}">${author.name}</option>
        </c:forEach>
    </select><br/>
    <input type="submit" value="Add Book"/>
</form>
<a href="/books">Back to List</a>
</body>
</html>