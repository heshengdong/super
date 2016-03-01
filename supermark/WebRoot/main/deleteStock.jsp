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
		$("#stockId").val(code);
		$("#flag").val(1);
		$("#delete").submit();
	}

	function change(code) {
		$("#stockId").val(code);
		$("#flag").val(2);
		$("#delete").submit();
	}
</script>
</head>
<body>
	<form action="stock/list" method="post">
		<input type="submit" class="btn btn-info" value="获取进货信息" />
	</form>
	<s:actionerror />
	<hr style="color:bule">
	<table class="table">
		<thead>
			<tr class="active" style="font-size:12px">
				<th>进货编号</th>
				<th>商品编号</th>
				<th>供应商名称</th>
				<th>进货单价</th>
				<th>进货数量</th>
				<th>进货总价格</th>
				<th>进货日期</th>
				<th style="color:blue">添加用户</th>
				<th style="color:blue">退货</th>
				<th style="color:blue">修改</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#request.list" var="list">
				<tr class="active" style="font-size:15px">
					<td><s:property value="#list.stockId" />
					</td>
					<td><s:property value="#list.providerId" />
					</td>
					<td><s:property value="#list.providerName" />
					</td>
					<td><s:property value="#list.providerPrice" /></td>
					<td><s:property value="#list.providerNumber" /></td>
					<td><s:property value="#list.allPrice" /></td>
					<td><s:property value="#list.date" /></td>
					<td style="color:blue"><s:property value="#list.addUsername" />
					</td>
					<td style="color:blue"><input type="button"
						class="btn btn-success"
						onclick="Delete('<s:property value="#list.stockId"/>')"
						value="退货" /></td>
					<td style="color:blue"><input type="button"
						class="btn btn-info"
						onclick="change('<s:property value="#list.stockId"/>')"
						value="修改" /></td>
				</tr>
			</s:iterator>
		</tbody>
		<s:form action="stock/deleteStock" method="post"
			id="delete">
			<input type="hidden" name="stock.stockId" id="stockId" />
			<input type="hidden" name="flag" id="flag" />
		</s:form>
	</table>
</body>
</html>
