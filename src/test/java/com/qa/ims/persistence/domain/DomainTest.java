package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DomainTest {
	
	@SuppressWarnings("static-access")
	@Test
	public void customerTest() {
		Domain domain = Domain.CUSTOMER;
		assertTrue(domain.getDescription().toLowerCase().contains("customer"));
		domain.printDomains();
	}
	
	@Test
	public void itemTest() {
		Domain domain = Domain.ITEM;
		assertTrue(domain.getDescription().toLowerCase().contains("item"));
	}
	
	@Test
	public void orderTest() {
		Domain domain = Domain.ORDER;
		assertTrue(domain.getDescription().toLowerCase().contains("items"));
	}
	
	@Test
	public void stopTest() {
		Domain domain = Domain.STOP;
		assertTrue(domain.getDescription().toLowerCase().contains("close"));
	}
	
	@Test
	public void printTest() {
		
	}

}
