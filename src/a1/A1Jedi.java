package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// takes in an integer to show the number of items in the store.
				int itemCount = scan.nextInt();
				
				// an array to take in the name of each item in the store
				String[] itemNames = new String[itemCount];
				
				// an array to take in the prices of each item in the store
				double[] itemPrice = new double[itemCount];
				
				// a for loop to assign price values into the price array
				for(int i=0; i<itemPrice.length; i++) {
					itemNames[i] = scan.next();
					itemPrice[i] = scan.nextDouble();
				}
				
				// takes in an integer to show the number of customers
				int totalCust = scan.nextInt();
				
				// an array to take in the first names of customers
				String[] firstNames = new String[totalCust];
				
				// an array to take in the last names of customers
				String [] lastNames = new String[totalCust];
				
				// an array to take in the total number of items bought by the customer
				int[] totalItems = new int[totalCust];
				
				
				
				int[] itemCounter = new int[itemCount];
				int[] custCounter = new int[itemCount];
				
				// a for loop to read and input values into each array listed above
				for(int i=0; i<firstNames.length; i++) {
					firstNames[i] = scan.next();
					lastNames[i] = scan.next();
					totalItems[i] = scan.nextInt();
					int[] checkCust = new int[itemCount];
					// a nested for loop for each item to store the quantity and price of each item into an array
					for (int k=0; k<totalItems[i]; k++) {
						int[] itemQuant = new int[totalItems[i]];
						itemQuant[k] = scan.nextInt();
						String[] shoppingList = new String [totalItems[i]];
						shoppingList[k] = scan.next();
					
						// another nested for loop to check if a customer has bought a specific item
						for (int m=0; m<itemNames.length; m++) {
							if(itemNames[m].equals(shoppingList[k])) {
								checkCust[m] ++ ;
							} 
							
						}
						log(itemQuant[k], shoppingList[k], itemNames, itemCounter, custCounter, checkCust);
					} 
				}	scan.close();
				
				for(int i=0; i<itemNames.length; i++) {
					if (custCounter[i] < 1) {
					System.out.println("No customers bought " + itemNames[i]);
					} else {
						System.out.println(custCounter[i] + " customers bought " + itemCounter[i] + " " + itemNames[i]);
					}
				}
	}
	
	static void log(int singleItemQuant, String shoppingItem, String[] itemNames, int[] itemCounter, int[] custCounter, int[] checkCust) {
		
		for (int i=0; i<itemNames.length; i++) {
			if (itemNames[i].equals(shoppingItem) && checkCust[i] < 2) {
				custCounter[i] ++;
			}
			if (itemNames[i].equals(shoppingItem)) {
				itemCounter[i] += singleItemQuant;
			}
		}
	}
}
