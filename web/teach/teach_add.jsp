<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/25
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script language="JavaScript">
        function check() {
            var id=$("#id").val();
            var name=$("#tName").val();
            if(isNaN(id) || id%1!=0){
                alert("编号请输入整数");
                return false;
            }
            if(name.length>10){
                alert("姓名太长");
                return false;
            }
        }
    </script>
</head>
<body>
<form action="<%= request.getContextPath() %>/addtServlet" onsubmit="return check();">
    <table border="0" cellspacing="0" cellpadding="0" width="100%" style="text-align: center">
        <caption class="tb_showall">授课信息</caption>
        <tr class="">
            <td>编号:<input type="text" name="id" id="id" required/></td>
        </tr>
        <tr class="">
            <td>姓名:<input type="text" name="tName" id="tName" required/></td>
        </tr>
        <tr class="">
            <td>科目:
                <select name="subject" style="width: 165px">
                    <option value =0>Java程序设计</option>
                    <option value =1>数据库原理</option>
                    <option value=2>数据结构</option>
                    <option value=3>Web程序设计</option>
                </select>
            </td>
        </tr>
        <tr class="">
            <td><input type="submit" value="增加"/></td>
        </tr>
    </table>
</form>
</body>
</html>
