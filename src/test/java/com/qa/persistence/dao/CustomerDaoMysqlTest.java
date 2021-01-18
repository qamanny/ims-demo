package com.qa.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.domain.Customer;

public class CustomerDaoMysqlTest {
	

	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);

	private static final long NULL = 0;

	private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims_test";
	private static String username = "root";
	private static String password = "root";

	@BeforeClass
	public static void init() {
		Ims ims = new Ims();
		ims.init(jdbcConnectionUrl, username, password, "src/test/resources/sql-schema.sql");
	}

	@Before
	public void setup() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from customer;");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Test
	public void createTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		long id = 1L;
		String firstname = "James";
		String surname = "McArthur";
		Customer customer = new Customer(id, firstname, surname);
		Customer savedcustomer = new Customer(id, firstname, surname);
		ArrayList<Customer> customerRead = new ArrayList<>();
		customer = customerDaoMysql.create(customer);
		customerDaoMysql.readAll();
		assertEquals(customer, savedcustomer);
		assertNotNull(customerRead);
	}

	@Test
	public void updateTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		long id = 1L;
		String firstname = "James";
		String surname = "McArthur";
		Customer cust = new Customer(id, firstname, surname);
		Customer savedcust = new Customer(id, firstname, surname);
		cust = customerDaoMysql.update(cust);
		savedcust = customerDaoMysql.update(savedcust);
		assertEquals(cust, savedcust);
	}
}
