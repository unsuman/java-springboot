<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Author</title>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<h2>Add Author</h2>
<form action="/authors/add" method="post">
    Name: <input type="text" name="name" required/><br/>
    Email: <input type="email" name="email" required/><br/>
    <input type="submit" value="Add Author"/>
</form>
<a href="/authors">Back to List</a>
</body>
</html>