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
    	 var password1 = document.getElementById("password1").value;
    	 var password2 = document.getElementById("password2").value;
    	 if(password1 == null || password1 == "") {
    		 alert("密码不能为空");
    		 return false;
    	 }
    	 if(password2 == null || password2 == "") {
    		 alert("确认密码不能为空");
    		 return false;
    	 }
    	 if(password1 != password2) {
    		 alert("两次输入的密码不正确，请重新输入");
    		 return false;
    	 }
    	 $('#form').submit();
     }
    </script>
  </head>
  
  <body>
  <s:actionerror cssStyle="color:red"/>
    <form class="form-horizontal" role="form" action="user/changePassword" method="post" id="form">
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">原始密码</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="password" class="form-control" id="telephone"  name="user.password"
            placeholder="请输入原始密码">
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">密码</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="password" class="form-control" id="password1" name="newPassword" 
            placeholder="请输入密码">
      </div>
   </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">确认密码</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="password" class="form-control" id="password2" 
            placeholder="请再次输入密码">
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
         <button type="button" class="btn btn-info" onclick="validate()" >提交</button>
         <button type="reset" class="btn btn-warning">重置</button>
      </div>
   </div>
</form>
  </body>
</html>
