<%@ page contentType="text/html; charset=utf-8" language="java" %>

<html>

<head>
<title>登录</title>
</head>
<script>
    $(function () {
        alert("嘻嘻嘻");
    })
</script>
<body>
<form action="/login/login " method="get">
    用户名:<input type="text" name="username" id="username"><br><br>
    密码:<input type="text" name="password" id="password"><br><br>
    验证码:<input type="text" name="picCord" id="picCode"><br><br>
    <img src="/login/getPic" id="img" onclick="getPic()"alt="无法加载">
    <input type="sumbit" value="登录">
</form>

<script>
    function getPic() {
        document.getElementById("img").src = document.getElementById("img").src +"?nocache="+new Date().getTime();

    }
</script>
</body>
</html>
