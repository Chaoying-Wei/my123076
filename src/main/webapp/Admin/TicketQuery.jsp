<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.neuedu.my12306.bean.TicketBean"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车票管理</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
<script language="javascript">
	function UserAdd(){
	
	
	window.navigate(<%=request.getContextPath()%>"/Admin/UserInfo_Add.jsp");
	
	}
</script>

<script>
function selectAllNullorReserve(obj,type){
   if(obj!=null&&obj!=""){
    if(document.getElementsByName(obj)!=undefined&&document.getElementsByName(obj).length>0){	//getElementsByName函数的作用按名字查找对象，返回一个数组。
     var userids = document.getElementsByName(obj);
     if(type=="全选"){
      for(var i=0;i<userids.length;i++){
       if(userids[i].checked == false){
        userids[i].checked = true;
       }
      }
     }else if(type=="全不选"){
      for(var i=0;i<userids.length;i++){
       if(userids[i].checked == true){
        userids[i].checked = false;
       }
      }
     }else if(type=="反选"){
      for(var i=0;i<userids.length;i++){
       if(userids[i].checked == true){
        userids[i].checked = false;
       }else{
        userids[i].checked = true;
       }
      }
     }
    }
   }  
}
function changePage(p){
	//dom解析
	var sizes=document.getElementById("pageSize").value;
	//使用JavaScript把分页参数传递回服务器
	location.href="<%=request.getContextPath()%>/TicketSerlvet.do?page="+p+"&size="+sizes;
}
function deleteById(){
	var form=document.TicketForm;
	form.action="<%=request.getContextPath()%>/TicketDeleteByIdServlet.do";
	//多选框效验
	var ticketIds =form.ticketId;
	var flag=false;
	for(var i=0;i<ticketIds.length;i++){
	    if(ticketIds[i].checked == true){
	      flag=true;
	      break;
	     }
	  }
	if(flag){
		if(confirm("确认删除同时这些这票信息吗？")){
			form.submit();
		}
		
	}else{
		alert("请选择需要删除的车票信息！！！");
	}
	
}
</script>
</head>
<body class="write_bg">
 <form name="TicketForm" method="post" action="">

<table width="1107" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"></td>
  </tr>
</table>
<table width="850" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" colspan="2" ></td>
  </tr>
  <tr>
    <td width="13" height="30" align="left" valign="top"  ></td>
    <td width="822" align="left" valign="top"  class="text_blod_title">车票管理</td>
  </tr>
  <tr>
    <td height="15" colspan="2" align="center" ><img src="<%=request.getContextPath()%>/images/line.jpg" width="850" height="6"></td>
  </tr>
  <tr>
    <td height="15" colspan="2"  ></td>
  </tr>
</table>
<table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="835" background="<%=request.getContextPath()%>/images/wb_01 (3).jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="5"></td>
        <td width="8%" align="center" class="text_cray1">起始站</td>
        <td width="10%" align="left" class="text_cray1"><label>
          <select class="text_cray" name="loginUserDTO.id_type_code" id="cardType">
            <option value="广州南">广州南</option>
            <option value="深圳 ">深圳 </option>
            <option value="柳州">柳州</option>
            <option value="桂林">桂林</option>
          </select>
        </label></td>
        <td width="8%" align="center" class="text_cray1">终点站</td>
        <td width="10%" align="left" class="text_blod"><label>
          <select class="text_cray" id="passengerType" name="passenger_type" style="width:100px">
            <option value="桂林">桂林</option>
            <option value="深圳 ">深圳 </option>
            <option value="柳州">柳州</option>
            <option value="广州南">广州南</option>
          </select>
        </label></td>
        <td width="10%"  align="center" class="text_cray1">出发日期</td>
        <td width="10%" align="left" class="text_cray1"><label>
          <input class="Wdate" type="text" name="startTime" id="startTime" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})">
        </label></td>
        <td width="10%"  align="center" class="text_cray1">出发时刻</td>
        <td width="10%" align="left" class="text_cray1"><label>
          <input class="Wdate" type="text" name="startTime" id="startTime" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
        </label></td>
        <td width="8%" align="center" valign="middle" class="text_craybold"><label>
          <input name="Submit" type="submit" class="butcx" value="">
        </label></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="20" colspan="11" align="center">&nbsp;</td>
      </tr>
    </table>
        <table width="553" border="1" align="center" cellpadding="0" cellspacing="1" bordercolor="#dadada" bgcolor="#FFFFFF">
          <tr align="center">
            <td width="44" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1">选择</td>
            <td width="80" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">车票id</td>
            <td width="80" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">起始站</td>
            <td width="80" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">终点站</td>
            <td width="100" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">出发日期</td>
            <td width="100" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">发车时刻</td>
            <td width="80" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">用户账号</td>
            <td width="80" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">操作</td>
          </tr>
          <tr align="center">
            <td height="15" colspan="7" bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1"><img src="<%=request.getContextPath()%>/images/line1.jpg" width="790" height="6"></td>
          </tr>
          
        
          <c:forEach items="${ticketlist}" var="ticketBean" varStatus="ticketStatus">
          	<c:if test="${ticketStatus.index%2==0}">
         	 <tr align="center" bgcolor="#FFFFFF">
            </c:if>
            <c:if test="${ticketStatus.index%2==1}">
         	 <tr align="center" bgcolor="#F5F5F5">
            </c:if>
            <td bordercolor="#FFFFFF"   class="text_cray1">
            <input type="checkbox" name="ticketId" value="${ticketBean.ticketId}"></td>
            <td width="80" bordercolor="#FFFFFF"  class="text_cray1">${ticketBean.ticketId}</td>
            <td width="80" bordercolor="#FFFFFF"  class="text_cray1">${ticketBean.startStation}</td>
            <td width="80" bordercolor="#FFFFFF"  class="text_cray1">${ticketBean.endStation}</td>
            <td width="100" bordercolor="#FFFFFF"  class="text_cray1">${ticketBean.startDate}</td>
            <td width="100" bordercolor="#FFFFFF"  class="text_cray1">${ticketBean.startTime}</td>
            <td width="80" bordercolor="#FFFFFF"  class="text_cray1">${ticketBean.renames}</td>
            <td width="80" bordercolor="#FFFFFF"  class="text_cray1"><a href="<%=request.getContextPath()%>/TickByIdServlet.do?ticketId=${ticketBean.ticketId}" class="text_red">编辑</a></td>
          </tr>
         </c:forEach>
        </table>
      <br>
        <table width="773" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr align="center">
            <td width="102" align="left"  class="text_cray1"><a href="#">
              <label></label>
              <label></label>
              <label>
              <input type="checkbox" name="checkbox2" value="11"  onclick="selectAllNullorReserve('ticketId','反选');" ><span class="text_blue">全选</span></label>
            </a></td>
            <td width="525" align="right"  class="text_cray1"><a href="#">
              <!--<input type="button" name="Submit23" value="新增" onClick="UserAdd()"> -->
            </a></td>
            <td width="55" align="right"  class="text_cray1"><a href="#">
              <input name="Submit22" type="button" class="butsc" value="" onclick="deleteById()">
            </a></td>
            <td width="91" align="right"  class="text_cray1"><label>
              <input name="Submit3" type="submit" class="butdc" value="">
            </label></td>
          </tr>
        </table>
      <br>
        <table width="773" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr align="center" style="width:60%">
            <td width="335" align="center"  class="text_cray">&nbsp;</td>
            <td width="284" align="center"  class="text_cray">
             
             >> 
            <%
           Integer pages=(Integer) request.getAttribute("pages");
          Integer prePage=(Integer) request.getAttribute("prePage");
          Integer nextPage=(Integer) request.getAttribute("nextPage");
          Integer size=(Integer) request.getAttribute("size");
          if(pages!=null){
        	  for(int i=1;i<=pages;i++){
        		  out.print( "<a href=\"javascript:changePage("+i+")\">"+ i +"</a>  ");

        	  }
          } 
          
          %>
             &lt;&lt; </td>
            <td width="154" align="right"  class="text_cray1" style="width:20%"><label class="text_cray"> 每页显示
                 <select name="pageSize" id="pageSize" >
                    <option <%=size==5?"selected":"" %> value="5">5</option>
                    <option <%=size==10?"selected":"" %> value="10">10</option>
                    <option <%=size==15?"selected":"" %> value="15">15</option>
                  </select>
            条信息</label></td>
          </tr>
        </table>
      <br></td>
  </tr>
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
</body>
</html>
