package service.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.SellerDaoImpl;
import model.Seller;
import service.SellerService;

public class SellerServiceImpl implements SellerService{
	
	SellerDaoImpl sdi=new SellerDaoImpl();
	
	public static void main(String[] args) {
		
		List<Seller> l = new ArrayList();
		String x="20970807";
		l=new SellerDaoImpl().findByCompanyNumber(x);
		for(Seller o:l)
			System.out.println(o.getCompanyAddress());
		
		
			
			
		
		

	}

	@Override
	public void newSellerAdd(Seller s) {
		sdi.addSeller(s);
		
	}

	@Override
	public boolean checkSellerNumber(String number) {
		List<Seller> l=sdi.findByCompanyNumber(number);
		boolean x=false;
		if (l.size()!=0) 
		{
			x=true;
			
		}
		
		return x;
		
		
	}

	@Override
	public List<Seller> selectAll() {
		List<Seller> l=new ArrayList();
		l=sdi.selectAll();
		
		
		return l;
	}

	@Override
	public List<Seller> selectAllByNumber(String number) {
		List<Seller> l=new ArrayList();
		l=sdi.findByCompanyNumber(number);
		
		
		return l;
	}
	
	@Override
	public List<Seller> selectAllByShortname(String shortname) {
		List<Seller> l=new ArrayList();
		l=sdi.findByShortname(shortname);
		
		
		return l;
	}

	@Override
	public void UpdateSeller(Seller s) {
		 sdi.Update(s);
		
	}

	@Override
	public void DeleteByNumber(String number) {
		sdi.DeleteByCompanyNumber(number);
		
	}

	@Override
	public boolean checkByShortname(String shortname) {
		List<Seller> l=sdi.findByShortname(shortname);
		boolean x=false;
		if (l.size()!=0) 
		{
			x=true;
			
		}
		
		return x;
	}

	
	
	
	
	
	
	
}
