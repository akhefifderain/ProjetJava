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
		this(i,j,t,f);
		larg=l;haut=h;
		
	}
	public static void init(){
		Carrefour c,cc;
		
		int s = getLA().size();
		for(int i=0;i<s;i++){
			if(getLA().get(i) instanceof Carrefour){
				
				c=(Carrefour)getLA().get(i);
				if(c.type=='v'){//cas d'un carrefour 4 voies
					System.out.println(c.fin+c.larg);
					for(int k=c.pos_x;k<=nc && k<=c.fin+c.larg;k++){
						for(int j=0;j<c.haut;j++){
							cc=new Carrefour(c.pos_x+j,k,'v',1);
							cc.voie=true;
						}
					}
					for(int k=c.pos_x-1;k>0&& k>=c.fin;k--){
						for(int j=0;j<c.haut;j++){
							cc=new Carrefour(c.pos_x+j,k,'v',1);
							cc.voie=true;
						}
					}
					for(int k=c.pos_y;k<=nl && k <= c.fin+c.haut;k++){
						for(int j=0;j<c.larg;j++){
							cc=new Carrefour(k,c.pos_y+j,'v',1);
							cc.voie=true;
						}
					}
					for(int k=c.pos_y-1;k>0&& k>=c.fin;k--){
						for(int j=0;j<c.larg;j++){
							cc=new Carrefour(k,c.pos_y+j,'v',1);
							cc.voie=true;
						}
					}
				}
			}
		}
	}

}
	