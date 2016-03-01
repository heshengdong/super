package zyl.model;

public class SellStock {

	private String guid;
	
	private String sellStockId;
	
	private String stockId;
	
	private String sellPrice;
	
	private String sellNumber;
	
	private String allSellPrice;
	
	private String date;
	
	private String username;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getSellNumber() {
		return sellNumber;
	}

	public void setSellNumber(String sellNumber) {
		this.sellNumber = sellNumber;
	}

	public String getAllSellPrice() {
		return allSellPrice;
	}

	public void setAllSellPrice(String allSellPrice) {
		this.allSellPrice = allSellPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSellStockId() {
		return sellStockId;
	}

	public void setSellStockId(String sellStockId) {
		this.sellStockId = sellStockId;
	}
}
