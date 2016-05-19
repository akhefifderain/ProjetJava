package Agent;

import java.util.LinkedList;

import autre.Coordonnee;

public class Robot extends Agent{
	char etat;
	char dir;
	LinkedList feuEnVisuel;
	LinkedList chemin;
	Robot robotASuivre;
	int tourDetectionRobotASuivre;
	static boolean etatAlerte = false;
	boolean surCheminRobotASuivre=false;
	int RetardSurRobotASuivre;
	boolean visionFeu;
	void cycle(){
		int nombreChangementTour=0;
		if(!visionFeu){
			if(robotASuivre==null){
				while((vision()||(!visionFeu&&!avancer()))&&nombreChangementTour<10){
					//System.out.println(visionRobot());
					changerDir();
					nombreChangementTour++;
				}
				
			}
			else{
				if(!surCheminRobotASuivre){
					avancer();
					if(chemin.getLast().equals(robotASuivre.chemin.get(tourDetectionRobotASuivre)))
						surCheminRobotASuivre=true;
				}else{
					
					Coordonnee coorObjectif=(Coordonnee) robotASuivre.chemin.get(tourDetectionRobotASuivre++);
					if(coorObjectif.x>pos_x)
						dir = 's';
					else if(coorObjectif.x<pos_x)
						dir = 'n';
					else if(coorObjectif.y<pos_y)
						dir = 'o';
					else
						dir = 'e';
					if(!avancer())
						tourDetectionRobotASuivre--;
						
				}
			}
		}
		horloge++;
	}
	public Robot(int i,int j,char dir,String n){
		chemin = new LinkedList();
		pos_x=i;pos_y=j;
		this.dir=dir;
		horloge=0;
		aff=n;
		visionFeu = false;
		getLA().add(this);
	}

	/**
	 * @return
	 */
	public boolean vision(){
		boolean continuer = true;
		for(int i =1;continuer&&!visionFeu;i++){
			switch(dir){
			case 'n':
				if(Agent.caractereImprimable(pos_x-i, pos_y) == "X"||pos_x-i<=0)
					continuer=false;
				else if(!Agent.caractereImprimable(pos_x-i, pos_y).equals(" ")){
					if(Agent.caractereImprimable(pos_x-i, pos_y) == "O"||Agent.caractereImprimable(pos_x-i, pos_y) == "o"){
						etatAlerte = true;
						visionFeu = true; 
						//si il voit du feu
					}else{
						if(etatAlerte&&robotASuivre == null){
							robotASuivre = (Robot) Agent.getAgentViaCoor(pos_x-i, pos_y);
							tourDetectionRobotASuivre=horloge;
						}
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
						etatAlerte = true;
						visionFeu = true; 
						
						//si il voit du feu
					}else{
						if(etatAlerte&&robotASuivre == null){
							robotASuivre = (Robot) Agent.getAgentViaCoor(pos_x, pos_y+i);
							tourDetectionRobotASuivre=horloge;
						}
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
						etatAlerte = true;
						visionFeu = true; 
						
						//si il voit du feu
					}else{
						if(etatAlerte&&robotASuivre == null){
							robotASuivre = (Robot) Agent.getAgentViaCoor(pos_x+i, pos_y);
							tourDetectionRobotASuivre=horloge;
						}
						continuer =false;
						return true;
					}

				}


				break;
			case 'o':
				if(Agent.caractereImprimable(pos_x, pos_y-i) == "X"||pos_y-i<=0)
					continuer=false;
				else if(Agent.caractereImprimable(pos_x, pos_y-i) != " " ){
					if(Agent.caractereImprimable(pos_x, pos_y-i) == "O"||Agent.caractereImprimable(pos_x, pos_y-i) == "o"){
						//si il voit du feu
						etatAlerte = true;
						visionFeu = true; 
					}else{						
						if(etatAlerte&&robotASuivre == null){
							robotASuivre = (Robot) Agent.getAgentViaCoor(pos_x-i, pos_y);
							tourDetectionRobotASuivre=horloge;
					}
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
				chemin.add(new Coordonnee(pos_x,pos_y));				
				return true;
			}
			break;
		case 'e':
			if(pos_y+1<nc&&Agent.caractereImprimable(pos_x, pos_y+1) == " "){

				pos_y++;
				chemin.add(new Coordonnee(pos_x,pos_y));
				return true;
			}
			//			System.out.println("_____________"+Agent.caractereImprimable(pos_x, pos_y+1));
			break;
		case 's':
			if(pos_x+1<nl&&Agent.caractereImprimable(pos_x+1, pos_y) == " "){
				pos_x++;
				chemin.add(new Coordonnee(pos_x,pos_y));
				return true;
			}
			break;
		case 'o':
			if(pos_y-1>0&&Agent.caractereImprimable(pos_x, pos_y-1) == " "){
				pos_y--;
				chemin.add(new Coordonnee(pos_x,pos_y));
				return true;
			}
			break; 
		}
		return false;
	}
	//public boolean VoitUnAutreRobot(){
	//	for(int )
	//}
	public static char randomDir(){
		return tableauDirection[(int)(Math.random() * ((tableauDirection.length-1)+1))]; 
	}
	public void changerDir(){
		dir = randomDir();

	}
}