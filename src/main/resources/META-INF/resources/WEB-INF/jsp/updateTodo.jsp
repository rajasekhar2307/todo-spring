<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>Update | Todo Application</title>
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
    <link href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.min.css" rel="stylesheet">
</head>
<body>
<main class="container">
    <h3>Please edit the details, ${name} kun</h3>



    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-4">
            <form:label path="description" cssClass="text-black mr-2" >Description</form:label>
            <form:input type="text" name="description" path="description" required="required"/>
            <form:errors path="description" cssClass="text-danger"/>
        </fieldset>

        <fieldset class="mb-4">
            <form:label path="date" cssClass="text-black mr-2" >Date</form:label>
            <form:input type="text" name="date" path="date" required="required"/>
            <form:errors path="date" cssClass="text-danger"/>
        </fieldset>

        <input type="hidden" name="id" value="0"/>
        <form:hidden path="isDone" name="isDone" value="false"/>

        <input type="submit" value="add" class="btn btn-success" />
    </form:form>
</main>

<script src="webjars\bootstrap\5.1.3\js\bootstrap.bundle.min.js"></script>
<script src="webjars\jquery\3.6.0\jquery.min.js"></script>
<script src="webjars\bootstrap-datepicker\1.9.0\js\bootstrap-datepicker.min.js" ></script>
<script type="application/javascript" >
    $('#date').datepicker({
        format: 'dd-mm-yyyy',
    });
</script>
</body>
</html>