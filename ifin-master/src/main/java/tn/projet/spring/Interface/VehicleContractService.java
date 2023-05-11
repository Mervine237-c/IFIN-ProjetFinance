package tn.projet.spring.Interface;

import java.util.List;

import tn.projet.spring.entities.VehicleContract;


public interface VehicleContractService {

	List<VehicleContract> retrieveAllVehicleContract();
	VehicleContract addVehicleContract(VehicleContract vc);
    void deleteVehicleContract(Long id);
    VehicleContract updateVehicleContract(VehicleContract vc);
    VehicleContract retrieveVehicleContract(Long id);
}
