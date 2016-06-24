package autre;

import Agent.Agent;
import Agent.Robot;

public class Carte {

	public Carte(int c,int l, int nb_r){
		Agent.nl=l;
		Agent.nc=c;
		if(nb_r>26 || Agent.nc*Agent.nl<nb_r){
			throw new Error("Trop de roboot");
		}



		/*Compteur a 65 pour que les robots se voit attribuer un nom de A à Z*/
		int compteur=65;
		while(compteur<(nb_r+65)){

			initRobot(new Robot(-1,-1, Robot.randomDir(),Character.toString((char)compteur).toLowerCase()));
			compteur++;
		}



		Agent.affiche();
	}


	/*Remplis la carte de papier*/
	private void init(){

	}
	private void initRobot(Agent a){
		int x,y;
		x =(int)(Math.random() * (Agent.nc));
		y = (int)(Math.random() * (Agent.nl));
		while(Agent.getAgentViaCoor(x,y)!=null){
			
			x =(int)(Math.random() * (Agent.nc));
			y = (int)(Math.random() * (Agent.nl));
			
		}
		
		a.setX(x);
		a.setY(y);
		System.out.println(a.toString()); 
	}

	public boolean PositionLibre(Agent a, int x , int y){

		return a.getX()!=x || a.getY()!=y;

	}
	public String toString(){
		String s="La carte est de "+Agent.nc+"x"+Agent.nl+".\n\n\n\n\n";

		return s;
	}

	/*		/*On check qu'il y a pas de robot
		if(Agent.getLA().size()!=1){
			boolean libre= true;

			int i=0;
			do{
				 x =(int)(Math.random() * (Agent.nc));
				 y = (int)(Math.random() * (Agent.nl));
				Agent agent =  (Agent) Agent.getLA().get(i);

				if( agent instanceof Robot ){
					for(int j=0;j<Agent.getLA().size();j++){
						agent =  (Agent) Agent.getLA().get(j);
						if(agent instanceof Robot){
							libre=PositionLibre(agent, x, y);
						}
					}
					agent =  (Agent) Agent.getLA().get(i);
					if(libre){
						System.out.println("Position Libre "+a.aff+" placé");
						a.setX(x);
						a.setY(y);
						i++;
						break;
					}else{
						System.out.println("Position non Libre "+a.aff+" pas placé");
					}
				}else{
					//Si pas robot on passe à l'agent suivant
					i++;
				}
			}while(i!=Agent.getLA().size());


		}else{
			 x =(int)(Math.random() * (Agent.nc));
			 y = (int)(Math.random() * (Agent.nl));
			a.setX(x);
			a.setY(y);

		}
		System.out.println(a.toString()); 
	 */


}
