<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <title>Your Todo's | Todo Application</title>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h2>Here's your list</h2>
            <br>
            <table class="table">
                <thead>
                <th>ID</th>
                <th>USERNAME</th>
                <th>DESCRIPTION</th>
                <th>DATE</th>
                <th>TODO STATUS</th>
                </thead>
                <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.username}</td>
                        <td>${todo.description}</td>
                        <td>${todo.date}</td>
                        <td>${todo.isDone}</td>
                        <td><a href="/delete?id=${todo.id}" class="btn btn-danger">DELETE</a></td>
                        <td><a href="/update?id=${todo.id}" class="btn btn-warning">UPDATE</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-success" href="add-todo">Add New Todo</a>

        </div>


    <script src="webjars\bootstrap\5.1.3\js\bootstrap.bundle.min.js"></script>
    <script src="webjars\jquery\3.6.0\jquery.min.js"></script>
    </body>
</html>