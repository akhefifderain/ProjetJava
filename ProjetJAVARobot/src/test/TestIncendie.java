package test;
import Agent.Agent;
import Agent.Carrefour;
import Agent.Robot;

public class TestIncendie {
	public static void main(String[] args) {
		Robot r1 = new Robot(4,1,'o',"a");
		Robot r2 = new Robot(3,4,'e',"b");
		Carrefour c1 = new Carrefour(4,4,'v',0,1,1);
		System.out.println(Agent.getLA());
		Carrefour.init();
		System.out.println(Agent.getLA());
		Agent.affiche();
	}
}