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
    		 alert("用户名不能为空");
    		 return false;
    	 }
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
    	 
    	 var telephone = document.getElementById("telephone").value;
    	 var address = document.getElementById("address").value;
    	 if(telephone == null || telephone == "") {
    		 alert("电话号码不能为空");
    		 return false;
    	 }
    	 if(address == null || address == "") {
    		 alert("地址不能为空");
    		 return false;
    	 }
    	 $("#addUserForm").submit();
     }
    </script>
  </head>
  
  <body>
  <s:actionerror cssStyle="color:red"/>
  <br>
  <br>
  <br>
    <form class="form-horizontal" role="form" action="user/add" method="post" id="addUserForm">
   <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label">用户名</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="firstname" name="user.username" placeholder="请输入用户名">
      </div>
      <label for="lastname" class="col-sm-2 control-label">电话号码</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="telephone"  name="user.telephone"
            placeholder="请输入电话号码">
      </div>
   </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">确认密码</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="password" class="form-control" id="password2" 
            placeholder="请再次输入密码">
      </div>
       <label for="lastname" class="col-sm-2 control-label">密码</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="password" class="form-control" id="password1" name="user.password" 
            placeholder="请输入密码">
      </div>
      </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">员工性别</label>
      <div class="col-sm-10" style="width: 200px">
         <select type="text" class="form-control" id="telephone"  name="user.sex">
            <option value="男" selected="selected">男</option>
            <option value="女">女</option>
          </select>
      </div>
      <label for="lastname" class="col-sm-2 control-label">教育学历</label>
      <div class="col-sm-10" style="width: 200px">
         <select type="text" class="form-control" id="education"  name="user.education">
            <option value="高中" selected="selected">高中</option>
            <option value="中专">中专</option>
            <option value="大专">大专</option>
            <option value="本科">本科</option>
            <option value="硕士">硕士</option>
            <option value="博士">博士</option>
          </select>
      </div>
      </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">身份证号码</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="card"  name="user.card"
            placeholder="身份证号码">
      </div>
      <label for="lastname" class="col-sm-2 control-label">家庭电话号码</label>
      <div class="col-sm-10" style="width: 200px">
        <input type="text" class="form-control" id="homePhone"  name="user.homePhone"
            placeholder="请输入电话号码">
      </div>
      </div>
    <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">邮件地址</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="emial"  name="user.emial"
            placeholder="请输入邮件地址">
      </div>
      <label for="lastname" class="col-sm-2 control-label">家庭住址</label>
      <div class="col-sm-10" style="width: 300px">
         <input type="text" class="form-control" id="address"  name="user.address"
            placeholder="请输入家庭住址">
      </div>
   </div>
   
   <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">生日</label>
      <div class="col-sm-10" style="width: 200px">
         <input type="text" class="form-control" id="birthday"  name="user.birthday" placeholder="请输入生日">如:20110908
      </div>
      <button type="reset" class="btn btn-info">重置</button>
         <input type="button" class="btn btn-success" onclick="validate()" value="登录"/>
   </div>
</form>
  </body>
</html>
