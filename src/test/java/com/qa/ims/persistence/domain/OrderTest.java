package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	private Order order;
	private Order other;
	
	@Before
	public void setup() {
		order = new Order(1L, 1L, "29 Fifth Street", "CF24 9FB");
		other = new Order(1L, 1L, "29 Fifth Street", "CF24 9FB");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(order.getOrderId());
		assertNotNull(order.getCustomerId());
		assertNotNull(order.getAddress());
		assertNotNull(order.getPostcode());
		
		order.setOrderId(null);
		assertNull(order.getOrderId());
		order.setCustomerId(null);
		assertNull(order.getCustomerId());
		order.setAddress(null);
		assertNull(order.getAddress());
		order.setPostcode(null);
		assertNull(order.getPostcode());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1L, order.getCustomerId(), 0);
		assertEquals("29 Fifth Street", order.getAddress());
		assertEquals("CF24 9FB", order.getPostcode());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void addressNullButOtheraddressNotNull() {
		order.setAddress(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void addressNamesNotEqual() {
		other.setAddress("30 Fifth Street");
		assertFalse(order.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		order.setAddress(null);
		other.setAddress(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void nullId() {
		order.setCustomerId(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		order.setCustomerId(null);
		other.setCustomerId(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setCustomerId(2L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullPostcode() {
		order.setPostcode(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullPostcodeOnBoth() {
		order.setPostcode(null);
		other.setPostcode(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherPostcodeDifferent() {
		other.setPostcode("30 Fifth Street");
		assertFalse(order.equals(other));
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
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null, null, null);
		Order other = new Order(null, null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Order [orderId=1, customerId=1, address=29 Fifth Street, postcode=CF24 9FB]";
		assertEquals(toString, order.toString());
	}

}



