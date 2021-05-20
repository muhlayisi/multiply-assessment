package za.co.multiply.shoppe.service;

import java.util.List;

import za.co.multiply.shoppe.data.Customer;

public interface CustomerService {
	List<Customer> findAllCustomers();
	Customer findCustomer(Long id);
	void saveCustomer(Customer customer);
}
