#include <iostream> 
#include <string> 
#include <vector> 

using namespace std; 

class Container {

	string name; 
public: 
	Container(string name) {
	
		this->name = name;
	} 

	string getName() { return this->name; } 

	virtual long getSize() const = 0; 

	friend ostream& operator << (ostream& out, Container& c) {
		return out << "[" << c.name << "] =>" << c.getSize() << "B" << endl;
	
	}

};
class File : public Container {

	long size; 

public: 
	File(string name, long size) : Container(name) { this->size = size; } 

	long getSize() const override {
		return size;
	
	}

};

class Folder : public Container {


	vector <Container*> containers; 

public: 
	using Container::Container; 

	Folder& operator + (Container * c) {
		containers.push_back(c);
		return *this;
	
	} 

	Container* operator [](unsigned i) {
		if (i< 0 || i > containers.size()) return nullptr; 
		return containers[i];
	} 

	long getSize() const override {
		long totalSize = 0; 
		for (auto cont : containers) {
			totalSize += cont->getSize();
		} 

		return totalSize;

	}

};

int main() { 

	Folder root("root"); 
	Folder folder1("folder1");
	Folder folder12("Folder12"); 
	File file121("file121", 1560); 
	File file122("file122", 20000); 
	Folder folder2("folder2"); 

	root + &(folder1 + &(folder12 + &file121 + &file122)) + &folder2; 

	cout << root << endl;

	return 0;
}