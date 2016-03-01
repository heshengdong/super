package zyl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import zyl.model.SellStock;
import zyl.model.TuiHuoSellStock;
import zyl.model.User;
import zyl.utils.DBUtil;
import zyl.utils.HttpUtil;
import zyl.utils.TableUtil;

public class SellStockDao {

	private static SellStockDao sellStockDao = null;
	
	
	public static SellStockDao getInstance() {
		if(sellStockDao == null) {
			sellStockDao = new SellStockDao();
		}
		return sellStockDao;
	}
	
	public int add(SellStock sellStock) {
		StockManagerDao.getInstance().changeStockNumber(sellStock.getStockId(), Double.parseDouble(sellStock.getSellNumber()), false);
		Connection connection = DBUtil.getConn();
    	PreparedStatement ps = null;
		String uuid = UUID.randomUUID().toString();
		User loginUser = (User)HttpUtil.getApplication().getAttribute("user");
		String sql = "insert into sellStock(guid, sellStockId, stockId, sellPrice, sellNumber, allSellPrice, date, username) values(?,?,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setString(2, TableUtil.getSellStock());
			ps.setString(3, sellStock.getStockId());
			ps.setString(4, sellStock.getSellPrice());
			ps.setString(5, sellStock.getSellNumber());
			double price = Double.parseDouble(sellStock.getSellPrice());
			double number = Double.parseDouble(sellStock.getSellNumber());
			double allPrice = price * number;
			ps.setString(6, allPrice + "");
			ps.setString(7, TableUtil.getDate());
			ps.setString(8, loginUser.getUsername());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
		}
		return 0;
	}
	
	public List<SellStock> getList() {
		List<SellStock> result = new LinkedList<SellStock>();
    	Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from sellStock";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				SellStock sellStock = new SellStock();
				sellStock.setAllSellPrice(rs.getString("allSellPrice"));
				sellStock.setDate(rs.getString("date"));
				sellStock.setSellNumber(rs.getString("sellNumber"));
				sellStock.setSellPrice(rs.getString("sellPrice"));
				sellStock.setStockId(rs.getString("stockId"));
				sellStock.setUsername(rs.getString("username"));
				sellStock.setSellStockId(rs.getString("sellStockId"));
				result.add(sellStock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return  result;
	}
	
	public SellStock getSellStockBy(SellStock sellStock) {
    	Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		SellStock result = null;
		ResultSet rs = null;
		String sql = "select * from sellStock where sellStockId= '" + sellStock.getSellStockId() + "'";
		System.out.println(sql);
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				result = new SellStock();
				result.setSellNumber(rs.getString("sellNumber"));
				result.setSellPrice(rs.getString("sellPrice"));
				result.setStockId(rs.getString("stockId"));
				result.setSellStockId(rs.getString("sellStockId"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return result;
	}
	
	public int addTuiHuoSellStock(TuiHuoSellStock tuiHuoSellStock) {
		StockManagerDao.getInstance().changeStockNumber(tuiHuoSellStock.getStockId(), Double.parseDouble(tuiHuoSellStock.getTuiHuoNumber()), true);
		Connection connection = DBUtil.getConn();
    	PreparedStatement ps = null;
		String uuid = UUID.randomUUID().toString();
		String sql = "insert into tuiHuoSellStock(guid, stockId, sellPrice, tuiHuoNumber, tuiHuoAllPrice, yuanYin, date) values(?,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setString(2, tuiHuoSellStock.getStockId());
			ps.setString(3, tuiHuoSellStock.getSellPrice());
			ps.setString(4, tuiHuoSellStock.getTuiHuoNumber());
			double price = Double.parseDouble(tuiHuoSellStock.getSellPrice());
			double number = Double.parseDouble(tuiHuoSellStock.getTuiHuoNumber());
			double allPrice = price * number;
			ps.setString(5, allPrice + "");
			ps.setString(6, tuiHuoSellStock.getYuanYin());
			ps.setString(7, TableUtil.getDate());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
		}
		return 0;
	}
	
	//TODO
	public List<TuiHuoSellStock> getTuiHuoSellList() {
		List<TuiHuoSellStock> result = new LinkedList<TuiHuoSellStock>();
		Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tuiHuoSellStock";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				TuiHuoSellStock tuiHuoSellStock = new TuiHuoSellStock();
				tuiHuoSellStock.setDate(rs.getString("date"));
				tuiHuoSellStock.setSellPrice(rs.getString("sellPrice"));
				tuiHuoSellStock.setStockId(rs.getString("stockId"));
				tuiHuoSellStock.setTuiHuoAllPrice(rs.getString("tuiHuoAllPrice"));
				tuiHuoSellStock.setTuiHuoNumber(rs.getString("tuiHuoNumber"));
				tuiHuoSellStock.setYuanYin(rs.getString("yuanYin"));
				result.add(tuiHuoSellStock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return result;
	}
}
