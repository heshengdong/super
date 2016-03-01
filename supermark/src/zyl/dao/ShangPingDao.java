package zyl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import zyl.model.ShangPing;
import zyl.model.User;
import zyl.utils.DBUtil;
import zyl.utils.HttpUtil;
import zyl.utils.TableUtil;

public class ShangPingDao {
	private static ShangPingDao shangPingDao = null;
	

	public static ShangPingDao getInstance() {
		if(shangPingDao == null) {
			shangPingDao = new ShangPingDao();
		}
		return shangPingDao;
	}
	
	public  int add(ShangPing shangPing) {
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		String uuid = UUID.randomUUID().toString();
		User loginUser = (User)HttpUtil.getApplication().getAttribute("user");
		String sql = "insert shangPing(guid, type, code, name, unit, modelNumber,measurement, price, address, date, addUsername) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setString(2, shangPing.getType());
			ps.setString(3, TableUtil.getShangPingCode());
			ps.setString(4, shangPing.getName());
			ps.setString(5, shangPing.getUnit());
			ps.setString(6, shangPing.getModelNumber());
			ps.setString(7, shangPing.getMeasurement());
			ps.setDouble(8, shangPing.getPrice());
			ps.setString(9, shangPing.getAddress());
			ps.setString(10, TableUtil.getDate());
			ps.setString(11, loginUser.getUsername());
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
	
	public List<ShangPing> getAllList() {
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ShangPing> result = new LinkedList<ShangPing>();
		String sql = "select * from shangPing";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ShangPing ping = new ShangPing();
				ping.setAddress(rs.getString("address"));
				ping.setAddUsername(rs.getString("addUsername"));
				ping.setCode(rs.getString("code"));
				ping.setDate(rs.getString("date"));
				ping.setMeasurement(rs.getString("measurement"));
				ping.setModelNumber(rs.getString("modelNumber"));
				ping.setName(rs.getString("name"));
				ping.setType(rs.getString("type"));
				ping.setPrice(rs.getDouble("price"));
				ping.setUnit(rs.getString("unit"));
				result.add(ping);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return result ;
	}
	
	public int delete(ShangPing shangPing) {
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		String sql = "delete from shangPing where code ='" + shangPing.getCode() + "'";
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
	
	public ShangPing getShangPing(ShangPing shangPing) {
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select *  from shangPing where code ='" + shangPing.getCode() + "'";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ShangPing ping = new ShangPing();
				ping.setAddress(rs.getString("address"));
				ping.setAddUsername(rs.getString("addUsername"));
				ping.setCode(rs.getString("code"));
				ping.setDate(rs.getString("date"));
				ping.setMeasurement(rs.getString("measurement"));
				ping.setModelNumber(rs.getString("modelNumber"));
				ping.setName(rs.getString("name"));
				ping.setType(rs.getString("type"));
				ping.setPrice(rs.getDouble("price"));
				ping.setUnit(rs.getString("unit"));
				return ping;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return null;
	}
	
	public int change(ShangPing shangPing) {
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		//TODO
		//"guid, type, code, name, unit, modelNumber,measurement, price, address, date, addUsername";
		String sql = "update shangPing set type=?, name=?, unit=?, modelNumber=?, measurement=?, price=?, address=? where code = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, shangPing.getType());
			ps.setString(2, shangPing.getName());
			ps.setString(3, shangPing.getUnit());
			ps.setString(4, shangPing.getModelNumber());
			ps.setString(5, shangPing.getMeasurement());
			ps.setDouble(6, shangPing.getPrice());
			ps.setString(7, shangPing.getAddress());
			ps.setString(8, shangPing.getCode());
			ps.execute();
			return 1;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}
