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
<script type="text/javascript">
function Delete(code) {
	$("#sellStockId").val(code);
	$("#flag").val(1);
	$("#delete").submit();
}
</script>
</head>
<body>
	<form action="sell/sellStockList" method="post">
		<input type="submit" class="btn btn-info" value="获取销售信息" />
	</form>
	<s:actionerror />
	<hr style="color:bule">
	<table class="table">
		<thead>
			<tr class="active" style="font-size:12px">
				<th>销售编号</th>
				<th>商品编号</th>
				<th>销售单价</th>
				<th>销售数量</th>
				<th>销售总价</th>
				<th>销售日期</th>
				<th style="color:blue">我要退货</th>
				<th style="color:blue">员工名称</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#request.list" var="list">
				<tr class="active" style="font-size:15px">
					<td><s:property value="#list.sellStockId" />
					</td>
					<td><s:property value="#list.stockId" />
					</td>
					<td><s:property value="#list.sellPrice" />
					</td>
					<td><s:property value="#list.sellNumber" /></td>
					<td><s:property value="#list.allSellPrice" /></td>
					<td><s:property value="#list.date" /></td>
					<td style="color:blue"><input type="button"
						class="btn btn-success"
						onclick="Delete('<s:property value="#list.sellStockId"/>')"
						value="退货" /></td>
					<td style="color:blue"><s:property value="#list.username" />
					</td>
				</tr>
			</s:iterator>
		</tbody>
		<s:form action="sell/tuiHuoSellStock" method="post"
			id="delete">
			<input type="hidden" name="sellStock.sellStockId" id="sellStockId" />
			<input type="hidden" name="flag" id="flag" />
		</s:form>
	</table>
</body>
</html>
