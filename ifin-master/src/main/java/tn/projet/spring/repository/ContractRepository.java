package tn.projet.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.projet.spring.entities.Contract;


@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
	//jpql
	@Query("SELECT max(c.Price) FROM Contract c ")
	Float maxPriceContract();
}
