package tn.projet.spring.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.projet.spring.Interface.ContractService;
import tn.projet.spring.entities.Contract;
import tn.projet.spring.repository.ContractRepository;

@Service
public class ContractServiceImp implements ContractService {
	
	@Autowired
    ContractRepository CRepository;
	
	@Override
	public List<Contract> retrieveAllContract() {
		// TODO Auto-generated method stub
		return CRepository.findAll();
	}

	@Override
	public Contract addContract(Contract c) {
		c.setLifeContract(null);
		c.setVhContract(null);
		// TODO Auto-generated method stub
		return CRepository.saveAndFlush(c);
	}

	@Override
	public void deleteContract(Long id) {
		CRepository.deleteById(id);
		
	}

	@Override
	public Contract updateContract(Contract c) {
		

		
		
		CRepository.save(c);
		return c;
	}

	@Override
	public Contract retrieveContract(Long id) {
		// TODO Auto-generated method stub
		return CRepository.findById(id).orElse(new Contract());
	}
	
}
