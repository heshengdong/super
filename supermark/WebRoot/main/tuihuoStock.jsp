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
	<b style="color: red">最多只能退货 ： <s:property value="#request.stock.providerNumber" /></b>
	<br>
	<br>
	<br>
	<form action="stock/tuihuo" method="post">
	 <input type="hidden" class="form-control"  name="tuiHuoStock.stockId" value="<s:property value="#request.stock.providerId"/>">
	 <input type="hidden" class="form-control"  name="tuiHuoStock.providerName" value="<s:property value="#request.stock.providerName"/>">
	 <input type="hidden" class="form-control"  name="tuiHuoStock.stockPrice" value="<s:property value="#request.stock.providerPrice"/>">
		<label for="lastname" class="col-sm-2 control-label">商品编号 : </label>
		<s:property value="#request.stock.providerId" />
		<br> <br> <label for="lastname"
			class="col-sm-2 control-label">供应商名称: </label>
		<s:property value="#request.stock.providerName" />
		<br> <br> <label for="lastname"
			class="col-sm-2 control-label">进货单价 :</label>
		<s:property value="#request.stock.providerPrice" />
		<br> <br> <label for="lastname"
			class="col-sm-2 control-label">退货数量:</label> <input type="text"
			class="form-control" id="telephone" style="width: 200px"
			name="tuiHuoStock.tuihuoNumber"
			value="<s:property value="#request.stock.providerNumber"/>">
		<br> <br> <label for="lastname"
			class="col-sm-2 control-label">原因:</label>
		<textarea rows="5" cols="40" style="resize:none" name="tuiHuoStock.yuanYin"></textarea>
		<br> <input type="submit" class="btn btn-success" value="退货" />
</form>
</body>
</html>
