import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_2 {
	static class Prism{
		int x,y,z,hacim;
		Prism(int a, int b, int c){
			x=a;y=b;z=c;
			hacim=x*y*z;
		}
		
	}
	static class Hacmegoresort implements Comparator<Prism>
	{
	    public int compare(Prism a, Prism b)
	    {
	        return a.hacim - b.hacim;
	    }
	}
	private static Prism[] filterInput(Prism[] kutular, Prism oda){
		ArrayList<Prism> filteredKutular = new ArrayList<Prism>();
		for(int i = 0; i < kutular.length; i++){
			if(((kutular[i].x > oda.x) && (kutular[i].x > oda.y) && (kutular[i].x > oda.z) && (kutular[i].y > oda.x) && (kutular[i].y > oda.y) && (kutular[i].y > oda.z) && (kutular[i].z > oda.z) && (kutular[i].z > oda.x) && (kutular[i].z > oda.y)) || (kutular[i].hacim > oda.hacim)){

			}else{
				filteredKutular.add(kutular[i]);
			}
		}
		Prism [] resultKutular = (Prism[]) filteredKutular.toArray();
		return resultKutular;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N, x,y,z;
		
		N=scan.nextInt();
		Prism ODA = new Prism(scan.nextInt(), scan.nextInt(), scan.nextInt());
		
		Prism [] Kutular = new Prism[N];
		int [][] Kupler = new int [N][3];
		
		for (int i = 0; i < N; i++) {
			Kutular[i]=new Prism(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}


		Kutular = filterInput(Kutular, ODA);
		Arrays.sort(Kutular, new Hacmegoresort());
		
		
	}

}
