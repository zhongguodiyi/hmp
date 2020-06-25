<%@ page import="course.CourseInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="commom.MyTools" %><%--
  Created by IntelliJ IDEA.
  User: 19843
  Date: 2020/6/2
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<head>
    <link rel="stylesheet" type="text/css" href=".././css/student.css">
    <meta charset="UTF-8">
    <title>修改课程信息</title>
</head>

<body>
<%
    int courseid = Integer.parseInt(request.getParameter("CourseID"));
    CourseInfo course = new CourseInfo();
    for(CourseInfo i : (ArrayList<CourseInfo>)session.getAttribute("CourseList")){
        if(i.getCourseID() == courseid){
            course = i;
        }
    }
    String detail = course.getDetail();
    if(detail == null){
        detail="";
    }

%>

<form action="<%=request.getContextPath()%>/CourseUpdateAction?courseid=<%=courseid%>" method="POST" name="frm">

    <table border="1" style="width: 400px ; margin: auto;margin-top: 200px;">
        <tr class="td1">
            <td colspan="2">课程信息录入，<span class="star">*</span>为必填项</td>
        </tr>
        <tr>
            <td style="width: 20%;">名称</td>
            <td><%=course.getName()%></td>
        </tr>
        <tr>
            <td style="width: 20%;">性质</td>
            <td><select name="type" id="type" >
                    <option value="1">通识必修课</option>
                    <option value="2">通识选修课</option>
                    <option value="3">公共基础必修课</option>
                    <option value="4">专业必修课</option>
                    <option value="5">专业选修课</option>
                </select>
            </td>
        </tr>
        <script src="../js/jquery-3.4.1.min.js"></script>
        <script>
            let type = <%=course.getType()%>
            $("#type").val(type)
        </script>
        <tr>
            <td style="width: 20%;">学分</td>
            <td><input type="text" required name="credit" value=<%=(int)course.getCredit()%>><span class="star">*</span>数值</td>
        </tr>
        <tr>
            <td style="width: 20%;">开设年级</td>
            <td><input type="text" name="grade" required value=<%=course.getGrade()%>><span class="star">*</span>4位数年份</td>
        </tr>
        <tr>
            <td style="width: 20%;">开设专业</td>
            <td>
                <input type="radio" name="major" id="major" value="1">软件工程<input type="radio" name="major" value="2">空间信息<span class="star">*</span>
            </td>
        </tr>
        <script>
                $("input[name='major'][value='<%=course.getMajor()%>']").prop("checked","checked")
        </script>
        <tr>
            <td style="width: 20%;">备注</td>
            <td><textarea cols="25" rows="3" name="detail"><%=detail%></textarea>200个字符以内</td>
        </tr>
        <tr>
            <td style="width: 20%;text-align: center;" colspan="2"><button type="button" onclick="check();">提交</button><button type="button" onclick="javascript:window.location.href='<%=request.getContextPath()%>/CourseListAction'">取消</button></td>
        </tr>
    </table>
</form>
<script type="text/javascript" src=".././js/datacheck.js" defer></script>
<script type="text/javascript" defer>
    function check() {
        if (Trim(frm.credit.value) != null && Trim(frm.credit.value) !== "") {
            if (!IsInt(Trim(frm.credit.value))) {
                alert("学分需为数值！");
                frm.credit.focus();
                return;
            }
        } else {
            alert("学分不可为空！");
            frm.credit.focus();
            return;
        }
        if (Trim(frm.grade.value) != null && Trim(frm.grade.value) !== "") {
            if (Trim(frm.grade.value).length !== 4 || !IsInt(Trim(frm.grade.value))) {
                alert("请给开设年级输入四位整数的年份！");
                frm.grade.focus;
                return;
            }
        } else {
            alert("年份不可为空！");
            frm.grade.focus();
            return;
        }
        frm.submit();
        alert("正在提交");
    }
</script>
</body>