<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <title>Your Todo's | Todo Application</title>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
            <a class="navbar-brand m-1" href="https://courses.in28minutes.com">Todos</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="/todos">Todos</a></li>
                </ul>
            </div>
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
            </ul>
        </nav>
        <div class="container">
            <h2>Here's your list</h2>
            <br>
            <table class="table">
                <thead>
                <th>DESCRIPTION</th>
                <th>DATE</th>
                <th>TODO STATUS</th>
                </thead>
                <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
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