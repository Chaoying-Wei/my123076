<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册信息</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	//不能被框架嵌套，跳出框架的代码
	if (window != top)  top.location.href = location.href; 
	
	//使用ajax检查用户账号是否已经被使用
	function checkUserName(){
		//1、获取用户输入的用户名
		var reNames=$("input[name='reNames']").val();
		var pamtt=/^[A-Za-z0-9_]{6,30}$/;
		if(!pamtt.exec(reNames)||reNames==" "){
			$("#userNameMSG").html("<font color='red'>用户名必须由字母、数字或“_”组成，长度不少于6位，不多于30位</font>")
		}else{
			//2、在后台发送到服务器端进行检查
			var url="CheckUserNameServlet?reNames="+reNames;
			$.get(url,callback);
			//3、得到服务器端返回的检查结果
			//4、进行用户操作提示
		}
		
	}
	//回调函数，当ajax执行完毕，从服务器端收到数据后自动调用,参数data用于接收服务器返回的数据
	function callback(data){
		//得到服务器端返回的检查结果
		var v=JSON.stringify(data);
		//进行用户操作提示
		if(data.result){
			$("#userNameMSG").html("<font color='red'>"+data.msg+"</font>");
		}else{
			$("#userNameMSG").html("<font color='green'>"+data.msg+"</font>");
		}
		
	}
	function checkPass(){
		//1、获取用户输入的密码
		var rePass=$("input[name='rePass']").val();
		var pamtt=/^[0-9A-Za-z]{6,}$/;
		if(!pamtt.exec(rePass)){
			$("#passMSG").html("<font color='red'>密码不能不少于6位字符</font>");
		}else{
			$("#passMSG").html("<font color='green'>该密码合法</font>");
		}
	}
	function confirmPass(){
		//1、获取用户输入的密码
		var rePass=$("input[name='rePass']").val();
		//1、获取用户再次输入的密码
		var confirmPass=$("input[name='confirmPass']").val();
		 alert(rePass);
		 alert(confirmPass);
		if(rePass!=confirmPass){
			$("#confirmPassMSG").html("<font color='red'>密码不一致</font>");
		}else{
			$("#confirmPassMSG").html("<font color='green'> </font>");
		}
	}
	
	function idNumberT(){
		//1、获取用户输入的身份证号
		var idNumber=$("input[name='idNumber']").val();
		var pamtt=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if(!pamtt.exec(idNumber)){
			$("#idNumberMSG").html("<font color='red'>无效的身份证号码</font>");
		}else{
			$("#idNumberMSG").html("<font color='green'> </font>");
		}
	}

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form action="ReUserServlet.do" method="post">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2" background="images/ny_top_img_bg.gif"><img src="images/ny_top_img.gif" width="650" height="108"></td>
    </tr>
  <tr>
    <td width="75" height="23" bgcolor="#deedf8">&nbsp;</td>
    <td width="958" align="left" bgcolor="#deedf8" class="text_cray1">当前位置:注册信息　</td>
    </tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="images/bg_point_write.gif"><table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="30" colspan="2" align="center">&nbsp;</td>
        </tr>
      <tr>
        <td width="41" height="7" align="center">&nbsp;</td>
        <td width="794" height="30" align="left" valign="top"><span class="text_blod_title">注册信息</span></td>
      </tr>
      <tr>
        <td height="15" colspan="2" align="center"><img src="images/line1.jpg" width="835" height="6"></td>
      </tr>
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="5%">&nbsp;</td>
            <td width="95%" align="left" class="text_cray">注：标有 <span class="text_red">*</span> 处，均为必填项</td>
          </tr>
          <tr>
            <td height="15" colspan="2">&nbsp;</td>
            </tr>
          
        </table>
          <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30" colspan="4" align="left" class="text_red1"><span class="text_title">登录信息</span></td>
                </tr>
          
          <tr>
            <td width="19" align="center" class="text_red">*</td>
                  <td width="98" height="40" align="left" class="text_cray1">登录名：</td>
                  <td width="160" align="left" class="text_cray1">
                  <input name="reNames" onblur="checkUserName()" type="text" class="text_cray" id="reNames" /></td>
                  <td id="userNameMSG" width="423" height="35" align="left" class="text_cray">由字母、数字或“_”组成，长度不少于6位，不多于30位</td>
                </tr>
          <tr>
            <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">密码：</td>
                  <td align="left" class="text_cray1">
                  <input name="rePass" onblur="checkPass()" type="password" class="text_cray" id="rePass" /></td>
                  <td height="35" id="passMSG"   align="left" class="text_cray">不少于6位字符</td>
                </tr>
          <tr>
            <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">确认密码：</td>
                  <td align="left" class="text_cray1">
                  <input name="confirmPass" onblur="confirmPass()" type="password" class="text_cray" id="confirmPass" /></td>
                  <td id="confirmPassMSG" height="35" align="left" class="text_cray">请再次输入密码</td>
                </tr>
        </table>
          <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td height="35" colspan="5" align="left" class="text_red1"><span class="text_title">详细信息</span></td>
                </tr>
            
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">真实姓名：</td>
                  <td height="35" colspan="3" align="left">
                  <input name="reTrueName" type="text" class="text_cray" id="reTrueName" /></td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">性 别：</td>
                  <td height="35" colspan="3" align="left" class="text_cray1">
                    <span class="mr25">
                    <input type="radio" name="sex" value="男" checked="checked" />
                    </span>
                    <span class="text_cray">
                    <label>男</label>
                    <input type="radio" name="sex" value="女" />
                    <label>女</label>
                    </span>
                    <label></label>
                    <span><label></label>
                  </span>				</td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">省份：</td>
                  <td width="104" height="35" align="left"><label>
                    <select name="province" class="text_cray" id="province">
                      <option value="省份" selected="selected">省份</option>
                    </select>
                  </label></td>
                  <td width="43" height="35" align="left"  class="text_cray">城市：</td>
                  <td width="436" height="35" align="left" class="text_cray"><label>
                    <select name="city" class="text_cray" id="city">
                      <option value="城市" selected="selected">市县</option>
                    </select>
                  </label></td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">证件类型：</td>
                  <td height="35" colspan="3" align="left">
                    <select class="text_cray" name="cardTpye" id="cardType">
                      <option value="1">二代身份证</option>
                      <option value="C">港澳通行证</option>
                      <option value="G">台湾通行证</option>
                      <option value="B">护照</option>
                  </select>				</td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">证件号码：</td>
                  <td height="35" colspan="3" align="left">
                  <input name="idNumber" onblur="idNumberT()" type="text" class="text_cray" id="idNumber" /></td>
                  <td id="idNumberMSG" height="20" width="170" align="left" class="text_cray"></td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">出生日期：</td>
                  <td height="35" colspan="3" align="left">
                  <input name="borthday" type="date" class="text_cray" id="borthday" /></td>
                </tr>
            
            <tr>
              <td width="19" align="center">&nbsp;</td>
                  <td width="98" height="40" align="left" class="text_cray1">旅客类型：</td>
                  <td height="35" colspan="3" align="left">
                    <select class="text_cray" id="passengerType" name="passengerType">
                    <option value="成人">成人</option>
                      <option value="儿童">儿童</option>
                      <option value="学生">学生</option>
                      <option value="残疾军人、伤残人民警察">残疾军人、伤残人民警察</option>
                  </select>				</td>
                </tr>
            <tr>
              <td height="10" colspan="5" align="center">	</td>
	            </tr>
            
            <tr>
              <td width="19" align="center">&nbsp;</td>
                  <td width="98" height="30" align="left" class="text_cray1">备注：</td>
                  <td colspan="3" align="left" height="80">
                  <textarea name="tips" rows="8" class="text_cray" style="width:100%"></textarea></td>
                </tr>
            
            <tr>
              <td align="center">&nbsp;</td>
                  <td height="30" align="left" class="text_cray1"></td>
                  <td height="50" colspan="3" align="left" valign="middle" class="text_cray1">
                  <input type="checkbox" class="check" id="checkAgree" /> 
                  我已阅读并同意遵守				<a href="/otn/regist/rule;jsessionid=FA97B306AACF75E37DD4D10CFD59994A" class="ft14" target="_blank" shape="rect"> 《中国铁路客户服务中心网站服务条款》</a></td>
                </tr>
          </table> <br>        
          <table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="234">&nbsp;</td>
                  <td width="147" height="30" align="center"><input name="button3" type="submit" class="buttj" id="button3" value=""></td>
                  <td width="141" align="center">&nbsp;</td>
                  <td width="147" align="center"><input name="button4" type="reset" class="butcz" id="button4" value=""></td>
                  <td width="166" align="center">&nbsp;</td>
                </tr>
              </table></td>
      </tr>
      </table></td>
  </tr>
</table><br>

<table width="100%" border="0" cellspacing="0">
<tr>
    <td height="2" background="images/bottom_point.gif"></td>
  </tr>
  <tr>
    <td height="25" align="center" background="images/bottom_ny_bg.gif" class="text_cray">copyright@12306 购票网</td>
  </tr>
</table>
</form>
<script type="text/JavaScript" src="js/common.js"></script>
</body>
</html>
