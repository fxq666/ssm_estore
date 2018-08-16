<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'qrcode.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	    body{ text-align:center} 
    .divcss5{margin:0 auto;border:0px solid #000;width:500px;height:200px} 
     .divcss6{margin:0 auto;border:0px solid #000;width:500px;height:30px; position:relative; left:-100px} 
    .div-inline{ float:left} 
	</style>
  </head>
  
  <body>

  <!-- 导入qrcode 和jquery -->
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
	 <div class="divcss6">支付宝扫码支付&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  微信扫码支付(研发中)</div>
	<div class="divcss5">
<div id="qrcodeTable" class="div-inline"></div ><div class="div-inline">&nbsp;&nbsp;&nbsp;&nbsp;</div>
<div id="qrcodeCanvas"  class="div-inline"></div>
</div>
 <input id="pageMsgNum" name="pageMsgNum" type="hidden"/>
<span id="msgNum" style="color: red;"></span>
  
  
  
  
 <script>
	
	jQuery('#qrcodeTable').qrcode({
		width       : 150,
        height      : 150,
        typeNumber  : -1,
        correctLevel    : 1,
		render	: "table",
		text	:  "${qrcode}",
	});	
	jQuery('#qrcodeCanvas').qrcode({
		width       : 150,
        height      : 150,
        typeNumber  : -1,
        correctLevel    : 1,
		text	: "https://qr.alipay.com/bax02520ntwh1codx6m800cc"
			
	});	
	

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
	});
		

  </body>
</html>
