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
	function DeleteShangPing(code) {
		$("#code").val(code);
		$("#flag").val(1);
		$("#deleteShangPing").submit();
	}

	function changeShangPing(code) {
		$("#code").val(code);
		$("#flag").val(2);
		$("#deleteShangPing").submit();
	}
</script>
</head>
<body>
	<form action="type/getAllShangPin" method="post">
		<input type="submit" class="btn btn-info" value="获取商品信息" />
	</form>
	<s:actionerror />
	<hr style="color:bule">
	<table class="table">
		<thead>
			<tr class="active" style="font-size:12px">
				<th>商品类型</th>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>商品单位</th>
				<th>商品型号</th>
				<th>商品规格</th>
				<th>商品售价</th>
				<th>商品产地</th>
				<th>添加时间</th>
				<th style="color:blue">添加用户</th>
				<th style="color:blue">删除</th>
				<th style="color:blue">修改</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#request.list" var="list">
				<tr class="active" style="font-size:15px">
					<td><s:property value="#list.type" />
					</td>
					<td><s:property value="#list.code" />
					</td>
					<td><s:property value="#list.name" />
					</td>
					<td><s:property value="#list.unit" /></td>
					<td><s:property value="#list.modelNumber" /></td>
					<td><s:property value="#list.measurement" /></td>
					<td><s:property value="#list.price" /></td>
					<td><s:property value="#list.address" /></td>
					<td><s:property value="#list.date" /></td>
					<td style="color:blue"><s:property value="#list.addUsername" />
					</td>
					<td style="color:blue"><input type="button"
						class="btn btn-success"
						onclick="DeleteShangPing('<s:property value="#list.code"/>')"
						value="删除" /></td>
					<td style="color:blue"><input type="button"
						class="btn btn-info"
						onclick="changeShangPing('<s:property value="#list.code"/>')"
						value="修改" /></td>
				</tr>
			</s:iterator>
		</tbody>
		<s:form action="type/deleteShangPing" method="post"
			id="deleteShangPing">
			<input type="hidden" name="shangPin.code" id="code" />
			<input type="hidden" name="flag" id="flag" />
		</s:form>
	</table>
</body>
</html>
