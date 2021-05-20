package za.co.multiply.shoppe.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import za.co.multiply.shoppe.data.Customer;
import za.co.multiply.shoppe.data.Product;
import za.co.multiply.shoppe.enums.PurchaseStatus;
import za.co.multiply.shoppe.model.PurchaseRequest;
import za.co.multiply.shoppe.model.PurchaseResponse;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;

	@Override
	public PurchaseResponse purchaseProducts(PurchaseRequest purchaseRequest) {
		PurchaseResponse purchaseResponse = new PurchaseResponse();
		purchaseResponse.setCustomerId(purchaseRequest.getCustomerId());
		
		Customer customer = customerService.findCustomer(purchaseRequest.getCustomerId());
		if(customer == null) {
			purchaseResponse.setStatus(PurchaseStatus.CUSTOMER_NOT_FOUND);
			purchaseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
			
			return purchaseResponse;
		}
		
		List<Product> products = purchaseRequest.getProducts();
		if(products == null || products.size() < 1) {
			purchaseResponse.setStatus(PurchaseStatus.NO_PRODUCTS);
			purchaseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
			
			return purchaseResponse;
		}
		purchaseResponse.setProducts(products);

		List<Product> invalidProducts = new ArrayList<Product>();
		Iterator<Product> iterator = products.iterator();
		double total = 0.0;
		
		while (iterator.hasNext()) {
			Product product = iterator.next();
			
			if(!productService.productExist(product.getCode()))
				invalidProducts.add(product);
			total+=product.getCost();
		}
		purchaseResponse.setTotal(total);
		
		if(invalidProducts.size() > 0) {
			purchaseResponse.setStatus(PurchaseStatus.INVALID_PRODUCTS);
			purchaseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
			purchaseResponse.setInvalidProducts(invalidProducts);
			
			return purchaseResponse;
		}
		
		if(total > customer.getPoints()) {
			purchaseResponse.setStatus(PurchaseStatus.INSUFICIENT_POINTS);
			purchaseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
			
			return purchaseResponse;
		}else {
			customer.setPoints(customer.getPoints() - total);
			customerService.saveCustomer(customer);
			
			purchaseResponse.setStatus(PurchaseStatus.OK);
			purchaseResponse.setStatusCode(HttpStatus.OK.value());
			
			return purchaseResponse;
		}
	}

}
