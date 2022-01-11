// Author: Kevin Bumgarner (kgb0022)
// USR_ID: 903935034
// File Name: project1_Bumgarner_kgb0022.cpp
// COMPILE: g++ project1_Bumgarner_kgb0022.cpp
// RUN:     ./a.out
// Version: 08/30/2020
// Description: A simple program that gives the user
//              loan information based on loan ammount,
//              Interest Rate, and Monthly Payment.
// HELP: Referenced Stack Overflow and 
//       Dr. Xuechao Li's Project 1 Hints to help me complete this project.

#include <iostream> 
#include <assert.h>
#include <iomanip> 
using namespace std;

int main() {
   // Variable Initialization
   // Loan ammount
   double loan = -1;
   // Interest Rate for the Year
   double interestRateYearly = -1;
   // Interest Rate for a Month 
   double interestRateMonthly = -1; 
   // Interest Rate used in Calculations
   double interestRateCalc = -1;
   // Payment made monthly
   double monthlyPayment = -1;
   // Total interest rate payed
   double totalInterest = 0;
   // Monthly Interest Rate Calculation
   double interestAmountMonthly = 0;
   // Principal
   double principal = 0;
   // Number of Months Paying
   int monthCount = 0;
   // Width of table columns 
   int width = 12;

   // CURRENCY FORMATTING
   cout.setf(ios::fixed);
   cout.setf(ios::showpoint);
   cout.precision(2);

   // USER INPUT
   // NOTE: For valid input, the loan, interest, and monthly payment must
   // be positive. The monthly payment must also be large enough to
   // terminate the loan.

   // GET LOAN AMMOUNT
   while (loan < 0) {
      cout << "\nLoan Amount: ";
      cin >> loan;  
   } 

   // GET YEARLY INTEREST RATE & MONTHLY RATE
   while (interestRateYearly < 0) {
      cout << "Interest Rate (% per year): ";
      cin >> interestRateYearly;
   } 
   interestRateMonthly = interestRateYearly / 12;
   interestRateCalc = interestRateMonthly / 100;

   // GET MONTHLY PAYMENT AMOUNT
   while (monthlyPayment < 0 || monthlyPayment < (loan * interestRateCalc)) {
      cout << "Monthly Payments: ";
      cin >> monthlyPayment;
   } 

   cout << endl;
   
   // AMORTIZATION TABLE HEADER 
   cout << "**********************************************************************\n"
      << "\t\t\tAmortization Table\n"
      << "**********************************************************************\n";

   cout << left << setw(width) << "Month" 
       << left << setw(width) << "Balance" 
       << left << setw(width) << "Payment" 
       << left << setw(width) << "Rate" 
       << left << setw(width) << "Interest" 
       << left << setw(width) << "Principal"
       << endl;

   cout << left << setw(width) << "0" 
       << left << setw(1) << "$" << setw(11) << loan 
       << left << setw(width) << "N/A"
       << left << setw(width) << "N/A" 
       << left << setw(width) << "N/A" 
       << left << setw(width) << "N/A" 
       << endl;

   // CALCULATIONS + BUILD TABLE
   while (loan > 0) {
      interestAmountMonthly = loan * interestRateCalc;       
      if (loan < monthlyPayment) {
         monthlyPayment = loan + interestAmountMonthly;
         principal = monthlyPayment - interestAmountMonthly;
         cout << left << setw(width) << ++monthCount 
             << left << setw(12) << "$0.00" 
             << left << setw(1) << "$" << setw(11) << monthlyPayment 
             << left << setw(width) << interestRateMonthly 
             << left << setw(1) << "$" << setw(11) << interestAmountMonthly 
             << left << setw(1) << "$" << setw(11) << principal 
             << endl;
         loan = 0;
      } 
      else {
         principal = monthlyPayment - interestAmountMonthly;
         loan = loan * (1 + interestRateCalc) - monthlyPayment;            
         cout << left << setw(width) << ++monthCount 
             << left << setw(1) << "$" << setw(11) << loan 
             << left << setw(1) << "$" << setw(11) << monthlyPayment 
             << left << setw(width) << interestRateMonthly 
             << left << setw(1) << "$" << setw(11) << interestAmountMonthly 
             << left << setw(1) << "$" << setw(11) << principal 
             << endl;
      } 
      totalInterest += interestAmountMonthly;
   }

   // SUMMARY OF PAYMENT
   cout << "**********************************************************************\n";
   cout << "\nIt takes " << monthCount <<  " months to pay off "
       << "the loan.\n"
       << "Total interest paid is: $" << totalInterest; 
   cout << endl << endl;
   return 0;
}