package za.co.multiply.shoppe.model;

import java.util.List;

import lombok.Data;
import za.co.multiply.shoppe.data.Product;
import za.co.multiply.shoppe.enums.PurchaseStatus;

@Data
public class PurchaseResponse {

	private PurchaseStatus status;
	private int statusCode;
	private int customerId;
	private List<Product> products;
	private List<Product> invalidProducts;
	private double total;
	
	public PurchaseStatus getStatus() {
		return status;
	}
	public void setStatus(PurchaseStatus status) {
		this.status = status;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public List<Product> getInvalidProducts() {
		return invalidProducts;
	}
	public void setInvalidProducts(List<Product> invalidProducts) {
		this.invalidProducts = invalidProducts;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
