package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	private Item other;
	
	@Before
	public void setup() {
		item = new Item(1L, "Red Wrench", 18.99);
		other = new Item(1L, "Red Wrench", 18.99);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getItem_name());
		assertNotNull(item.getItem_price());
		
		item.setId(null);
		assertNull(item.getId());
		item.setItem_name(null);
		assertNull(item.getItem_name());
		item.setItem_price(null);
		assertNull(item.getItem_price());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getId(), 0);
		assertEquals("Red Wrench", item.getItem_name());
		assertEquals(18.99, item.getItem_price(), 0);
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	
	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setItem_name(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNamesNotEqual() {
		other.setItem_name("rhys");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setItem_name(null);
		other.setItem_name(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void nullId() {
		item.setId(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setId(null);
		other.setId(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullPrice() {
		item.setItem_price(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullPriceOnBoth() {
		item.setItem_price(null);
		other.setItem_price(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherPriceDifferent() {
		other.setItem_price(10.99);
		assertFalse(item.equals(other));
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
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item(null, null);
		Item other = new Item(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Item [id=1, item_name=Red Wrench, item_price=18.99]";
		assertEquals(toString, item.toString());
	}

}
