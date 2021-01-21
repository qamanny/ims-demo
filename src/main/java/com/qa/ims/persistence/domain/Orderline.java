package com.qa.ims.persistence.domain;

public class Orderline {
	
	private Long orderlineId;
	private Long orderId;
	private Long itemID;
	private Long stock;
	
	public Orderline(Long orderlineId, Long orderId, Long itemID, Long stock) {
		super();
		this.orderlineId = orderlineId;
		this.orderId = orderId;
		this.itemID = itemID;
		this.stock = stock;
			
	}

	public Orderline(Long orderId, Long itemID, Long stock) {
		super();
		this.orderId = orderId;
		this.itemID = itemID;
		this.stock = stock;
	}

	public Orderline(Long itemID, Long stock) {
		super();
		this.itemID = itemID;
		this.stock = stock;
	}

	public Long getOrderlineId() {
		return orderlineId;
	}

	public void setOrderlineId(Long orderlineId) {
		this.orderlineId = orderlineId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Orderline [orderlineId=" + orderlineId + ", orderId=" + orderId + ", itemID=" + itemID + ", stock="
				+ stock + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderlineId == null) ? 0 : orderlineId.hashCode());
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
		Orderline other = (Orderline) obj;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderlineId == null) {
			if (other.orderlineId != null)
				return false;
		} else if (!orderlineId.equals(other.orderlineId))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}
	
	
	

}
