package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		

		// Your code follows here.
		
		// takes in an integer to represent the total number of customers
				int totalCust = scan.nextInt();
				
				// an array to take in the first names of customers
				String[] firstNames = new String[totalCust];
				// an array to take in the last names of customers
				String [] lastNames = new String[totalCust];
				// an array to take in the total number of items bought by the customer
				int[] totalItems = new int[totalCust];
			
				
				
				// a for loop to read and input values into each array listed above
				for (int i=0; i<firstNames.length; i++) {
					firstNames[i] = scan.next();
					lastNames[i] = scan.next();
					totalItems[i] = scan.nextInt();
					// once the for loop reiterates, the total counter is reset to 0 for the next customer
					double total = 0;
					// a nested for loop for each item to store the quantity and price of each item into an array
					for (int k=0; k<totalItems[i]; k++) {
						int[] itemQuant = new int[totalItems[i]];
						itemQuant[k] = scan.nextInt();
						// a meaningless variable to read over a string input
						String itemNames = scan.next();
						double[] itemPrice = new double[totalItems[i]];
						itemPrice [k] = scan.nextDouble();
						// every time the for loop executes it adds into the total price of the items bought from a single customer
						total += calculatePrice(itemQuant, itemPrice);
					}
					
				
					System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] +  ": " + String.format("%.2f", total));
				
				} scan.close();
							
						
	}

static double calculatePrice(int[] quant, double [] price) {
		
		double total = 0;
		
		for (int i=0; i<quant.length; i++) {
			total += quant[i] * price[i];
		}
		
		return total;
	}

}
