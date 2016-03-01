<%@page import="zyl.model.ShangPing"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="zyl.dao.ShangPingDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<ShangPing> list = ShangPingDao.getInstance().getAllList();
request.setAttribute("list", list);
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
    <form class="form-horizontal" role="form" action="stock/addStock" method="post" id="form_type">
     <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label">商品编号</label>
      <div class="col-sm-10" style="width: 200px">
 <!--        <input type="text" class="form-control" id="firstname" name="stock.providerName" placeholder="请输入商品编号">
  --> 
      <select name="stock.providerId">
      <s:iterator value="#request.list" var="list">
        <option  value="<s:property value="#list.code" />"><s:property value="#list.code" /></option>
        </s:iterator>
      </select>
      </div>
      <label for="lastname" class="col-sm-2 control-label">供应商名称</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="name"  name="stock.providerName"
            placeholder="请输入供应商名称">
      </div>
   </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">进货单价</label>
      <div class="col-sm-10" style="width: 200px">
            <input type="text" class="form-control" id="telephone"  name="stock.providerPrice"
            placeholder="请输入进货单价">
      </div>
      <label for="lastname" class="col-sm-2 control-label">进货数量</label>
     <div class="col-sm-10" style="width: 200px">
            <input type="text" class="form-control" id="telephone"  name="stock.providerNumber"
            placeholder="请输入进货数量">
      </div>
      </div>
   <br>
   <center>
   <button type="reset" class="btn btn-info">重置</button>
   <input type="submit" class="btn btn-success" value="添加"/>
   </center>
</form>
  </body>
</html>
