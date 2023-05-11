package tn.projet.spring.configuration;

public class Statistic {
public String typecontract;
public String contractnumber;
public Statistic(String typecontract, int contractnumber) {

	this.typecontract = typecontract;
	this.contractnumber = contractnumber+" contract(s)";
}




}
