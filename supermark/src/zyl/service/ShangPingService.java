package zyl.service;

import java.util.List;

import zyl.dao.ShangPingDao;
import zyl.model.ShangPing;

public class ShangPingService {
	private static ShangPingService typeService = null;
	
	public static ShangPingService getInstance() {
		if(typeService == null) {
			typeService = new ShangPingService();
		}
		return typeService;
	}

	public int add(ShangPing shangPing) {
		return ShangPingDao.getInstance().add(shangPing);
	}
	
	public List<ShangPing> getAllList() {
		return ShangPingDao.getInstance().getAllList();
	}
	
	public int delete(ShangPing shangPing) {
		return ShangPingDao.getInstance().delete(shangPing);
	}
	
	public ShangPing getShangPing(ShangPing shangPing) {
		return ShangPingDao.getInstance().getShangPing(shangPing);
	}
	
	public int change(ShangPing shangPing) {
		return ShangPingDao.getInstance().change(shangPing);
	}
}
