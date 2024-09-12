package service.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.AccountantDaoImpl;
import model.Accountant;
import service.AccountantService;

public class AccountantServiceImpl implements AccountantService {
	
	private static AccountantDaoImpl adi=new AccountantDaoImpl();
	public static void main(String[] args) {
		List<Accountant> l=new ArrayList();
		List<Accountant> l2=new ArrayList();
		l=new AccountantServiceImpl().selectByInvoice("c1");
				Accountant o=l.get(0);
				String h="c1部部";
				for(int i=1;i<=l.size();i++) 
				{	l2=adi.selectByInvoiceForProduct("c1", i);
					Accountant a =l2.get(0); 
						
						if(!h.equals(a.getDepartment()))
						{
							a.setDepartment(h);
							new  AccountantServiceImpl().UpdateAccountByInvoiceAndItem(a);
						}
						
					
					
				}
				
				
			}
						
	@Override
	public void addAccount(Accountant a) {
		adi.addAccount(a);
		
	}

	@Override
	public List<Accountant> selectAll() {
		List<Accountant> l=new ArrayList();
		l=adi.selectAll();
		return l;
	}

	@Override
	public boolean checkInvoice(String Invoice) {
		List<Accountant> l=new ArrayList();
		l=adi.selectByInvoice(Invoice);
		boolean x=false;
		if (l.size()!=0) 
		{
			x=true;
			
		}
		return x;
	}
	


	@Override
	public void UpdateAccount(Accountant a) {
		adi.UpdateAccount(a);
		
	}

	@Override
	public void DeleteByInvoice(String Invoice) {
		adi.DeleteByInvoice(Invoice);
		
	}

	@Override
	public void DeleteByItemAndProuctNumber(Accountant a) {
		adi.DeleteByItemAndProuctNumber(a);
		
	}

	@Override
	public List<Accountant> selectByInvoice(String Invoice) {
		List<Accountant> l=new ArrayList();
		l=adi.selectByInvoice(Invoice);	
		return l;
	}
	
	
	

	@Override
	public boolean checkItemByInvoice(String invoice,Integer item) {
		List<Accountant> l=new ArrayList();
		l=adi.selectByInvoice(invoice);
		boolean x=false;
		for(Accountant o:l) 
		{
			if(o.getItem()==item)
			{
				x=true;
				return x;
			}
		}
		return x;
	}

	@Override
	public void UpdateAccountByInvoiceAndItem(Accountant a) {
		adi.UpdateAccountByInvoiceAndItem(a);
		
	}

	@Override
	public void UpdateAccountByInvoiceAndItemForProduct(Accountant a) {
		adi.UpdateAccountByInvoiceAndItemForProduct(a);
		
	}

	@Override
	public List<Accountant> selectByInvoiceForProduct(String Invoice, int Item) {
		List<Accountant> l=new ArrayList();
		l=adi.selectByInvoiceForProduct(Invoice,Item);	
		return l;
	}



	

	
}
