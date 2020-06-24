<%@ page import="user.UserInfo" %>
<%@ page import="user.UserDB" %><%--
  Created by IntelliJ IDEA.
  User: 19843
  Date: 2020/6/24
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息修改</title>
</head>
<link rel="stylesheet" href="../css/login.css">
<style>
    body {
        font-family: '宋体';
    }

    button {
        padding: 10px 20px;
        margin-top: 30px;
        color: #fff;
        text-align: center;
        letter-spacing: 2px;
        font-family: '黑体';
        font-size: 14px;
    }

    button:hover {
        border-radius: 5px;
        color: #fff;
        background: #03e9f4;
        box-shadow: 0 0 5px 0 #03e9f4, 0 0 25px 0 #03e9f4, 0 0 50px 0 #03e9f4, 0 0 100px 0 #03e9f4;
    }

    table {
        text-align: center;
    }
</style>
<%
    int status = Integer.parseInt(request.getParameter("status"));
    UserInfo user = new UserInfo();
    if(status == 1){
        user = (UserInfo) session.getAttribute("user");
    }else if(status == 2){
        UserDB userBean = new UserDB();
        user = userBean.GetUserbyId(Integer.parseInt(request.getParameter("id")));
    }

%>
<body>
<div class="wrap-mask">
    <form name="frm" id="frm">
        <input type="text" name="userId"  value="<%=user.getUserID()%>" hidden>
        <table class="loginBox">
            <th colspan="2">
                用户信息修改
            </th>
            <tr>
                <td>ID</td>
                <td><label class="item"><%=user.getUserID()%></label></td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><label class="item"><input type="text" name="userName" id="userName" value="<%=user.getUserName()%>"></label><br>
                    <div id="UMsg"></div>
                </td>
            </tr>
            <tr>
                <td>密 码</td>
                <td><label class="item"><input type="password" name="pwd" id="pwd" value="<%=user.getUserPwd()%>"></label><br>
                    <div id="PMsg"></div>
                </td>
            </tr>
            <tr>
                <td colspan="2"><button type="button" onclick="check()">确定</button><button type="reset">重置</button><button type="button" onclick="window.location.href='<%=request.getContextPath()%>/menu/welcome.jsp'">返回</button></td>
            </tr>
        </table>
    </form>
    <script src="../js/jquery-3.4.1.min.js"></script>
    <script src="../js/datacheck.js"></script>
    <script>
        function check() {
            if (Trim(frm.userName.value) !== "" && Trim(frm.userName.value) != null) {
                if (Trim(frm.pwd.value) !== "" && Trim(frm.pwd.value) != null) {
                    $.ajax({
                        type:"POST",
                        url:"<%=request.getContextPath()%>/UserInfoEditServlet",
                        data:$("#frm").serialize(),
                        success:function(data){
                            alert(data);
                            //window.location.href="<%=request.getContextPath()%>/menu/welcome.jsp"
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
</div>
</body>

</html>
