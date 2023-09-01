<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter Data</title>
</head>
<body>
    <form id="Enter Form" action="/Gradle___com___SpringLess3_1_0_SNAPSHOT_war__exploded_/enterData" method="post" modelAttribute="${costumer}">
        <p>Name: <input type="text" name="name"></p>
        <p>Car: <input type="text" name="car"></p>
        <p>Price: <input type="number" name="price"></p>
        <input type="submit" value="Save">
    </form>
<form id="Show" action="/Gradle___com___SpringLess3_1_0_SNAPSHOT_war__exploded_/showData" method="post">
    <input type="submit" value="Show all writed data">
</form>
</body>
</html>
