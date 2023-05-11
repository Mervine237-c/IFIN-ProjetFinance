package tn.projet.spring.Interface;

import java.util.List;

import tn.projet.spring.entities.LifeWarrantyContract;

public interface LifeWarrantyContractService {
	
	List<LifeWarrantyContract> retrieveAllLifeWarrantyContract();
	LifeWarrantyContract addLifeWarrantyContract(LifeWarrantyContract lc);
    void deleteLifeWarrantyContract(Long id);
    LifeWarrantyContract retrieveLifeWarrantyContract(Long id);
	LifeWarrantyContract updateLifeWarrantyContract(LifeWarrantyContract lc);
	
}
