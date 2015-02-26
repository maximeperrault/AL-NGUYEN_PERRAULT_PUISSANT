package LogEsiea;

enum Levels {

	d ("Debug"), i ("Info"), e ("Error"), w ("WTF");
	
	private String lvl = "";

	Levels(String lvl){
	  this.lvl = lvl;
	}
	
	public String toString(){
	  return lvl;
	}
}