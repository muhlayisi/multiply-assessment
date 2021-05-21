package za.co.multiply.shoppe;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import za.co.multiply.shoppe.data.Customer;
import za.co.multiply.shoppe.data.CustomerRepository;
import za.co.multiply.shoppe.data.Product;
import za.co.multiply.shoppe.data.ProductRepository;
import za.co.multiply.shoppe.model.PurchaseRequest;

@DataJpaTest
class PurchaseTests {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	void testPurchaseProducts() {
		Customer customer = new Customer("Candy", 1000);
		Customer savedCustomer = customerRepository.save(customer);
		assertNotNull(savedCustomer);
		
		Product product = new Product("1011", "Prod1", 100);
		Product savedProduct = productRepository.save(product);
		assertNotNull(savedProduct);
		
		PurchaseRequest purchaseRequest = new PurchaseRequest();
		purchaseRequest.setCustomerId(1);
		List<Product> productsList = new ArrayList<>();
		productsList.add(new Product("1011", "Prod1", 100));
		purchaseRequest.setProducts(productsList);
		
		Optional<Customer> optionalCustomer = customerRepository.findById(1);
		assertTrue(optionalCustomer.isPresent());
		
		Customer c = optionalCustomer.get();
		
		List<Product> products = purchaseRequest.getProducts();
		assertTrue(products != null);
		assertTrue(products.size() > 0);

		Iterator<Product> iterator = products.iterator();
		double total = 0.0;
		while (iterator.hasNext()) {
			Product p = iterator.next();
			assertTrue(productRepository.existsByCode(p.getCode()));
			
			total+=p.getCost();
		}
		
		assertTrue(c.getPoints() >= total);
		
		c.setPoints(c.getPoints() - total);
		
		Customer savedCustomer2 = customerRepository.save(c);
		
		assertNotNull(savedCustomer2);
	}
	
}
