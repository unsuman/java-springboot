<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Author</title>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<h2>Edit Author</h2>
<form action="/authors/edit" method="post">
    <input type="hidden" name="id" value="${author.id}"/>
    Name: <input type="text" name="name" value="${author.name}" required/><br/>
    Email: <input type="email" name="email" value="${author.email}" required/><br/>
    <input type="submit" value="Update Author"/>
</form>
<a href="/authors">Back to List</a>
</body>
</html>