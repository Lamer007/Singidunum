#pragma once 

#include "Building.h" 

class OfficeBuilding : public Building {


protected: 
	int noOfCompanys; 
	bool reception; 

public: 
	OfficeBuilding(); 
	OfficeBuilding(int, bool, string, int, bool);  
	virtual double monthlyPayment() const override; 
	virtual void printData();
	void addCompany();
};
