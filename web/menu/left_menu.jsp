	<%@ page import="login.UserInfo" %>
		<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<HEAD>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/menu_style.css" type="text/css">
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/label.js"></script>
<TITLE>menu</TITLE>
        <style>
        body{
        position: relative;
        width:160px;

        }
        table{
        font-family: "\5B8B\4F53";
        font-size: 16px;
        }
        .logout{
            text-align: center;
            font-family: "\5B8B\4F53";
            position: absolute;
            bottom:2px;
            width:160px;
            padding:4px;
            background-color: #1f65c2;
            color: #fff;
            font-size: 14px;
            border: 0px;
        }
        </style>
</HEAD>
<BODY bgColor="#1fa5a2">
<div id="menuDiv" ></div>
<div ><button class="logout" type="button" onclick="javascript:parent.window.location.href='<%=request.getContextPath()%>/LogoutServlet'">注销</button></div>
</BODY>
</html>
<script>
		<%
			UserInfo user = (UserInfo)session.getAttribute("user");
		%>
let path = "<%=request.getContextPath()%>/MenuInitServlet";
let id = <%=user.getUserID()%>
var classCount = 3; // 菜单大类的个数
//所有的menu列表被我搬到了MenuInitServlet里 要修改去那儿修改
$.ajax({
		type:"post",
		url:path,
		data:"id="+id,
		success:function(data) {
			var menuList=eval(data);
			console.log(menuList);
			createMenu(menuList);
		},
		error:function() {
			alert("请求失败");
		}
	})
</script>


