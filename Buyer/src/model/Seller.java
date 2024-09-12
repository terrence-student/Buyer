package model;

public class Seller {
	String Companynumber;
	String CompanyName;
	String ShortName;
	String InvoiceType;
	Integer PostCode;
	String ContactPerson;
	String Email;
	String phone;
	String fax;
	String CompanyAddress;
	String InvoiceAddress;
	
	public Seller(){}
	
	public Seller(String companynumber, String companyName, String shortName, String invoiceType, Integer postCode,
			String contactPerson, String email, String phone, String fax, String companyAddress, String invoiceAddress) {
		super();
		Companynumber = companynumber;
		CompanyName = companyName;
		ShortName = shortName;
		InvoiceType = invoiceType;
		PostCode = postCode;
		ContactPerson = contactPerson;
		Email = email;
		this.phone = phone;
		this.fax = fax;
		CompanyAddress = companyAddress;
		InvoiceAddress = invoiceAddress;
	}
	public String getCompanynumber() {
		return Companynumber;
	}
	public void setCompanynumber(String companynumber) {
		Companynumber = companynumber;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getShortName() {
		return ShortName;
	}
	public void setShortName(String shortName) {
		ShortName = shortName;
	}
	public String getInvoiceType() {
		return InvoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		InvoiceType = invoiceType;
	}
	public Integer getPostCode() {
		return PostCode;
	}
	public void setPostCode(Integer postCode) {
		PostCode = postCode;
	}
	public String getContactPerson() {
		return ContactPerson;
	}
	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCompanyAddress() {
		return CompanyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		CompanyAddress = companyAddress;
	}
	public String getInvoiceAddress() {
		return InvoiceAddress;
	}
	public void setInvoiceAddress(String invoiceAddress) {
		InvoiceAddress = invoiceAddress;
	}
	
	
}
