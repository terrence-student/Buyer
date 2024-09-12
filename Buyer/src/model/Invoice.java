package model;

public class Invoice {
	String Invoice;
	String CompanyNumber;
	String CompanyShortName;
	String  InvoiceDate;
	String  InvoiceType;
	Integer Money;
	Integer MoneyInTxt;
	
	public Invoice() {}
	
	public Invoice(String invoice,String companyNumber,String companyShortName, String invoiceDate,String invoiceType, Integer money, Integer moneyInTxt) {
		super();
		Invoice = invoice;
		CompanyNumber = companyNumber;
		CompanyShortName = companyShortName;
		InvoiceDate = invoiceDate;
		InvoiceType=invoiceType;
		Money = money;
		MoneyInTxt = moneyInTxt;
	}
	public String getInvoice() {
		return Invoice;
	}
	public void setInvoice(String invoice) {
		Invoice = invoice;
	}
	
	
	public String getCompanyNumber() {
		return CompanyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		CompanyNumber = companyNumber;
	}

	public String getCompanyShortName() {
		return CompanyShortName;
	}

	public void setCompanyShortName(String companyShortName) {
		CompanyShortName = companyShortName;
	}

	public String getInvoiceDate() {
		return InvoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		InvoiceDate = invoiceDate;
	}
	
	public String getInvoiceType() {
		return InvoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		InvoiceType = invoiceType;
	}
	
	public Integer getMoney() {
		return Money;
	}
	public void setMoney(Integer money) {
		Money = money;
	}
	public Integer getMoneyInTxt() {
		return MoneyInTxt;
	}
	public void setMoneyInTxt(Integer moneyInTxt) {
		MoneyInTxt = moneyInTxt;
	}



	
	

}
