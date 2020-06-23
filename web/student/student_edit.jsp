<%@ page import="student.StudentInfo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 25865
  Date: 2020/6/6
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student_edit</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/student.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/datacheck.js" type="text/javascript" charset="utf-8"></script>
    <script language="JavaScript">
        <%
        String id = request.getParameter("id");
        ArrayList<StudentInfo> list = (ArrayList<StudentInfo>) request.getSession().getAttribute("studentList");
        StudentInfo student = new StudentInfo();
        for (StudentInfo studentInfo : list) {
          if (studentInfo.getId().toString().equals(id)){
              student = studentInfo;
              break;
          }
        }
%>
        function ShowData(){
            //学号
            frm.code.value=<%= student.getCode().toString() + ""%>
            //姓名
            frm.name.value=<%= "'" + student.getName()+"'"%>
            //性别
            var rObj = frm.sex;//单选按钮对象数组
            for(var i = 0;i < rObj.length;i++){
                if(rObj[i].value == <%= student.getSex().toString()%>){
                    rObj[i].checked =  'checked';
                }
            }
            //年级
            frm.grade.value=<%= student.getGrade().toString()%>;
            //专业
            //frm.major.value=student["major"];//方式1
            //frm.major.options[student["major"]-1].selected=true; //方式2
            //方式3
            var optionObj = frm.major.options;//选项对象数组
            for(var i = 0;i < optionObj.length;i++){
                if(optionObj[i].value == <%= student.getMajor().toString()%>){
                    optionObj[i].selected=true;
                }
            }
        }
    </script>
</head>
<body onload="ShowData()">

<center>
    <a href="JavaScript:history.back();">>>学生信息管理</a><br><br>
    <form name="frm" method="post" action="<% out.print(request.getContextPath() + "/StudentUpdateAction?id=" + id); %>">
        <input type="hidden" name="id" value="1">
        <table border=1>
            <tr class="td_header"><td colspan="2"> 学生信息修改，<span class="star">*</span>为必填项</td></tr>
            <tr><td>学号</td><td><input type="text" name="code" value="" size="20" maxlength="5"><span class="star">*</span>5位字符数字</td></tr>
            <tr><td>姓名</td><td><input type="text" name="name" value="" size="20" maxlength="20"><span class="star">*</span></td></tr>
            <tr><td>性别</td><td><input type="radio" name="sex" value="0" >男<input type="radio" name="sex" value="1" >女<span class="star">*</span></td></tr>
            <tr><td>年级</td><td><input type="text" name="grade" value="" size="20" maxlength="4"><span class="star">*</span>4位整数</td></tr>
            <tr><td>专业</td><td><select name="major" size='1' >
                <option value='1' >软件工程</option>
                <option value='2' >空间信息</option>
            </select><span class="star">*</span></td></tr>
            <tr><td>备注</td><td><TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('描述最多20个字符!');}"></TEXTAREA>200个字符以内</td></tr>
            <tr><td colspan="2" align="center"><input type="reset"  value="重填" ><input type="button"  value="提交" onclick="check();"></td></tr>
        </table>
    </form>
</center>
</body>
</html>
<script language="JavaScript">
    function check(){
        var re = /[0-9]{5}/;
        if(!re.test(frm.code.value)){
            alert("请输入5位字符数字的学号!");
            frm.code.focus();
            return ;
        }
        re = /\S{2,20}/;
        if(!re.test(frm.name.value)){
            alert("请输入2~20个字符的姓名!");
            frm.name.focus();
            return ;
        }
        re = /20[0-9]{2}/;
        if(!re.test(frm.grade.value)){
            alert("请输入4位整数年份20xx!");
            frm.grade.focus();
            return ;
        }
        frm.submit();
    }

</script>
</body>
</html>
