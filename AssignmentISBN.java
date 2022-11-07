/**
 * Author: David Bowles
 * File: AssignmentISBN.java
 * Description: This application runs book inventory, 
 *              accounts for books returned/checked out.
 *              The program will loop until the user
 *              chooses to quit the program.
 */

// Import Scanner.
import java.util.Scanner;

public class AssignmentISBN {
	public static void main(String[] args) {
		
		// Create Scanner.
		Scanner input = new Scanner(System.in);
		
		
		// Declare user-input variable for first 12 digits of ISBN.
		String strISBN;	
		
		// Char variable initialized to continue.
		// User input will change the value.
		char continueOrQuit = 'Y';
		
		// Counters for return/checked out books
		int returnCounter = 0;
		int checkOutCounter = 0;
		int totalProcessed = 0;
		
		// Display heading.
		System.out.println("***************************************************");
		System.out.println("* Welcome to the Book Inventory Program!          *");
		System.out.println("***************************************************");
		
		// Do/While loop to continue looping program until
		// user decides to quit program.
		do {
		
		System.out.println("Enter the first 12 digits of ISBN-13 as a string: ");
		strISBN = input.next();
		
		
		// String length must be equal to 12.
		while (strISBN.length() != 12) {
			System.out.println("-------------------------------------------------");
			System.out.println("Invalid ISBN input. Try again.");
			System.out.println("Enter the first 12 digits of ISBN-13 as a string: ");
			strISBN = input.next();
		}
		
		// Make sure input is 12 digits.			
		if (strISBN.length() == 12) {
					
			// Create variable initialized with the string value in long data type.
			long ISBN12 = Long.valueOf(strISBN);
			
			// Define each digit place.
			long d1 = ISBN12/10/10/10/10/10/10/10/10/10/10/10;
			long d2 = ISBN12/10/10/10/10/10/10/10/10/10/10 % 10;
			long d3 = ISBN12/10/10/10/10/10/10/10/10/10 % 10;
			long d4 = ISBN12/10/10/10/10/10/10/10/10 % 10;
			long d5 = ISBN12/10/10/10/10/10/10/10 % 10;
			long d6 = ISBN12/10/10/10/10/10/10 % 10;
			long d7 = ISBN12/10/10/10/10/10 % 10;
			long d8 = ISBN12/10/10/10/10 % 10;
			long d9 = ISBN12/10/10/10 % 10;
			long d10 = ISBN12/10/10 % 10;
			long d11 = ISBN12/10 % 10;
			long d12 = ISBN12 % 10;
			
			
			// Check digit variable declared.
			long checkDigit = 10 - (d1 +3*d2 +d3 + 3*d4 + d5 + 3*d6 + d7 + 3*d8 + d9 + 3*d10 + d11 + 3*d12) % 10;
			
			// If check digit is equal to 10, change value to 0.
			if (checkDigit == 10) {
				checkDigit = 0;
			}
							
			// Display ISBN-13 with check digit concatenated with first 12 digits.
			System.out.println("ISBN-13 number is: " + ISBN12 + checkDigit);
			System.out.println();
			System.out.println();
			
			
			// Return or check out prompt.
			System.out.print("Enter 'R' for return or 'C' for check out: ");
			char returnOrContinue = input.next().charAt(0);
			
			// If 'R' or 'C' is entered, increment counter values.
			if (returnOrContinue == 'R') {
				returnCounter++;
			}
			
			else if (returnOrContinue == 'C') {
				checkOutCounter++; 
			}
			
			// Total amount of books processed is equal to returns + checked out.
			totalProcessed = returnCounter + checkOutCounter;
			
			// Book Inventory menu.
			System.out.println("***************************************************");
			System.out.println("*               Daily Book Inventory              *");
			System.out.println("***************************************************");
			System.out.println("Number of books returned: " + returnCounter);
			System.out.println("Number of books checked out: " + checkOutCounter);
			System.out.println("The total of books processed: " + totalProcessed);
			System.out.println("***************************************************");
			System.out.print("Enter 'Y' to continue, 'N' to quit: ");
			continueOrQuit = input.next().charAt(0);
			System.out.println("****************************************");
			System.out.println();
		}
	  }
		while (continueOrQuit == 'Y');
	}

}
