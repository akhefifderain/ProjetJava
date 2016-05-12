package test;
import Agent.Agent;
import Agent.Carrefour;
import Agent.Robot;

public class TestIncendie {
	public static void main(String[] args) {
		Robot r1 = new Robot(4,1,'o',"_a_");
		//Robot r2 = new Robot(8,4,'e',"_b_");
		Carrefour c1 = new Carrefour(4,4,'v',0);
		System.out.println(Agent.getLA());
		Carrefour.init();
		System.out.println(Agent.getLA());
		Agent.affiche();
	}
}