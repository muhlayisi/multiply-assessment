package za.co.multiply.shoppe.service;

import za.co.multiply.shoppe.model.PurchaseRequest;
import za.co.multiply.shoppe.model.PurchaseResponse;

public interface PurchaseService {
	
	PurchaseResponse purchaseProducts(PurchaseRequest purchaseRequest);
	
}
