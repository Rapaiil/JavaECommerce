package lazada.model;

public interface LazadaOnlineOrdering {
	//use of LUHN algorithm
	void validateCreditCard();
	void computeGrossPay();
	void computeVAT();
	//generate PDF of sales receipt 
	void generatePDFReceipt();
	void netPay();
	//generate PDF of sales report as application is terminated
	void printPDFSalesReport();
}
