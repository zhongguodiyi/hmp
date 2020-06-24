<%@ page import="student.StudentInfo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 25865
  Date: 2020/6/6
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student_list</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/student.css" type="text/css">
    <script src="<%= request.getContextPath()%>/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%" style="text-align: center">
    <caption class="tb_showall">课程信息列表</caption>
    <tr class="td_header">
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年级</th>
        <th>专业</th>
        <td></td>
        <td></td>
    </tr>
    <%
        ArrayList<StudentInfo> studentList = (ArrayList<StudentInfo>) session.getAttribute("studentList");
        for (int i = 0; i < studentList.size();i++) {
            out.print("<tr class= \" td_" + (i%2==0?1:2) + "\" >");
            out.print("<td>" + studentList.get(i).getCode() +"</td>");
            out.print("<td>"+ (studentList.get(i).getName()) +"</td>");
            out.print("<td>"+ (studentList.get(i).getSex() == 0?"男":"女") +"</td>");
            out.print("<td>"+ studentList.get(i).getGrade().toString() +"</td>");
            out.print("<td>"+ (studentList.get(i).getMajor() ==1?"软件工程":"空间信息") +"</td>");

            out.print("<td><a href=" + request.getContextPath() +"/student/student_edit.jsp?id="+ studentList.get(i).getId()+">编辑</a></td>");
            out.print("<td><a href=" + request.getContextPath() +"/StudentDeleteAction?code=" + studentList.get(i).getCode()+ ">删除</a></td>");
            out.print("</tr>");
        }
    %>
    <tr>
        <td><a href="student_add.jsp">学生信息添加</a></td>
        <td></td>
        <td></td>
        <td></td>
        <td><a href="student_list.jsp">刷新数据列表</a></td>
        <td></td>
        <td></td>
    </tr>
</table>
</body>
</html>
