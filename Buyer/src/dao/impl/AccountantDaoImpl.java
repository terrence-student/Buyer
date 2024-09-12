 package dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.AccountantDao;
import dao.Dbconnection;
import model.Accountant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountantDaoImpl implements AccountantDao {

	public static void main(String[] args) {
		List<Accountant> l=new ArrayList();
		l=new AccountantDaoImpl().selectByInvoice("a1");
		Accountant a;
		a=new Accountant("gtest1","b2","b3","b4","b5",
				"b6", "b7", 1.3, "b8", 1.2, "a1",
				"b10", "b11", "b12","b14ttttttest", "b14", "b15",
				1, 2, 3, 4, 5,2,
				"b16", "b17",7,"b18testNo", 7);
		
		for(int i=1;i<=l.size();i++) {
				a.setItem(i);	
		
		new AccountantDaoImpl().UpdateAccountByInvoiceAndItem(a);
		//new AccountantDaoImpl().UpdateAccountByInvoiceAndItemForProduct(a);
		}
		
		
		
		
		/*
		List<Accountant> l2=new ArrayList();
		l2=new AccountantDaoImpl().selectByInvoice("b9");
		boolean x=false;
		if (l.size()!=0) 
		{
			x=true;
			
		}
		System.out.println(x);
		*/
	}

	@Override
	public void addAccount(Accountant a) {
		Connection cn=Dbconnection.getDb();
		String SQL="INSERT INTO accountant (PRBuyer, Department, InvoiceCompany, CompanyNumber, CostType, CostName, Currency, ExchangeRate, TaxType, TaxRate, Invoice, PayWay, PayType, PayDate, PaymentType, PayExpireDate, PayState, UseCurrency, Tax, Sum, Paid, NonPayment, Item, ProductNumber, ProductName, Amount, Unit, Price)"
				+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=cn.prepareStatement(SQL);
			ps.setString(1, a.getPRBuyer());ps.setString(2, a.getDepartment());ps.setString(3,a.getInvoiceCompany());ps.setString(4,a.getCompanyNumber());
			ps.setString(5, a.getCostType());ps.setString(6,a.getCostName());ps.setString(7, a.getCurrency());ps.setDouble(8, a.getExchangeRate());ps.setString(9,a.getTaxType());ps.setDouble(10,a.getTaxRate());ps.setString(11,a.getInvoice());
			ps.setString(12,a.getPayWay());ps.setString(13, a.getPayType());ps.setString(14,a.getPayDate());ps.setString(15,a.getPaymentType());ps.setString(16,a.getPayExpireDate());ps.setString(17,a.getPayState());
			ps.setInt(18,a.getUseCurrency());ps.setInt(19, a.getTax());ps.setInt(20, a.getSum());ps.setInt(21, a.getPaid());ps.setInt(22, a.getNonpayment());
			ps.setInt(23,a.getItem());ps.setString(24, a.getProductNumber());ps.setString(25, a.getProductName());ps.setInt(26, a.getAmount());ps.setString(27, a.getUnit());ps.setInt(28, a.getPrice());
			
			ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Accountant> selectAll() {
		Connection cn=Dbconnection.getDb();
		List<Accountant> l=new ArrayList();
		
		String SQL="select * from accountant";
		
		try {
			PreparedStatement ps=cn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{	
				Accountant a=new Accountant();
				a.setPRBuyer(rs.getString("PRBuyer"));
				a.setDepartment(rs.getString("Department"));
				a.setInvoiceCompany(rs.getString("InvoiceCompany"));
				a.setCompanyNumber(rs.getString("CompanyNumber"));
				
				a.setCostType(rs.getString("CostType"));
				a.setCostName(rs.getString("CostName"));
				a.setCurrency(rs.getString("Currency"));
				a.setExchangeRate(rs.getDouble("ExchangeRate"));
				a.setTaxType(rs.getString("TaxType"));
				a.setTaxRate(rs.getDouble("TaxRate"));
				a.setInvoice(rs.getString("Invoice"));
				
				a.setPayWay(rs.getString("PayWay"));
				a.setPayType(rs.getString("PayType"));
				a.setPayDate(rs.getString("PayDate"));
				a.setPaymentType(rs.getString("PaymentType"));
				a.setPayExpireDate(rs.getString("PayExpireDate"));
				a.setPayState (rs.getString("PayState"));
				
				a.setUseCurrency(rs.getInt("UseCurrency"));
				a.setTax(rs.getInt("Tax"));
				a.setSum(rs.getInt("Sum"));
				a.setPaid(rs.getInt("Paid"));
				a.setNonpayment(rs.getInt("NonPayment"));
				
				a.setItem(rs.getInt("Item"));
				a.setProductNumber(rs.getString("ProductNumber"));
				a.setProductName(rs.getString("ProductName"));
				a.setAmount(rs.getInt("Amount"));
				a.setUnit(rs.getString("Unit"));
				a.setPrice(rs.getInt("Price"));
				
				l.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return l;
	}

	@Override
	public List<Accountant> selectByInvoice(String Invoice) {
		Connection cn=Dbconnection.getDb();
		List<Accountant> l=new ArrayList();
		
		
		try {
			
			
			String SQL="select * from accountant where Invoice=?"; 
			PreparedStatement ps;
			ps = cn.prepareStatement(SQL);
			ps.setString(1, Invoice);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Accountant a=new Accountant();
				a.setPRBuyer(rs.getString("PRBuyer"));
				a.setDepartment(rs.getString("Department"));
				a.setInvoiceCompany(rs.getString("InvoiceCompany"));
				a.setCompanyNumber(rs.getString("CompanyNumber"));
				
				a.setCostType(rs.getString("CostType"));
				a.setCostName(rs.getString("CostName"));
				a.setCurrency(rs.getString("Currency"));
				a.setExchangeRate(rs.getDouble("ExchangeRate"));
				a.setTaxType(rs.getString("TaxType"));
				a.setTaxRate(rs.getDouble("TaxRate"));
				a.setInvoice(rs.getString("Invoice"));
				
				a.setPayWay(rs.getString("PayWay"));
				a.setPayType(rs.getString("PayType"));
				a.setPayDate(rs.getString("PayDate"));
				a.setPaymentType(rs.getString("PaymentType"));
				a.setPayExpireDate(rs.getString("PayExpireDate"));
				a.setPayState (rs.getString("PayState"));
				
				a.setUseCurrency(rs.getInt("UseCurrency"));
				a.setTax(rs.getInt("Tax"));
				a.setSum(rs.getInt("Sum"));
				a.setPaid(rs.getInt("Paid"));
				a.setNonpayment(rs.getInt("NonPayment"));
				
				a.setItem(rs.getInt("Item"));
				a.setProductNumber(rs.getString("ProductNumber"));
				a.setProductName(rs.getString("ProductName"));
				a.setAmount(rs.getInt("Amount"));
				a.setUnit(rs.getString("Unit"));
				a.setPrice(rs.getInt("Price"));
				
				l.add(a);
				
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return l;
	}
	
	@Override
	public List<Accountant> selectByInvoiceForProduct(String Invoice,int Item) {
		
		Connection cn=Dbconnection.getDb();
		List<Accountant> l=new ArrayList();
		
		
		try {
			
			
			String SQL="select * from accountant where Invoice=? and Item=?"; 
			PreparedStatement ps;
			ps = cn.prepareStatement(SQL);
			ps.setString(1, Invoice);
			ps.setInt(2, Item);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Accountant a=new Accountant();
				a.setPRBuyer(rs.getString("PRBuyer"));
				a.setDepartment(rs.getString("Department"));
				a.setInvoiceCompany(rs.getString("InvoiceCompany"));
				a.setCompanyNumber(rs.getString("CompanyNumber"));
				
				a.setCostType(rs.getString("CostType"));
				a.setCostName(rs.getString("CostName"));
				a.setCurrency(rs.getString("Currency"));
				a.setExchangeRate(rs.getDouble("ExchangeRate"));
				a.setTaxType(rs.getString("TaxType"));
				a.setTaxRate(rs.getDouble("TaxRate"));
				a.setInvoice(rs.getString("Invoice"));
				
				a.setPayWay(rs.getString("PayWay"));
				a.setPayType(rs.getString("PayType"));
				a.setPayDate(rs.getString("PayDate"));
				a.setPaymentType(rs.getString("PaymentType"));
				a.setPayExpireDate(rs.getString("PayExpireDate"));
				a.setPayState (rs.getString("PayState"));
				
				a.setUseCurrency(rs.getInt("UseCurrency"));
				a.setTax(rs.getInt("Tax"));
				a.setSum(rs.getInt("Sum"));
				a.setPaid(rs.getInt("Paid"));
				a.setNonpayment(rs.getInt("NonPayment"));
				
				a.setItem(rs.getInt("Item"));
				a.setProductNumber(rs.getString("ProductNumber"));
				a.setProductName(rs.getString("ProductName"));
				a.setAmount(rs.getInt("Amount"));
				a.setUnit(rs.getString("Unit"));
				a.setPrice(rs.getInt("Price"));
				
				l.add(a);
				
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return l;
	}
	

	@Override
	public void UpdateAccount(Accountant a) {
		Connection cn=Dbconnection.getDb();
		
				
		try {
			// 1. 設置 SQL_SAFE_UPDATES = 0
	        String disableSafeUpdates = "SET SQL_SAFE_UPDATES = 0";
	        PreparedStatement psDisable = cn.prepareStatement(disableSafeUpdates);
	        psDisable.executeUpdate();
			
			String SQL="update accountant set PRBuyer=?,Department=?,InvoiceCompany=?,CompanyNumber=?,"
					+ "CostType=?,CostName=?,Currency=?,ExchangeRate=?,TaxType=?,TaxRate=?,"
					+ "PayWay=?,PayType=?,PayDate=?,PaymentType=?,PayExpireDate=?,PayState=?,"
					+ "UseCurrency=?,Tax=?,Sum=?,Paid=?,NonPayment=?,"
					+ "Item=?,ProductNumber=?,ProductName=?,Amount=?,Unit=?,Price=? where Invoice=?";
			PreparedStatement ps=cn.prepareStatement(SQL);
			ps.setString(1, a.getPRBuyer());ps.setString(2, a.getDepartment());ps.setString(3,a.getInvoiceCompany());ps.setString(4,a.getCompanyNumber());
			ps.setString(5, a.getCostType());ps.setString(6,a.getCostName());ps.setString(7, a.getCurrency());ps.setDouble(8, a.getExchangeRate());ps.setString(9,a.getTaxType());ps.setDouble(10,a.getTaxRate());
			ps.setString(11,a.getPayWay());ps.setString(12, a.getPayType());ps.setString(13,a.getPayDate());ps.setString(14,a.getPaymentType());ps.setString(15,a.getPayExpireDate());ps.setString(16,a.getPayState());
			ps.setInt(17,a.getUseCurrency());ps.setInt(18, a.getTax());ps.setInt(19, a.getSum());ps.setInt(20, a.getPaid());ps.setInt(21, a.getNonpayment());
			ps.setInt(22,a.getItem());ps.setString(23, a.getProductNumber());ps.setString(24, a.getProductName());ps.setInt(25, a.getAmount());ps.setString(26, a.getUnit());ps.setInt(27, a.getPrice());
			ps.setString(28, a.getInvoice());
			
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
	public void DeleteByInvoice(String Invoice) {
		Connection cn=Dbconnection.getDb();
		
		try {
			// 1. 設置 SQL_SAFE_UPDATES = 0
	        String disableSafeUpdates = "SET SQL_SAFE_UPDATES = 0";
	        PreparedStatement psDisable = cn.prepareStatement(disableSafeUpdates);
	        psDisable.executeUpdate();
			
			String SQL="delete  from accountant where Invoice=?";
			PreparedStatement ps=cn.prepareStatement(SQL);
			ps.setString(1, Invoice);
			ps.executeUpdate();
			
			// 3. 設置 SQL_SAFE_UPDATES = 1
	        String enableSafeUpdates = "SET SQL_SAFE_UPDATES = 1";
	        PreparedStatement psEnable = cn.prepareStatement(enableSafeUpdates);
	        psEnable.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void DeleteByItemAndProuctNumber(Accountant a) {
		Connection cn=Dbconnection.getDb();
		
		
		try {
			// 1. 設置 SQL_SAFE_UPDATES = 0
	        String disableSafeUpdates = "SET SQL_SAFE_UPDATES = 0";
	        PreparedStatement psDisable = cn.prepareStatement(disableSafeUpdates);
	        psDisable.executeUpdate();
			
	        String SQL="delete  from accountant where Invoice=? and ProuctNumber=?";
			PreparedStatement ps=cn.prepareStatement(SQL);
			ps.setString(1,a.getInvoice());
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
	public void UpdateAccountByInvoiceAndItemForProduct(Accountant a) {
	    Connection cn = Dbconnection.getDb();
	    
	    try {
	        // 1. 設置 SQL_SAFE_UPDATES = 0
	        String disableSafeUpdates = "SET SQL_SAFE_UPDATES = 0";
	        PreparedStatement psDisable = cn.prepareStatement(disableSafeUpdates);
	        psDisable.executeUpdate();
	        
	        // 修改這裡的 SQL 語句
	        String SQL = "UPDATE buyer.accountant SET ProductNumber = ?, ProductName = ?, Amount = ?, Unit = ?, Price = ? "
	                    + "WHERE Invoice = ? AND Item = ?";
	        
	        PreparedStatement ps = cn.prepareStatement(SQL);
	        ps.setString(1, a.getProductNumber());
	        ps.setString(2, a.getProductName());
	        ps.setInt(3, a.getAmount());
	        ps.setString(4, a.getUnit());
	        ps.setInt(5, a.getPrice());
	        ps.setString(6, a.getInvoice()); // 確保 Invoice 是正確的
	        ps.setInt(7, a.getItem());       // 確保 Item 是正確的
	        
	        ps.executeUpdate();
	        
	        // 3. 設置 SQL_SAFE_UPDATES = 1
	        String enableSafeUpdates = "SET SQL_SAFE_UPDATES = 1";
	        PreparedStatement psEnable = cn.prepareStatement(enableSafeUpdates);
	        psEnable.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void UpdateAccountByInvoiceAndItem(Accountant a) {
Connection cn=Dbconnection.getDb();
		
		
		try {
			// 1. 設置 SQL_SAFE_UPDATES = 0
	        String disableSafeUpdates = "SET SQL_SAFE_UPDATES = 0";
	        PreparedStatement psDisable = cn.prepareStatement(disableSafeUpdates);
	        psDisable.executeUpdate();
			
	        String SQL = "update buyer.accountant set PRBuyer=?,Department=?,InvoiceCompany=?,CompanyNumber=?,"
	                + "CostType=?,CostName=?,Currency=?,ExchangeRate=?,TaxType=?,TaxRate=?,"
	                + "PayWay=?,PayType=?,PayDate=?,PaymentType=?,PayExpireDate=?,PayState=?,"
	                + "UseCurrency=?,Tax=?,Sum=?,Paid=?,NonPayment=? "
	                + "where Invoice=? and Item=?";
			PreparedStatement ps=cn.prepareStatement(SQL);
			ps.setString(1, a.getPRBuyer());ps.setString(2, a.getDepartment());ps.setString(3,a.getInvoiceCompany());ps.setString(4,a.getCompanyNumber());
			ps.setString(5, a.getCostType());ps.setString(6,a.getCostName());ps.setString(7, a.getCurrency());ps.setDouble(8, a.getExchangeRate());ps.setString(9,a.getTaxType());ps.setDouble(10,a.getTaxRate());
			ps.setString(11,a.getPayWay());ps.setString(12, a.getPayType());ps.setString(13,a.getPayDate());ps.setString(14,a.getPaymentType());ps.setString(15,a.getPayExpireDate());ps.setString(16,a.getPayState());
			ps.setInt(17,a.getUseCurrency());ps.setInt(18, a.getTax());ps.setInt(19, a.getSum());ps.setInt(20, a.getPaid());ps.setInt(21, a.getNonpayment());
			ps.setString(22, a.getInvoice());ps.setInt(23,a.getItem());
			
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
