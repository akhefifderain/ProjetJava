package Agent;

import java.util.LinkedList;

public class Robot extends Agent{
	char etat;
	char dir;
	LinkedList FeuEnVisuel;
	LinkedList RobotEnVisuel;
	void cycle(){
		int nombreChangementTour=0;
		while((vision()||!avancer())&&nombreChangementTour<10){
			//System.out.println(visionRobot());
			changerDir();
			nombreChangementTour++;
		}
		horloge++;
	}
	public Robot(int i,int j,char dir,String n){
		RobotEnVisuel = new LinkedList();
		pos_x=i;pos_y=j;
		this.dir=dir;
		horloge=0;
		aff=n;
		getLA().add(this);
	}
	/**
	 * @return
	 */
	public boolean vision(){
		boolean continuer = true;
		for(int i =1;continuer;i++){
			switch(dir){
			case 'n':
				if(Agent.caractereImprimable(pos_x-i, pos_y) == "X"||pos_x-i<=0)
					continuer=false;
				else if(!Agent.caractereImprimable(pos_x-i, pos_y).equals(" ")){
					if(Agent.caractereImprimable(pos_x-i, pos_y) == "O"||Agent.caractereImprimable(pos_x-i, pos_y) == "o"){
						//si il voit du feu
					}else{
						continuer =false;
						return true;
					}

				}


				break;
			case 'e':
				//System.out.println("________________________"+Agent.caractereImprimable(pos_x, pos_y+i)+"___"+pos_x+"____"+pos_y+"_____");
				if(Agent.caractereImprimable(pos_x, pos_y+i).equals("X")||pos_y+i>nc)
					continuer=false;
				else if(Agent.caractereImprimable(pos_x, pos_y+i) != " "&&Agent.caractereImprimable(pos_x, pos_y+i) != "X"){
					if(Agent.caractereImprimable(pos_x, pos_y+i) == "O"||Agent.caractereImprimable(pos_x, pos_y+i) == "o"){
						//si il voit du feu
					}else{
						continuer =false;
						return true;
					}

				}


				//			System.out.println("_____________"+Agent.caractereImprimable(pos_x, pos_y+1));
				break;
			case 's':
				if(Agent.caractereImprimable(pos_x+i, pos_y) == "X"||pos_x+i>nl)
					continuer=false;
				else if(Agent.caractereImprimable(pos_x+i, pos_y) != " " ){
					if(Agent.caractereImprimable(pos_x+i, pos_y) == "O"||Agent.caractereImprimable(pos_x+i, pos_y) == "o"){
						//si il voit du feu
					}else{
						continuer =false;
						return true;
					}

				}


				break;
			case 'o':
				if(Agent.caractereImprimable(pos_x, pos_y-1) == "X"||pos_y-i<=0)
					continuer=false;
				else if(Agent.caractereImprimable(pos_x, pos_y-i) != " " ){
					if(Agent.caractereImprimable(pos_x, pos_y-i) == "O"||Agent.caractereImprimable(pos_x, pos_y-i) == "o"){
						//si il voit du feu
					}else{
						continuer =false;
						return true;
					}

				}


				break; 
			}
		}
		return false;
	}
	public boolean avancer(){
		switch(dir){
		case 'n':
			if(pos_x-1>0&&Agent.caractereImprimable(pos_x-1, pos_y) == " "){

				pos_x--;
				return true;
			}
			break;
		case 'e':
			if(pos_y+1<nc&&Agent.caractereImprimable(pos_x, pos_y+1) == " "){

				pos_y++;
				return true;
			}
			//			System.out.println("_____________"+Agent.caractereImprimable(pos_x, pos_y+1));
			break;
		case 's':
			if(pos_x+1<nl&&Agent.caractereImprimable(pos_x+1, pos_y) == " "){
				pos_x++;
				return true;
			}
			break;
		case 'o':
			if(pos_y-1>0&&Agent.caractereImprimable(pos_x, pos_y-1) == " "){
				pos_y--;
				return true;
			}
			break; 
		}
		return false;
	}
	//public boolean VoitUnAutreRobot(){
	//	for(int )
	//}
	public void changerDir(){
		dir = tableauDirection[(int)(Math.random() * ((tableauDirection.length-1)+1))];

	}
}