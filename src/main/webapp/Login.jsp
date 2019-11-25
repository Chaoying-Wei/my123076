<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>12306购票系统</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
</style>
<script language="javascript">
	//Login不能被框架嵌套，跳出框架的代码
	if (window != top)  top.location.href = location.href; 
	function UserRegistration(){
	window.navigate("UserRegistration.jsp");
	
	}
</script>
<script language="javascript"> 
	function UserLogin(){
	//location.href="Admin/Index.jsp"
	document.loginForm.submit();
	}
	
	function refleshCode(){
		var code=document.getElementById("validateCode");
		//验证码刷新原理：每次点击修改验证码图片src的地址，改成一个动态变化的地址，当img对象的src变化时，浏览器会自动刷新
		//在ajax编程时，经常也会使用随机地址刷新数据
		//注意：new Date().getTime();是JavaScript的代码不是java的代码
		code.src="ValidateCodeServlet?r="+new Date().getTime();
		
	}
	//取cookies     
	function getCookie(name){
	  let arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	  if (arr != null) return unescape(arr[2]); 
	  return null;
	}
	//删除cookie
	function delCookie(name){
	  var exp = new Date();
	  exp.setTime(exp.getTime() - 1);
	  var cval = getCookie(name);
	  if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
	}

	//退出自动登录的方法
	function logout(){
		//1、删除浏览器本地的cookie
		delCookie('reNames');
		//2、清除服务器中的session会话信息
		location.href="OutLoginServlet.do";
		
	}
	
</script>
<style type="text/css">
<!--
body {
	background-image: url(images/bg_point.gif);
}
-->
</style></head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
 <form name="loginForm" method="post" action="LoginServlet.do">
   <table width="933" border="0" align="center" cellpadding="0" cellspacing="0" style="margin:120px;">
  <tr>
    <td height="412" valign="top" background="images/bg_img1.jpg"><table height="300" border="0" cellspacing="0">
      <tr>
        <td width="538">&nbsp;</td>
        <td height="130" colspan="6">&nbsp;</td>
        </tr>
        
        <!-- start -->
        <%
        Cookie[] cookies=request.getCookies();
        boolean isAutoLogin=false;
        String reNames=null;
        if(cookies!=null){
        	 for(Cookie cookie:cookies){
             	String cname=cookie.getName();
             	//判断客户端有没有保存用户登录的账号
             	if("reNames".equals(cname)){
             		isAutoLogin=true;
             		reNames=cookie.getValue();
             		break;
             	}
             }
        }
       
        if(!isAutoLogin){
       
        %>
        
        
      <tr>
        <td rowspan="9">&nbsp;</td>
        <td width="98" height="20" align="right"><img src="images/text_yh.gif" width="60" height="18"></td>
        <td width="16">&nbsp;</td>
        <td width="136"><input name="reNames" type="text" id="reNames" size="18" /></td>
        <td width="55">&nbsp;</td>
        <td width="44">&nbsp;</td>
        <td width="32">&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right"><img src="images/text_password.gif" width="60" height="18"></td>
        <td>&nbsp;</td>
        <td><input name="rePass" type="password" id="rePass" size="18" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right">
        <img src="images/text_yzm.gif" width="60" height="18"></td>
        <td>&nbsp;</td>
        <td><input name="yanz" type="text" id="yanz" size="18" /></td>
        <td><span class="text_cray1">
        <img src="ValidateCodeServlet" id="validateCode" alt="" height="20" /></span></td>
        <td>
        <img src="images/text_sx.gif" onclick="refleshCode();" width="32" height="18"></td>
        <td align="left">&nbsp;</td>
      </tr>
      <tr>
        <td height="30">&nbsp;</td>
        <td>&nbsp;</td>
        <td valign="bottom"><table width="100%" border="0" cellspacing="0">
          <tr>
            <td width="26" align="left">
            <!-- 自动登录：自动登录与记住密码是两种不同的实现方式 -->
            <input name="autoLogin" type="checkbox" value="autovalue" style=" margin:0 auto;"/>
            </td>
            <td width="170"><img src="images/text_zddl.gif" width="60" height="18"></td>
          </tr>
        </table></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
        <td>&nbsp;</td>
        <td colspan="2">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
        <td>&nbsp;</td>
        <td colspan="2"><table width="200" border="0" cellspacing="0">
          <tr>
            <td width="78"><input name="button"  type="submit"  class="butlogin" id="button" value=""></td>
            <td>&nbsp;</td>
            <td width="78"><input name="button2"  type="submit"  class="butzc" id="button2"value="" onClick="UserRegistration()"></td>
          </tr>
        </table></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <%}else{ %>
      	 <tr>
      		<td rowspan="9">&nbsp;</td>
      		<td width="300" height="20" align="right"><%=reNames %>，欢迎您使用My12306购票系统</td>
    	</tr>
     	<tr>
     		 <td width="300" height="20" align="center"><a href="LoginServlet.do">进入系统</a></td>
    	</tr>
     	<tr>
     		 <td width="300" height="20" align="center"><a href="JavaScript:logout()">退出登陆</a></td>
    	</tr>
		<% 
      }
      %>
      <!-- end -->
      
      <tr>
        <td height="20">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
 </form>
</body>
</html>
