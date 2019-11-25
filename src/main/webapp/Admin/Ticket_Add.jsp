<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增车票信息</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
</head>

<body class="write_bg">
<form action="<%=request.getContextPath()%>/AddTicketServlet.do" method="post">
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
    <td height="15" colspan="2" ><img src="../images/line1.jpg" width="835" height="6"></td>
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
            <td width="100" height="40" align="left" class="text_cray1">起始站：</td>
            <td>&nbsp;</td>
            <td colspan="3" align="left">
	            <select class="text_cray" name="startStation" id="startStation">
	                <option value="广州南">广州南</option>
	                <option value="深圳">深圳</option>
	                <option value="南宁">南宁</option>
	                <option value="柳州">柳州</option>
	            </select>            
            </td>
          </tr>
           <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">终点站：</td>
            <td>&nbsp;</td>
            <td colspan="3" align="left">
	            <select class="text_cray" name="endStation" id="endStation">
	                <option value="深圳">深圳</option>
	                <option value="广州南">广州南</option>
	                <option value="南宁">南宁</option>
	                <option value="柳州">柳州</option>
	            </select>            
            </td>
          </tr>
          
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">发车日期：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input class="Wdate" type="text" name="startDate" id="startDate" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"></td>
            <td colspan="2" align="left"></td>
          </tr>
         
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">发车时刻：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input class="Wdate" type="text" name="startTime" id="startTime" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"></td>
            <td colspan="2" align="left"></td>
          </tr>
           <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">用户账号：</td>
            <td></td>
            <td colspan="3" align="left" class="text_cray"><input type="text" name="renames" id="renames" /></td>
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
    <td height="2" background="../images/bottom_point.gif"></td>
  </tr>
  <tr>
    <td height="25" align="center" background="../images/bottom_ny_bg.gif" class="text_cray">copyright@12306 购票网</td>
  </tr>
</table>
</form>
<script type="text/JavaScript" src="../js/common.js"></script>
</body>
</html>
