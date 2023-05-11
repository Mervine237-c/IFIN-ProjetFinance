package tn.projet.spring.configuration;

import java.util.Date;

import javax.persistence.Column;

public class ContractLife {

	//contract
public long idContract;
	 
	
	public Date CreationDate;
	 
	
	public Date StartDate;
	 
	
	public Date EndDate;	
	 
	
	 public float Price;
	 
	
	public String Status;
	 
	
	public String TypeContract;
	
	//life
	public long idContractLife;
	 

	public int nbYearsContribution;
	 

	public float InitialAmount;
	 

	public float MonthlyAmount;
	 

	public float Risk;
}
