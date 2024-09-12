package model;

public class Accountant {
	
	String PRBuyer ;
	String Department;
	String InvoiceCompany;
	String CompanyNumber;
	
	String CostType;
	String CostName;
	String Currency;
	Double ExchangeRate;
	String TaxType;
	Double TaxRate;
	String Invoice;
	
	
	String PayWay;
	String PayType;
	String PayDate;
	String PaymentType;
	String PayExpireDate;
	String PayState;
	
	
	Integer UseCurrency;
	Integer Tax;
	Integer Sum;
	Integer Paid;
	Integer Nonpayment;
	
	
	Integer Item;
	String ProductNumber;
	String ProductName;
	Integer Amount;
	String Unit;
	Integer Price;
	
	
	public Accountant() {}
	



	public Accountant(String pRBuyer, String department, String invoiceCompany, String companyNumber, String costType,
			String costName, String currency, Double exchangeRate, String taxType, Double taxRate, String invoice,
			String payWay, String payType, String payDate, String paymentType, String payExpireDate, String payState,
			Integer useCurrency, Integer tax, Integer sum, Integer paid, Integer nonpayment, Integer item,
			String productNumber, String productName, Integer amount, String unit, Integer price) {
		super();
		PRBuyer = pRBuyer;
		Department = department;
		InvoiceCompany = invoiceCompany;
		CompanyNumber = companyNumber;
		CostType = costType;
		CostName = costName;
		Currency = currency;
		ExchangeRate = exchangeRate;
		TaxType = taxType;
		TaxRate = taxRate;
		Invoice = invoice;
		PayWay = payWay;
		PayType = payType;
		PayDate = payDate;
		PaymentType = paymentType;
		PayExpireDate = payExpireDate;
		PayState = payState;
		UseCurrency = useCurrency;
		Tax = tax;
		Sum = sum;
		Paid = paid;
		Nonpayment = nonpayment;
		Item = item;
		ProductNumber = productNumber;
		ProductName = productName;
		Amount = amount;
		Unit = unit;
		Price = price;
		
	}







	public String getPRBuyer() {
		return PRBuyer;
	}
	public void setPRBuyer(String pRBuyer) {
		PRBuyer = pRBuyer;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getInvoiceCompany() {
		return InvoiceCompany;
	}
	public void setInvoiceCompany(String invoiceCompany) {
		InvoiceCompany = invoiceCompany;
	}
	public String getCompanyNumber() {
		return CompanyNumber;
	}
	public void setCompanyNumber(String companyNumber) {
		CompanyNumber = companyNumber;
	}
	public String getCostType() {
		return CostType;
	}
	public void setCostType(String costType) {
		CostType = costType;
	}
	public String getCostName() {
		return CostName;
	}
	public void setCostName(String costName) {
		CostName = costName;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public Double getExchangeRate() {
		return ExchangeRate;
	}
	public void setExchangeRate(Double exchangeRate) {
		ExchangeRate = exchangeRate;
	}
	public String getTaxType() {
		return TaxType;
	}
	public void setTaxType(String taxType) {
		TaxType = taxType;
	}
	public Double getTaxRate() {
		return TaxRate;
	}
	public void setTaxRate(Double taxRate) {
		TaxRate = taxRate;
	}
	public String getInvoice() {
		return Invoice;
	}
	public void setInvoice(String invoice) {
		Invoice = invoice;
	}
	public String getPayWay() {
		return PayWay;
	}
	public void setPayWay(String payWay) {
		PayWay = payWay;
	}
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String payType) {
		PayType = payType;
	}
	public String getPayDate() {
		return PayDate;
	}
	public void setPayDate(String payDate) {
		PayDate = payDate;
	}
	public String getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}
	public String getPayExpireDate() {
		return PayExpireDate;
	}
	public void setPayExpireDate(String payExpireDate) {
		PayExpireDate = payExpireDate;
	}
	public String getPayState() {
		return PayState;
	}
	public void setPayState(String payState) {
		PayState = payState;
	}
	public Integer getUseCurrency() {
		return UseCurrency;
	}
	public void setUseCurrency(Integer useCurrency) {
		UseCurrency = useCurrency;
	}
	public Integer getTax() {
		return Tax;
	}
	public void setTax(Integer tax) {
		Tax = tax;
	}
	public Integer getSum() {
		return Sum;
	}
	public void setSum(Integer sum) {
		Sum = sum;
	}
	public Integer getPaid() {
		return Paid;
	}
	public void setPaid(Integer paid) {
		Paid = paid;
	}
	public Integer getNonpayment() {
		return Nonpayment;
	}
	public void setNonpayment(Integer nonpayment) {
		Nonpayment = nonpayment;
	}
	public Integer getItem() {
		return Item;
	}
	public void setItem(Integer item) {
		Item = item;
	}
	public String getProductNumber() {
		return ProductNumber;
	}
	public void setProductNumber(String productNumber) {
		ProductNumber = productNumber;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public Integer getAmount() {
		return Amount;
	}
	public void setAmount(Integer amount) {
		Amount = amount;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public Integer getPrice() {
		return Price;
	}
	public void setPrice(Integer price) {
		Price = price;
	}
	
	
}
