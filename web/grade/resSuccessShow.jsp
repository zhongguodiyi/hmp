<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/23
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int flag=(int)session.getAttribute("flag");
    String path=request.getContextPath();
%>

<%
    if(flag==1){
     session.removeAttribute("flag");
%>
    <script type="text/javascript">
        alert("操作成功");
        window.location.href="<%=path%>/grade/grade_add.jsp";
    </script>
<%
    }
    else if(flag==2 || flag==3){
        session.removeAttribute("flag");
%>
    <script type="text/javascript">
        alert("操作成功");
        window.location.href="<%=path%>/searchAllServlet";
    </script>
<%
    }

%>

</body>
</html>
