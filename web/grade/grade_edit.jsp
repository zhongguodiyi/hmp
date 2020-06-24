<%@ page import="grade.StudentGrade" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/23
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script language="JavaScript">
        function check() {
            var score=$("#score").val();
            if(isNaN(score) || score>100 || score <0){
                alert("分数请输入0-100内的数字");
                return false;
            }
        }
    </script>
</head>
<body>
<%
    int id=Integer.parseInt(request.getParameter("id"));
    String[] subjects={"Java程序设计","数据库原理","数据结构","Web程序设计"};
    ArrayList<StudentGrade> gradeList = (ArrayList<StudentGrade>) session.getAttribute("gradeList");
    StudentGrade st=gradeList.get(id);
%>
<form action="<%= request.getContextPath() %>/updateServlet" onsubmit="return check();">
    <table border="0" cellspacing="0" cellpadding="0" width="100%" style="text-align: center">
        <caption class="tb_showall">成绩信息</caption>
        <tr class="">
            <td>学号:<input type="text" value=<%=st.getId()%> readonly="readonly" name="id"/></td>
        </tr>
        <tr class="">
            <td>姓名:<input type="text" value=<%=st.getName()%> readonly="readonly" name="name"/></td>
        </tr>
        <tr class="">
            <td>性别:<input type="text" value=<%=st.getSex()==0?"男":"女"%> readonly="readonly" name="sex"/></td>
        </tr>
        <tr class="">
            <td>科目:<input type="text" value=<%=subjects[st.getSubject()]%> readonly="readonly" name="subject"/></td>
        </tr>
        <tr class="">
            <td>分数:<input type="text" name="score" value=<%=st.getScore()%> id="score"/></td>
        </tr>
        <tr class="">
            <td><input type="submit" value="修改"/></td>
        </tr>
    </table>
</form>
</body>
</html>
