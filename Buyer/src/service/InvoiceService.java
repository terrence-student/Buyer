package service;

import java.util.List;

import model.Invoice;



public interface InvoiceService {
	
	//create
		void newInvoiceAdd(Invoice i);
		
		//read
		boolean checkInvoice(String invoice);
		List<Invoice> selectAll();
		List<Invoice> selectAllByInvoice(String invoice);
		List<Invoice> selectByNumber(String Number);
		//update
		void UpdateInvoice(Invoice i);
		//delete
		void DeleteByInvoice(String invoice);

}
