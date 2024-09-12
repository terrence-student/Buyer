package dao;

import java.util.List;

import model.Seller;

public interface SellerDao {
	
	//create
	void addSeller(Seller s);
	
	//reed
	List<Seller> selectAll();
	List<Seller> findByCompanyNumber(String number);
	List<Seller> findByShortname(String shortname);
	//update
	void Update(Seller s);
	//delete
	void DeleteByCompanyNumber(String number);
}
