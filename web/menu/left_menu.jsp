<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<HEAD>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/menu_style.css" type="text/css">
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>

<TITLE>menu</TITLE>
</HEAD>
<BODY bgColor="#1fa5a2">
<div id="menuDiv" ></div>	 
</BODY>
</html>
<script> 

var classCount = 3; // 菜单大类的个数
function Show(theId) {
 	theTr = eval("tr_" + theId);
	//document.getElementById('tr_0');
	if (theTr.style.display === "none") {
		theTr.style.display = "block";
	}
	else {
		theTr.style.display = "none";
	}
	for (i = 0; i < classCount; i++) {
		if (i === theId)
			continue;
		theTr = eval("tr_" + i);
		theTr.style.display = "none";
	}
}


var menuList; 
menuList=[ 
	{"main":"学生管理","sub":[
		{"name":"专业信息管理","link":"waiting.html"},
		{"name":"院系信息管理","link":"waiting.html"},
		{"name":"学生信息管理","link":"StudentListAction"}]},
	{"main":"课程管理","sub":[{"name":"课程信息管理","link":"CourseListAction"}]},
	{"main":"成绩管理","sub":[
		{"name":"学生成绩查询","link":"waiting.html"},
		{"name":"课程成绩查询","link":"waiting.html"},
		{"name":"成绩录入","link":"waiting.html"}]}
];
function createMenu(){	
	var strHtml="";
	strHtml+="<table class=\"guide guideText\" width=\"100%\">	";	 
	for( var i=0;i<menuList.length;i++){
		strHtml+="<TR><TD  id=\"td_"+i+"\"  align=\"center\" width=\"90%\" bgColor=\"#1f65c2\" ><A  href=\"javascript:Show("+i+")\">"+menuList[i]["main"]+"</A></TD></TR>";
		strHtml+=" <TR id=tr_"+i+" style=\"DISPLAY: none;cursor:hand\">";
		strHtml+=" 	<TD  width=\"100%\" align=\"center\"  bgColor=\"#4c84ce\" height=\"50\">";
		strHtml+=" 		<table align=\"center\" border=\"0\" width=\"90%\">";
		var submenu=menuList[i]["sub"];
	    for(var j=0;j<submenu.length;j++){ 
            strHtml+="<tr><td width=\"150\" align=\"center\" ><A href=\""+submenu[j]["link"]+"\" target=\"right_workspace\">"+submenu[j]["name"]+"</A> </td><tr>";
		}
	    strHtml+=" </table> </TD> </TR>";	
	}
	 strHtml+=" </table>";	
	 document.getElementById("menuDiv").innerHTML =strHtml;
}
createMenu();
</script>
<style>
    body{
        width:160px;

    }
	table{
		font-family: "\5B8B\4F53";
		font-size: 16px;
	}
</style>

