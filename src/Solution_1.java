import java.util.Scanner;

/**
 * Created by User on 3/24/2018.
 */
public class Solution_1 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		char customerType;
		int t1, t2, c1, c2, c3;
		int p1;
		int N, K;

		customerType = scan.next().charAt(0);
		switch (customerType) {
		case 'V':
			N = scan.nextInt();
			K = scan.nextInt();
			p1 = scan.nextInt();

			if (N < 0 || K < 0 || p1 < 0) {
				System.exit(0);
			}
			if (p1 > N) {
				System.exit(0);
			}
			if (K * p1 > N) {
				int availableMins = N / p1;
				System.out.println(availableMins);
			} else {
				int reminderCredit = N - K * p1;
				System.out.println(reminderCredit);
			}
			break;
		case 'M':
			N = scan.nextInt();
			K = scan.nextInt();
			t1 = scan.nextInt();
			t2 = scan.nextInt();
			c1 = scan.nextInt();
			c2 = scan.nextInt();
			c3 = scan.nextInt();

			if (N < 0 || K < 0 || t1 < 0 || t2 < 0 || c1 < 0 || c2 < 0 || c3 < 0) {
				System.exit(0);
			}
			if ((t1 > 0 && c1 > N) || N < 0) {
				System.exit(0);
			}

			else if (t1 == 0 && c2 > N) {
				System.exit(0);
			} else if (t1 == 0 && t2 == 0 && c3 > N) {
				System.exit(0);
			}
			int totalSpentCredit = t1 * c1 + t2 * c2 + (K - t1 - t2) * c3;
			int availableMins;
			if (totalSpentCredit > N) {
				if (t1 * c1 >= N) {
					availableMins = N / c1;
					System.out.println(availableMins);
				} else if ((t1 * c1 < N) && (N <= (t1 * c1 + t2 * c2))) {
					availableMins = t1 + (N - t1 * c1) / c2;
					System.out.println(availableMins);
				} else if (((t1 * c1 + t2 * c2) < N)) {
					availableMins = t1 + t2 + (N - (t1 * c1 + t2 * c2)) / c3;
					System.out.println(availableMins);
				}
			} else {
				int reminderCredit = N - (t1 * c1 + t2 * c2 + (K - t1 - t2) * c3);
				System.out.println(reminderCredit);
			}
			break;
		}
	}
}