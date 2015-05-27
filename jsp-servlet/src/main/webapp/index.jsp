<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp servlet example</title>
</head>
<body>
    <h1>jsp servlet example</h1>

    <form action="submit" method="POST">
        <table>
            <tr>
                <td style="text-align: right;"><label for="name">Input Name:</label>
                </td>
                <td><input type="text" id=name name="name" value="${entity.name}" /></td>
            </tr>
            
        </table>
        <p>
            <input type="submit" value="submit" />
        </p>
        <p>
            <label>${infoMessage}</label>
        </p>
        <p>
             <label>${errorMessage}</label>
        </p>
    </form>

</body>
</html>
