<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在线用户列表</title>
</head>
<body>
 在线用户列表：  
  
   <c:forEach items="${ONLINES}" var="userMap">
      <c:out value="${userMap.value}"></c:out> | 
   </c:forEach>


</body>
</html>