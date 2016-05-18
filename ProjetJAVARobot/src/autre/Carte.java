package autre;

import Agent.Agent;
import Agent.Robot;

public class Carte {

	int hauteur;
	int largeur;
	String carte[][];
	
	public Carte(int h,int l, int nb_r){
		if(nb_r>26){
			throw new Error("Trop de robooot");
		}
		hauteur=h;
		largeur=l;
		/**/
		init();
		/*Compteur a 65 pour que les robots se voit attribuer un nom de A à Z*/
		int compteur=65;
		while(compteur<(nb_r+65)){
			placementAgent(new Robot(Character.toString((char)compteur)));
			compteur++;
		}
		
		
	}
	
	
	/*Remplis la carte de papier*/
	private void init(){
		carte = new String[hauteur][largeur];
		for(int i=0;i<hauteur;i++){
			for(int j=0;j<largeur;j++){
				carte[i][j]=".";
			}
		}
	}
	private void placementAgent(Agent a){
		a.setX((int)(Math.random() * (hauteur)));
		a.setY((int)(Math.random() * (largeur)));
		System.out.println(a.getX()+"_"+a.getY());
		/*On check qu'il y a pas de robot*/
		if(this.carte[a.getX()][a.getY()]=="."){
			this.carte[a.getX()][a.getY()]=a.aff;
		}else{
			placementAgent(a);
		}
		
	}
	public String toString(){
		String s="La carte est de "+this.hauteur+"x"+this.largeur+".\n\n\n\n\n";
		for(int i=0;i<hauteur;i++){
			for(int j=0;j<largeur;j++){
				s+=carte[i][j];
			}
			s+="\n";
		}
		return s;
	}
	
}
