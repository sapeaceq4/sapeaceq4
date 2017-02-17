package com.sapient.ace.spring.hibernate.config.model;

public class Equity {

	private String symbol;
	private String securityName;
	private String type;
	private int qty;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Equity [symbol=" + symbol + ", securityName=" + securityName + ", type=" + type + ", qty=" + qty + "]";
	}

}
