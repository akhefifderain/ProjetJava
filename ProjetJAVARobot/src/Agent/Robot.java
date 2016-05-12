package Agent;
public class Robot extends Agent{
	char etat;
	char dir;
	void cycle(){
	}
	public Robot(int i,int j,char dir,String n){
		pos_x=i;pos_y=j;
		this.dir=dir;
		aff=n;
		getLA().add(this);
	}
}