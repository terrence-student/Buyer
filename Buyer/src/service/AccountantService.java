package service;

import java.util.List;

import model.Accountant;

public interface AccountantService {
	//create
	void addAccount(Accountant a);
	//read
	List<Accountant> selectAll();
	boolean checkInvoice(String Invoice);
	List<Accountant>selectByInvoice(String Invoice);
	public List<Accountant> selectByInvoiceForProduct(String Invoice,int Item);
	boolean checkItemByInvoice(String invoice,Integer item);
	
	
	//update
	void UpdateAccount(Accountant a);
	void UpdateAccountByInvoiceAndItem(Accountant a);
	void UpdateAccountByInvoiceAndItemForProduct(Accountant a);
	//delete
	void DeleteByInvoice(String Invoice);
	void DeleteByItemAndProuctNumber(Accountant a);
	
	
}
