package Agent;

import java.util.LinkedList;

import autre.Coordonnee;

public class Robot extends Agent{
	static boolean etatAlerte = false;// voit si il y une alerte générale



	char dir;
	// à partir du moment où un robot en suis un autre cette liste sert de GPS
	LinkedList chemin;
	Robot robotASuivre;
	int tourDetectionRobotASuivre;
	boolean surCheminRobotASuivre=false;
	int deplacementRobot;

	boolean visionFeu;
	boolean visionRobot;
	void cycle(){
		// je dois reorganiser la methode permettant au robot d'agir
		vision();
		int nombreChangementTour=0;
		if(!visionFeu){
			if(visionRobot){
				if(etatAlerte){
					if(robotASuivre == null){
						if(!avancer())
							changerDir();
					}
					else{
						if(surCheminRobotASuivre){
							if(this.chemin.size()>0 &&this.getProchaineCoordonne().equals(this.chemin.getFirst()))
								avancer();
							else
								changerDir();
						}
						else{
							avancer();
							if(this.chemin.size()>0 &&this.chemin.getFirst().equals(new Coordonnee(pos_x,pos_y))){
								surCheminRobotASuivre = true;
							}
						}
					}
				}
				else{
					changerDir();
				}
			}
			else if(!avancer()){
				changerDir();
			}
		}

		//		if(!visionFeu){
		//			if(robotASuivre==null){
		//				while((vision()||(!visionFeu&&!avancer()))&&nombreChangementTour<10){
		//					//System.out.println(visionRobot());
		//					changerDir();
		//					nombreChangementTour++;
		//				}
		//				
		//			}
		//			else{
		//				if(!surCheminRobotASuivre){
		//					avancer();
		//					if(chemin.getLast().equals(robotASuivre.chemin.get(tourDetectionRobotASuivre)))
		//						surCheminRobotASuivre=true;
		//				}else{
		//					
		//					Coordonnee coorObjectif=(Coordonnee) robotASuivre.chemin.get(tourDetectionRobotASuivre++);
		//					if(coorObjectif.x>pos_x)
		//						dir = 's';
		//					else if(coorObjectif.x<pos_x)
		//						dir = 'n';
		//					else if(coorObjectif.y<pos_y)
		//						dir = 'o';
		//					else
		//						dir = 'e';
		//					if(!avancer())
		//						tourDetectionRobotASuivre--;
		//						
		//				}
		//			}
		//		}
		//		horloge++;
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
	public void vision(){
		boolean continuer = true;
		visionRobot = false; 
		visionFeu = false; 
		// on regarde si on voit un feu puis un robot
		for(int i = 0; i<Agent.getLA().size();i++){
			Agent ag = (Agent) Agent.getLA().get(i);
			// si elle voit un incendie
			if(ag instanceof Incendie&& ag.estVu(this)){
				etatAlerte = true;
				visionFeu = true;
				return;

			}
			else if(ag instanceof Robot&& !ag.equals(this)&&ag.estVu(this)){
				visionRobot = true; 
				if(etatAlerte && robotASuivre==null && ((Robot)ag).robotASuivre!=this){
					robotASuivre = ((Robot)ag);
				}

			}
		}
		//		for(int i =1;continuer&&!visionFeu;i++){
		//			switch(dir){
		//			case 'n':
		//				if(Agent.caractereImprimable(pos_x-i, pos_y) == "X"||pos_x-i<=0)
		//					continuer=false;
		//				else if(!Agent.caractereImprimable(pos_x-i, pos_y).equals(" ")){
		//					if(Agent.caractereImprimable(pos_x-i, pos_y) == "O"||Agent.caractereImprimable(pos_x-i, pos_y) == "o"){
		//						etatAlerte = true;
		//						visionFeu = true; 
		//						//si il voit du feu
		//					}else{
		//						if(etatAlerte&&robotASuivre == null){
		//							robotASuivre = (Robot) Agent.getAgentViaCoor(pos_x-i, pos_y);
		//							tourDetectionRobotASuivre=horloge;
		//						}
		//						continuer =false;
		//						return true;
		//					}
		//
		//				}
		//
		//
		//				break;
		//			case 'e':
		//				//System.out.println("________________________"+Agent.caractereImprimable(pos_x, pos_y+i)+"___"+pos_x+"____"+pos_y+"_____");
		//				if(Agent.caractereImprimable(pos_x, pos_y+i).equals("X")||pos_y+i>nc)
		//					continuer=false;
		//				else if(Agent.caractereImprimable(pos_x, pos_y+i) != " "&&Agent.caractereImprimable(pos_x, pos_y+i) != "X"){
		//					if(Agent.caractereImprimable(pos_x, pos_y+i) == "O"||Agent.caractereImprimable(pos_x, pos_y+i) == "o"){
		//						etatAlerte = true;
		//						visionFeu = true; 
		//						
		//						//si il voit du feu
		//					}else{
		//						if(etatAlerte&&robotASuivre == null){
		//							robotASuivre = (Robot) Agent.getAgentViaCoor(pos_x, pos_y+i);
		//							tourDetectionRobotASuivre=horloge;
		//						}
		//						continuer =false;
		//						return true;
		//					}
		//
		//				}
		//
		//
		//				//			System.out.println("_____________"+Agent.caractereImprimable(pos_x, pos_y+1));
		//				break;
		//			case 's':
		//				if(Agent.caractereImprimable(pos_x+i, pos_y) == "X"||pos_x+i>nl)
		//					continuer=false;
		//				else if(Agent.caractereImprimable(pos_x+i, pos_y) != " " ){
		//					if(Agent.caractereImprimable(pos_x+i, pos_y) == "O"||Agent.caractereImprimable(pos_x+i, pos_y) == "o"){
		//						etatAlerte = true;
		//						visionFeu = true; 
		//						
		//						//si il voit du feu
		//					}else{
		//						if(etatAlerte&&robotASuivre == null){
		//							robotASuivre = (Robot) Agent.getAgentViaCoor(pos_x+i, pos_y);
		//							tourDetectionRobotASuivre=horloge;
		//						}
		//						continuer =false;
		//						return true;
		//					}
		//
		//				}
		//
		//
		//				break;
		//			case 'o':
		//				if(Agent.caractereImprimable(pos_x, pos_y-i) == "X"||pos_y-i<=0)
		//					continuer=false;
		//				else if(Agent.caractereImprimable(pos_x, pos_y-i) != " " ){
		//					if(Agent.caractereImprimable(pos_x, pos_y-i) == "O"||Agent.caractereImprimable(pos_x, pos_y-i) == "o"){
		//						//si il voit du feu
		//						etatAlerte = true;
		//						visionFeu = true; 
		//					}else{						
		//						if(etatAlerte&&robotASuivre == null){
		//							robotASuivre = (Robot) Agent.getAgentViaCoor(pos_x-i, pos_y);
		//							tourDetectionRobotASuivre=horloge;
		//					}
		//						continuer =false;
		//						return true;
		//					}
		//
		//				}
		//
		//
		//				break; 
		//			}
		//		}

	}
	private Coordonnee getProchaineCoordonne(){
		
		switch(dir){
		case 'n':
			return new Coordonnee(pos_x-1,pos_y);
		case 'e':
			return new Coordonnee(pos_x,pos_y+1);
		case 's':
			return new Coordonnee(pos_x+1,pos_y);
		case 'o':
			return new Coordonnee(pos_x,pos_y-1); 
		default:
			return new Coordonnee(pos_x,pos_y); 
		}
	}
	public boolean avancer(){
		switch(dir){
		case 'n':
			if(pos_x-1>0&&Agent.caractereImprimable(pos_x-1, pos_y) == " "){

				pos_x--;
				prevenirDeplacement(new Coordonnee(pos_x,pos_y));				
				return true;
			}
			break;
		case 'e':
			if(pos_y+1<nc&&Agent.caractereImprimable(pos_x, pos_y+1) == " "){

				pos_y++;
				prevenirDeplacement(new Coordonnee(pos_x,pos_y));
				return true;
			}
			//			System.out.println("_____________"+Agent.caractereImprimable(pos_x, pos_y+1));
			break;
		case 's':
			if(pos_x+1<nl&&Agent.caractereImprimable(pos_x+1, pos_y) == " "){
				pos_x++;
				prevenirDeplacement(new Coordonnee(pos_x,pos_y));
				return true;
			}
			break;
		case 'o':
			if(pos_y-1>0&&Agent.caractereImprimable(pos_x, pos_y-1) == " "){
				pos_y--;
				prevenirDeplacement(new Coordonnee(pos_x,pos_y));
				return true;
			}
			break; 
		}
		return false;
	}

	public void prevenirDeplacement(Coordonnee coor){
		if(etatAlerte){
			for(int i = 0; i<Agent.getLA().size();i++){
				Agent ag = (Agent) Agent.getLA().get(i);
				if(ag instanceof Robot && ((Robot)ag).robotASuivre == this){
					((Robot)ag).chemin.add(coor);
				}
			}
		}
	}
	//public boolean VoitUnAutreRobot(){
	//	for(int )
	//}
	public static char randomDir(){
		return tableauDirection[(int)(Math.random() * ((tableauDirection.length-1)+1))]; 
	}
	public void changerDir(){

		if(robotASuivre==null){
			char ProchaineDir=dir;
			while(ProchaineDir == dir){
				ProchaineDir = tableauDirection[(int)(Math.random() * ((tableauDirection.length-1)+1))];
			}
			dir = ProchaineDir;

		dir = randomDir();


		
		}
		else
			if(this.getProchaineCoordonne().equals(new Coordonnee(pos_x-1,pos_y)))
				dir ='n';
			else if(this.getProchaineCoordonne().equals(new Coordonnee(pos_x,pos_y+1)))
				dir ='e';
			else if(this.getProchaineCoordonne().equals(new Coordonnee(pos_x+1,pos_y)))
				dir ='s';
			else if(this.getProchaineCoordonne().equals(new Coordonnee(pos_x,pos_y-1)))
				dir ='o';
	}
}