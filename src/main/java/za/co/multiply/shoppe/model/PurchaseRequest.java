package za.co.multiply.shoppe.model;

import java.util.List;

import lombok.Data;
import za.co.multiply.shoppe.data.Product;

@Data
public class PurchaseRequest {
	
	private Long customerId;
	private List<Product> products;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
