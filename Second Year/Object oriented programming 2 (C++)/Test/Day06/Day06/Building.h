#pragma once

#include <string> 
using namespace std; 

class Building {

protected: 
	string color; 
	int noOfLevels; 
	bool lift; 

public:  
	Building();
	Building(int, bool, string color = "grey"); 
	void paint(string color); 
	virtual void printData();//virtual function 
	virtual double monthlyPayment() const = 0; //pure virtual function



};
