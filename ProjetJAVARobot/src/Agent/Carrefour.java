package Agent;
public class Carrefour extends Agent{
	int larg;
	int haut;
	int fin;
	char type;
	boolean voie;
	void cycle(){}
	public Carrefour(int i,int j,char t,int f){
		aff=" ";
		pos_x=i;pos_y=j;
		larg=1;haut=1;
		type=t;
		fin=f;
		voie=false;
		getLA().add(this);
	}
	public Carrefour(int i,int j,char t,int f, int l, int h){
		aff=" ";
		pos_x=i;pos_y=j;
		larg=l;haut=h;
		type=t;
		fin=f;
		voie=false;
		getLA().add(this);
	}
	public static void init(){
		Carrefour c,cc;
		int s = getLA().size();
		for(int i=0;i<s;i++){
			if(getLA().get(i) instanceof Carrefour){
				c=(Carrefour)getLA().get(i);
				if(c.type=='v'){//cas d'un carrefour 4 voies
					for(int k=c.pos_x+c.larg;k<=nc;k++){
						cc=new Carrefour(c.pos_x,k,'v',0);cc.voie=true;
					}
					for(int k=c.pos_x-1;k>0;k--){
						cc=new Carrefour(c.pos_x,k,'v',0);cc.voie=true;
					}
					for(int k=c.pos_y+c.haut;k<=nl;k++){
						cc=new Carrefour(k,c.pos_y,'v',0);cc.voie=true;
					}
					for(int k=c.pos_y-1;k>0;k--){
						cc=new Carrefour(k,c.pos_y,'v',0);cc.voie=true;
					}
				}
			}
		}
	}
}
	