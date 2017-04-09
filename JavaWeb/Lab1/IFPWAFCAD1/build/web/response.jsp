<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : response
    Created on : 25.03.2017, 22:56:45
    Author     : siede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<sql:query var="counselorQuery" dataSource="jdbc/IFPWAFCAD">
    SELECT * FROM Subject, Counselor
    WHERE Counselor.counselor_id = Subject.counselor_idfk
    AND Subject.subject_id = ? <sql:param value="${param.subject_id}"/>
</sql:query>
<c:set var="counselorDetails" value="${counselorQuery.rows[0]}"/>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFPWAFCAD - {placeholder}</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <table border="0">
            <thead>
                <tr>
                    <th colspan="2">${counselorDetails.name}</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><strong>Описание: </strong></td>
                    <td><span style="font-size:smaller; font-style:italic;">${counselorDetails.description}</span></td>
                </tr>
                <tr>
                    <td><strong>Консультант: </strong></td>
                    <td>${counselorDetails.first_name} ${counselorDetails.nick_name} ${counselorDetails.last_name}
                        <br>
                        <span style="font-size:smaller; font-style:italic;"> member since: ${counselorDetails.member_since}</span>
                    </td>
                </tr>
                <tr>
                    <td><strong>Контактные детали: </strong></td>
                    <td><strong>email: </strong>
                        <a href="mailto:${counselorDetails.email}">${counselorDetails.email}</a>
                        <br><strong>phone: </strong>${counselorDetails.telephone}
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
