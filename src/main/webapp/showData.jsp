<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Data</title>
</head>
<body>
    <h2>Записані данні</h2>
<%--    <h3>${savedCostumers}</h3>--%>

    <table>
<%--        <thead>--%>
<%--            <tr>--%>
<%--                <th>Name</th>--%>
<%--                <th>Car</th>--%>
<%--                <th>Price</th>--%>
<%--            </tr>--%>
<%--        </thead>--%>
        <tbody>
        <tr>${savedCostumers}</tr>
<%--          <tr th:each="costumer : ${savedCostumers}">--%>
<%--              <td> <span th:text="${costumer.name}">Name</span></td>--%>
<%--              <td> <span th:text="${costumer.car}">Car</span></td>--%>
<%--              <td> <span th:text="${costumer.price}">Price</span></td>--%>

<%--          </tr>--%>
        </tbody>

    </table>

</body>
</html>
