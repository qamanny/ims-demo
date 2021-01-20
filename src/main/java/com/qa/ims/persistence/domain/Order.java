package com.qa.ims.persistence.domain;

public class Order {
	
	private Long orderId;
	private Long customerId;
	private String address;
	private String postcode;
	private Long stock;
	
	// These are order constructors
	
	public Order(Long orderId, Long customerId, String address, String postcode) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.address = address;
		this.postcode = postcode;
	}
	
	//These are orderline constructors
	
	public Order(Long orderId, Long customerId, String address, String postcode, Long stock) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.address = address;
		this.postcode = postcode;
		this.stock = stock;
	}

	// Getters and Setters
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	//To String method
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", address=" + address + ", postcode="
				+ postcode + ", stock=" + stock + "]";
	}

	//hashCode and equals 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}
	
	
	
	

	
	
	
	
	
	
	

	
	
	

}
