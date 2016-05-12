package Agent;
import java.util.LinkedList;
import java.util.List;

public abstract class Agent{
	static int nl=6;
	static int nc=6;
    private static List LA = new LinkedList();
	int pos_x;
	int pos_y;
	String aff;
	abstract void cycle();
	public static void affiche(){
		for(int i=1;i<=nl;i++){
			System.out.print(i+" ");
			for(int j=1;j<=nc;j++)
				System.out.print(caractereImprimable(i,j));
			System.out.println();
		}
	}
	static String caractereImprimable(int i,int j){
		String r="X";
		Agent a;
		for(int k=0;k<getLA().size();k++){
			a=(Agent)getLA().get(k);
			if(a.pos_x==i && a.pos_y==j)return a.aff;
		}
		return r;
	}
	public String toString(){
		return getClass().getSimpleName()+" "+pos_x+" "+pos_y+" / ";
	}
	public static List getLA() {
		return LA;
	}
	public static void setLA(List lA) {
		LA = lA;
	}


}