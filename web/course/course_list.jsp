<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="course.CourseInfo" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href=".././css/student.css">
    <meta charset="UTF-8">
    <title>课程信息表</title>
</head>
<body>
    <table border ="0" class = "tb_showall" style="width:100%;border-collapse: collapse;">
        <tr>
            <th colspan="7" style="text-align: center;">课程信息表</th>
        </tr>
        <tr border = "0" class = "td1">
            <td>名称</td>
            <td>性质</td>
            <td>学分</td>
            <td>开设年级</td>
            <td>开设专业</td>
            <td></td>
        </tr>

        <%
            //取出session对象中的courselist
            ArrayList<CourseInfo> CourseList = (ArrayList<CourseInfo>) session.getAttribute("CourseList");
            int flag = 1;
            for(CourseInfo course : CourseList){
                String td_n;
                //对序号做判断分析该用的css样式
                if(flag % 2==0){
                    td_n = "td_2";
                }else {
                    td_n = "td_1";
                }%>
        <tr class=<%=td_n%>>
            <td><%=course.getName()%></td>
            <td><%=course.getC_type()%></td>
            <td><%=course.getCredit()%></td>
            <td><%=course.getGrade()%></td>
            <td><%=course.getC_major()%></td>
            <td style="text-align: right;"><a  href="course_modify.jsp?CourseID=<%=course.getCourseID()%>">编辑</a> <a  href="<%=request.getContextPath()%>/CourseDeleteAction?CourseID=<%=course.getCourseID()%>">删除</a></td>
        </tr>
           <%
                flag ++;
            }
           %>
        <tr style="background-color: white;">
            <td colspan="3" style="text-align: left;"><a href="course_add.jsp">添加</a></td>
            <td colspan="3" style="text-align: center;"><a href="<%=request.getContextPath()%>/CourseListAction">刷新数据列表</a></td>
        </tr>
    </table>
	
</body>
</html>