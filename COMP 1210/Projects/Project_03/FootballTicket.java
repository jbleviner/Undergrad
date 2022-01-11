import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

/**
 * Program to accept coded football ticket information as input 
 *     that includes the ticket price, category, time, date, seat, 
 *     row, section, followed by the description of the game. 
 * Then prints the ticket information including the actual cost, 
 *     which is the price with discount applied, and a random prize 
 *     number.
 *      
 * Project 3 
 * @author Kevin Bumgarner - COMP 1210 - 003
 * @version septemeber 14th, 2018
 */
 
 
public class FootballTicket {

   static final double STUDENT_DISCOUNT = 0.67; 
   static final double FACULTY_STAFF_DISCOUNT = 0.20;
   
 /**
  * Gets game ticket code from user and reads it to give user
  * ticket info. 
  * 
  * @param args Command line arguments - not used 
  */
   
   public static void main(String[] args) {
   
      // Get ticket code from user
      Scanner userInput = new Scanner(System.in);
      String ticket = "";
      
      System.out.print("Enter your ticket code: ");
      ticket = userInput.nextLine();
      ticket = ticket.trim();
      
      // Invalidate short ticket code 
      if (ticket.length() < 25) {
      
         System.out.println();
         System.out.println("Invalid Ticket Code.");
         System.out.println("Ticket code must have at least 25 characters.");
      } 
      else {
         // Read user input
      
         // Get category
         char category = ticket.charAt(0);
      
         // Get price 
         DecimalFormat df1 = new DecimalFormat("$#0.00");
         double price;
         String priceFinal;
         price = Double.parseDouble(ticket.substring(1, 6)) / 100;
         priceFinal = df1.format(price);
        
         // Get cost
         double cost;
         if (category == 's') {
            cost = price * (1 - STUDENT_DISCOUNT);
         }
         else if (category == 'f') {
            cost = price * (1 - FACULTY_STAFF_DISCOUNT); 
         }
         else {
            cost = price;
         }
         
         String costFinal;
         costFinal = df1.format(cost);
         
         // Get time
         String hour;
         String minute;
         hour = ticket.substring(6, 8);
         minute = ticket.substring(8, 10);
         
         // Get date
         String month;
         String day;
         String year;
         month = ticket.substring(10, 12);
         day = ticket.substring(12, 14);
         year = ticket.substring(14, 18);
      
         // Get seat 
         String seat;
         seat = ticket.substring(18, 20);
      
         // Get row
         String row;
         row = ticket.substring(20, 22);
         
         // Get section
         int section;
         section = Integer.parseInt(ticket.substring(22, 24));
        
         // Get game description
         String game;
         game = ticket.substring(24);
        
         // Generate random prize number 
         Random gen = new Random();
         int prize;
         prize = gen.nextInt((9999999) + 1000000);
         
         // Print ticket description
         System.out.println();
         System.out.println("Game: " + game 
            + "   Date: " + month + "/" + day + "/" + year 
            + "   Time: " + hour + ":" + minute);
         System.out.println("Section: " + section
            + "   Row: " + row
            + "   Seat: " + seat);
         System.out.println("Price: " + priceFinal 
            + "   Category: " + category
            + "   Cost: " + costFinal);
         System.out.print("Prize Number: " + prize);
         
      }
   }
}