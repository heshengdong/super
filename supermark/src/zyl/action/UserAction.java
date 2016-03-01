package zyl.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import zyl.model.User;
import zyl.service.UserService;
import zyl.utils.HttpUtil;

import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name="success", location="/index.html"),
	@Result(name="error", location="/login.html"),
	@Result(name="addSuccess", location="../../main/addUser.jsp"),
	@Result(name="addError", location="../../main/addUser.jsp"),
	@Result(name="deleteSuccess", location="../../main/deleteUser.jsp"),
	@Result(name="deleteError", location="../../main/deleteUser.jsp"),
	@Result(name="search", location="../../main/searchUser.jsp"),
	@Result(name="changePassword", location="../../main/changePassword.jsp")
})
@Namespace("/user")
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = -713025028568640988L;
	
	private User user;
	
	private String newPassword;
	
	
	@Action("/login")
	public String login() {
		int flag = UserService.getUserService().validateLogin(user);
		if(flag == 1) {
			ServletContext servletContext = HttpUtil.getApplication(); 
			servletContext.setAttribute("user", user);
			return "success";
		}
		return "error";
	}
	
	@Action("/add")
	public String add() {
		int flag = UserService.getUserService().add(user);
		if(flag == 1) {
			addActionError("添加用户成功");
			return "addSuccess";
		} else if(flag == 2) {
			//TODO userName is exist
			addActionError("用户名已经存在");
		} else {
			addActionError("添加用户失败，请刷新页面之后再重试");
		}
		return "addError";
	}
	
	@Action("/getAllUser")
	public String getAllUser() {
		List<User> users = UserService.getUserService().getAll();
		HttpServletRequest request = HttpUtil.getRequest();
		if(users.size() > 0) {
			request.setAttribute("users", users);
		} else {
			addActionError("暂时还没有数据");
		}
		return "deleteSuccess";
	}
	
	@Action("/delete")
	public String delete() {
		int flag = UserService.getUserService().delete(user);
		if(flag == 1) {
			HttpServletRequest request = HttpUtil.getRequest();
			List<User> users = UserService.getUserService().getAll();
			request.setAttribute("users", users);
			return "deleteSuccess";
		}
		addActionError("删除用户失败");
		return "deleteError";
	}
	
	@Action("/search")
	public String search() {
		List<User> users = UserService.getUserService().search(user);
		HttpServletRequest request = HttpUtil.getRequest();
		if(users.size() > 0) {
			System.out.println("hsd :" + users.size());
			request.setAttribute("users", users);
		} else {
			addActionError("没有找到相应的匹配项");
		}
		return "search";
	}
	
	@Action("/changePassword")
	public String changePassword() {
		int flag = UserService.getUserService().changePassword(user, getNewPassword());
		String messgae = "";
		if(flag == 1) {
			 messgae = "密码更改成功";
		} else if(flag == 2) {
			messgae = "原始密码不正确";
		} else {
			 messgae = "密码更改失败";
		}
		addActionError(messgae);
		return "changePassword";
	}
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
