package dao;

import java.util.List;

import model.Invoice;


public interface InvoiceDao {
	//create
		void addInvoice(Invoice i);
		
		//reed
		List<Invoice> selectAll();
		List<Invoice> findByInvoice(String invoice);
		List<Invoice> findByNumber(String Number);
		//update
		void Update(Invoice i);
		//delete
		void DeleteByInvoice(String invoice);

}
