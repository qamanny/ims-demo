package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderlineTest {
	
	private Orderline orderline;
	private Orderline other;
	
	@Before
	public void setup() {
		orderline = new Orderline(1L, 1L, 1L, 100L);
		other = new Orderline(1L, 1L, 1L, 100L);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(orderline.getOrderlineId());
		assertNotNull(orderline.getOrderId());
		assertNotNull(orderline.getItemID());
		assertNotNull(orderline.getStock());
		
		orderline.setOrderlineId(null);
		assertNull(orderline.getOrderlineId());
		orderline.setOrderId(null);
		assertNull(orderline.getOrderId());
		orderline.setItemID(null);
		assertNull(orderline.getItemID());
		orderline.setStock(null);
		assertNull(orderline.getStock());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(orderline.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(orderline.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1L, orderline.getOrderId(), 0);
		assertEquals(1L, orderline.getItemID(), 0);
		assertEquals(100L, orderline.getStock(), 0);
	}
	
	@Test
	public void checkEquality() {
		assertTrue(orderline.equals(orderline));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(orderline.equals(other));
	}
	
	@Test
	public void stockNullButOtherstockNotNull() {
		orderline.setStock(null);
		assertFalse(orderline.equals(other));
	}
	
	@Test
	public void stockNotEqual() {
		other.setStock(200L);
		assertFalse(orderline.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullValues() {
		orderline.setStock(null);
		other.setStock(null);
		assertTrue(orderline.equals(other));
	}
	
	@Test
	public void nullId() {
		orderline.setOrderlineId(null);
		assertFalse(orderline.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		orderline.setOrderlineId(null);
		other.setOrderlineId(null);
		assertTrue(orderline.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setOrderlineId(2L);
		assertFalse(orderline.equals(other));
	}
	
	@Test
	public void nullItemID() {
		orderline.setItemID(null);
		assertFalse(orderline.equals(other));
	}
	
	@Test
	public void nullItemIDBoth() {
		orderline.setItemID(null);
		other.setItemID(null);
		assertTrue(orderline.equals(other));
	}
	
	@Test
	public void otherItemIDDifferent() {
		other.setItemID(3L);
		assertFalse(orderline.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Item item = new Item("Red Wrench", 18.99);
		assertNull(item.getId());
		assertNotNull(item.getItem_name());
		assertNotNull(item.getItem_price());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(orderline.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Orderline orderline = new Orderline(null, null, null, null);
		Orderline other = new Orderline(null, null, null, null);
		assertEquals(orderline.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Orderline [orderlineId=1, orderId=1, itemID=1, stock=100]";
		assertEquals(toString, orderline.toString());
	}


}
