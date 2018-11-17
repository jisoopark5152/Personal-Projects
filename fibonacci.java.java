/* Jisoo Park
 * CIS 2168
 * Andrew Rosen
 */
package fibonacci;

public class fibonacci {

	public static int fib(int n) {
	if (n == 1 || n==2) {
		return 1;	
	}
	return fib(n - 1) + fib(n - 2);
}

public static void main(String[] args) {
	System.out.println(fib (5));
}
}