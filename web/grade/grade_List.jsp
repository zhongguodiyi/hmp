<%@ page import="grade.StudentGrade" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/23
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/student.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
</head>

<script type="text/javascript">
    function del(obj) {
        var path1="${pageContext.request.contextPath}/deleteServlet";
        var sid=$(obj).parent().prevAll(".gid").text();
        var ssub=$(obj).parent().prevAll(".gsub").text();
        $.ajax({
            url:path1,
            type:"post",
            data: {"id":sid,"sub":ssub},
            dataType:"json",
            success:function (result,testStatus) {
                if(result){
                    alert("删除成功");
                    $(obj).parents("tr").remove();
                }else{
                    alert("删除失败");
                }
            }
            }
        )
    }
    function add() {
        var fr=$("#frame");
        var path2="${pageContext.request.contextPath}/grade/grade_add.jsp";
        fr.attr("src",path2);
    }
</script>
<body>
<%
    String[] subjects={"Java程序设计","数据库原理","数据结构","Web程序设计"};
    ArrayList<StudentGrade> gradeList = (ArrayList<StudentGrade>) session.getAttribute("gradeList");
%>
<table border="0" cellspacing="0" cellpadding="0" width="100%" style="text-align: center">
    <caption class="tb_showall">成绩信息列表</caption>
    <tr class="td_header">
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>科目</th>
        <th>分数</th>
        <td></td>
        <td></td>
    </tr>

    <%
        for (int i = 0; i < gradeList.size();i++) {
            out.print("<tr class= \" td_" + (i%2==0?1:2) + "\" >");
            out.print("<td class=\"gid\">" + gradeList.get(i).getId() +"</td>");
            out.print("<td class=\"game\">"+ (gradeList.get(i).getName()) +"</td>");
            out.print("<td class=\"gsex\">"+ (gradeList.get(i).getSex() == 0?"男":"女") +"</td>");
            out.print("<td class=\"gsub\">"+ subjects[gradeList.get(i).getSubject()] +"</td>");
            out.print("<td class=\"gscore\">"+ (gradeList.get(i).getScore()) +"</td>");
            out.print("<td><a href=" + request.getContextPath() +"/grade/grade_edit.jsp?id="+ i+">编辑</a></td>");
            out.print("<td><input type=\"button\" value=\"删除\" onclick=\"del(this)\"/></td>");
            out.print("</tr>");
        }
    %>
</table>
<a href="<%=request.getContextPath()%>/searchAllServlet">刷新</a>
<input type="button" value="录入成绩" onclick="add()"/>
<iframe id="frame" width="100%" src="" border="0">

</iframe>
</body>
</html>
