package za.co.multiply.shoppe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.multiply.shoppe.data.Customer;
import za.co.multiply.shoppe.data.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomer(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
}
