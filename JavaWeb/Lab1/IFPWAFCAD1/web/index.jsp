<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 25.03.2017, 22:51:39
    Author     : siede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Домашняя страница IFPWAFCAD</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <sql:query var="subjects" dataSource="jdbc/IFPWAFCAD">
            SELECT subject_id, name FROM Subject
        </sql:query>
        <h1>Добро пожаловать в IFPWAFCAD, Международную ассоциацию по консультированию и развитию для бывших профессиональных борцов!</h1>
        <table border="0">
            <thead>
                <tr>
                    <th>IFPWAFCAD предоставляет экспертные консультации в широком спектре областей.</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Для просмотра подробных сведений о контактных IFPWAFCAD сертифицированных бывших профессиональных борцов в вашем регионе, выберите тему ниже:</td>
                </tr>
                <tr>
                    <td><form action="response.jsp">
                            <strong> Выберите тему: </strong>
                            <select name="subject_id">
                                <c:forEach var="row" items="${subjects.rows}">
                                    <option value="${row.subject_id}">${row.name}</option>
                                </c:forEach>
                            </select>
                            <input type="submit" value="Отправить" name="Отправить" />
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
