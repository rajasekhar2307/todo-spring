<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>Add | Todo Application</title>
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
</head>
<body>
<main class="container">
    <h3>Please fill the details, ${name} kun</h3>



    <form:form method="post" modelAttribute="todo">
        <label>Description</label>
        <form:input type="text" name="description" path="description" required="required"/>
        <input type="hidden" name="id" value="0"/>
        <input type="hidden" name="isDone" value="false"/>

        <input type="submit" value="add" class="btn btn-success" />
        <form:errors path="description" cssClass="text-danger"/>
    </form:form>
</main>

<script src="webjars\bootstrap\5.1.3\js\bootstrap.bundle.min.js"></script>
<script src="webjars\jquery\3.6.0\jquery.min.js"></script>
</body>
</html>