package za.co.multiply.shoppe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.multiply.shoppe.data.Product;
import za.co.multiply.shoppe.data.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public boolean productExist(String code) {
		return productRepository.existsByCode(code);
	} 

}
