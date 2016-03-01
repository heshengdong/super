package zyl.service;

import java.util.List;

import zyl.dao.SellStockDao;
import zyl.model.SellStock;
import zyl.model.TuiHuoSellStock;

public class SellStockService {

	private static SellStockService sellStockService = null;
	
	
	public static SellStockService getInstance() {
		if(sellStockService == null) {
			sellStockService = new SellStockService();
		}
		return sellStockService;
	}
	
	public int add(SellStock sellStock) {
		return SellStockDao.getInstance().add(sellStock);
	}
	
	public List<SellStock> getList() {
		return SellStockDao.getInstance().getList();
	}
	
	public SellStock getTuiHuoStock(SellStock sellStock) {
		return SellStockDao.getInstance().getSellStockBy(sellStock);
	}
	
	public int addTuiHuoStock(TuiHuoSellStock huoSellStock) {
		return SellStockDao.getInstance().addTuiHuoSellStock(huoSellStock);
	}
	
	public List<TuiHuoSellStock> getTuiHuoSellList() {
		return SellStockDao.getInstance().getTuiHuoSellList();
	}
}
