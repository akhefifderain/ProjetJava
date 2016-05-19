package Agent;
import java.util.LinkedList;
import java.util.List;

public abstract class Agent{
	final static int nombreDeRobotDevantEtreAlerte = 2;
	public static int nl;
	public static int nc;
    private static List LA = new LinkedList();
    static char tableauDirection[] = {'n','e','s','o'};
	int pos_x;
	int pos_y;
	public static boolean extinctionIncendie = false;
	public String aff;
	
	int horloge;
	abstract void cycle();
	public static void affiche(){
		for(int i=0;i<nl;i++){
			System.out.print(i+" ");
			for(int j=0;j<nc;j++)
				System.out.print(caractereImprimable(i,j));
			System.out.println();
		}
	}
	public static String caractereImprimable(int i,int j){
		String r=".";
		Agent a;
		for(int k=0;k<getLA().size();k++){
			a=(Agent)getLA().get(k);
			if(a.pos_x==i && a.pos_y==j)return a.aff;
		}
		return r;
	}
	
	public String toString(){
		return getClass().getSimpleName()+" "+aff+" "+pos_x+" "+pos_y+" / ";
	}
	public static Agent getAgentViaCoor(int x,int y){
		for(int i =0; i<LA.size();i++)
			if(((Agent) (LA.get(i))).getX()==x&&(((Agent) (LA.get(i))).getY()==y))
				return ((Agent) LA.get(i));
		return null;
	}
	public static List getLA() {
		return LA;
	}
	public static void setLA(List lA) {
		LA = lA;
	}
	
	public void setX(int x){
		
		this.pos_x=x;
	}
	public void setY(int y){
		this.pos_y=y;
	}
	
	public int getX(){
		return pos_x;
	}
	public int getY(){
		return pos_y;
	}
	public static void faireCycle(){
		for (int i = 0;i< LA.size();i++){
 			((Agent) LA.get(i)).cycle();
		}
	}
	
	public static void verifierIncendie() {
		int compteurAlarme = 0;
		boolean incendie=true;
		for(int i =0; i<LA.size();i++)
			if(LA.get(i) instanceof Robot && ((Robot) LA.get(i)).visionFeu)
				compteurAlarme++;
			else if(LA.get(i) instanceof Incendie){
				incendie=true;

			}
		if (compteurAlarme >= nombreDeRobotDevantEtreAlerte)
			extinctionIncendie=true;
		for(int i =0; i<LA.size();i++)
			if(LA.get(i) instanceof Robot && ((Robot) LA.get(i)).visionFeu)
				compteurAlarme++;
		if(!incendie){
			extinctionIncendie=false;
			desactiverRobot();
		}
		
		// TODO Auto-generated method stub
		
	}
	private static void desactiverRobot() {
		for(int i =0; i<LA.size();i++)
			if(LA.get(i) instanceof Robot)
				((Robot) LA.get(i)).visionFeu=false;
		
	}
	
	

}