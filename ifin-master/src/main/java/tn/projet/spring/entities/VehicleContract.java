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



@Entity
@Table( name = "Vehicle")
public class VehicleContract implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	 
	@Column(name="idContractVh")
	private long idContractVh;
	 
	@Column(name="Brand")
	private String Brand;
	 
	@Column(name="Model")
	private String Model;
	 
	@Column(name="Displacement")
	private int Displacement;
	 
	@Column(name="DateOfcirculation")
	private Date DateOfCirculation;
	 
	@Column(name="CoverageLevel")
	private String CoverageLevel;
	 
	@Column(name="TypeOfVehicle")
	private String TypeOfVehicle;
	
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE)
	private Contract contract ;
	
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public long getIdContractVh() {
		return idContractVh;
	}
	public void setIdContractVh(long idContractVh) {
		this.idContractVh = idContractVh;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getDisplacement() {
		return Displacement;
	}
	public void setDisplacement(int displacement) {
		Displacement = displacement;
	}
	public Date getDateOfCirculation() {
		return DateOfCirculation;
	}
	public void setDateOfCirculation(Date dateOfCirculation) {
		DateOfCirculation = dateOfCirculation;
	}
	public String getCoverageLevel() {
		return CoverageLevel;
	}
	public void setCoverageLevel(String coverageLevel) {
		CoverageLevel = coverageLevel;
	}
	public String getTypeOfVehicle() {
		return TypeOfVehicle;
	}
	public void setTypeOfVehicle(String typeOfVehicle) {
		TypeOfVehicle = typeOfVehicle;
	}
	public VehicleContract(long idContractVh, String brand, String model, int displacement, Date dateOfCirculation,
			String coverageLevel, String typeOfVehicle) {
		super();
		this.idContractVh = idContractVh;
		Brand = brand;
		Model = model;
		Displacement = displacement;
		DateOfCirculation = dateOfCirculation;
		CoverageLevel = coverageLevel;
		TypeOfVehicle = typeOfVehicle;
	}
	
	public VehicleContract( String brand, String model, int displacement, Date dateOfCirculation,
			String coverageLevel, String typeOfVehicle) {
		super();
		
		Brand = brand;
		Model = model;
		Displacement = displacement;
		DateOfCirculation = dateOfCirculation;
		CoverageLevel = coverageLevel;
		TypeOfVehicle = typeOfVehicle;
	}
	
	
	public void setVehicleContract( String brand, String model, int displacement, Date dateOfCirculation,
			String coverageLevel, String typeOfVehicle,Contract c) {
		
		
		Brand = brand;
		Model = model;
		Displacement = displacement;
		DateOfCirculation = dateOfCirculation;
		CoverageLevel = coverageLevel;
		TypeOfVehicle = typeOfVehicle;
		contract=c;
	}
	
	
	@Override
	public String toString() {
		return "VehicleContract [idContractVh=" + idContractVh + ", Brand=" + Brand + ", Model=" + Model
				+ ", Displacement=" + Displacement + ", DateOfCirculation=" + DateOfCirculation + ", CoverageLevel="
				+ CoverageLevel + ", TypeOfVehicle=" + TypeOfVehicle + "]";
	}
	public VehicleContract() {
		super();
	}
	
	
}
