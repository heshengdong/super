<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  <s:actionerror cssStyle="color:red"/>
    <br>
    <br>
    <br>
    <form class="form-horizontal" role="form" action="stock/changeStock" method="post" id="form_type">
     <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label">商品编号</label>
      <div class="col-sm-10" style="width: 200px">
      <s:property value="#request.stock.providerId"/>
      </div>
      <label for="lastname" class="col-sm-2 control-label">供应商名称</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="name"  name="stock.providerName" value="<s:property value="#request.stock.providerName"/>">
         <input type="hidden" class="form-control"  name="stock.stockId" value="<s:property value="#request.stock.stockId"/>">
      </div>
   </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">进货单价</label>
      <div class="col-sm-10" style="width: 200px">
            <input type="text" class="form-control" id="telephone"  name="stock.providerPrice" value="<s:property value="#request.stock.providerPrice"/>">
      </div>
      <label for="lastname" class="col-sm-2 control-label">进货数量</label>
     <div class="col-sm-10" style="width: 200px">
            <input type="text" class="form-control" id="telephone"  name="stock.providerNumber"  value="<s:property value="#request.stock.providerNumber"/>">
      </div>
      </div>
   <br>
   <center>
   <input type="submit" class="btn btn-success" value="修改"/>
   </center>
</form>
  </body>
</html>
