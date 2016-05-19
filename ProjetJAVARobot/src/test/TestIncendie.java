package test;
import Agent.*;
import autre.*;

public class TestIncendie {
	public static void main(String[] args) {
		//Robot r1 = new Robot(1,1,'e',"a");
		//Robot r2 = new Robot(2,2,'e',"b");
		Carrefour c1 = new Carrefour(1,2,'v',3,5,5);
		Carte testcarte = new Carte(5,5,0);
	
		Carrefour.init();
		
		//System.out.println(testcarte.toString());
		/*System.out.println(Agent.getLA());
		
		System.out.println(Agent.getLA());
		Incendie in = new Incendie();
		Agent.affiche();
		while(true){
			Agent.verifierIncendie();
 			Agent.faireCycle();
 			Agent.affiche();
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}*/
	}
}