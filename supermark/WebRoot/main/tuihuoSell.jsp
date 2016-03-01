<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<s:actionerror cssStyle="color:red" />
	<b style="color: red">最多只能退货 ： <s:property value="#request.sellStock.sellNumber" /></b>
	<br>
	<br>
	<br>
	<form action="sell/addTuihuoSell" method="post">
	 <input type="hidden" class="form-control"  name="tuiHuoSellStock.stockId" value="<s:property value="#request.sellStock.stockId"/>">
	 <input type="hidden" class="form-control"  name="tuiHuoSellStock.sellPrice" value="<s:property value="#request.sellStock.sellPrice"/>">
		<label for="lastname" class="col-sm-2 control-label">商品编号 : </label>
		<s:property value="#request.sellStock.stockId" />
		<br> <br> <label for="lastname"
			class="col-sm-2 control-label">销售单价 :</label>
		<s:property value="#request.sellStock.sellPrice" />
		<br> <br> <label for="lastname"
			class="col-sm-2 control-label">退货数量:</label> <input type="text"
			class="form-control" id="telephone" style="width: 200px"
			name="tuiHuoSellStock.tuiHuoNumber"
			value="<s:property value="#request.sellStock.sellNumber"/>">
		<br> <br> <label for="lastname"
			class="col-sm-2 control-label">原因:</label>
		<textarea rows="5" cols="40" style="resize:none" name="tuiHuoSellStock.yuanYin"></textarea>
		<br> <input type="submit" class="btn btn-success" value="退货" />
</form>
</body>
</html>
