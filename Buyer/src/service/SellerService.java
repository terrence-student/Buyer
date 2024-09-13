package service;

import java.util.List;

import model.Seller;

public interface SellerService {
	
	//create
	void newSellerAdd(Seller s);
	
	//read
	boolean checkSellerNumber(String number);
	List<Seller> selectAll();
	List<Seller> selectAllByNumber(String number);
	List<Seller> selectAllByShortname(String shortname);
	boolean checkByShortname(String shortname);
	//update
	void UpdateSeller(Seller s);
	//delete
	void DeleteByNumber(String number);
}
