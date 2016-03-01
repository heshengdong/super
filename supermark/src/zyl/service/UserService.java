package zyl.service;

import java.util.List;

import zyl.dao.UserDao;
import zyl.model.User;

public class UserService {
	
	private static UserService userService = null;
	
	
	public static  UserService getUserService() {
		if(userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	public int validateLogin(User user){
		return UserDao.getUserDao().validateLogin(user);
	}
	
	public int add(User user) {
		return UserDao.getUserDao().add(user);
	}
	
	public List<User> getAll() {
		return UserDao.getUserDao().getALl();
	}
	
	public int delete(User user) {
		return UserDao.getUserDao().delete(user);
	}
	
	public List<User> search(User user) {
		return UserDao.getUserDao().search(user);
	}
	
	public int changePassword(User user, String newPassword) {
		return UserDao.getUserDao().changePassword(user, newPassword);
	}
}
