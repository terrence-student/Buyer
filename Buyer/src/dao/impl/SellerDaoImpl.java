package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Dbconnection;
import dao.SellerDao;
import model.Seller;

public class SellerDaoImpl implements SellerDao {

	public static void main(String[] args) {
		Seller s=new Seller("a1","atest","a3","a4",1,"a5","a6","a7","a8","a9","a10");
		//new SellerDaoImpl().addSeller(s);
		
		
		List<Seller> l=new ArrayList();
		new SellerDaoImpl().Update(s);
		
	}

	@Override
	public void addSeller(Seller s) {
		Connection cn=Dbconnection.getDb();
		String SQL="insert into seller(CompanyNumber,CompanyName,ShortName,"
				+ "InvoiceType,PostCode,ContactPerson,`E-mail`,phone,"
				+ "fax,CompanyAddress,InvoiceAddress)" + "values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=cn.prepareStatement(SQL);
			ps.setString(1, s.getCompanynumber());
			ps.setString(2, s.getCompanyName());
			ps.setString(3, s.getShortName());
			ps.setString(4, s.getInvoiceType());
			ps.setInt(5, s.getPostCode());
			ps.setString(6,s.getContactPerson());
			ps.setString(7,s.getEmail());
			ps.setString(8, s.getPhone());
			ps.setString(9,s.getFax());
			ps.setString(10, s.getCompanyAddress());
			ps.setString(11, s.getInvoiceAddress());
			
			ps.executeUpdate();
			
				} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Seller> selectAll() {
		Connection cn=Dbconnection.getDb();
		String SQL="select * from seller";
		List<Seller> l=new ArrayList();
		try {
			PreparedStatement ps=cn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			
			while (rs.next()) 
			{
				Seller s=new Seller();
				s.setCompanynumber(rs.getString("CompanyNumber"));
				s.setCompanyName(rs.getString("CompanyName"));
				s.setShortName(rs.getString("ShortName"));
				s.setInvoiceType(rs.getString("InvoiceType"));
				s.setPostCode(rs.getInt("PostCode"));
				s.setContactPerson(rs.getString("ContactPerson"));
				s.setEmail(rs.getString("E-mail"));
				s.setPhone(rs.getString("Phone"));
				s.setFax(rs.getString("fax"));
				s.setCompanyAddress(rs.getString("CompanyAddress"));
				s.setInvoiceAddress(rs.getString("InvoiceAddress"));
				l.add(s);
	
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Seller> findByCompanyNumber(String number) {
		Connection cn=Dbconnection.getDb();
		
		List<Seller> l=new ArrayList();
		try {
				String disableSafeUpdates = "SET SQL_SAFE_UPDATES = 0";
		        PreparedStatement psDisable = cn.prepareStatement(disableSafeUpdates);
		        psDisable.executeUpdate();
			
		        String SQL="select * from buyer.seller where CompanyNumber=?";
		        PreparedStatement ps=cn.prepareStatement(SQL);
		        ps.setString(1,number);
		        ResultSet rs=ps.executeQuery();
		        
		        String enableSafeUpdates = "SET SQL_SAFE_UPDATES = 1";
		        PreparedStatement psEnable = cn.prepareStatement(enableSafeUpdates);
		        psEnable.executeUpdate();
		        
		        while(rs.next()) 
			{
				Seller s=new Seller();
				s.setCompanynumber(rs.getString("CompanyNumber"));
				s.setCompanyName(rs.getString("CompanyName"));
				s.setShortName(rs.getString("ShortName"));
				s.setInvoiceType(rs.getString("InvoiceType"));
				s.setPostCode(rs.getInt("PostCode"));
				s.setContactPerson(rs.getString("ContactPerson"));
				s.setEmail(rs.getString("E-mail"));
				s.setPhone(rs.getString("Phone"));
				s.setFax(rs.getString("fax"));
				s.setCompanyAddress(rs.getString("CompanyAddress"));
				s.setInvoiceAddress(rs.getString("InvoiceAddress"));
				l.add(s);
			}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return l;
	}
	
	@Override
	public List<Seller> findByShortname(String shortname) {
		Connection cn=Dbconnection.getDb();
		
		List<Seller> l=new ArrayList();
		try {
			
	        String disableSafeUpdates = "SET SQL_SAFE_UPDATES = 0";
	        PreparedStatement psDisable = cn.prepareStatement(disableSafeUpdates);
	        psDisable.executeUpdate();
			

			
	        String SQL="select * from buyer.seller where ShortName=?";
			PreparedStatement ps=cn.prepareStatement(SQL);
			ps.setString(1,shortname);
			ResultSet rs=ps.executeQuery();
			
			
			String enableSafeUpdates = "SET SQL_SAFE_UPDATES = 1";
	        PreparedStatement psEnable = cn.prepareStatement(enableSafeUpdates);
	        psEnable.executeUpdate();
			
			
			while(rs.next()) 
			{
				Seller s=new Seller();
				s.setCompanynumber(rs.getString("CompanyNumber"));
				s.setCompanyName(rs.getString("CompanyName"));
				s.setShortName(rs.getString("ShortName"));
				s.setInvoiceType(rs.getString("InvoiceType"));
				s.setPostCode(rs.getInt("PostCode"));
				s.setContactPerson(rs.getString("ContactPerson"));
				s.setEmail(rs.getString("E-mail"));
				s.setPhone(rs.getString("Phone"));
				s.setFax(rs.getString("fax"));
				s.setCompanyAddress(rs.getString("CompanyAddress"));
				s.setInvoiceAddress(rs.getString("InvoiceAddress"));
				l.add(s);
			}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return l;
	}

	@Override
	public void Update(Seller s) {
		 Connection cn = Dbconnection.getDb();
		    String SQL = "update buyer.seller set CompanyName=?, ShortName=?,"
		               + "InvoiceType=?, PostCode=?, ContactPerson=?, `E-mail`=?, phone=?, fax=?,"
		               + "CompanyAddress=?, InvoiceAddress=? where CompanyNumber=?";
		    try {
		        PreparedStatement ps = cn.prepareStatement(SQL);
		        ps.setString(1, s.getCompanyName());
		        ps.setString(2, s.getShortName());
		        ps.setString(3, s.getInvoiceType());
		        ps.setInt(4, s.getPostCode());
		        ps.setString(5, s.getContactPerson());
		        ps.setString(6, s.getEmail());
		        ps.setString(7, s.getPhone());
		        ps.setString(8, s.getFax());
		        ps.setString(9, s.getCompanyAddress());
		        ps.setString(10, s.getInvoiceAddress());
		        ps.setString(11, s.getCompanynumber());

		        ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void DeleteByCompanyNumber(String number) {
		Connection cn=Dbconnection.getDb();
		String SQL="delete * from seller where=?";
		try {
			PreparedStatement ps=cn.prepareStatement(SQL);
			ps.setString(1, number);
		
			ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
