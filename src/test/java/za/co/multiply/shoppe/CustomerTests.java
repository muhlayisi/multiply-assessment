package za.co.multiply.shoppe;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import za.co.multiply.shoppe.data.Customer;
import za.co.multiply.shoppe.data.CustomerRepository;

@DataJpaTest
class CustomerTests {

	@Autowired
	private CustomerRepository repository;
	
	@Test
	@Order(1)
	@Rollback(false)
	void testSaveCustomer() {
		Customer customer = new Customer("Candy", 1000);
		Customer savedCustomer = repository.save(customer);
		assertNotNull(savedCustomer);
	}
	
	@Test
	@Order(2)
	void testFindAllCustomers() {
		List<Customer> customers = repository.findAll();
		assertTrue(customers.size() > 0);
	}

	@Test
	@Order(3)
	void testFindCustomer() {
		Optional<Customer> customer = repository.findById(1);
		assertTrue(customer.isPresent());
	}

}
