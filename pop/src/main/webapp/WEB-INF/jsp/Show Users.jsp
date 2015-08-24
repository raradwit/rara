<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Show User</title>
    <link rel="stylesheet" href="/css/bootstrap.css"/>
</head>

<body>
<div class="container">

    <div class="table-responsive">

        <h2>Show Users</h2>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Roll</th>
                <th>Nick Name</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var ="i" items ="${user}" varStatus="counter">
                <tr>
                    <td>
                            ${counter.count}
                    </td>
                    <td>
                            ${i.name}
                    </td>
                    <td>
                            ${i.roll}
                    </td>
                    <td>
                            ${i.alias}
                    </td>
                    <td>
                        <a href="/edit?id=${i.id}">Edit</a>
                    </td>
                    <td>
                        <a href="/delete?id=${i.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>



</body>

</html>

