<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="user.UserInfo" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href=".././css/student.css">
    <meta charset="UTF-8">
    <title>管理设置</title>
</head>
<body>
<table border ="0" class = "tb_showall" style="width:100%;border-collapse: collapse;" >
    <tr>
        <th colspan="7" style="text-align: center;">管理员设置</th>
    </tr>
    <tr border = "0" class = "td1" id="user_list">
        <td>用户ID</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td>权限</td>
    </tr>
    <tr style="background-color: white;">
        <td colspan="4" style="text-align: center;"><a href="user_auth.jsp">刷新数据列表</a></td>
    </tr>
    <script src="../js/jquery-3.4.1.min.js"></script>
    <script>
        $("body").onload=fillData();

        function fillData() {
            $.ajax({
                type : "POST",
                url:"<%=request.getContextPath()%>/UserListServlet",
                success:function (data) {
                    console.log(data)
                    for (let i = 0; i < data.length; i++){
                        let tdi = i%2===0?"1":"2";
                        let type = data[i].auth === 1 ?"取消管理员":"设为管理员"

                        $("#user_list").after("<tr class=\" td_" + tdi + "\">" +
                            "<td>"+ data[i].userID+"</td>" +
                            "<td>"+ data[i].userName +"</td>" +
                            "<td>"+ data[i].userPwd +"</td>" +
                            "<td colspan=\"2\"><a href="+"\"<%=request.getContextPath()%>"+"/UserAuthEditServlet?id="+ data[i].userID+"\">"+type+"</a></td>")
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