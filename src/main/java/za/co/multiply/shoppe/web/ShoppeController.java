package za.co.multiply.shoppe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.multiply.shoppe.data.Customer;
import za.co.multiply.shoppe.data.Product;
import za.co.multiply.shoppe.model.PurchaseRequest;
import za.co.multiply.shoppe.model.PurchaseResponse;
import za.co.multiply.shoppe.service.CustomerService;
import za.co.multiply.shoppe.service.ProductService;
import za.co.multiply.shoppe.service.PurchaseService;

@RestController
@RequestMapping(value = "/api/v1/shoppe", produces = "application/json")
public class ShoppeController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PurchaseService purchaseService;
	
    @GetMapping("/customer/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
    	return ResponseEntity.ok(customerService.findAllCustomers());
    }
    
    @GetMapping("/product/all")
    public ResponseEntity<List<Product>> getAllProducts() {
    	return ResponseEntity.ok(productService.findAllProducts());
    }
    
    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponse> purchase(@RequestBody PurchaseRequest purchaseRequest) {
    	return ResponseEntity.ok(purchaseService.purchaseProducts(purchaseRequest));
    }
    
}
