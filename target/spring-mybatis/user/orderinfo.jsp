<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="description" content="杰普电子商务门户">
		<title>杰普电子商务门户</title>
		<LINK href="../css/main.css" rel=stylesheet>
		<script language = "JavaScript" src = "../js/main.js"></script>
		<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	</head>
	<body onLoad="MM_preloadImages('../images/index_on.gif','../images/reg_on.gif','../images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="table2">
		  <tr>
		    <td align="left" width="7%" background="../images/top_bg.gif"><img src="../images/logo.gif" width="165" height="60"></td>
		    <td width="62%" background="../images/top_bg.gif">　</td>
		    <td width="31%" background="../images/top_bg.gif" align="right">
			<img src="../images/top_r.gif" width="352" height="58" border="0"></td>
		  </tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td background="../images/dh_bg.gif" align="left" height="12">
		      <table width="100" border="0" cellspacing="0" cellpadding="0" align="center">
		        <tr>
		          <td width="5%">　</td>
		          <td width="10%"><a href="../index" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image1','','../images/index_on.gif',1)">
					<img name="Image1" border="0" src="../images/index.gif" width="90" height="36"></a></td>
		          <td width="10%"><a href="../user/userinfo.jsp" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image2','','../images/reg_on.gif',1)">
					<img name="Image2" border="0" src="../images/reg.gif" width="92" height="36"></a></td>
		          <td width="10%"><a href="../shopcart.jsp" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image4','','../images/carts_on.gif',1)">
					<img name="Image4" border="0" src="../images/cart.gif" width="92" height="36"></a></td>
		          <td width="10%"><a href="../user/order.jsp" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image5','','../images/order_on.gif',1)">
					<img name="Image5" border="0" src="../images/order.gif" width="92" height="36"></a></td>
		          <td width="10%"><a href="../customer/logout" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image6','','../images/exit_on.gif',1)">
					<img name="Image6" border="0" src="../images/exit.gif" width="92" height="36"></a></td>
		        </tr>
		      </table>
		    </td>
		  </tr>
		</table>
		<table cellspacing="1" cellpadding="3" align="center" border="0" width="98%">
		<tr>
		<td width="65%"><BR>
		>>${customer.name } 欢迎访问 <b>杰普电子商务门户</b> </td>
		<td width="35%" align="right">

		</td></tr></table>



<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="../images/Forum_nav.gif" align="middle">
                  <a href=../index.html>杰普电子商务门户</a> →
					<a href="order.jsp">定单列表</a> →
					定单明细
                </td>
                </tr>
		</table>
              <br>

<%-- 		<form name="order" method="post" action="<%=basePath %>/user/alipay.index.jsp"> --%>
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="../images/bg2.gif">
			<font color="#ffffff"><b>用户信息</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right"><b>用户名</b>：</td>
			<td width="60%" class="tablebody1">${customer.name }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>联系地址</b>：</td>
			<td class="tablebody1">${customer.address }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>邮编</b>：</td>
			<td class="tablebody1">${customer.zip }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>家庭电话</b>：</td>
			<td class="tablebody1">sdfadsf</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>办公室电话</b>：</td>
			<td class="tablebody1">sdfadsfa</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>手机</b>：</td>
			<td class="tablebody1">${customer.telephone }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>Email地址</b>：</td>
			<td class="tablebody1">${customer.email }</td>
		</tr>
	</table>
<br>
<!--文件尾开始-->
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table2">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="../images/bg2.gif">
			<font color="#FFFFFF"><b>付款方式</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right">　</td>
			<td width="60%" class="tablebody1">${order2.payway }</td>
		</tr>
		</table>
		<br>
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1 id="table3">
		<tr>
			<td valign=middle align=center height=25 background="../images/bg2.gif" colspan="5">
			<font color="#ffffff"><b>商品购物清单</b></font></td>
		</tr>
              
		        
		 <c:forEach items="${setLine}" var="line" varStatus="varstatus">      
		<tr>
			<td class=tablebody2 valign=middle align=center width=""><input type="hidden" name="orderid" value="${varstatus.count }">${varstatus.count }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="../productDetail.jsp?productid=2" target="_blank">${line.book.name}</a></td>
			<td class=tablebody2 valign=middle align=center width="">价格：${line.book.price}</td>
			<td class=tablebody1 valign=middle align=center width="">数量：${line.num}</td>
			<td class=tablebody2 valign=middle align=left width="">小计：${line.book.price*line.num}</td>
		</tr>
                </c:forEach>
                
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width="">合计：<font color="#ff0000"><b>${order2.cost }</b></font></td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width=""><input id="payId" type="submit" value="扫码支付"/></td>
		</tr>
		        </table>
<!-- 		</form> -->
		<br>
</p>

		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" height="28">
		  <tr>
		    <td height="17" background="../images/bot_bg.gif">
		      　</td>
		  </tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
		  <tr>
		    <td bgcolor="#f1f1f6" height="53" valign="center">
			<p align="center">Copyright &copy;2004 - 2013 <a href="http://www.briup.com.cn"><b><font face="Verdana,">briup</font></b><font color=#CC0000>.com.cn</font></b><br>
			</td>
		  </tr>
		</table>
		<script type="text/javascript">
		$(function(){
			alert("#payId");
			$("#payId").click(function(){
				var url = "${pageContext.request.contextPath}/order/deleteOrder/${order2.id}";
				alert(url);
				$.getJSON(url,function(data){
					if(data.status == 200){
						window.location.href='<%=basePath %>/user/alipay.index.jsp';
					}
				});	
			});
			});
		</script>
	</body>
</html>
