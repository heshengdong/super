<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="zyl.model.ShangPing" %>
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
    <script type="text/javascript">
     function validate() {
    	 var firstname = document.getElementById("firstname").value;
    	 if(firstname == null || firstname == "") {
    		 alert("商品类别不能为空");
    		 return false;
    	 }
    	 var lifeType = document.getElementById("name").value;
    	 if(firstname == null || firstname == "") {
    		 alert("商品名称不能为空");
    		 return false;
    	 }
    	$("#form_type").submit();
     }
    </script>
  </head>
  
  <body>
    <form class="form-horizontal" role="form" action="type/changeShangPin" method="post" id="form_type">
     <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label">商品类别 </label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="firstname" name="shangPin.type" value="<s:property value="#request.shangPin.type"/>">
      </div>
      <label for="lastname" class="col-sm-2 control-label">商品名称</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="name"  name="shangPin.name" value="<s:property value="#request.shangPin.name"/>">
      </div>
   </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">商品单位</label>
      <div class="col-sm-10" style="width: 200px">
            <input type="text" class="form-control" id="telephone"  name="shangPin.unit" value="<s:property value="#request.shangPin.unit"/>">
      </div>
      <label for="lastname" class="col-sm-2 control-label">商品型号</label>
     <div class="col-sm-10" style="width: 200px">
            <input type="text" class="form-control" id="telephone"  name="shangPin.modelNumber" value="<s:property value="#request.shangPin.modelNumber"/>">
      </div>
      </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">商品规格</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="card"  name="shangPin.measurement" value="<s:property value="#request.shangPin.measurement"/>">
      </div>
      <label for="lastname" class="col-sm-2 control-label">商品售价</label>
      <div class="col-sm-10" style="width: 200px">
        <input type="text" class="form-control" id="price"  name="shangPin.price" value="<s:property value="#request.shangPin.price"/>">
      </div>
      </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">商品产地</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="emial"  name="shangPin.address" value="<s:property value="#request.shangPin.address"/>">
      </div>
          <input type="hidden" class="form-control"  name="shangPin.code" value="<s:property value="#request.shangPin.code"/>">
      <input type="button" class="btn btn-success" onclick="validate()" value="修改"/>
   </div>
</form>
  </body>
</html>
