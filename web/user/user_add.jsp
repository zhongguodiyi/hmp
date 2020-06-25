<%@ page import="user.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: 19843
  Date: 2020/6/25
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<link rel="stylesheet" href="../css/student.css">
<style>
    body {
        width: 100%;
        height: 200px;
    }

    table {
        width: 300px;
        height: 100px;
        font-size: 16px;
        margin: auto;
    }

    input {
        width: 200px;
        padding: 3px;
        font-size: 14px;
    }

    td {
        font-size: 14px;
        text-align: center;
    }

    button {
        border: 1px solid black;
        background-color: #fff;
        cursor: hand;
    }
    #UMsg,
    #PMsg {
        height: 20px;
        font-size: 14px;
        color: red;
        font-family: '\9ED1\4F53';
    }
</style>

<body>
<form name="frm" id="frm">
    <table border="1">
        <tr>
            <th class="td_header" colspan="2">添加用户信息(<span class="star">*</span>为必填)</th>
        </tr>
        <tr>
            <td>用户名<span class="star">*</span></td>
            <td><label class="item"><input type="text" name="userName" id="userName" value="" size="12" maxlength="6" placeholder="3-6位字符" required pattern="\S{3,6}"></label><br>
                <div id="UMsg"></div>
            </td>
        </tr>
        <tr>
            <td>密 码<span class="star">*</span></td>
            <td><label class="item"><input type="password" name="pwd" id="pwd" value="" size="12" maxlength="12" placeholder="6-12位字符" required pattern="\S{6,12}"></label><br>
                <div id="PMsg"></div>
            </td>
        </tr>
        <tr id="auth" hidden>
            <td>用户权限<span class="star">*</span></td>
            <td><select name="auth">
                <option value="1">管理员</option>
                <option value="2" selected>普通用户</option>
            </select></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="button" onclick="check()">提交</button>
                <button type="reset">重置</button>
                <button type="button" onclick="javascript:window.location.href='<%=request.getContextPath()%>/user/user_list.jsp'">返回</button>
            </td>
        </tr>
    </table>
</form>
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../js/datacheck.js"></script>
<script>
    <%
        UserInfo user = (UserInfo)session.getAttribute("user");
    %>
    let type = <%=user.getAuth()%>
    if(type === 0){
        $("#auth").removeAttr("hidden");
    }


    function check() {
        if (Trim(frm.userName.value) !== "" && Trim(frm.userName.value) != null) {
            if (Trim(frm.pwd.value) !== "" && Trim(frm.pwd.value) != null) {
                $.ajax({
                    type:"POST",
                    url:"<%=request.getContextPath()%>/UserAddServlet",
                    data:$("#frm").serialize(),
                    success:function(data){
                        alert(data);
                        window.location.href="<%=request.getContextPath()%>/user/user_list.jsp"
                    },
                    error:function () {
                        alert("请求失败");
                    }
                })
            } else {
                document.getElementById("PMsg").innerText = "密码不可为空"
            }
        } else {
            document.getElementById("UMsg").innerText = "用户名不可为空！"
        }
    }
    //清除提示信息
    $("input").focus(function(){
        document.getElementById("PMsg").innerText = ""
        document.getElementById("UMsg").innerText = ""
    })
</script>
</body>

</html>
