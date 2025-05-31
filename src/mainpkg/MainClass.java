package mainpkg;
import java.util.Scanner;
import java.util.Random;

public class MainClass {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Press enter to flip a coin!");
		
		if (scnr.nextLine() != null) {
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
