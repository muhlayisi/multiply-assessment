package za.co.multiply.shoppe.service;

import java.util.List;
import java.util.Optional;

import za.co.multiply.shoppe.data.Customer;

public interface CustomerService {
	
	List<Customer> findAllCustomers();
	Optional<Customer> findCustomer(int id);
	Customer saveCustomer(Customer customer);
	
}
