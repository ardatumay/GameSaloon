import java.util.*;

public class Solution_2 {
	static class Prism {
		int x, y, z, hacim;
		boolean[] isFitOda = { false, false, false, false, false, false };

		Prism(int a, int b, int c) {
			x = a;
			y = b;
			z = c;
			hacim = x * y * z;
		}
		Prism(Prism p1,Prism p2){
			hacim = p1.hacim + p2.hacim;
		}

	}

	static class Hacmegoresort implements Comparator<Prism[]> {
		public int compare(Prism a[] , Prism b[]) {
			return a[2].hacim- b[2].hacim;
		}
	}

	private static Prism[] filterInput(Prism[] kutular, Prism oda) {
		ArrayList<Prism> filteredKutular = new ArrayList<Prism>();
		for (int i = 0; i < kutular.length; i++) {
			if (((kutular[i].x > oda.x) && (kutular[i].x > oda.y) && (kutular[i].x > oda.z) && (kutular[i].y > oda.x)
					&& (kutular[i].y > oda.y) && (kutular[i].y > oda.z) && (kutular[i].z > oda.z)
					&& (kutular[i].z > oda.x) && (kutular[i].z > oda.y)) || (kutular[i].hacim > oda.hacim)) {

			} else {
				filteredKutular.add(kutular[i]);
			}
		}
		Prism[] resultKutular =  filteredKutular.toArray(new Prism[0]);
		return resultKutular;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N;

		N = scan.nextInt();
		Prism ODA = new Prism(scan.nextInt(), scan.nextInt(), scan.nextInt());

		Prism[] Kutular = new Prism[N];

		for (int i = 0; i < N; i++) {
			Kutular[i] = new Prism(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}

		Kutular = filterInput(Kutular, ODA);
		//Arrays.sort(Kutular, new Hacmegoresort());
		Prism [][] CombKutular = tumKombinasyonlar(Kutular);
		Arrays.sort(CombKutular, new Hacmegoresort());
		for(Prism p[] : CombKutular){
			System.out.println(p[2].hacim);
		}
	}

	public static Prism[][] tumKombinasyonlar(Prism[] kutular) {
		int kombinasyon = kutular.length * (kutular.length - 1) / 2;
		Prism[][] kombArray = new Prism[kombinasyon][3];
		int k = 0;
		for (int i = 0; i < kutular.length; i++) {
			for (int j = i + 1; j < kutular.length; j++) {
				kombArray[k][0] = kutular[i];
				kombArray[k][1] = kutular[j];
				kombArray[k][2] = new Prism(kombArray[k][0], kombArray[k][1]);
				k++;
			}
		}
		return kombArray;
	}

	public static void odayaSigarMi(Prism p1, Prism p2) {
		if (p1.x <= p2.x) {
			if (p1.y <= p2.y && p1.z <= p2.z) {
				p1.isFitOda[0] = true;
			}
			if (p1.z <= p2.y && p1.y <= p2.z) {
				p1.isFitOda[1] = true;
			}
		}
		if (p1.x <= p2.y) {
			if (p1.y <= p2.x && p1.z <= p2.z) {
				p1.isFitOda[2] = true;
			}
			if (p1.y < p2.z && p1.z <= p2.x) {
				p1.isFitOda[3] = true;
			}
		}
		if (p1.x <= p2.z) {
			if (p1.y <= p2.x && p1.z < p2.y) {
				p1.isFitOda[4] = true;
			}
			if (p1.y < p2.y && p1.z < p2.x) {
				p1.isFitOda[5] = true;
			}
		}
	}

}
