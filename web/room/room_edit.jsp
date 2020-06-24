<%--
  Created by IntelliJ IDEA.
  User: 25865
  Date: 2020/6/23
  Time: 13:25
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
                url: "/test5/RoomGetOne?id=<%=id%>",
                success: function (data) {
                    frm.code.value = data.code;
                    frm.location.value = data.location;
                }

            })
        }
    })

</script>
<body>
<center>
    <form name="frm" method="post" action="<%= request.getContextPath() %>/RoomUpdate?id=<%=id%>">
        <table border=1>
            <tr class="td_header"><td colspan="2"> 教室信息录入，<span class="star">*</span>为必填项</td></tr>
            <tr><td>编号</td><td><input type="text" name="code" value="" size="20" maxlength="5" placeholder="4位字符数字" required pattern="[0-9]{4}"><span class="star">*</span></td></tr>
            <tr><td>位置</td><td><input type="text" name="location" value="" size="20" maxlength="20" placeholder="长度为2-20个字符" required pattern="\S{2,20}"><span class="star">*</span></td></tr>
            <tr><td colspan="2" align="center"><input type="reset"  value="重填" ><input type="submit"  value="提交"  ></td></tr>
        </table>
    </form>
</center>
</body>
</html>
