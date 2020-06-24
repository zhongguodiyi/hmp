<%--
  Created by IntelliJ IDEA.
  User: 25865
  Date: 2020/6/22
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/student.css" type="text/css">
</head>
    <script>
        $(function () {

            $("body").onload=fillData();

            function fillData() {
                $.ajax({
                    type : "POST",
                    url:"<%=request.getContextPath()%>/TeacherList",
                    success:function (data) {
                        for (let i = 0; i < data.length; i++){
                            let tdi = i%2==0?"1":"2";
                            $("#list").after("<tr class=\" td_" + tdi + "\">" +
                                "<td>"+ data[i].code +"</td>" +
                                "<td>"+ data[i].name +"</td>" +
                                "<td>"+ data[i].sex +"</td>" +
                                "<td>"+ data[i].age +"</td>" +
                                "<td>"+ data[i].title +"</td>" +
                                "<td><a href="+"<%=request.getContextPath()%>"+"\"/teacher/teacher_edit.jsp?id="+ data[i].id+"\">编辑</a></td>" +
                                "<td><a href="+"<%=request.getContextPath()%>"+"\"/TeacherDelete?id="+ data[i].id +"\">删除</a></td></tr>")
                        }
                    }
                })
            }

        })
    </script>

<body>

<table border="0" cellspacing="0" cellpadding="0" width="100%" style="text-align: center">
    <caption class="tb_showall">教师信息列表</caption>
    <tr class="td_header" id="list">
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>职称</th>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td><a href="teacher_add.jsp">添加</a></td>
        <td></td>
        <td></td>
        <td></td>
        <td><a href="teacher_list.jsp">刷新数据列表</a></td>
        <td></td>
        <td></td>
    </tr>
</table>
</body>


</html>
