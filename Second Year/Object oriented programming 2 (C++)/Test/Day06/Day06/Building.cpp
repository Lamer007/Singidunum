#include "Building.h" 

#include <iostream> 

Building::Building() {
	noOfLevels = 2; 
	lift = false; 
	color = "grey";

}  

Building::Building(int noOfLevels, bool lift, string color) {

	this->noOfLevels = noOfLevels; 
	this->lift = lift; 
	this->color = color;
} 

void Building::printData() {

	if (lift)
		cout << "Builidng " << this->noOfLevels << " levels" 
		<< this->color << " in color" << " have lift" << endl; 
	else 
		cout << "Builidng " << this->noOfLevels << " levels"
		<< this->color << " in color" << " does not have lift" << endl;
}

