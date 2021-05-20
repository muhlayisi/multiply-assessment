package za.co.multiply.shoppe.service;

import java.util.List;

import za.co.multiply.shoppe.data.Product;

public interface ProductService {
	List<Product> findAllProducts();
	boolean productExist(String code);
}
