package com.coast.loans;

public class Mortgage implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 333L;
	
	private String custId;
	private String mortgageAcctNum;
	private float mortgageValue;
	private float mortgagePaid;
	private String mortgagteType;
	private int mortgageEndYear;
	private float mortgageInterestRate;
	
	public Mortgage()
	{
		
	}
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getMortgageAcctNum() {
		return mortgageAcctNum;
	}
	public void setMortgageAcctNum(String mortgageAcctNum) {
		this.mortgageAcctNum = mortgageAcctNum;
	}
	public float getMortgageValue() {
		return mortgageValue;
	}
	public void setMortgageValue(float mortgageValue) {
		this.mortgageValue = mortgageValue;
	}
	public float getMortgagePaid() {
		return mortgagePaid;
	}
	public void setMortgagePaid(float mortgagePaid) {
		this.mortgagePaid = mortgagePaid;
	}
	public String getMortgagteType() {
		return mortgagteType;
	}
	public void setMortgagteType(String mortgagteType) {
		this.mortgagteType = mortgagteType;
	}
	public int getMortgageEndYear() {
		return mortgageEndYear;
	}
	public void setMortgageEndYear(int mortgageEndYear) {
		this.mortgageEndYear = mortgageEndYear;
	}
	public float getMortgageInterestRate() {
		return mortgageInterestRate;
	}
	public void setMortgageInterestRate(float mortgageInterestRate) {
		this.mortgageInterestRate = mortgageInterestRate;
	}
	
	
	
	
}
