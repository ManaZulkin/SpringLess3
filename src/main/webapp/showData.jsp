<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <title>Show Data</title>
</head>
<body>
    <h2>Записані данні</h2>
<%--    <h3>${savedCostumers}</h3>--%>

    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Car</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${savedCostumers}" var="costumer">
            <tr>
                <td>${costumer.name}</td>
                <td>${costumer.car}</td>
                <td>${costumer.price}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</body>
</html>
