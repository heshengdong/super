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
    
    <title>删除用户信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	 function deleteUser(username) {
		 $("#username").val(username);
		 $("#delete").submit();
	 }
	</script>
  </head>
  
  <body>
   <form action="user/getAllUser" method="post">
   <input type="submit" class="btn btn-success" value="获取用户信息"/>
   </form>
   <table class="table">
   <thead>
      <tr class="active" style="font-size:13px">
         <th>用户名</th>
         <th>电话号码</th>
         <th>家庭号码</th>
         <th>性别</th>
         <th>学历</th>
         <th>生日</th>
         <th>员工编号</th>
         <th>身份证号码</th>
         <th>邮件地址</th>
         <th>地址</th>
         <th>添加的时间</th>
         <th style="color:blue">添加管理员</th>
         <th style="color:blue">操作</th>
      </tr>
   </thead>
   <tbody>
     <s:iterator value="#request.users" var="user">
      <tr class="active" style="font-size:13px">
         <td> <s:property value="#user.username"/></td>
         <td> <s:property value="#user.telephone"/></td>
         <td> <s:property value="#user.homePhone"/></td>
         <td> <s:property value="#user.sex"/> </td>
         <td> <s:property value="#user.education"/> </td>
         <td> <s:property value="#user.birthday"/> </td>
         <td> <s:property value="#user.code"/> </td>
         <td> <s:property value="#user.card"/> </td>
         <td> <s:property value="#user.emial"/> </td>
         <td> <s:property value="#user.address"/> </td>
          <td> <s:property value="#user.date"/> </td>
         <td style="color:blue"> <s:property value="#user.addUsername"/> </td>
         <td style="color:blue">  <input type="button" class="btn btn-success" onclick="deleteUser('<s:property value="#user.username"/>')" value="删除"/> </td>
      </tr>
      </s:iterator>
   </tbody>
   <s:form action="user/delete" method="post" id="delete">
     <input type="hidden" name="user.username" id="username"/>
   </s:form>
</table>
  </body>
</html>
