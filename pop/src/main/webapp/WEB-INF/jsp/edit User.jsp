<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Edit User</title>
    <link rel="stylesheet" href="/css/bootstrap.css"/>
    <script src="/js/angular.min.js"></script>
</head>

<body>
<div class="container">

    <h2>Edit User</h2>
    <form class="form-horizontal" action="/update" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" value="${user.name}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="roll">Roll No:</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="roll" placeholder="Enter Roll" name="roll" value="${user.roll}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="alias">Alias(nickname):</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="alias" placeholder="Enter Nickname" name="alias" value="${user.alias}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-3">
                <input type="hidden" name="id" value="${user.id}">
                <button type="submit" class="btn btn-default">Update</button>
            </div>
        </div>
    </form>

</div>
</body>

</html>