<html>
<head>
    <title>Edit User</title>
</head>

<body>

<form action="/update" method="post">
    <table>
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name" value="${user.name}"/></td>
        </tr>
        <tr>
        <td>Roll No: </td>
        <td><input type="text" name="roll" value="${user.roll}"/></td>
        </tr>

        <tr>
        <td>Alias(nickname): </td>
        <td><input type="text" name="alias" value="${user.alias}"/></td>
        </tr>

        <tr>
        <td>
            <input type="hidden" name="id" value="${user.id}">
        </td>
        <td><input type="submit" value="Update"/>

        </td>
        </tr>


    </table>

</form>
</body>

</html>