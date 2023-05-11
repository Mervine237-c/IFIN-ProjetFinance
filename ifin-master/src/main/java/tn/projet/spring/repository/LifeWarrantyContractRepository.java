package tn.projet.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.projet.spring.entities.LifeWarrantyContract;


@Repository
public interface LifeWarrantyContractRepository extends JpaRepository<LifeWarrantyContract, Long> {

}
