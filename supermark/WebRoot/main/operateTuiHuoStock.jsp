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
	<form action="sell/getTuiHuoSellList" method="post">
		<input type="submit" class="btn btn-info" value="获取销售退货信息" />
	</form>
	<s:actionerror />
	<hr style="color:bule">
	<table class="table">
		<thead>
			<tr class="active" style="font-size:12px">
				<th>商品编号</th>
				<th>退货单价</th>
				<th>退货数量</th>
				<th>退货总价格</th>
				<th>退货日期</th>
				<th>退货原因</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#request.list" var="list">
				<tr class="active" style="font-size:15px">
					<td><s:property value="#list.stockId" />
					</td>
					<td><s:property value="#list.sellPrice" />
					</td>
					<td><s:property value="#list.tuiHuoNumber" /></td>
					<td><s:property value="#list.tuiHuoAllPrice" /></td>
					<td><s:property value="#list.date" /></td>
					<td><s:property value="#list.yuanYin" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>
