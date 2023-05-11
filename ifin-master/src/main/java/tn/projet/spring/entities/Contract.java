package tn.projet.spring.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;











@Entity
@Table( name = "contract")

public class Contract implements Serializable {
	 @Id
	 @GeneratedValue (strategy = GenerationType.IDENTITY)
	
	 @Column(name="idContract")
	private long idContract;
	 
	 @Column(name="CreationDate")
	 @Temporal (TemporalType.DATE)
	private Date CreationDate;
	 
	 @Column(name="StartDate")
	 @Temporal (TemporalType.DATE)
	private Date StartDate;
	 
	 @Temporal (TemporalType.DATE)
	 @Column(name="EndDate")
	private Date EndDate;	
	 
	 @Column(name="Price")
	 private float Price;
	 
	 @Column(name="Status")
	private String Status;
	 
	 @Column(name="TypeContrat")
	private String TypeContract;

	 @JsonIgnore 
	@OneToOne (mappedBy="contract")
	private VehicleContract VhContract;
	
	 @JsonIgnore 	 
	@OneToOne (mappedBy="contract")
	private LifeWarrantyContract LifeContract;
	
	
	 
	 
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	
	 @JsonIgnore 
	public VehicleContract getVhContract() {
		return VhContract;
	}
	public void setVhContract(VehicleContract vhContract) {
		VhContract = vhContract;
	}
	
	 @JsonIgnore 
	public LifeWarrantyContract getLifeContract() {
		return LifeContract;
	}
	public void setLifeContract(LifeWarrantyContract lifeContract) {
		LifeContract = lifeContract;
	}
	public long getIdContract() {
		return idContract;
	}
	public void setIdContract(long idContract) {
		this.idContract = idContract;
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getTypeContract() {
		return TypeContract;
	}
	public void setTypeContract(Object object) {
		TypeContract = (String) object;
	}
	public Contract(Date creationDate, Date startDate, Date endDate, float price, String status,
			String typeContract) {
		super();
		CreationDate = creationDate;
		StartDate = startDate;
		EndDate = endDate;
		Price = price;
		Status = status;
		TypeContract = typeContract;
	}
	@Override
	public String toString() {
		return "Contract [CreationDate=" + CreationDate + ", StartDate=" + StartDate + ", EndDate=" + EndDate
				+ ", Price=" + Price + ", Status=" + Status + ", TypeContract=" + TypeContract + "]";
	}
	public Contract() {
		super();
	}
	public void setTypeContract(String typeContract) {
		TypeContract = typeContract;
	}
	
	
	public void setContractt(Date creationDate, Date startDate, Date endDate, float price, String status,
			String typeContract) {
		
		CreationDate = creationDate;
		StartDate = startDate;
		EndDate = endDate;
		Price = price;
		Status = status;
		TypeContract = typeContract;
	}
	
	
	
}
