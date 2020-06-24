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
function createMenu(menuList){
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