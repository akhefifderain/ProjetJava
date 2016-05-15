package test;
import Agent.Agent;
import Agent.Carrefour;
import Agent.Incendie;
import Agent.Robot;

public class TestIncendie {
	public static void main(String[] args) {
		Robot r1 = new Robot(1,1,'e',"a");
		Robot r2 = new Robot(2,2,'e',"b");
		Carrefour c1 = new Carrefour(1,1,'v',3,2,1);
		
		System.out.println(Agent.getLA());
		Carrefour.init();
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
		}
	}
}