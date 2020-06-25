<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/25
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script language="JavaScript">
        function searchSub() {
            var fr=$("#fframe");
            var sub=$("#subject option:selected").val();
            var path="${pageContext.request.contextPath}/searchSubtServlet";
            var path1="${pageContext.request.contextPath}/teach/resulttShow.jsp";
            $.ajax({
                url:path,
                type:"post",
                data:{"sub":sub},
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

<body>
<select id="subject">
    <option value =0>Java程序设计</option>
    <option value =1>数据库原理</option>
    <option value=2>数据结构</option>
    <option value=3>Web程序设计</option>
</select>
<input type="button" value="搜索" onclick="searchSub()"/>
<iframe id="fframe" width="100%" src="" border="0">

</iframe>
</form>
</body>
</html>

