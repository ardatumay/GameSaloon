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
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N;
		
		N=scan.nextInt();
		Prism ODA = new Prism(scan.nextInt(), scan.nextInt(), scan.nextInt());
		
		Prism [] Kutular = new Prism[N];
	
		
		for (int i = 0; i < N; i++) {
			Kutular[i]=new Prism(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
		
		Arrays.sort(Kutular, new Hacmegoresort());
		
		
	}

}
