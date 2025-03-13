#include <iostream> 
#include <string>
#include <fstream>

using namespace std;


void printASCII(string fileName)
{
	string line = "";
	ifstream inFile;
	inFile.open(fileName);
	if (inFile.is_open())
	{
		while (getline(inFile, line))
		{
			cout << line << endl;
		}
	}
	else
	{
		cout << "File load failed" << endl;
	}

	inFile.close();
}


int main() {

	string fileName = "testing.txt";
	printASCII(fileName);


	system("pause");
	return 0;
}