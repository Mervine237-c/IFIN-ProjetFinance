package tn.projet.spring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table( name = "Life")
public class LifeWarrantyContract implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	 
	@Column(name="idContractLife")
	private long idContractLife;
	 
	@Column(name="NbYearsContribution")
	private int nbYearsContribution;
	 
	@Column(name="InitialAmount")
	private float InitialAmount;
	 
	@Column(name="MonthlyAmount")
	private float MonthlyAmount;
	 
	@Column(name="Risk")
	private float Risk;
	
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE)
	private Contract contract;
	
	
	
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public long getIdContractLife() {
		return idContractLife;
	}
	public void setIdContractLife(long idContractLife) {
		this.idContractLife = idContractLife;
	}
	public int getNbYearsContribution() {
		return nbYearsContribution;
	}
	public void setNbYearsContribution(int nbYearsContribution) {
		this.nbYearsContribution = nbYearsContribution;
	}
	public float getInitialAmount() {
		return InitialAmount;
	}
	public void setInitialAmount(float initialAmount) {
		InitialAmount = initialAmount;
	}
	public float getMonthlyAmount() {
		return MonthlyAmount;
	}
	public void setMonthlyAmount(float monthlyAmount) {
		MonthlyAmount = monthlyAmount;
	}
	public float getRisk() {
		return Risk;
	}
	public void setRisk(float risk) {
		Risk = risk;
	}
	public LifeWarrantyContract(long idContractLife, int nbYearsContribution, float initialAmount, float monthlyAmount,
			float risk) {
		super();
		this.idContractLife = idContractLife;
		this.nbYearsContribution = nbYearsContribution;
		InitialAmount = initialAmount;
		MonthlyAmount = monthlyAmount;
		Risk = risk;
	}
	
	
	public LifeWarrantyContract( int nbYearsContribution, float initialAmount, float monthlyAmount,
			float risk) {
		super();
		
		this.nbYearsContribution = nbYearsContribution;
		InitialAmount = initialAmount;
		MonthlyAmount = monthlyAmount;
		Risk = risk;
	}
	
	public void setLifeWarrantyContract( int nbYearsContribution, float initialAmount, float monthlyAmount,
			float risk, Contract c) {
		
		
		this.nbYearsContribution = nbYearsContribution;
		InitialAmount = initialAmount;
		MonthlyAmount = monthlyAmount;
		Risk = risk;
		contract=c;
	}
	
	@Override
	public String toString() {
		return "WarrantyLifeContract [idContractLife=" + idContractLife + ", NbYearsContribution=" + nbYearsContribution
				+ ", InitialAmount=" + InitialAmount + ", MonthlyAmount=" + MonthlyAmount + ", Risk=" + Risk + "]";
	}
	public LifeWarrantyContract() {
		super();
	}
	
}
