<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 这是标签库指令：prefix配置标签的前缀，可以自定义名称；uri配置标签的标记或标签地址  -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息修改</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet" type="text/css">
</head>

<body class="write_bg">
<!--  1、在form表单中，如果需要执行上传文件（既包含文件域），需要修改form表单的默认编码格式为：enctype="multipart/form-data"
	  2、修改默认编码后，不能再servlet直接使用request.getparament()方法获取参数，每一个输入项都是以文件流（不在以字符串）形成传递的
	  3、
 -->
<form enctype="multipart/form-data" action="EditUserServlet.do" method="post" name="userFrom">
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
    <td width="64" ></td>
    <td width="794" height="30" valign="top" class="text_blod_title">修改个人信息</td>
  </tr>
  <tr>
    <td height="15" colspan="2" ><img src="<%=request.getContextPath()%>/images/line1.jpg" width="835" height="6"></td>
    </tr>
  <tr>
    <td colspan="2" background="<%=request.getContextPath()%>/images/wb_01 (3).jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="64">&nbsp;</td>
        <td width="771" height="25" align="left" class="text_cray">注：标有 <span class="text_red">*</span> 处，均为必填项</td>
      </tr>
      <tr>
        <td height="20" colspan="2">&nbsp;</td>
        </tr>
    </table>
    
        <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="15" colspan="4" align="left" class="text_title">登录信息</td>
          </tr>
          <tr>
            <td height="10" colspan="4" ></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red1"></td>
            <td width="100" height="40" align="left" class="text_cray1">登录名：</td>
            <td class="text_cray">
            <!-- readonly和disabled都是只能读不能修改；但是readonly可以把表单域的数据提交到服务器，而disabled不可以 -->
            <input type="text" name="reNames" id="reNames" readonly="readonly" disabled value="${reNames.reNames}"/>
            <!-- 对于不能修改的数据，可以使用readonly进行限制或者使用隐藏域进行提交数据 -->
             <input type="hidden" name="reNames" id="reNames" value="${reNames.reNames}"/>
          
            </td>
            <td width="239" rowspan="6" align="center" >
            <c:if test="${empty reNames.img}">
             <img  src="<%=request.getContextPath()%>/images/photo.jpg" width="120" height="120"></td>
          
            </c:if>
            <c:if test="${not empty reNames.img}">
             <img  src="<%=request.getContextPath()%>/${reNames.img}" width="120" height="120"></td>
          
            </c:if>
           </tr>
          <tr>
            <td width="20" align="center" class="text_red1"></td>
            <td width="100" height="40" align="left" class="text_cray1">密码初始化：</td>
            <td class="text_cray"><label>
              <input name="Submit" type="submit" class="text_cray" value="密码初始化">
            </label></td>
          </tr>
          <tr>
            <td height="20" colspan="3"></td>
          </tr>
          <tr>
            <td height="15" colspan="3" align="left" class="text_title">权限设置</td>
          </tr>
          <tr>
            <td height="10" colspan="3"></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">用户权限：</td>
            <td>
            <!-- 使用jsp标签库进行数据显示控制：jstl  -->
            <select name="isAdmin" class="text_cray" id="isAdmin">
	            <c:if test="${reNames.isAdmin eq 1 }">
	            	<option selected value="1">管理员</option>
                	<option value="0">普通用户</option>
	            </c:if>
                <c:if test="${reNames.isAdmin eq 0 }">
	            	<option  value="1">管理员</option>
                	<option selected value="0">普通用户</option>
	            </c:if>
            </select>            
            </td>
          </tr>
        </table>
      <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="6"></td>
          </tr>
          <tr>
            <td height="15" colspan="6" align="left" class="text_title">详细信息</td>
          </tr>
          <tr>
            <td height="10" colspan="6" ></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">真实姓名：</td>
            <td colspan="4" class="text_cray">
            <input name="reTrueName" type="text" class="text_cray" id="reTrueName" value="${reNames.reTrueName}"/></td>
          </tr>
           <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">用户头像：</td>
            <td colspan="4" class="text_cray">
            <input name="file1" type="file" class="text_cray" id="file1" value=""/></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">性 别：</td>
            <td colspan="4" class="text_cray">
            <span class="mr25">
            <c:if test="${reNames.sex eq '男' }">
            	<input type="radio" name="sex" value="男"  checked="checked"/>
             	<label>男</label>
             	 </span> <span>
                <input type="radio" name="sex" value="女" />
             	 <label>女</label>
            </c:if>
            <c:if test="${reNames.sex eq '女' }">
            	<input type="radio" name="sex" value="男"  />
             	<label>男</label>
             	 </span> <span>
                <input type="radio" name="sex" value="女" checked="checked" />
             	 <label>女</label>
             	 
            </c:if>
               </span> 
               </td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">省份：</td>
            <td width="106"><label>
              <select name="province" class="text_cray" id="province">
                <option value="省份" selected="selected">省份</option>
              </select>
            </label>            </td>
            <td width="24" align="left"  class="text_cray">&nbsp;</td>
            <td width="43" align="left"  class="text_cray">城市：</td>
            <td width="407" align="left" class="text_cray"><label>
              <select name="city" class="text_cray" id="city">
                <option value="市县" selected="selected">市县</option>
              </select>
            </label>            </td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">证件类型：</td>
            <td colspan="4" >
            <select class="text_cray" name="cardTpye" id="cardTpye">
            <c:if test="${reNames.cardTpye eq '1' }">
           		<option value="1" selected >二代身份证</option>
                <option value="C">港澳通行证</option>
                <option value="G">台湾通行证</option>
                <option value="B">护照</option>
            </c:if>
            <c:if test="${reNames.cardTpye eq 'C' }">
           		<option value="1" >二代身份证</option>
                <option value="C" selected >港澳通行证</option>
                <option value="G">台湾通行证</option>
                <option value="B">护照</option>
            </c:if>
            <c:if test="${reNames.cardTpye eq 'G'}">
           		<option value="1" >二代身份证</option>
                <option value="C">港澳通行证</option>
                <option value="G" selected >台湾通行证</option>
                <option value="B">护照</option>
            </c:if>
            <c:if test="${reNames.cardTpye eq 'B' }">
           		<option value="1" >二代身份证</option>
                <option value="C">港澳通行证</option>
                <option value="G">台湾通行证</option>
                <option value="B" selected >护照</option>
            </c:if>
                
            </select>           
             </td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">证件号码：</td>
            <td colspan="4" class="text_cray">
            <input type="text" name="idNumber" id="idNumber" value="${reNames.idNumber}" /></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">出生日期：</td>
            <td colspan="4" class="text_cray">
            <input type="date" name="borthday" id="borthday" value="${reNames.birthday}" /></td>
          </tr>
          <tr>
            <td width="20" align="center">&nbsp;</td>
            <td width="100" height="40" align="left" class="text_cray1">旅客类型：</td>
            <td colspan="4" class="text_cray">
            <select class="text_cray" id="passengerType" name="passengerType">
            <c:if test="${reNames.passengerType eq '成人'}">
            	<option value="成人" selected>成人</option>
                <option value="儿童">儿童</option>
                <option value="学生">学生</option>
                <option value="残疾军人">残疾军人、伤残人民警察</option>
            </c:if>
            <c:if test="${reNames.passengerType eq '儿童'}">
            	<option value="成人" >成人</option>
                <option value="儿童" selected>儿童</option>
                <option value="学生">学生</option>
                <option value="残疾军人">残疾军人、伤残人民警察</option>
            </c:if>
            <c:if test="${reNames.passengerType eq '学生'}">
            	<option value="成人" >成人</option>
                <option value="儿童">儿童</option>
                <option value="学生" selected>学生</option>
                <option value="残疾军人">残疾军人、伤残人民警察</option>
            </c:if>
            <c:if test="${reNames.passengerType eq '残疾军人'}">
            	<option value="成人" >成人</option>
                <option value="儿童">儿童</option>
                <option value="学生">学生</option>
                <option value="残疾军人" selected>残疾军人、伤残人民警察</option>
            </c:if>
                
            </select>            
            </td>
          </tr>
          <tr>
            <td height="10" colspan="6" >&nbsp;</td>
          </tr>
          <tr>
            <td width="20" align="center">&nbsp;</td>
            <td height="15" align="left" class="text_cray1">备注：</td>
            <td height="15" colspan="4">
            
            <textarea name="tips" rows="8" class="text_cray" style="width:100%"  ><c:out value="${reNames.tips}"></c:out>
            </textarea>
            </td>
          </tr>
        </table>
      <table width="100%" border="0" cellspacing="0">
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table>
    </table>
  <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="164">&nbsp;</td>
      <td width="99" height="30" align="center"><input name="button" type="submit" class="buttj" id="button"value=""></td>
      <td width="98" align="center">&nbsp;</td>
      <td width="97" align="center"><input name="button2" type="reset" class="butcz" id="button2"value=""></td>
      <td width="92" align="center">&nbsp;</td>
    </tr>
  </table>  
  <table width="100%" border="0" cellspacing="0">
  <tr>
    <td height="20">&nbsp;</td>
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
</td>
  </tr>
</table>
</form>

<script type="text/JavaScript" src="<%=request.getContextPath()%>/js/common.js"></script>
</body>
</html>
