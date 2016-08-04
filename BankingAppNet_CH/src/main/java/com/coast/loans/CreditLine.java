package com.coast.loans;

public class CreditLine implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 99L;
	private String custId;
	private String clAcctNum;
	private float clLimit;
	private float clInterestRate;
	private float clBalance;
	
	public CreditLine()
	{
		
	}
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getClAcctNum() {
		return clAcctNum;
	}
	public void setClAcctNum(String clAcctNum) {
		this.clAcctNum = clAcctNum;
	}
	public float getClLimit() {
		return clLimit;
	}
	public void setClLimit(float clLimit) {
		this.clLimit = clLimit;
	}
	public float getClInterestRate() {
		return clInterestRate;
	}
	public void setClInterestRate(float clInterestRate) {
		this.clInterestRate = clInterestRate;
	}
	public float getClBalance() {
		return clBalance;
	}
	public void setClBalance(float clBalance) {
		this.clBalance = clBalance;
	}
	
	
	

}
