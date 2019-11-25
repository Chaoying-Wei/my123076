<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var count=5;
	function starTimer(){
		document.getElementById("showMsg").innerText=count+"秒返回操作页面！";
		if(--count>0){
			setTimeout('starTimer()',1000);
		}else{
			location.href="${BACKURL}";
		}
	}
	
</script>
</head>
<body onload="starTimer()">
失败啦:
<!-- $+{} el表达式可以用于从内置对象中读取数据 -->
<%String msg=(String)session.getAttribute("MSG") ;%>
${MSG} =====<%=msg %>
<br>
<a href="${BACKURL}">返回</a>
<br>
<div id="showMsg" style="color:red;"></div>
</body>
</html>