package tn.projet.spring.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.projet.spring.Interface.LifeWarrantyContractService;
import tn.projet.spring.entities.Contract;
import tn.projet.spring.entities.LifeWarrantyContract;
import tn.projet.spring.repository.ContractRepository;
import tn.projet.spring.repository.LifeWarrantyContractRepository;

@Service
public class LifeWarrantyContractServiceImp implements LifeWarrantyContractService {
	@Autowired
    LifeWarrantyContractRepository   LWCRepository;
	
	@Autowired ContractRepository CRepository;
	
	@Override
	public List<LifeWarrantyContract> retrieveAllLifeWarrantyContract() {
		// TODO Auto-generated method stub
		return LWCRepository.findAll();
	}

	@Override
	public LifeWarrantyContract addLifeWarrantyContract(LifeWarrantyContract lc) {
		Contract c = CRepository.findById(lc.getContract().getIdContract()).get();
		lc.setContract(c);
		return LWCRepository.saveAndFlush(lc);
	}

	@Override
	public void deleteLifeWarrantyContract(Long id) {
		// TODO Auto-generated method stub
		LWCRepository.deleteById(id);
	}

	@Override
	public LifeWarrantyContract updateLifeWarrantyContract(LifeWarrantyContract lc) {
		
		
		LWCRepository.save(lc);
		return lc;
	}

	@Override
	public LifeWarrantyContract retrieveLifeWarrantyContract(Long id) {
		
		return LWCRepository.findById(id).orElse(new LifeWarrantyContract());
	}

	

}
