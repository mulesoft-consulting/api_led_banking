package com.coast;

public class CustomerAccount implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerId;
	private String accountNumber;
	private String accountType;
	private float acountBalance;
	private float accountIterestRate;
	
	
	public CustomerAccount()
	{
		
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getAcountBalance() {
		return acountBalance;
	}

	public void setAcountBalance(float acountBalance) {
		this.acountBalance = acountBalance;
	}

	public float getAccountIterestRate() {
		return accountIterestRate;
	}

	public void setAccountIterestRate(float accountIterestRate) {
		this.accountIterestRate = accountIterestRate;
	}

	
	

}
