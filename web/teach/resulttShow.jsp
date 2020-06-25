<%@ page import="teach.teachInfo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/25
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/student.css" type="text/css">
</head>
<body>
<%
    String[] subjects={"Java程序设计","数据库原理","数据结构","Web程序设计"};
    ArrayList<teachInfo> ls = (ArrayList<teachInfo>) session.getAttribute("teachList");
%>
<table border="0" cellspacing="0" cellpadding="0" width="100%" style="text-align: center">
    <caption class="tb_showall">查询结果列表</caption>
    <tr class="td_header">
        <th>教师编号</th>
        <th>姓名</th>
        <th>科目</th>
    </tr>

    <%
        for (int i = 0; i < ls.size();i++) {
            out.print("<tr class= \" td_" + (i%2==0?1:2) + "\" >");
            out.print("<td>" + ls.get(i).getId() +"</td>");
            out.print("<td>"+ (ls.get(i).gettName()) +"</td>");
            out.print("<td>"+ subjects[ls.get(i).getSubject()] +"</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
