/*Jisoo Park
 * CIS 2168
 * Towers of Hanoi Assignment
 */



package hanoitowers;
import java.util.Scanner;

public class hanoitowers {
	public void move(int n, String source, String auxiliary, String target) {
	       if (n == 1) {
	           System.out.println(source + " -> " + target);
	       } else {
	    	   move(n - 1, source, target, auxiliary);
	           System.out.println(source + " -> " + target);
	           move(n - 1, auxiliary, source, target);
	       }
	   }

	   public static void main(String[] args) {
	       hanoitowers hanoitowers = new hanoitowers();
	       System.out.print("Enter number of discs: ");
	       Scanner scanner = new Scanner(System.in);
	       int discs = scanner.nextInt();
	       hanoitowers.move(discs, "A", "B", "C");
	   }
	}


