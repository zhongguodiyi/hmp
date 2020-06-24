<%--
  Created by IntelliJ IDEA.
  User: 25865
  Date: 2020/6/23
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/student.css" type="text/css">
    <script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<% String id = request.getParameter("id"); %>

<script language="JavaScript">
    $(function () {
        $("body").onload = filldata();

        function filldata(){
            $.ajax({
                type : "POST",
                url: "/test5/TeacherGetOne?id=<%=id%>",
                success: function (data) {
                    frm.code.value = data.code;
                    frm.name.value = data.name;
                    frm.sex.value = data.sex;
                    frm.age.value = data.age;
                    frm.title.value = data.title;
                }

            })
        }
    })

</script>

<body>
<center>
    <form name="frm" method="post" action="<%= request.getContextPath() %>/TeacherUpdate?id=<%=id%>">
        <table border=1>
            <tr class="td_header"><td colspan="2"> 教师信息录入，<span class="star">*</span>为必填项</td></tr>
            <tr><td>编号</td><td><input type="text" name="code" value="" size="20" maxlength="5" placeholder="5位字符数字" required pattern="[0-9]{5}"><span class="star">*</span></td></tr>
            <tr><td>姓名</td><td><input type="text" name="name" value="" size="20" maxlength="20" placeholder="长度为2-5个字符" required pattern="\S{2,5}"><span class="star">*</span></td></tr>
            <tr><td>性别</td><td>
                <input type="radio" name="sex" value="男" checked>男<input type="radio" name="sex" value="女">女<span class="star">*</span></td></tr>
            <tr><td>年龄</td><td><input type="text" name="age" value="" size="20" maxlength="2" placeholder="2位整数" required pattern="[0-9]{2}"><span class="star">*</span></td></tr>
            <tr><td>职称</td><td>
                <select name="title" size='1' >
                    <option value='讲师'>讲师</option>
                    <option value='副教授'>副教授</option>
                    <option value='教授'>教授</option>
                </select><span class="star">*</span></td></tr>
            <tr><td colspan="2" align="center"><input type="reset"  value="重填" ><input type="submit"  value="提交"  ></td></tr>
        </table>
    </form>
</center>
</body>
</html>
