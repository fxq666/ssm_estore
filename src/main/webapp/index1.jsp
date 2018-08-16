<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="description" content="杰普电子商务门户">
		<title>杰普电子商务门户</title>
		<LINK href="css/main.css" rel=stylesheet>
		<script type="text/javascript"  src = "js/main.js"></script>
		<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
		<style type="text/css">
		.myClass{
			color:inactivecaption
		}
	</style>
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
		          <td width="10%"><a id="userinfoId" href="javascript:;" onclick="checkSession()" onMouseOver="MM_swapImage('Image2','','images/reg_on.gif',1)">
					<img name="Image2" border="0" src="images/reg.gif" width="92" height="36"></a></td>
		          <td width="10%"><a id="shopId" href="javascript:;" onclick="checkshopSession()" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image4','','images/carts_on.gif',1)">
					<img name="Image4" border="0" src="images/cart.gif" width="92" height="36"></a></td>
		          <td width="10%"><a id="OrderId" href="javascript:;" onclick="checkorderSession()"onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image5','','images/order_on.gif',1)">
					<img name="Image5" border="0" src="images/order.gif" width="92" height="36"></a></td>
		          <td width="10%"><a href="customer/logout" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image6','','images/exit_on.gif',1)">
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
<!-- <c:import url="header.jsp"></c:import> -->
<script type="text/javascript">
function checkSession() {
	//点击超链接
	if("${sessionScope.customer.name}".length == 0)
		{
		var name = "fail";
		}
	$("#userinfoId").click(function(){   
		var url = "${pageContext.request.contextPath}/checkSession/"+ name;
		$.getJSON(url,function(data){
			//alert(data.status);
			if(data.status == 500){
				alert("用户未登录，请先登录");
				window.location.href='${pageContext.request.contextPath}/login.jsp';	
			}
			else{
				//alert("登录");
				window.location.href='${pageContext.request.contextPath}/user/userinfo.jsp';	
			}
		});
      });
}
	
function checkshopSession() {
	//点击超链接
	if("${sessionScope.customer.name}".length == 0)
		{
		var name = "fail";
		}
	$("#shopId").click(function(){   
		var url = "${pageContext.request.contextPath}/checkSession/"+ name;
		$.getJSON(url,function(data){
			//alert(data.status);
			if(data.status == 500){
				alert("用户未登录，请先登录");
				window.location.href='${pageContext.request.contextPath}/login.jsp';	
			}
			else{
				//alert("登录");
				window.location.href='${pageContext.request.contextPath}/shopcart.jsp';	
			}
		});
      });
}
	
function checkorderSession() {
	//点击超链接
	if("${sessionScope.customer.name}".length == 0)
		{
		var name = "fail";
		}
	$("#OrderId").click(function(){   
		var url = "${pageContext.request.contextPath}/checkSession/"+ name;
		$.getJSON(url,function(data){
			//alert(data.status);
			if(data.status == 500){
				alert("用户未登录，请先登录");
				window.location.href='${pageContext.request.contextPath}/login.jsp';	
			}
			else{
				//alert("登录");
				window.location.href='${pageContext.request.contextPath}/order/show';	
			}
		});
      });
}
	


</script>



	<script type="text/javascript">
		//当浏览器加载web页面时
		$(function(){
			//将文本框中的文本样式改变
			$("#findbookId").addClass("myClass");
		});
		//当光标定位文本框时
		$("#findbookId").live('focus',function(){
			//清空文本框中的内容
			$(this).val("");
			//删除文本框的样式
			$(this).removeClass("myClass");
		});
		
		//当文本框失去焦点时
		$("#findbookId").live('blur',function(){
			//获取文本框中填入的内容
			var content = $(this).val();
			//去二边的空格
			content = $.trim(content);
			//如果没填了内容
			if(content.length == 0){
				//在文本框显示提示信息
				$("#findbookId").val("请输入书名");
				//设置文本框中文本的样式
				$("#findbookId").addClass("myClass");
			}
			else{
				
				window.location.href='${pageContext.request.contextPath}/queryBook?name='+content;
			}
		});
	</script>

<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					欢迎<font color="red">${sessionScope.customer.name }</font>光临！
                </td>
                </tr>
		</table>
              <br>
<center>
       <span>
       <font color="red" size="5px">${sessionScope.loginmsg }</font>
       </span>
       </center>
       <c:remove var="loginmsg" scope="session"></c:remove>
       
       <table cellpadding=3 cellspacing=1 align=center class=tableborder1>
       <tr> <td valign=left align=left height=25 background="images/bg2.gif" width="">
       <font color="#ffffff">搜索:</font><input type="text" id="findbookId" value="请输入书名">
     
       </td></tr>
       </table>
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
                

               <c:forEach items="${sessionScope.pageinfo }" var="book" varStatus="status">    
		<tr>
			<td class=tablebody2 valign=middle align=center width="">${status.index+1 }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.jsp">${book.name }</a></td>
			<td class=tablebody2 valign=middle align=center width="">${book.price }</td>
			<td class=tablebody1 valign=middle align=center width=""><a  href="shopping/add?id=${book.id }&name=${book.name }&price=${book.price }" >
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
		</tr>

		
		</c:forEach> 
		
		
		</table>

		
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
			<p align="center">Copyright &copy;2004 - 2013 <a href="http://www.briup.com"><b><font face="Verdana,">briup</font></b><font color=#CC0000>.com</font></b></a><br>
			</td>
		  </tr>
		</table>
	</body>
</html>