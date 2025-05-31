package mainpkg;
import java.util.Scanner;
import java.util.Random;

public class MainClass {
	static int numCoins, numHeads, numTails;
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		numHeads = 0;
		numTails = 0;
		
		System.out.println("Enter the number of coins to be flipped!");
		
		numCoins = Math.abs(scnr.nextInt()); // Ensure a non-negative number of coins
		
		for (var i = 0; i < numCoins; i++) {	
			System.out.println(flipCoin());
		}
		
		System.out.println("Percentage of coinflips that landed on heads: " + (((float)numHeads / numCoins) * 100) + "%");
		System.out.println("Percentage of coinflips that landed on tails: " + (((float)numTails / numCoins) * 100) + "%");
	}
	
	static String flipCoin() {
		Random rand = new Random();
		boolean isHeads = rand.nextBoolean();
		
	    if (isHeads) {
	    	numHeads++;
            return "Heads";
        } else {
            numTails++;
            return "Tails";
        }
	}
}
