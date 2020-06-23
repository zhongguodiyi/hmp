<%--
  Created by IntelliJ IDEA.
  User: 19843
  Date: 2020/6/23
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>信息管理系统</title>
</head>
<link rel="stylesheet" type="text/css" href="./css/login.css">
<body>
<div class="wrap-mask">
    <h1>信息管理系统</h1>
    <div class="loginBox" >
        <h2>Login</h2>
        <form action="#" name="frm" id="frm" method="post">
            <div class="item"><input type="text" name="userName" required ><label >用户名</label></div>
            <div id="UMsg"></div>
            <div class="item"><input type="password" name="pwd" required ><label>密码</label></div>
            <div id="PMsg"></div>
            <button class="btn" type="button" onclick="check()">登录
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </button>
            <button class="btn" type="reset">重置
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </button>
        </form>
        <script type="text/javascript" src="./js/datacheck.js" defer></script>
        <script src="./js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" defer>
            function check() {
                if (Trim(frm.userName.value) !== "" && Trim(frm.userName.value) != null) {
                    if (Trim(frm.pwd.value) !== "" && Trim(frm.pwd.value) != null) {
                        $.ajax({
                            type:"POST",
                            url:"<%=request.getContextPath()%>/LoginServlet",
                            data:$("#frm").serialize(),
                            success:function(data){
                                if(parseInt(data) === 1){
                                    document.getElementById("UMsg").innerText = "用户不存在！"
                                }else if(parseInt(data) === 2){
                                    document.getElementById("PMsg").innerText = "密码错误！"
                                }else{
                                    console.log(data.userID);
                                    window.location.href="<%=request.getContextPath()%>/menu/index.jsp"
                                }
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
</div>
</body>

</html>
