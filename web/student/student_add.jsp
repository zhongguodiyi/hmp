<%--
  Created by IntelliJ IDEA.
  User: 25865
  Date: 2020/6/6
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student_add</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/student.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/datacheck.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<%--<center>
    <form action="<%= request.getContextPath()%>/StudenInsertAction" method="post" name="frm">
        <table border="1" cellspacing="" cellpadding="">
            <tr class="td_header">
                <td colspan="2" class="td8">学生信息录入，<span class="star">*</span>为必填项</td>
            </tr>
            <tr>
                <td>学号</td>
                <td><input type="text" name="code" id="" value="" /><span class="star">*</span></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" value="" size="20" maxlength="20" placeholder="长度为2-20个字符" required pattern="\S{2,20}"><span class="star">*</span></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" name="sex" id="" value="0" checked/>男
                    <input type="radio" name="sex" id="" value="1" />女
                    <span class="star">*</span>
                </td>
            </tr>
            <tr>
                <td>专业</td>
                <td><select name="major">
                    <option value ="0">软件工程</option>
                    <option value="1">空间信息</option>
                </select>
                    <span class="star">*</span>
                </td>
            </tr>
            <tr>
                <td>年级</td>
                <td><input type="text" name="grade" id="" value="" placeholder="4位整数年份20xx" /><span class="star">*</span></td>
            </tr>
            <tr>
                <td>学分</td>
                <td><input type="text" name="score" id="" value="" /><span class="star">*</span>数值</td>
            </tr>


            <tr>
                <td>备注</td>
                <td><textarea name="detail" rows="2" cols="20" oninput="check_textarea()">
					</textarea><span class="star">*</span>200个字符以内</td>
            </tr>
            <tr style="text-align: center;">
                <td colspan="2"><input type="button" name="" id="" value="提交" class="button" onclick="check()"/></td>
            </tr>
        </table>
    </form>
</center>--%>
<center>
    <a href="JavaScript:history.back();">>>学生信息管理</a><br><br>
    <form name="frm" method="post" action="<%= request.getContextPath() %>/StudentInsertAction">
        <table border=1>
            <tr class="td_header"><td colspan="2"> 学生信息录入，<span class="star">*</span>为必填项</td></tr>
            <tr><td>学号</td><td><input type="text" name="code" value="" size="20" maxlength="5" placeholder="5位字符数字" required pattern="[0-9]{5}"><span class="star">*</span></td></tr>
            <tr><td>姓名</td><td><input type="text" name="name" value="" size="20" maxlength="20" placeholder="长度为2-20个字符" required pattern="\S{2,20}"><span class="star">*</span></td></tr>
            <tr><td>性别</td><td><input type="radio" name="sex" value="0" checked>男<input type="radio" name="sex" value="1">女<span class="star">*</span></td></tr>
            <tr><td>年级</td><td><input type="text" name="grade" value="" size="20" maxlength="4" placeholder="4位整数年份20xx" required pattern="20[0-9]{2}"><span class="star">*</span></td></tr>
            <tr><td>专业</td><td><select name="major" size='1' ><option value='1'>软件工程</option><option value='2'>空间信息</option></select><span class="star">*</span></td></tr>
            <tr><td>备注</td><td><TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('描述最多200个字符!');}"></TEXTAREA>200个字符以内</td></tr>
            <tr><td colspan="2" align="center"><input type="reset"  value="重填" ><input type="submit"  value="提交"  ></td></tr>
        </table>
    </form>
</center>
</body>
</html>
