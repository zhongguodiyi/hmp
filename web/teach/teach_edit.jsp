<%@ page import="teach.teachInfo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/25
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<%
    int id=Integer.parseInt(request.getParameter("no"));
    String[] subjects={"Java程序设计","数据库原理","数据结构","Web程序设计"};
    ArrayList<teachInfo> gradeList = (ArrayList<teachInfo>) session.getAttribute("teachAllList");
    teachInfo st=gradeList.get(id);
    session.setAttribute("qsub",st.getSubject());
%>
<form action="<%= request.getContextPath() %>/updatetServlet">
    <table border="0" cellspacing="0" cellpadding="0" width="100%" style="text-align: center">
        <caption class="tb_showall">授课信息</caption>
        <tr class="">
            <td>编号:<input type="text" name="id" id="id" value=<%=st.getId()%> readonly="readonly"/></td>
        </tr>
        <tr class="">
            <td>姓名:<input type="text" value=<%=st.gettName()%> readonly="readonly" name="tName"/></td>
        </tr>
        <tr class="">
            <td>科目:
                <select name="subject" id="subject" style="width: 150px">
                    <option value=0 <%if(st.getSubject()==0){out.print("selected = \"selected\"");}%>>Java程序设计</option>
                    <option value=1 <%if(st.getSubject()==1){out.print("selected = \"selected\"");}%>>数据库原理</option>
                    <option value=2 <%if(st.getSubject()==2){out.print("selected = \"selected\"");}%>>数据结构</option>
                    <option value=3 <%if(st.getSubject()==3){out.print("selected = \"selected\"");}%>>Web程序设计</option>
                </select>
            </td>
        </tr>
        <tr class="">
            <td><input type="submit" value="修改"/></td>
        </tr>
    </table>
</form>
</body>
</html>
