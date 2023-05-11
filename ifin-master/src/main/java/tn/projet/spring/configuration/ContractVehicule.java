package tn.projet.spring.configuration;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ContractVehicule {

	 //contrat
	public long idContract;
	 
	
	public Date CreationDate;
	 
	
	public Date StartDate;
	 
	
	public Date EndDate;	
	 
	
	 public float Price;
	 
	
	public String Status;
	 
	
	public String TypeContract;
	
	//vehicule
	
	public long idContractVh;
	 
	
	public String Brand;
	 

	public String Model;
	 

	public int Displacement;
	 

	public Date DateOfCirculation;
	 

	public String CoverageLevel;
	 

	public String TypeOfVehicle;
	
	
	
	
}
