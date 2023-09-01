<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pass</title>
</head>
<body>

  <form id="My Form" action="/Gradle___com___SpringLess3_1_0_SNAPSHOT_war__exploded_/pass" method="post" modelAttribute="${user}">
    <p>name : <input type="text" name="name"></p>
    <p>surname : <input type="text" name="surname"></p>
    <p>age : <input type="number" name="age"></p>
    <input type="submit" value="Pass">
  </form>
</body>
</html>
