package zyl.model;

public class Stock {
	private String guid;
	
	private String stockId;
	
	private String providerId;
	
	private String providerName;
	
	private String providerPrice;
	
	private String providerNumber;
	
	private String allPrice;
	
	private String date;
	
	private String addUsername;
	
	
	@Override
	public String toString() {
		return providerId + "" + providerName + ""+ providerPrice + "" +  providerNumber;
	};

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

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderPrice() {
		return providerPrice;
	}

	public void setProviderPrice(String providerPrice) {
		this.providerPrice = providerPrice;
	}

	public String getProviderNumber() {
		return providerNumber;
	}

	public void setProviderNumber(String providerNumber) {
		this.providerNumber = providerNumber;
	}

	public String getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(String allPrice) {
		this.allPrice = allPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddUsername() {
		return addUsername;
	}

	public void setAddUsername(String addUsername) {
		this.addUsername = addUsername;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
}
