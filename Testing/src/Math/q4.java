package Math;

public class q4 {
	public static double q4b (int n) {
		int time = 150;
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Starting " + i);
			time = time + 10;
			for (int k = 5; k <= i+2; k++) {
				System.out.println("\tStarting " + k);
				time = time + 6 * k;
			}
		}
		
		return time;
	}
	
	public static void main(String[] args) {
		int number = 50;
		
		System.out.println(q4b(number));
	}
}
