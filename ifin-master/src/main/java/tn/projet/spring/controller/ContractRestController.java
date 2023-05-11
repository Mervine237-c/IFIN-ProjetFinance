package tn.projet.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.projet.spring.Interface.ContractService;
import tn.projet.spring.Interface.LifeWarrantyContractService;
import tn.projet.spring.Interface.VehicleContractService;
import tn.projet.spring.configuration.Statistic;
import tn.projet.spring.entities.Contract;
import tn.projet.spring.repository.ContractRepository;

@RestController("/contract")
public class ContractRestController {
	
	@Autowired
	ContractRepository contractrepo;
	
	@Autowired
	VehicleContractService vehiclecontractservice;
	
	@Autowired
	LifeWarrantyContractService lifewarrantycontractservice;
	
	@Autowired
	ContractService contractservice;
	
		
		//////Métier///////////////////////
		@GetMapping("/StatistiqueContract")
		public List<Statistic> StatistiqueContract()
		{
		int numbercontractvehicule=	vehiclecontractservice.retrieveAllVehicleContract().size();
		int numbercontractlifewarrantity=	lifewarrantycontractservice.retrieveAllLifeWarrantyContract().size();
		
		
		Statistic st1=new Statistic("Vehicule Contract",numbercontractvehicule  );
		Statistic st2=new Statistic("Life Contract",numbercontractlifewarrantity  );
		List<Statistic> liststatitcs=new ArrayList<>();
		liststatitcs.add(st1);
		liststatitcs.add(st2);
		return liststatitcs;
			
		}
		
		
		@GetMapping("/getTotalPriceByYear/{year}")
		public String getTotalPriceByYear(@PathVariable("year") int year)
		{
			float totalprice=0;
			List<Contract> contracts= contractservice.retrieveAllContract();
			for (Contract c: contracts){
				int yearcontract=c.getStartDate().getYear()+1900;
				if(yearcontract==year){
					totalprice+=c.getPrice();
				}
			}
			return "We have "+ totalprice+"dinars for the year "+year;
		}
		
		
		@GetMapping("/getMaxPrice")
		public String getMaxPrice()
		{
			return " the maximum price of contracts: "+ contractrepo.maxPriceContract()+" Dt";
		}
}
