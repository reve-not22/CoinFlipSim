package mainpkg;
import java.util.Scanner;
import java.util.Random;

public class MainClass {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter the number of coins to be flipped!");
		
		int numCoins = scnr.nextInt();
		for (var i = 0; i < numCoins; i++) {	
			System.out.println(flipCoin());
		}
	}
	
	static String flipCoin() {
		Random rand = new Random();
		boolean isHeads = rand.nextBoolean();
		
	    if (isHeads) {
            return "Heads";
        } else {
            return "Tails";
        }
	}
}
