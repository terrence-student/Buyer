package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Dbconnection;
import dao.InvoiceDao;
import model.Invoice;
import model.Member;

public class InvoiceDaoImpl implements InvoiceDao {

	public static void main(String[] args) {
		
		Invoice i=new Invoice("a7","a7_1","a7_2","a7_3","電子發票",7777,7388);
		new InvoiceDaoImpl().addInvoice(i);
	}

	@Override
	public void addInvoice(Invoice i) {
		Connection cn=Dbconnection.getDb();
		
		try {
			String SQL="insert into invoice(Invoice,CompanyNumber,CompanyShortName,InvoiceDate,InvoiceType,Money,MoneyInTxt)"+
						"values(?,?,?,?,?,?,?)";
			
			PreparedStatement ps=cn.prepareStatement(SQL);
			
			ps.setString(1,i.getInvoice());
			ps.setString(2,i.getCompanyNumber());
			ps.setString(3,i.getCompanyShortName());
			ps.setString(4,i.getInvoiceDate());
			ps.setString(5,i.getInvoiceType());
			ps.setInt(6,i.getMoney());
			ps.setInt(7,i.getMoneyInTxt());
			
			
			ps.executeUpdate();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	

	@Override
	public List<Invoice> selectAll() {
		// TODO Auto-generated method stub
		Connection cn=Dbconnection.getDb();
		String SQL="select * from invoice";
		List<Invoice> l=new ArrayList();
		
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Invoice i=new Invoice();
				i.setInvoice(rs.getString("Invoice"));
				i.setCompanyNumber(rs.getString("CompanyNumber"));
				i.setCompanyShortName(rs.getString("CompanyShortName"));
				i.setInvoiceDate(rs.getString("InvoiceDate"));
				i.setInvoiceType(rs.getString("InvoiceType"));
				i.setMoney(rs.getInt("Money"));
				i.setMoneyInTxt(rs.getInt("MoneyInTxt"));
				
		
				
				
				l.add(i);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
		
	}

	@Override
	public List<Invoice> findByInvoice(String invoice) {
		Connection cn=Dbconnection.getDb();
		List<Invoice> l=new ArrayList();
		
		try {
			
			
			String SQL="select * from invoice where Invoice=?";
			
			PreparedStatement ps =cn.prepareStatement(SQL);
			ps.setString(1, invoice);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				Invoice i=new Invoice();
				i.setInvoice(rs.getString("Invoice"));
				i.setCompanyNumber(rs.getString("CompanyNumber"));
				i.setCompanyShortName(rs.getString("CompanyShortName"));
				i.setInvoiceDate(rs.getString("InvoiceDate"));
				i.setInvoiceType(rs.getString("InvoiceType"));
				i.setMoney(rs.getInt("Money"));
				i.setMoneyInTxt(rs.getInt("MoneyInTxt"));
				
				l.add(i);
			}
			
			
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(NullPointerException e) {
				e.printStackTrace();
			}
		return l;	
				
				
			
		
	}
	
	@Override
	public List<Invoice> findByNumber(String Number) {
		Connection cn=Dbconnection.getDb();
		String SQL="select * from invoice where Number=?";
		List<Invoice> l=new ArrayList();
		
		try {
			PreparedStatement ps =cn.prepareStatement(SQL);
			ps.setString(1, Number);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				Invoice i=new Invoice();
				i.setInvoice(rs.getString("Invoice"));
				i.setCompanyNumber(rs.getString("CompanyNumber"));
				i.setCompanyShortName(rs.getString("CompanyShortName"));
				i.setInvoiceDate(rs.getString("InvoiceDate"));
				i.setInvoiceType(rs.getString("InvoiceType"));
				i.setMoney(rs.getInt("Money"));
				i.setMoneyInTxt(rs.getInt("MoneyInTxt"));
				
				l.add(i);
			}
			
			
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(NullPointerException e) {
				e.printStackTrace();
			}
				
				
				
			
		return l;
	}
	

	@Override
	public void Update(Invoice i) {
		Connection cn=Dbconnection.getDb();
		
		 
	        try {
	        	// 1. 設置 SQL_SAFE_UPDATES = 0
		        String disableSafeUpdates = "SET SQL_SAFE_UPDATES = 0";
		        PreparedStatement psDisable = cn.prepareStatement(disableSafeUpdates);
		        psDisable.executeUpdate();
	        	
	        	
	        	
	        	
	        	String SQL = "update invoice set CompanyNumber=?,CompanyShortName=?,InvoiceDate=?,InvoiceType=?,Money=?,MoneyInTxt=? where Invoice=? ";
		        PreparedStatement ps = cn.prepareStatement(SQL);
		        ps.setString(1,i.getCompanyNumber());
				ps.setString(2,i.getCompanyShortName());		        
		        ps.setString(3, i.getInvoiceDate());
	        	ps.setString(4,i.getInvoiceType());
	        	ps.setInt(5,i.getMoney());
	        	ps.setInt(6,i.getMoneyInTxt());
	        	ps.setString(7,i.getInvoice());
	        	
	        	ps.executeUpdate();
	        	
	        	 // 3. 設置 SQL_SAFE_UPDATES = 1
		        String enableSafeUpdates = "SET SQL_SAFE_UPDATES = 1";
		        PreparedStatement psEnable = cn.prepareStatement(enableSafeUpdates);
		        psEnable.executeUpdate();
	        	
	        	
	        	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void DeleteByInvoice(String invoice) {
		Connection cn=Dbconnection.getDb();
		String SQL="delete from invoice where Invoice=?";
		
		
		
		try {
			// 1. 設置 SQL_SAFE_UPDATES = 0
	        String disableSafeUpdates = "SET SQL_SAFE_UPDATES = 0";
	        PreparedStatement psDisable = cn.prepareStatement(disableSafeUpdates);
	        psDisable.executeUpdate();
			
			
			PreparedStatement ps=cn.prepareStatement(SQL);
			ps.setString(1,invoice);
			ps.executeUpdate();
			
			// 3. 設置 SQL_SAFE_UPDATES = 1
	        String enableSafeUpdates = "SET SQL_SAFE_UPDATES = 1";
	        PreparedStatement psEnable = cn.prepareStatement(enableSafeUpdates);
	        psEnable.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
	
}
