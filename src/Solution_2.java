import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_2 {
	static class Prism{
		int x,y,z,hacim;
		boolean [] isFitOda={false,false,false,false,false,false};
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
	public static void odayaSigarMi(Prism p1,Prism p2){
		if(p1.x<=p2.x){
			if(p1.y<=p2.y && p1.z<=p2.z){
				p1.isFitOda[0]=true;
			}
			if(p1.z<=p2.y && p1.y<=p2.z){
				p1.isFitOda[1]=true;
			}
		}
		if(p1.x<=p2.y){
			if(p1.y<=p2.x && p1.z<=p2.z){
				p1.isFitOda[2]=true;
			}
			if(p1.y<p2.z && p1.z<=p2.x){
				p1.isFitOda[3]=true;
			}
		}
		if(p1.x<=p2.z){
			if(p1.y<=p2.x && p1.z<p2.y){
				p1.isFitOda[4]=true;
			}
			if(p1.y<p2.y && p1.z<p2.x){
				p1.isFitOda[5]=true;
			}
		}
	}

}
