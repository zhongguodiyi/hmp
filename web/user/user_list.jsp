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
<table border ="0" class = "tb_showall" style="width:100%;border-collapse: collapse;">
    <tr>
        <th colspan="7" style="text-align: center;">用户信息列表</th>
    </tr>
    <tr border = "0" class = "td1">
        <td>用户ID</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td>用户权限</td>
        <td></td>
    </tr>

    <%

        ArrayList<UserInfo> UserList = (ArrayList<UserInfo>) session.getAttribute("UserList");
        int flag = 1;
        for(UserInfo user : UserList){
            String td_n;
            //对序号做判断分析该用的css样式
            if(flag % 2==0){
                td_n = "td_2";
            }else {
                td_n = "td_1";
            }
            String type =null;
            int n = user.getAuth();
            if(n == 1){
                type = "管理员";
            }else {
                type = "普通用户";
            }
    %>
    <tr class=<%=td_n%>>
        <td><%=user.getUserID()%></td>
        <td><%=user.getUserName()%></td>
        <td><%=user.getUserPwd()%></td>user
        <td><%=type%></td>
        <td style="text-align: right;"><a  href="#">编辑</a> <a  href="#">删除</a></td>
    </tr>
    <%
            flag ++;
        }
    %>
    <tr style="background-color: white;">
        <td colspan="3" style="text-align: left;"><a href="#">添加</a></td>
        <td colspan="3" style="text-align: center;"><a href="#">刷新数据列表</a></td>
    </tr>
</table>

</body>
</html>