<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Show User</title>
</head>

<body>

<table style="border: 1px solid red">
    <tr>
        <th>S.N</th>
        <th>Name</th>
        <th>Roll No</th>
        <th>Nick Name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var ="i" items ="${user}" varStatus="counter">
        <tr>
            <td>
                ${counter.count})
                ${i.name}
                ${i.roll}
                ${i.alias}
                <a href="/edit?id=${i.id}">Edit</a>
                <a href="/delete?id=${i.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>

</html>

