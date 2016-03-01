package zyl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import zyl.model.Stock;
import zyl.model.StockManager;
import zyl.model.TuiHuoStock;
import zyl.model.User;
import zyl.utils.DBUtil;
import zyl.utils.HttpUtil;
import zyl.utils.TableUtil;

public class StockDao {
    private static StockDao stockDao = null;
    
    
    public static StockDao getInstance() {
    	if(stockDao == null) {
    		stockDao = new StockDao();
    	}
    	return stockDao;
    }
    
    public int add(Stock stock) {
    	String stockCode = TableUtil.getStockCode();
    	Connection connection = DBUtil.getConn();
    	PreparedStatement ps = null;
    	StockManager stockManager = new StockManager();
    	stockManager.setNumber(stock.getProviderNumber());
    	stockManager.setStockId(stock.getProviderId());
    	addStockManager(stockManager);
		String uuid = UUID.randomUUID().toString();
		User loginUser = (User)HttpUtil.getApplication().getAttribute("user");
		String sql = "insert into stock(guid, stockId, providerId, providerName, providerPrice, providerNumber, allPrice, date, addUsername) values(?,?,?,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setString(2, stockCode);
			ps.setString(3, stock.getProviderId());
			ps.setString(4, stock.getProviderName());
			ps.setString(5, stock.getProviderPrice());
			ps.setString(6, stock.getProviderNumber());
			double price = Double.parseDouble(stock.getProviderPrice());
			double number = Double.parseDouble(stock.getProviderNumber());
			double all = (price * number);
			ps.setString(7, all + "");
			ps.setString(8, TableUtil.getDate());
			ps.setString(9, loginUser.getUsername());
			ps.execute();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
		}
    	return 0;
    }
    
    private void addStockManager(StockManager stockManager) {
    	Connection connection = DBUtil.getConn();
    	PreparedStatement ps = null;
		String sql = "insert into stockmanager(stockId, number) values(?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, stockManager.getStockId());
			ps.setString(2, stockManager.getNumber());
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
		}
    }
    
    public int delete(Stock stock) {
    	Connection connection = DBUtil.getConn();
    	PreparedStatement ps = null;
    	String sql = "delete from stock where stockId = '" + stock.getStockId() + "'";
    	try {
    		ps = connection.prepareStatement(sql);
    		ps.execute();
    		return 1;
    		
    	} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
		}
    	
    	return 1;
    }
    
    public Stock getStockBy(Stock stock) {
    	Connection connection = DBUtil.getConn();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	String sql = "select * from stock where stockId= '" + stock.getStockId() + "'";
    	try{
    		ps = connection.prepareStatement(sql);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			Stock result = new Stock();
    			result.setStockId(rs.getString("stockId"));
    			result.setProviderName(rs.getString("providerName"));
    			result.setProviderPrice(rs.getString("providerPrice"));
    			result.setProviderNumber(rs.getString("providerNumber"));
    			result.setProviderId(rs.getString("providerId"));
    			return result;
    		}
    		
    	} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
    	return null;
    }
    
    public int change(Stock stock) {
    	Connection connection = DBUtil.getConn();
    	PreparedStatement ps = null;
    	String sql = "update stock set providerName=?, providerNumber=?, providerPrice=?, allPrice=? where stockId=?" ;
    	try {
    		ps = connection.prepareStatement(sql);
    		ps.setString(1, stock.getProviderName());
    		ps.setString(2, stock.getProviderNumber());
    		ps.setString(3, stock.getProviderPrice());
    		double price = Double.parseDouble(stock.getProviderPrice());
    		double number = Double.parseDouble(stock.getProviderNumber());
    		double all = price * number;
    		ps.setString(4, all + "");
    		ps.setString(5, stock.getStockId());
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
    
    public int tuiHuoStock(TuiHuoStock tuiHuoStock) {
    	StockManagerDao.getInstance().changeStockNumber(tuiHuoStock.getStockId(), Double.parseDouble(tuiHuoStock.getTuihuoNumber()), false);
    	Connection connection = DBUtil.getConn();
    	PreparedStatement ps = null;
		String uuid = UUID.randomUUID().toString();
		User loginUser = (User)HttpUtil.getApplication().getAttribute("user");
		String sql = "insert tuiHuoStock(guid, tuiHuoCode, stockId, providerName, stockPrice, tuihuoNumber, tuihuoAllPrice, date, yuanyin, username) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setString(2, TableUtil.getTuiHuoStock());
			ps.setString(3, tuiHuoStock.getStockId());
			ps.setString(4, tuiHuoStock.getProviderName());
			ps.setString(5, tuiHuoStock.getStockPrice());
			ps.setString(6, tuiHuoStock.getTuihuoNumber());
			double price = Double.parseDouble(tuiHuoStock.getStockPrice());
			double number = Double.parseDouble(tuiHuoStock.getTuihuoNumber());
			double all = (price * number);
			ps.setString(7, all + "");
			ps.setString(8, TableUtil.getDate());
			ps.setString(9, tuiHuoStock.getYuanYin());
			ps.setString(10, loginUser.getUsername());
			ps.execute();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
		}
    	return 0;
    }
    
    public List<TuiHuoStock> getTuiHuoList() {
    	List<TuiHuoStock> result = new LinkedList<TuiHuoStock>();
    	Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tuiHuoStock";
		try{
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				TuiHuoStock tuiHuoStock = new TuiHuoStock();
				tuiHuoStock.setDate(rs.getString("date"));
				tuiHuoStock.setProviderName(rs.getString("providerName"));
				tuiHuoStock.setStockId(rs.getString("stockId"));
				tuiHuoStock.setStockPrice(rs.getString("stockPrice"));
				tuiHuoStock.setTuihuoAllPrice(rs.getString("tuiHuoAllPrice"));
				tuiHuoStock.setTuiHuoCode(rs.getString("tuiHuoCode"));
				tuiHuoStock.setTuihuoNumber(rs.getString("tuihuoNumber"));
				tuiHuoStock.setUsername(rs.getString("username"));
				tuiHuoStock.setYuanYin(rs.getString("yuanYin"));
				result.add(tuiHuoStock);
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
    
    public List<Stock> getAll() {
    	List<Stock> result = new LinkedList<Stock>();
    	Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from stock";
		try{
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Stock stock = new Stock();
				stock.setAddUsername(rs.getString("addUsername"));
				stock.setAllPrice(rs.getString("allPrice"));
				stock.setDate(rs.getString("date"));
				stock.setProviderId(rs.getString("providerId"));
				stock.setProviderName(rs.getString("providerName"));
				stock.setProviderNumber(rs.getString("providerNumber"));
				stock.setProviderPrice(rs.getString("providerPrice"));
				stock.setStockId(rs.getString("stockId"));
				result.add(stock);
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
    
    public List<StockManager> getStockManagerList() {
    	List<StockManager> result = new LinkedList<StockManager>();
    	Connection connection = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from stockmanager";
		try{
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				StockManager stockManager = new StockManager();
				stockManager.setStockId(rs.getString("stockId"));
				stockManager.setNumber(rs.getString("number"));
				result.add(stockManager);
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
