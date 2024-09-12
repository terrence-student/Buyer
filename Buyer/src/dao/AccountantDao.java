package dao;

import java.util.List;

import model.Accountant;

public interface AccountantDao {
	
	
	//create
	void addAccount(Accountant a);
	
	//read
	List<Accountant> selectAll();
	List<Accountant> selectByInvoice(String Invoice); 
	List<Accountant> selectByInvoiceForProduct(String Invoice,int Item);
	 
	
	//update
	void UpdateAccount(Accountant a);
	void UpdateAccountByInvoiceAndItem(Accountant a);
	void UpdateAccountByInvoiceAndItemForProduct(Accountant a);
	
	//delete
	void DeleteByInvoice(String Invoice);
	void DeleteByItemAndProuctNumber(Accountant a);
}
