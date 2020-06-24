<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/23
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script language="JavaScript">
        function searchStu() {
            var fr=$("#sframe");
            var id=$("#id").val();
            if(isNaN(id) || id%1!=0){
                alert("学号请输入整数");
                return false;
            }
            var path="${pageContext.request.contextPath}/searchStuGradeServlet";
            var path1="${pageContext.request.contextPath}/grade/resultShow.jsp";
            $.ajax({
                url:path,
                type:"post",
                data:{"id":id},
                dataType:"json",
                success:function (result,testStatus){
                    if(result){
                        fr.attr("src",path1);
                    }else{
                        alert("查询失败");
                    }
                }
            })
        }
    </script>
</head>
<%
    String path=request.getContextPath();
%>
<body>

    学号:<input type="text" id="id"/>
    <input type="button" value="搜索" onclick="searchStu()"/>

<iframe id="sframe" width="100%" src="" border="0">

</iframe>


</body>
</html>
