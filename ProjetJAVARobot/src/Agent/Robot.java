package Agent;
public class Robot extends Agent{
	char etat;
	char dir;

	void cycle(){
		while(!avancer())
			changerDir();
	}
	public Robot(int i,int j,char dir,String n){
		pos_x=i;pos_y=j;
		this.dir=dir;
		horloge=0;
		aff=n;
		getLA().add(this);
	}
	public boolean avancer(){
		switch(dir){
		case 'n':
			if(pos_x-1>=0&&Agent.caractereImprimable(pos_x-1, pos_y) == " "){
				
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
			if(pos_y-1>=0&&Agent.caractereImprimable(pos_x, pos_y-1) == " "){
				pos_y--;
				return true;
			}
			break; 
		}
		return false;
	}

	public void changerDir(){
		dir = tableauDirection[(int)(Math.random() * ((tableauDirection.length-1)+1))];

	}
}