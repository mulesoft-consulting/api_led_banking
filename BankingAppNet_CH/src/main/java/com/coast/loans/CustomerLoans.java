package com.coast.loans;

import java.util.List;

public class CustomerLoans implements java.io.Serializable
{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 3L;
	private List<CreditCard> creditCards;
	private List<CreditLine> creditLines;
	private List<Mortgage> mortgages;
	private String custId;
	

	public CustomerLoans()
	{
		
	}
	
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	public List<CreditLine> getCreditLines() {
		return creditLines;
	}
	public void setCreditLines(List<CreditLine> creditLines) {
		this.creditLines = creditLines;
	}
	public List<Mortgage> getMortgages() {
		return mortgages;
	}
	public void setMortgages(List<Mortgage> mortgages) {
		this.mortgages = mortgages;
	}

}
