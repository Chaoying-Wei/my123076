<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 这是标签库指令：prefix配置标签的前缀，可以自定义名称；uri配置标签的标记或标签地址  -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改车票信息</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
</head>

<body class="write_bg">
<form action="<%=request.getContextPath()%>/EditTicketServlet.do" method="post">
  <table width="100%" border="0" cellspacing="0">
    <tr>
      <td height="30"></td>
    </tr>
  </table>
<table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" colspan="2" ></td>
  </tr>
  <tr>
    <td width="64" height="30"  ></td>
    <td width="771" height="30" valign="top"  class="text_blod_title">新增车票信息</td>
  </tr>
  <tr>
    <td height="15" colspan="2" ><img src="<%=request.getContextPath()%>/images/line1.jpg" width="835" height="6"></td>
    </tr>
  <tr>
    <td colspan="2" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="64"></td>
        <td width="771" height="25" align="left" class="text_cray">注：标有<span class="text_red"> *</span> 处，均为必填项</td>
      </tr>
      <tr>
        <td></td>
        <td height="15"></td>
      </tr>
    </table>
      
      <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="6" ></td>
          </tr>
          <tr>
            <td height="15" colspan="6" align="center" class="text_title">车票详细信息</td>
          </tr>
          <tr>
            <td height="10" colspan="6" ></td>
          </tr>
          
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">车票id：</td>
            <td></td>
            <td colspan="3" align="left" class="text_cray">
            <input type="text" name="ticketId" id="ticketId" readonly="readonly" disabled value="${ticketID.ticketId}" />
            <!-- readonly和disabled都是只能读不能修改；但是readonly可以把表单域的数据提交到服务器，而disabled不可以 -->
            <!-- 对于不能修改的数据，可以使用readonly进行限制或者使用隐藏域进行提交数据 -->
             <input type="hidden" name="ticketId" id="ticketId" value="${ticketID.ticketId}"/>
          
            </td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">起始站：</td>
            <td>&nbsp;</td>
            <td colspan="3" align="left">
	            <select class="text_cray" name="startStation" id="startStation">
		            <c:if test="${ticketID.startStation eq '广州南' }">
		           		<option value="广州南" selected >广州南</option>
		                <option value="深圳">深圳</option>
		                <option value="南宁">南宁</option>
		                <option value="柳州">柳州</option>
	           		 </c:if>
	           		 <c:if test="${ticketID.startStation eq '深圳' }">
		           		<option value="广州南"  >广州南</option>
		                <option value="深圳" selected>深圳</option>
		                <option value="南宁">南宁</option>
		                <option value="柳州">柳州</option>
	           		 </c:if>
	           		 <c:if test="${ticketID.startStation eq '南宁' }">
		           		<option value="广州南"  >广州南</option>
		                <option value="深圳">深圳</option>
		                <option value="南宁" selected>南宁</option>
		                <option value="柳州">柳州</option>
	           		 </c:if>
	           		 <c:if test="${ticketID.startStation eq '柳州' }">
		           		<option value="广州南"  >广州南</option>
		                <option value="深圳">深圳</option>
		                <option value="南宁">南宁</option>
		                <option value="柳州" selected>柳州</option>
	           		 </c:if>
	                
	            </select>            
            </td>
          </tr>
           <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">终点站：</td>
            <td>&nbsp;</td>
            <td colspan="3" align="left">
	            <select class="text_cray" name="endStation" id="endStation">
	                <c:if test="${ticketID.endStation eq '广州南' }">
		           		<option value="广州南" selected >广州南</option>
		                <option value="深圳">深圳</option>
		                <option value="南宁">南宁</option>
		                <option value="柳州">柳州</option>
	           		 </c:if>
	           		 <c:if test="${ticketID.endStation eq '深圳' }">
		           		<option value="广州南"  >广州南</option>
		                <option value="深圳" selected>深圳</option>
		                <option value="南宁">南宁</option>
		                <option value="柳州">柳州</option>
	           		 </c:if>
	           		 <c:if test="${ticketID.endStation eq '南宁' }">
		           		<option value="广州南"  >广州南</option>
		                <option value="深圳">深圳</option>
		                <option value="南宁" selected>南宁</option>
		                <option value="柳州">柳州</option>
	           		 </c:if>
	           		 <c:if test="${ticketID.endStation eq '柳州' }">
		           		<option value="广州南"  >广州南</option>
		                <option value="深圳">深圳</option>
		                <option value="南宁">南宁</option>
		                <option value="柳州" selected>柳州</option>
	           		 </c:if>
	            </select>            
            </td>
          </tr>
          
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">发车日期：</td>
            <td></td>
            <td width="175" align="left" class="text_cray">
            <input class="Wdate" value="${ticketID.startDate}" type="text" name="startDate" id="startDate" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"></td>
            <td colspan="2" align="left"></td>
          </tr>
         
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">发车时刻：</td>
            <td></td>
            <td width="175" align="left" class="text_cray">
            <input class="Wdate" value="${ticketID.startTime}" type="text" name="startTime" id="startTime" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"></td>
            <td colspan="2" align="left"></td>
          </tr>
           <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">用户账号：</td>
            <td></td>
            <td colspan="3" align="left" class="text_cray">
            <input type="text" name="renames" id="renames" readonly="readonly" disabled value="${ticketID.renames}" />
            <!-- readonly和disabled都是只能读不能修改；但是readonly可以把表单域的数据提交到服务器，而disabled不可以 -->
            <!-- 对于不能修改的数据，可以使用readonly进行限制或者使用隐藏域进行提交数据 -->
             <input type="hidden" name="renames" id="renames" value="${ticketID.renames}"/>
          
            </td>
          </tr>
          
          <tr>
            <td height="10" colspan="6"></td>
          </tr>
          
        </table>
</table><br>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td></td>
  </tr>
</table>
<table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="164"></td>
    <td width="99" height="30" align="center"><input name="button" type="submit" class="buttj" id="button"value=""></td>
    <td width="98" ></td>
    <td width="97" align="center"><input name="button2" type="reset" class="butcz" id="button2"value=""></td>
    <td width="92" ></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td height="20"></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0">
<tr>
    <td height="2" background="<%=request.getContextPath()%>/images/bottom_point.gif"></td>
  </tr>
  <tr>
    <td height="25" align="center" background="<%=request.getContextPath()%>/images/bottom_ny_bg.gif" class="text_cray">copyright@12306 购票网</td>
  </tr>
</table>
</form>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/js/common.js"></script>
</body>
</html>
