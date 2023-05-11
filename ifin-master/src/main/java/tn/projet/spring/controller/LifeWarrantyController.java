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
import tn.projet.spring.Interface.LifeWarrantyContractService;
import tn.projet.spring.configuration.ContractLife;
import tn.projet.spring.configuration.ContractVehicule;
import tn.projet.spring.configuration.SendMail;
import tn.projet.spring.entities.Contract;
import tn.projet.spring.entities.LifeWarrantyContract;
import tn.projet.spring.entities.VehicleContract;

@RestController
public class LifeWarrantyController {
	@Autowired
	LifeWarrantyContractService lifewarrantycontractservice;
	
	

	@Autowired
	ContractService contractService;
	
	
	
	//////////////////////////CRUUUD//////////////////////
	
	@PostMapping("/addLifeContract")
	public LifeWarrantyContract addLifeContract(@RequestBody  ContractLife vc) {
		Contract contract=new Contract(vc.CreationDate, vc.StartDate, vc.EndDate, vc.Price, vc.Status, vc.TypeContract);
		contractService.addContract(contract);
		
		LifeWarrantyContract lifewarrantycontract=new LifeWarrantyContract(vc.nbYearsContribution, vc.InitialAmount, vc.MonthlyAmount, vc.Risk);
		lifewarrantycontract.setContract(contract);
		lifewarrantycontractservice.addLifeWarrantyContract(lifewarrantycontract);
		SendMail.email(contract,"Life Warranty Contract");
		return lifewarrantycontract;
	}
	
	
	@PutMapping("/updateLifeContract")
	public ContractLife updateLifeContract(@RequestBody ContractLife vc) {
		
		Contract contract=contractService.retrieveContract(vc.idContract);		
		 contract.setContractt(vc.CreationDate, vc.StartDate, vc.EndDate, vc.Price, vc.Status, vc.TypeContract);		
		contractService.updateContract(contract);
		
		
		LifeWarrantyContract lifewarrantycontract=lifewarrantycontractservice.retrieveLifeWarrantyContract(vc.idContractLife);
		
		lifewarrantycontract.setLifeWarrantyContract(vc.nbYearsContribution, vc.InitialAmount, vc.MonthlyAmount, vc.Risk,contract);
		
		 lifewarrantycontractservice.updateLifeWarrantyContract(lifewarrantycontract);
		return vc;
	}
	
	
	@GetMapping("/getAllLifeWarrantyContracts")
	public List<LifeWarrantyContract> getAllLifeWarrantyContracts()
	{
		return lifewarrantycontractservice.retrieveAllLifeWarrantyContract();
	}
	
	
	
	
	@GetMapping("getLifeWarrantyContracts/{id}")
	public LifeWarrantyContract getLifeWarrantyContract(@PathVariable("id")Long id) {
			return lifewarrantycontractservice.retrieveLifeWarrantyContract(id);
		}
	
	
	
	@DeleteMapping("/deleteLifeWarrantyContract/{id}")  
		public String deleteLifeWarrantyContract(@PathVariable("id")Long id) {
		lifewarrantycontractservice.deleteLifeWarrantyContract(id);
		return "Deleted";
		}
	
	
	
//////Métier///////////////////////
	
	@GetMapping("searchLifeWarrantyContract/{word}")
	public List<LifeWarrantyContract> searchLifeWarrantyContract(@PathVariable("word")int word) {
		List<LifeWarrantyContract> listeLifeWarrantyContract= lifewarrantycontractservice.retrieveAllLifeWarrantyContract();
		List<LifeWarrantyContract> listeLifeWarrantyContractfiltred=new ArrayList<LifeWarrantyContract>();
		
		for(LifeWarrantyContract vc:listeLifeWarrantyContract){
			if(vc.getInitialAmount()==word || vc.getMonthlyAmount()==word || vc.getRisk()==word || vc.getNbYearsContribution()==word  ){
				listeLifeWarrantyContractfiltred.add(vc);
			}
		}
		return listeLifeWarrantyContractfiltred;
	}
	
	
	
	
}
