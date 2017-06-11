<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 2017/6/11
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h2 align="center" style="margin-top: 20px">欢迎来到馨香园</h2>

<form method="post" action="register">
    <table align="center" style="margin-top: 50px">
        <tr>
            <td>用&nbsp;户&nbsp;名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
            <td>
                <label><input name="sex" type="radio" value="" />男 </label>
                <label><input name="sex" type="radio" value="" />女 </label>
            </td>
        </tr>
        <tr>
            <td>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作:</td>
            <td><input type="text" name="work"></td>
        </tr>
        <tr>
            <td>住&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>电话号码:</td>
            <td><input type="text" name="number"></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="注册"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="取消"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
