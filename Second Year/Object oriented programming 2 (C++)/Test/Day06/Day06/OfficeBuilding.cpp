#include "OfficeBuilding.h" 
#include <iostream> 

using namespace std;

OfficeBuilding::OfficeBuilding() {

	noOfCompanys = 0; 
	reception = false;
} 

OfficeBuilding::OfficeBuilding(int nol, bool lift, string color, int noc, bool reception):
				Building(nol, lift, color){

	this->noOfCompanys = noc; 
	this->reception = reception;

}

void OfficeBuilding::addCompany() {
	noOfCompanys++;

} 

double OfficeBuilding::monthlyPayment() const  {
	return noOfCompanys * 10000;

}  

void OfficeBuilding::printData(){

	Building::printData(); 

	if (reception)
		cout << "Office Builidng " << this->noOfCompanys << " companys"
		 " have recepiton" << endl;
	else
		cout << "Office Builidng " << this->noOfCompanys << " companys"
		" dose not have recepiton" << endl;
}

