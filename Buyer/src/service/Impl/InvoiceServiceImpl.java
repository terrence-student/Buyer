package service.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.InvoiceDaoImpl;
import model.Invoice;
import model.Seller;
import service.InvoiceService;

public class InvoiceServiceImpl implements InvoiceService {
	
	static InvoiceDaoImpl idi=new InvoiceDaoImpl();
	public static void main(String[] args) {
		//boolean x=new InvoiceServiceImpl().checkInvoice("c");
		//System.out.println(x);
		 List<Invoice> l=new  ArrayList();
		 l=new InvoiceServiceImpl().selectAllByInvoice("a5");
		System.out.println(l);
		
		for(Invoice o:l) 
		{
			System.out.println(o.getInvoiceType());
		}
		
		

	}
	@Override
	public void newInvoiceAdd(Invoice i) {
		idi.addInvoice(i);
		
	}
	@Override
	public boolean checkInvoice(String invoice) {
		List<Invoice> l=idi.findByInvoice(invoice);
		boolean x=false;
		if (l.size()!=0) 
		{
			x=true;
			return x;
		}
		
		else return x;
	}
	@Override
	public List<Invoice> selectAll() {
		List<Invoice> l=new ArrayList();
		l=idi.selectAll();
		
		
		return l;
	}
	@Override
	public List<Invoice> selectAllByInvoice(String invoice) {
		List<Invoice> l=new ArrayList();
		l=idi.findByInvoice(invoice);
		
		
		return l;
	}
	
	@Override
	public List<Invoice> selectByNumber(String Number) {
		List<Invoice> l=new ArrayList();
		l=idi.findByNumber(Number);
		
		
		return l;
	}
	
	@Override
	public void UpdateInvoice(Invoice i) {
		idi.Update(i);
		
	}
	@Override
	public void DeleteByInvoice(String invoice) {
		idi.DeleteByInvoice(invoice);
		
	}
	

}
