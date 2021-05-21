package za.co.multiply.shoppe;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import za.co.multiply.shoppe.data.Product;
import za.co.multiply.shoppe.data.ProductRepository;

@DataJpaTest
class ProductTests {

	@Autowired
	private ProductRepository repository;
	
	@Test
	@Order(1)
	@Rollback(false)
	void testSaveProduct() {
		Product product = new Product("1011", "Prod1", 100);
		Product savedProduct = repository.save(product);
		assertNotNull(savedProduct);
		
	}
	
	@Test
	@Order(2)
	void testFindAllProducts() {
		List<Product> products = repository.findAll();
		assertTrue(products.size() > 0);
	}

	@Test
	@Order(3)
	void testProductExist() {
		assertTrue(repository.existsByCode("1011"));
	}

}
