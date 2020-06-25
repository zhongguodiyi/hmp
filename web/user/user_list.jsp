<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="user.UserInfo" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href=".././css/student.css">
    <meta charset="UTF-8">
    <title>用户信息表</title>
</head>
<body>
<table border ="0" class = "tb_showall" style="width:100%;border-collapse: collapse;" >
    <tr>
        <th colspan="7" style="text-align: center;">用户信息列表</th>
    </tr>
    <tr border = "0" class = "td1" id="user_list">
        <td>用户ID</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td>用户权限</td>
        <td></td>
        <td></td>
    </tr>
    <tr style="background-color: white;">
        <td colspan="3" style="text-align: left;"><a href="user_add.jsp">添加</a></td>
        <td colspan="3" style="text-align: center;"><a href="user_list.jsp">刷新数据列表</a></td>
    </tr>
    <script src="../js/jquery-3.4.1.min.js"></script>
    <script>
        $("body").onload=fillData();

        function fillData() {
            $.ajax({
                type : "POST",
                url:"<%=request.getContextPath()%>/UserListServlet",
                success:function (data) {
                    for (let i = 0; i < data.length; i++){
                        let tdi = i%2===0?"1":"2";
                        let type = data[i].Auth === 1 ?"管理员":"普通用户"

                        $("#user_list").after("<tr class=\" td_" + tdi + "\">" +
                            "<td>"+ data[i].userID+"</td>" +
                            "<td>"+ data[i].userName +"</td>" +
                            "<td>"+ data[i].userPwd +"</td>" +
                            "<td>"+ type +"</td>" +
                            "<td><a href="+"\"<%=request.getContextPath()%>"+"/user/userInfo_edit.jsp?id="+ data[i].userID+"&status=2\">编辑</a></td>" +
                            "<td><a href="+"\"<%=request.getContextPath()%>"+"/UserDeleteServlet?id="+data[i].userID+"\">删除</a></td></tr>")
                    }
                },
                error:function () {
                    alert("请求失败")
                }
            })
        }
    </script>
</table>

</body>
</html>