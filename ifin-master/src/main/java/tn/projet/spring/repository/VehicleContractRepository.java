package tn.projet.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.projet.spring.entities.VehicleContract;

@Repository
public interface VehicleContractRepository extends JpaRepository<VehicleContract, Long> {


}
