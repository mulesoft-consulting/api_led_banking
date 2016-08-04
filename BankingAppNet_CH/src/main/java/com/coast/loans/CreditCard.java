package com.coast.loans;

public class CreditCard implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 88L;
	private String custId;
	private String ccType;
	private String ccNumber;
	private float ccBalance;
	private float ccInterestRate;
	
	public CreditCard()
	{
		
	}
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCcType() {
		return ccType;
	}
	public void setCcType(String ccType) {
		this.ccType = ccType;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public float getCcBalance() {
		return ccBalance;
	}
	public void setCcBalance(float ccBalance) {
		this.ccBalance = ccBalance;
	}
	public float getCcInterestRate() {
		return ccInterestRate;
	}
	public void setCcInterestRate(float ccInterestRate) {
		this.ccInterestRate = ccInterestRate;
	}
	
}
