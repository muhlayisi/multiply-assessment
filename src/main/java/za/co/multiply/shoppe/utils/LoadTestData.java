package za.co.multiply.shoppe.utils;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.multiply.shoppe.data.Customer;
import za.co.multiply.shoppe.data.CustomerRepository;
import za.co.multiply.shoppe.data.Product;
import za.co.multiply.shoppe.data.ProductRepository;

@Component
public class LoadTestData {
	
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    @Transactional
    public void execute() {
        createCustomer("Banner", 1000);
        createCustomer("Stark", 2000);

        createProduct("1011", "Prod1", 100);
        createProduct("1012", "Prod2", 200);
        createProduct("1013", "Prod3", 300);
        createProduct("1014", "Prod4", 400);
        createProduct("1015", "Prod5", 500);
    }

    private void createCustomer(String name, double points) {
    	Customer c = new Customer();
    	c.setName(name);
    	c.setPoints(points);
      
        customerRepository.save(c);
    }

    private void createProduct(String code, String name, double cost) {
    	Product p = new Product();
    	p.setCode(code);
    	p.setName(name);
    	p.setCost(cost);
       
        productRepository.save(p);
    }
}
