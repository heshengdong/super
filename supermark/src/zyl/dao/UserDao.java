package zyl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.xwork.StringUtils;

import zyl.model.User;
import zyl.utils.DBUtil;
import zyl.utils.HttpUtil;
import zyl.utils.TableUtil;

public class UserDao {
	private static UserDao userDao = null;
	
	
	public static UserDao getUserDao() {
		if(userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
	}

	public int validateLogin(User user) {
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where username = '" + user.getUsername() + "' and password = '"+ user.getPassword() + "'";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return 0;
	}
	
	// add user
	public int add(User user) {
		if(validateUsername(user.getUsername()) == 1) {
			return 2;
		}
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		String uuid = UUID.randomUUID().toString();
		User loginUser = (User)HttpUtil.getApplication().getAttribute("user");
		String sql = "insert user(id, username, password, telephone, address, date, addUsername,sex, code, card, homePhone, emial, education, birthday) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getTelephone());
			ps.setString(5, user.getAddress());
			ps.setString(6, TableUtil.getDate());
			ps.setString(7, loginUser.getUsername());
			ps.setString(8, user.getSex());
			ps.setString(9, TableUtil.getCode());
			ps.setString(10, user.getCard());
			ps.setString(11, user.getHomePhone());
			ps.setString(12, user.getEmial());
			ps.setString(13, user.getEducation());
			ps.setString(14, user.getBirthday());
			ps.execute();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
		}
		return 0;
	}
	
	public List<User> getALl() {
		List<User> result = new LinkedList<User>();
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user";
		User loginUser = (User)HttpUtil.getApplication().getAttribute("user");
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while(rs.next()) {
				User user = new User();
				user.setAddress(rs.getString("address"));
				user.setUsername(rs.getString("username"));
				user.setTelephone(rs.getString("telephone"));
				user.setDate(rs.getString("date"));
				user.setAddUsername(rs.getString("addUsername"));
				user.setBirthday(rs.getString("birthday"));
				user.setCard(rs.getString("card"));
				user.setCode(rs.getString("code"));
				user.setEducation(rs.getString("education"));
				user.setEmial(rs.getString("emial"));
				user.setSex(rs.getString("sex"));
				user.setHomePhone(rs.getString("homePhone"));
				if(!StringUtils.equals(user.getUsername(), loginUser.getUsername())) {
					result.add(user);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return result;
	}
	
	public List<User> search(User users) {
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> result = new LinkedList<User>();
		String username = users.getUsername();
		String telephone = users.getTelephone();
		if(StringUtils.isBlank(username)) {
			username = "";
		} 
		if(StringUtils.isBlank(telephone)) {
			telephone = "";
		}
		String sql = "select * from user where username like '%" + username + "%' and telephone like '%" + telephone + "%'";
		System.out.println("hsd sql " + sql);
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setAddress(rs.getString("address"));
				user.setUsername(rs.getString("username"));
				user.setTelephone(rs.getString("telephone"));
				user.setDate(rs.getString("date"));
				user.setAddUsername(rs.getString("addUsername"));
				user.setBirthday(rs.getString("birthday"));
				user.setCard(rs.getString("card"));
				user.setCode(rs.getString("code"));
				user.setEducation(rs.getString("education"));
				user.setEmial(rs.getString("emial"));
				user.setSex(rs.getString("sex"));
				user.setHomePhone(rs.getString("homePhone"));
				result.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		
		return result;
	}
	
	public int delete(User user) {
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		String sql = "delete from user where username = '" + user.getUsername() + "'";
		System.out.println("hsd : sql " + sql);
		try {
			ps = connection.prepareStatement(sql);
			ps.execute();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
		}
		return 0;
	}
	
	public int changePassword(User user, String newPassword) {
		User loginUser = (User)HttpUtil.getApplication().getAttribute("user");
		User u = new User();
		u.setUsername(loginUser.getUsername());
		u.setPassword(user.getPassword());
		int flag = validateLogin(u);
		if(flag == 0) {
			return 2;
		}
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		String sql = "update user set password = '" + newPassword + "' where username ='" + loginUser.getUsername() + "'";
		System.out.println("hsd sql " + sql);
		try {
			ps = connection.prepareStatement(sql);
			ps.execute();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
		}
		return 0;
	}
	
    // validate userName is exist
	private int validateUsername(String username) {
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user where username = '" + username + "'";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return 0;
	}
}
