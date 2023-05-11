package tn.projet.spring.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.projet.spring.Interface.VehicleContractService;
import tn.projet.spring.entities.Contract;
import tn.projet.spring.entities.VehicleContract;
import tn.projet.spring.repository.ContractRepository;
import tn.projet.spring.repository.VehicleContractRepository;

@Service
public class VehicleContractServiceImp implements VehicleContractService {
	
	@Autowired
	VehicleContractRepository VCRepository;
	
	@Autowired 
	ContractRepository CRepository;
	
	@Override
	public List<VehicleContract> retrieveAllVehicleContract() {
		// TODO Auto-generated method stub
		return VCRepository.findAll();
	}

	@Override
	public VehicleContract addVehicleContract(VehicleContract vc) {
		Contract c = CRepository.findById(vc.getContract().getIdContract()).get();
		vc.setContract(c);
		return VCRepository.saveAndFlush(vc);
	}

	@Override
	public void deleteVehicleContract(Long id) {
		// TODO Auto-generated method stub
		VCRepository.deleteById(id);

	}

	@Override
	public VehicleContract updateVehicleContract(VehicleContract vc) {
		
		VCRepository.save(vc);
		return vc;
	}

	@Override
	public VehicleContract retrieveVehicleContract(Long id) {
	return	VCRepository.findById(id).orElse(new VehicleContract());  
	}

}
