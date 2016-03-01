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
    
    <title>添加用户</title>
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
  <s:actionerror cssStyle="color:red"/>
  <br>
  <br>
  <br>
    <form class="form-horizontal" role="form" action="type/addshangPin" method="post" id="form_type">
     <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label">商品类别</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="firstname" name="shangPin.type" placeholder="请输入商品类别">
      </div>
      <label for="lastname" class="col-sm-2 control-label">商品名称</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="name"  name="shangPin.name"
            placeholder="请输入商品名称">
      </div>
   </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">商品单位</label>
      <div class="col-sm-10" style="width: 200px">
            <input type="text" class="form-control" id="telephone"  name="shangPin.unit"
            placeholder="请输入商品单位">
      </div>
      <label for="lastname" class="col-sm-2 control-label">商品型号</label>
     <div class="col-sm-10" style="width: 200px">
            <input type="text" class="form-control" id="telephone"  name="shangPin.modelNumber"
            placeholder="请输入商品单位">
      </div>
      </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">商品规格</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="card"  name="shangPin.measurement"
            placeholder="商品型号">
      </div>
      <label for="lastname" class="col-sm-2 control-label">商品售价</label>
      <div class="col-sm-10" style="width: 200px">
        <input type="text" class="form-control" id="price"  name="shangPin.price"
            placeholder="请输入商品售价">
      </div>
      </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">商品产地</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="emial"  name="shangPin.address"
            placeholder="请输入商品产地">
      </div>
        <button type="reset" class="btn btn-info">重置</button>
      <input type="button" class="btn btn-success" onclick="validate()" value="添加"/>
   </div>
</form>
  </body>
</html>
