package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// takes in an integer to show the number of items in the store.
		int itemCount = scan.nextInt();
		// an array to take in the name of each item in the store
		String[] itemName = new String[itemCount];
		// an array to take in the prices of each item in the store
		double[] itemPrice = new double[itemCount];
		
		// a for loop to assign price values into the price array
		for(int i=0; i<itemPrice.length; i++) {
			itemName[i] = scan.next();
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
		// an array to take in the total amount spent by the customer
		double[]amountSpent = new double[totalCust];
		
		
		// a for loop to read and input values into each array listed above
		for(int i=0; i<firstNames.length; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			totalItems[i] = scan.nextInt();
			// a nested for loop for each item to store the quantity and price of each item into an array
			for (int k=0; k<totalItems[i]; k++) {
				int[] itemQuant = new int[totalItems[i]];
				itemQuant[k] = scan.nextInt();
				String[] shoppingList = new String [totalItems[i]];
				shoppingList[k] = scan.next();
				amountSpent[i] += itemQuant[k] * priceCheck(shoppingList[k], itemName, itemPrice);
			}
			
		} 	scan.close();
			System.out.println("Biggest: " + firstNames[(biggestIndex(amountSpent))] + " " + lastNames[(biggestIndex(amountSpent))] + " (" + String.format("%.2f", biggest(amountSpent)) + ")");
			System.out.println("Smallest: " + firstNames[(smallestIndex(amountSpent))]+ " " + lastNames[(smallestIndex(amountSpent))]  + " (" + String.format("%.2f", smallest(amountSpent)) + ")");
			System.out.println("Average: " + String.format("%.2f", average(amountSpent, totalCust)));
		
	}
	
	
	
	// a method that checks the price of the customer's items and returns that price
	static double priceCheck(String shoppingList, String [] itemName, double [] itemPrice) {
	
		double price = 0;
	
		for (int k=0; k<itemName.length; k++) {
			if (shoppingList.equals(itemName[k])) {
					price = itemPrice[k];
			}
		}
		return price;
	}
	// a method that returns the smallest amount spent from all customers
	static double smallest(double[] amountSpent) {
	
		double currentMin = amountSpent[0];
	
		for (int i=1; i<amountSpent.length; i++) {
			if (amountSpent[i] < currentMin) {
			currentMin = amountSpent[i];
			}
			
		}
	
		return currentMin;
	}
	// a method that returns an integer that represents the index of the smallest spender name
			static int smallestIndex(double[] amountSpent) {
				
				double currentMin = amountSpent[0];
				int index = 0;
			
				for (int i=1; i<amountSpent.length; i++) {
					if (amountSpent[i] < currentMin) {
					currentMin = amountSpent[i];
					index = i;
					}
				}
				return index;
			}
	// a method that returns the biggest amount spent from all customers
	static double biggest(double[] amountSpent) {
	
		double currentMax = amountSpent[0];
	
		for (int i=1; i<amountSpent.length; i++) {
			if (amountSpent[i] > currentMax) {
			currentMax = amountSpent[i];
			}
		}
		return currentMax;
	}
	// a method that returns an integer that represents the index of the biggest spender name
	static int biggestIndex(double[] amountSpent) {
		
		double currentMax = amountSpent[0];
		int index = 0;
	
		for (int i=1; i<amountSpent.length; i++) {
			if (amountSpent[i] > currentMax) {
			currentMax = amountSpent[i];
			index = i;
			}
		}
		return index;
	}
	// a method that returns the average amount spent from all customers
	static double average(double[] amountSpent, int totalCust) {
		double average = 0;
		double total = 0;
		
		for(int i=0; i<amountSpent.length; i++) {
			total += amountSpent [i];
		}
		average = total / totalCust;
		return average;
	}
	

	
	
}
