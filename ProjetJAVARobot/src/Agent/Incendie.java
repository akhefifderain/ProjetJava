package Agent;

public class Incendie extends Agent{
	double vitessePropagation;
	int vitesseIntensite = 10;
	public Incendie(){
		horloge=0;
		aff ="o";
		System.out.println(pos_x +"   "+ pos_y);
		this.pos_x = -1;
		this.pos_y = -1;
		vitessePropagation = 0.2;
		while (this.pos_x == -1 && this.pos_y == -1){
			int x = (int)(Math.random() * ((nc-1) + 1))+1;
			int y = (int)(Math.random() * ((nl-1) + 1))+1;
			System.out.println(x +"  "+y+"______________"+caractereImprimable(2,1));
				if(caractereImprimable(x,y)=="X") {
					pos_x = x;
					pos_y = y;
				}
				
		}
		getLA().add(this);
	}
	public Incendie(int x,int y){
		aff ="o";
		if(caractereImprimable(x,y)=="X") {
			pos_x = x;
			pos_y = y;
		}			
		getLA().add(this);
	}
	public Incendie(double v){
		this();
		vitessePropagation=v;
	}
	public Incendie(int x,int y,double v){
		this(x,y);
		vitessePropagation=v;
	}
	
	@Override
	void cycle() {
		//System.out.println(horloge +">="+vitesseIntensite +"  "+ (horloge>=vitesseIntensite));
		if(horloge>=vitesseIntensite*3){
			
			//for(int i = 0; i < getLA().size();i++)
				//if(((Agent)(getLA().get(i))).pos_x == this.pos_x&&((Agent)(getLA().get(i))).pos_y == this.pos_y)
			getLA().remove(this);
			getLA().add(new Carrefour(pos_x,pos_y,'v',1));
		}
		else if(horloge>=vitesseIntensite){
			//System.out.println(horloge +">="+vitesseIntensite);
			aff="O";
			propager();
		}
		if(Agent.extinctionIncendie){
			horloge-=2;
			if(horloge <=0)
				Agent.getLA().remove(this);
		}
		else
			horloge++;
		// TODO Auto-generated method stub
		
	}
	private void propager() {
		
		if(caractereImprimable(pos_x+1,pos_y)=="X")
			if((Math.random() * ((1)))<vitessePropagation)
				getLA().add(new Incendie(pos_x+1,pos_y,vitessePropagation));
		if(caractereImprimable(pos_x-1,pos_y)=="X")
			if((Math.random() * ((1)))<vitessePropagation)
				getLA().add(new Incendie(pos_x-1,pos_y,vitessePropagation));
		if(caractereImprimable(pos_x,pos_y+1)=="X")
			if((Math.random() * ((1)))<vitessePropagation)
				getLA().add(new Incendie(pos_x,pos_y+1,vitessePropagation));
		if(caractereImprimable(pos_x,pos_y-1)=="X")
			if((Math.random() * ((1)))<vitessePropagation)
				getLA().add(new Incendie(pos_x,pos_y-1,vitessePropagation));
	}

}
