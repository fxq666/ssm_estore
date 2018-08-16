<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="description" content="杰普电子商务门户">
		<title>杰普电子商务门户</title>
		<LINK href="css/main.css" rel=stylesheet>
		<script type="text/javascript" src="js/main.js"></script>
		<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	</head>
	<body onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="table2">
		  <tr>
		    <td align="left" width="7%" background="images/top_bg.gif"><img src="images/logo.gif" width="165" height="60"></td>
		    <td width="62%" background="images/top_bg.gif">　</td>
		    <td width="31%" background="images/top_bg.gif" align="right">
			<img src="images/top_r.gif" width="352" height="58" border="0"></td>
		  </tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td background="images/dh_bg.gif" align="left" height="12">
		      <table width="100" border="0" cellspacing="0" cellpadding="0" align="center">
		        <tr>
		          <td width="5%">　</td>
		          <td width="10%"><a href="index" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image1','','images/index_on.gif',1)">
					<img name="Image1" border="0" src="images/index.gif" width="90" height="36"></a></td>
		          <td width="10%"><a href="login.jsp" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image2','','images/reg_on.gif',1)">
					<img name="Image2" border="0" src="images/reg.gif" width="92" height="36"></a></td>
		          <td width="10%"><a href="login.jsp" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image4','','images/carts_on.gif',1)">
					<img name="Image4" border="0" src="images/cart.gif" width="92" height="36"></a></td>
		          <td width="10%"><a href="login.jsp" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image5','','images/order_on.gif',1)">
					<img name="Image5" border="0" src="images/order.gif" width="92" height="36"></a></td>
		          <td width="10%"><a href="login.jsp" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image6','','images/exit_on.gif',1)">
					<img name="Image6" border="0" src="images/exit.gif" width="92" height="36"></a></td>
		        </tr>
		      </table>
		    </td>
		  </tr>
		</table>
		<table cellspacing="1" cellpadding="3" align="center" border="0" width="98%">
		<tr>
		<td width="65%"><BR>
		>> 欢迎访问 <b>杰普电子商务门户</b> </td>
		<td width="35%" align="right">

		</td></tr></table>

	<script type="text/javascript">
	  function trim(str){//" *** "
			str = str.replace(/^\s*/,"");//"*** "去左边空格
			str = str.replace(/\s*$/,"");//"***"去右边空格
			return str;
		      }
     
</script>
 <script type="text/javascript">
	//整个页面加载完，，再加载js代码

	$(function(){
		//blur失去焦点
		$("#userid").blur(function(){
//			var $username = $("#userid").val();
// 		     var $username = this.value;
 		   
			var url = "${pageContext.request.contextPath}/customer/checkUsername/"+this.value;
			$.getJSON(url,function(data){
				//alert(data.status);
				if(data.status == 200){
					$("#fontID").html("<font color='#FF0000'>不存在此用户</font>");
					$("#button").attr("disabled", true); 
				}
				else{
				$("#fontID").html("");	
				}
			});
	      });
		$("#checkcode").keyup(function(){
			 var checkcode = this.value;
		    checkcode = trim(checkcode);
			   if(checkcode.length == 4){
				  var url = "${pageContext.request.contextPath}/customer/checkcode/"+checkcode;
					$.getJSON(url,function(data){
						if(data.status == 200){
							$("#imgID").html("<img src='images/MsgSent.gif' height='15px' width='15px'>");
							$("#button").attr("disabled", false);
						}
						else{
						$("#imgID").html("<img src='images/MsgError.gif' height='15px' width='15px'>");	
						$("#button").attr("disabled", true);
						}
					});
			   }
			   else{
				  $("#imgID").html("");
			   }
				
		});
	 	
		
	});
		
		</script>
		
		
	

<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="absmiddle">
                  <a href=index.jsp>杰普电子商务门户</a> → 用户登录
                </td>
                </tr>
		</table>
              <br>
       <center>
       <span>
       <font color="red" size="3px">${sessionScope.msg }</font>
       </span>
       <span>
       <font color="red" size="3px">${sessionScope.loginError }</font>
       </span>
       </center>
        <!-- 移除session中的msg -->
     <c:remove var="msg" scope="session"></c:remove>
     <c:remove var="loginError" scope="session"></c:remove>
	<form action="customer/login" method=post name="login">
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle colspan=2 align=center height=25 background="images/bg2.gif" ><font color="#ffffff"><b>输入您的用户名、密码登录</b></font></td>
		</tr>
		<tr>
		<td valign=middle class=tablebody1>请输入您的用户名</td>
			<td valign=middle class=tablebody1><INPUT id=userid  name=name type=text> &nbsp;
				<a href="register.jsp">没有注册？</a><span id="fontID"><font color='#FF0000'>*</font></span>
			</td>
		</tr>
		<tr>
			<td valign=middle class=tablebody1>请输入您的密码</td>
			<td valign=middle class=tablebody1><INPUT name=password type=password> &nbsp; </td>
		</tr>
		<tr>
			<td valign=middle class=tablebody1>请输入验证码</td>
			<td valign=middle class=tablebody1><INPUT name=checkcode type=text id=checkcode>&nbsp;
			<img src="01_img.jsp" height="24px"> <span id="imgID"></span> </td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center><input id="button" type=button value="登 录" onclick="javascript:checkMe()"></td>
		</tr>
		</table>
	</form>
<!--文件尾开始-->
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" height="28">
		  <tr>
		    <td height="17" background="images/bot_bg.gif">
		      　</td>
		  </tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
		  <tr>
		    <td bgcolor="#f1f1f6" height="53" valign="center">
			<p align="center">Copyright &copy;2004 - 2013 <a href="http://www.briup.com.cn"><b><font face="Verdana,">briup</font></b><font color=#CC0000>.com.cn</font></b></a><br>
			</td>
		  </tr>
		</table>
	</body>
</html>
