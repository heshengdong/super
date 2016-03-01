package zyl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import zyl.utils.DBUtil;

public class StockManagerDao {

	private static StockManagerDao stockManagerDao = null;
	
	public static StockManagerDao getInstance() {
		if(stockManagerDao == null) {
			stockManagerDao = new StockManagerDao();
		}
		return stockManagerDao;
	}
	
	public void changeStockNumber(String stockId, double number, boolean flag) {
		Connection connection = DBUtil.getConn();
    	PreparedStatement ps = null;
    	String sql = "update stockmanager set number=? where stockId=?" ;
    	try {
    		ps = connection.prepareStatement(sql);
    		double numberOfinit = getStockNumberBy(stockId);
    		if(flag) {
    			numberOfinit = numberOfinit + number;
    		} else {
    			numberOfinit = numberOfinit - number;
    		}
    		ps.setString(1, numberOfinit + "");
    		ps.setString(2, stockId);
    		ps.executeUpdate();
    		
    	} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
		}
	}
	
	public Double getStockNumberBy(String stockId) {
		Connection connection = DBUtil.getConn();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	String sql = "select number from stockmanager where stockId= '" + stockId + "'";
    	try {
    		ps = connection.prepareStatement(sql);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			return Double.parseDouble(rs.getString("number"));
    		}
    	} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
    	return 0.0;
	}
}
