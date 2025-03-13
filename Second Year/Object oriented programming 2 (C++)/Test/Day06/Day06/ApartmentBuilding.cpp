#include "ApartmentBuilding.h" 
#include <iostream> 
using namespace std; 

ApartmentBuilding::ApartmentBuilding() {
	noOfApartments = 0; 
	terrace = false;
} 

ApartmentBuilding::ApartmentBuilding(int nol, bool lift, string color , int noa, bool terrace): 
					Building(nol, lift, color) {

	this->noOfApartments = noa; 
	this->terrace = terrace;
} 


double ApartmentBuilding::monthlyPayment() const {

	return noOfApartments * 1000.00;

} 

void ApartmentBuilding::printData() {
	Building::printData(); 
	if (terrace)
		cout << "Apartment Builidng " << this->noOfApartments << " apartments"
		" have terrace" << endl;
	else
		cout << "Apartment Builidng " << this->noOfApartments << " apartments"
		" does not have terrace" << endl;

}