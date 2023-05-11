package tn.projet.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.projet.spring.Interface.ContractService;
import tn.projet.spring.Interface.VehicleContractService;
import tn.projet.spring.configuration.ContractVehicule;
import tn.projet.spring.configuration.SendMail;
import tn.projet.spring.entities.Contract;
import tn.projet.spring.entities.VehicleContract;

@RestController
public class VehicleController {
	@Autowired
	VehicleContractService vehiclecontractservice;
	
	@Autowired
	ContractService contractService;
	
	//URL : http://localhost:8888/SpringMVC/getAllVehicleContracts
	
	
	
	
	
	//////////////////////////////CRUUUD//////////////////////////////
	
	@PostMapping("/addContractVehicule")
	public VehicleContract addContractVehicule(@RequestBody ContractVehicule vc) {
		Contract contract=new Contract(vc.CreationDate, vc.StartDate, vc.EndDate, vc.Price, vc.Status, vc.TypeContract);
		contractService.addContract(contract);
		VehicleContract vehiculeContract=new VehicleContract(vc.Brand, vc.Model, vc.Displacement, vc.DateOfCirculation, vc.CoverageLevel, vc.TypeOfVehicle);
		vehiculeContract.setContract(contract);
		vehiclecontractservice.addVehicleContract(vehiculeContract);
		SendMail.email(contract,"Vehicle Contract");
		return vehiculeContract;
	}
	
	
	@PutMapping("/updateContractVehiculee")
	public ContractVehicule updateContractVehiculee(@RequestBody ContractVehicule vc) {
		
		Contract contract=contractService.retrieveContract(vc.idContract);		
		 contract.setContractt(vc.CreationDate, vc.StartDate, vc.EndDate, vc.Price, vc.Status, vc.TypeContract);		
		contractService.updateContract(contract);
		
		
		VehicleContract vehiculeContract=vehiclecontractservice.retrieveVehicleContract(vc.idContractVh);
		
		 vehiculeContract.setVehicleContract(vc.Brand, vc.Model, vc.Displacement, vc.DateOfCirculation, vc.CoverageLevel, vc.TypeOfVehicle,contract);
		
		vehiclecontractservice.updateVehicleContract(vehiculeContract);
		return vc;
	}
	
	
	@GetMapping("/getAllVehicleContracts")
	public List<VehicleContract> getAllVehicleContracts()
	{
		return vehiclecontractservice.retrieveAllVehicleContract();
	}
	
	
	
	@GetMapping("getVehicleContract/{id}")
	public VehicleContract getLifeWarrantyContract(@PathVariable("id")Long id) {
			return vehiclecontractservice.retrieveVehicleContract(id);
		}
	
	
	
	
	@DeleteMapping("/deleteVehicleContract/{id}")  
	public String deleteVehicleContract(@PathVariable("id")Long id) {
	
		vehiclecontractservice.deleteVehicleContract(id);
		
		return "Deleted";
	}
	
//////Métier///////////////////////
	
	@GetMapping("searchvehiculeContract/{word}")
	public List<VehicleContract> searchvehiculeContract(@PathVariable("word")String word) {
		List<VehicleContract> listevehiculecontract= vehiclecontractservice.retrieveAllVehicleContract();
		List<VehicleContract> listevehiculecontractfiltred=new ArrayList<VehicleContract>();
		
		for(VehicleContract vc:listevehiculecontract){
			if(vc.getBrand().toLowerCase().contains(word.toLowerCase()) || vc.getCoverageLevel().toLowerCase().contains(word.toLowerCase()) || vc.getModel().toLowerCase().contains(word.toLowerCase())  || vc.getTypeOfVehicle().toLowerCase().contains(word.toLowerCase()) ){
				listevehiculecontractfiltred.add(vc);
			}
		}
		return listevehiculecontractfiltred;
	}
	
}
