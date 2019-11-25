<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台管理</title>
</head>
<frameset rows="130,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="<%=request.getContextPath()%>/User/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame">
  <frameset rows="*" cols="247,*" framespacing="0" frameborder="no" border="0">
    <frame src="<%=request.getContextPath()%>/User/left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame">
    <frame src="<%=request.getContextPath()%>/User/main.html" name="mainFrame" id="mainFrame" title="mainFrame">
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes></html>
