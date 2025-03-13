#pragma once 

#include "Building.h" 

class ApartmentBuilding : public Building {


protected: 
	int noOfApartments; 
	bool terrace;  


public: 

	ApartmentBuilding(); 
	ApartmentBuilding(int, bool, string, int, bool); 
	virtual double monthlyPayment() const override;
	virtual void printData();


}; 



