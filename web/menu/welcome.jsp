<%@ page import="user.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: 19843
  Date: 2020/6/23
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link rel="stylesheet" href="../css/login.css">
    <style>
        body {
            background-image: url("../images/welcome.jpg");
        }
        #time {
            font-size: 25px;
            font-family: "宋体";
            text-align: center;
            width: 400px;
            height: 60px;
            position: absolute;
            top: 300px;
        }
        h2 {
            position: absolute;
            top: 210px;
            text-align: center;
            font-size: 28px;
            font-family: "宋体";
        }
    </style>

    <body>
            <%
        UserInfo user = (UserInfo)session.getAttribute("user");
        String type = null;
        if(user.getAuth()==0){
            type = "超级管理员";
        }else if(user.getAuth()==1){
            type = "管理员";
        }else {
            type="普通用户";
        }
        %>
    <div class="wrap-mask">
    <h1>欢迎！<%=user.getUserName()%></h1>
    <h2><%=type%></h2>
    <div id="time"></div>
    </div>
    </body>
    <script>
    function showtime() {
        var date = new Date();
        this.year = date.getFullYear();
        this.month = date.getMonth() + 1;
        this.date = date.getDate();
        this.day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[date.getDay()]; //获取星期
        this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours(); //判断是否为两位数事件，不是就加个零
        this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
        var currentTime = this.year + "年" + this.month + "月" + this.date + "日 " + this.hour + ":" + this.minute + ":" + this.second + " " + "(" + this.day + ")";
        document.getElementById("time").innerText = currentTime;
        var timei = setTimeout(showtime, 1000);
    }
    window.onload = showtime()
    </script>
