package zyl.service;

import java.util.List;

import zyl.dao.StockDao;
import zyl.model.Stock;
import zyl.model.StockManager;
import zyl.model.TuiHuoStock;

public class StockService {

	private static StockService stockService = null;
	
	
	public static StockService getInstance() {
		if(stockService == null) {
			stockService = new StockService();
		}
		return stockService;
	}
	
	public int add(Stock stock) {
		return StockDao.getInstance().add(stock);
	}
	
	public List<Stock> getAll() {
		return StockDao.getInstance().getAll();
	}
	
	public int delete(Stock stock) {
		return StockDao.getInstance().delete(stock);
	}
	
	public Stock getStockBy(Stock stock) {
		return StockDao.getInstance().getStockBy(stock);
	}
	
	public int change(Stock stock) {
		return StockDao.getInstance().change(stock);
	}
	
	public int tuiHuoStock(TuiHuoStock tuiHuoStock) {
		return StockDao.getInstance().tuiHuoStock(tuiHuoStock);
	}
	
	public List<TuiHuoStock> getTuiHuoList() {
		return StockDao.getInstance().getTuiHuoList();
	}
	
	public List<StockManager> getStockManagerList() {
		return StockDao.getInstance().getStockManagerList();
	}
}
