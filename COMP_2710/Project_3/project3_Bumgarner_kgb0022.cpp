/* Author: Kevin Bumgarner 
 * USR_ID: 903935034
 * File Name: project3_Bumgarner_kgb0022.cpp
 * COMPILE: g++ project3_Bumgarner_kgb0022.cpp
 * RUN:     ./a.out
 * Version: 10/07/2020
 * Description: A simple program that merges the numbers in two files and writes all the numbers into a
                third file
 * HELP: Referenced Stack Overflow and 
 *       Dr. Xuechao Li's Project 3 Hints to help me complete this project.
 */

#include <fstream> 
#include <iostream>
#include <vector> 
#include <cstdlib>
#include <assert.h>
using namespace std; 

// Declare user defined Functions

/**
 * Input: file, file name 
 * Return true if file exists, false if not.
 */
bool check_file(string);

/**
 * Input: string File name
 * reads file.
 */
vector<int> read_file(string);

/**
 * Input: string filename, vector<int> vector
 * Writes vector to an output file.
 */
void write_file(string, vector<int>);

/**
 * Input: vector<int> vector, vector<int> vector
 * Merges two vectors and sorts them.
 */
vector<int> merge(vector<int>, vector<int>);

/**
 * Input: string file name, vector<int> vector
 * Creates a string representation of a vector.
 */
void to_string(string, vector<int>);

// Driver Function
int main() {
    cout << "*** Welcome to Kevin's sorting program ***" << endl;
    cout << "Enter the first input file name: ";
    string filename1;
    cin >> filename1;
    while (!check_file(filename1)) {
        cout << "Invalid file, please enter another file name: ";
        cin >> filename1;
    }
    vector<int> vector1 = read_file(filename1);
    to_string(filename1, vector1);
    
    cout << "\n";
    
    cout << "Enter the second input file name: ";
    string filename2;
    cin >> filename2;
        while (!check_file(filename2)) {
        cout << "Invalid file, please enter another file name: ";
        cin >> filename2;
    }
    vector<int> vector2 = read_file(filename2);
    to_string(filename2, vector2);

    cout << "\n";

    vector<int> vector3 = merge(vector1, vector2);
    int size = vector3.size();
    cout << "The Sorted List of " << size << " is: "; 
    for (int x : vector3) {
        cout << x << " ";
    }
    cout << endl;
    cout << "Enter the ouput file name: ";
    string outputName;
    cin >> outputName;
    write_file(outputName, vector3);
    cout << "*** Please check the new file - " << outputName <<	" ***" << endl;
    cout << "*** Goodbye ***" << endl;
    return 0;
}

// Implementation of Functions
bool check_file(string file) {
    ifstream stream;
    stream.open(file.c_str());
    if (stream.fail()) {
        //cout << "Could not find file! Goodbye." << endl;
        //exit(1);
        return false;
    }
    stream.close();
    return true;
}

vector<int> read_file(string file) {
    ifstream stream;
    vector<int> vector;
    int data;
    stream.open(file.c_str());
    while (!stream.eof()) {
        stream >> data;
        vector.push_back(data);
    }
    vector.pop_back();
    stream.close();
    return vector;
}

void write_file(string file, vector<int> v) {
    ofstream output;
    output.open(file.c_str());
    for (int x : v) {
        output << x << endl;
    }
    output.close();
}

vector<int> merge(vector<int> v1, vector<int> v2) {
    vector<int> unsorted;
    vector<int> sort;

    for (int x : v1) {
        unsorted.push_back(x);
    }
    for (int x : v2) {
        unsorted.push_back(x);
    }

    sort = unsorted;

    int size = sort.size();
    for (int j = 0; j < size - 1; ++j) {
    int min = j;
    for (int i = j + 1; i < size; ++i) {
        if (sort.at(min) > sort.at(i)) {
            min = i;
        }
    }  
    if (min != j)
        swap(sort.at(j), sort.at(min));
    } 
    return sort;
}

void to_string(string file, vector<int> v) {
    int size = v.size();
    cout << "The list of " << size << " numbers in file " << file << " is:\n";
    for (int x : v) {
        cout << x << endl;
    }
}