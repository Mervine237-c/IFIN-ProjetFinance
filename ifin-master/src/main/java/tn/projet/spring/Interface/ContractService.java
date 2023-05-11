package tn.projet.spring.Interface;

import java.util.List;

import tn.projet.spring.entities.Contract;

public interface ContractService {
	
	List<Contract> retrieveAllContract();
	Contract addContract(Contract c);
    void deleteContract(Long id);
    Contract updateContract(Contract c);
    Contract retrieveContract(Long id);
}
