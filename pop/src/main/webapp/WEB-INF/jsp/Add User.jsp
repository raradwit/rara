<html>
    <head>
        <title>Add User</title>
    </head>

    <body>

        <form action="/addUser" method="post">
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>Roll No: </td>
                    <td><input type="text" name="roll"/></td>
                </tr>

                <tr>
                    <td>Alias(nickname): </td>
                    <td><input type="text" name="alias"/></td>
                </tr>

                <tr>
                <td></td>
                <td><input type="submit" value="Add"/></td>
                </tr>


            </table>

        </form>
    </body>

</html>