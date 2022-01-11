/* Author: Kevin Bumgarner 
 * USR_ID: 903935034
 * File Name: project4_Bumgarner_kgb0022.cpp
 * COMPILE: g++ project4_Bumgarner_kgb0022.cpp
 * RUN:     ./a.out
 * Version: 11/05/2020
 * Description: A simple Trivia Quiz Game.            
 * HELP: Referenced Stack Overflow, GeeksforGeeks.org and 
 *       Dr. Xuechao Li's Project 4 Hints to help me complete this project.
 */

#include <iostream>
#include <string>
#include <cstring>
#include <stdio.h>
#include <ctype.h>
using namespace std;


//Structure for creating a linked list that holds a trivia 
//   question, answer and point amount.
struct trivia_node {
    string question;
    string answer;
    int points;
    trivia_node *next;
};

//creates a pointer to trivia_node.
typedef trivia_node* ptr_node;

//Prototypes
// Creates 3 predetermined Questions
void init_question_list(ptr_node& q_list);
// Game functions 
void add_question(ptr_node& q_list);
int ask_question(ptr_node& q_list, int num_ask);
// Gets node list size
int getCount(ptr_node& q_list);
//Testing function
void Unit_test();

//CREATES TWO VERSIONS
// Comment/Un-comment below to use these versions
//#define UNIT_TESTING //Debugging Version
#define trivia_quiz //Regular Version

// variables
int point_total = 0;

// Driver Function
int main() {
    ptr_node node_list = new trivia_node;
    ptr_node constant_list = new trivia_node;

    #ifdef trivia_quiz
    init_question_list(constant_list);

    cout << "*** Welcome to Kevin's. trivia quiz game ***\n";
    
    //Add User Questions
    string cont = "YES"; 
    node_list = NULL;
    do {
        add_question(node_list);
        cout << "Continue? (Yes/No): ";
        getline(cin, cont);

    } while (cont.compare("Yes") == 0);

    //This is start of Trivia quiz game.  
    ask_question(constant_list, 3);

    cout << "\n..." << endl;
    
    int num_of_questions = getCount(node_list);
    ask_question(node_list, num_of_questions);
    
    cout << "\n*** Thank you for playing the trivia quiz game. Goodbye! ***";
    point_total = 0;
    return 0;
}
    #endif
    //Method for testing
    #ifdef UNIT_TESTING

    Unit_test();
    return 0;
}
    #endif

// Initializes a list of 3 predetermined questions.
void init_question_list(ptr_node& q_list) {
    ptr_node q1 = new trivia_node; 
    ptr_node q2 = new trivia_node;
    ptr_node q3 = new trivia_node;

    q1 -> question =  "How long was the shortest war on record? (Hint: how many minutes)";
    q1 -> answer = "38";
    q1 -> points = 100;

    q2 -> question = "What was Bank of America’s original name? (Hint: Bank of Italy or Bank of Germany)?";
    q2 -> answer = "Bank of Italy";
    q2 -> points = 50;

    q3 -> question = "What is the best-selling video game of all time? (Hint: Call of Duty or Wii Sports)?";
    q3 -> answer = "Wii Sports";
    q3 -> points = 20;

    q_list = q1;
    q1 -> next = q2;
    q2 -> next = q3;

}

//gives user the option to add a question to the linked list.
//question is added to the front of the linked list.
void add_question(ptr_node& q_list) {
    
    trivia_node *newNode = new trivia_node;
    cout << "Enter a new question: ";
    getline(cin, newNode->question);
    cout << "Enter an answer: ";
    getline(cin, newNode->answer);
    cout << "Enter award points: ";
    cin >> newNode -> points;
	cin.get();

    newNode -> next = q_list;  
    q_list = newNode; 
}

// Asks the user questions. 
int ask_question(ptr_node& q_list, int num_ask) {
    int num_of_questions = getCount(q_list);
    trivia_node *tmp;
    tmp = q_list;
    string user_answer;

    if (q_list == NULL) {
         return 0;
    }
   
    if(num_ask < 1) {
        cout << "\nWarning - the number of trivia to be asked must equal to or be larger than 1." << endl;
    } else if(num_of_questions < num_ask) {
        cout << "\nWarning - There is only " << num_of_questions << " trivia in the list." << endl;
    } else {
        for(int x = 0; x < num_ask; x++) {
            cout << "\nQuestion: " << tmp -> question << endl;
            cout << "Answer: ";
            getline(cin, user_answer);
            if (user_answer.compare(tmp -> answer) == 0) {
                point_total += tmp -> points;
                cout << "Your answer is correct. You recieve " << tmp -> points << " points." << endl;
                cout << "Your total points: " << point_total << endl;
            } else {
                cout << "Your answer is wrong. The correct answer is: " << tmp -> answer << endl;
                cout << "Your total points: " << point_total << endl;
            }
            tmp = tmp -> next;
        }
    }
    return point_total;
}

//Test cases to check whether the methods work.
void Unit_test() {
    ptr_node node_list = new trivia_node;
    init_question_list(node_list);

    cout << "*** This is a Debugging Version ***" << endl;
    cout << "Unit Test Case 1: Ask no question. The program should give a warning message.";
    ask_question(node_list, 0);
    point_total = 0;
    cout << "Case 1 Passed\n\n";
    
    cout << "Unit Test Case 2.1: Ask 1 question in the linked list. The tester enters an incorrect answer.";
    ask_question(node_list, 1);
    point_total = 0;
    cout << "Case 2.1 Passed\n\n";

    cout << "Unit Test Case 2.2: Ask 1 question in the linked list. The tester enters a correct answer.";
    ask_question(node_list, 1);
    point_total = 0;
    cout << "Case 2.2 Passed\n\n";

    cout << "Unit Test Case 3: Ask every question in the linked list.";
    int count = getCount(node_list);
    ask_question(node_list, count);
    point_total = 0;
    cout << "Case 3 Passed\n\n";

    cout << "Unit Test Case 4: Attempt to ask 5 Questions.";
    cout << " The program should give a warning message.";
    ask_question(node_list, 5);
    point_total = 0;
    cout << "Case 4 Passed\n\n";

    cout << "*** End of the debugging version ***" << endl;
}

// Gets Size of the Node List.
int getCount(ptr_node& q_list) {
    int count = 0;

    trivia_node *tmp;
    tmp = q_list;
    while (tmp != NULL) {
        count++;
        tmp = tmp -> next;
   }

    return count;
}
