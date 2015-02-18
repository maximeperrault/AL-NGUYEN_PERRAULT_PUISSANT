package LogEsiea;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LogEsiea {

	private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private final String loggingFrom;
	private char destination = 't';
	private int lvl = 0;
	private LogBuilder lb = new LogBuilder();
	private String path = "/Log";
	
	
	public LogEsiea() {
		PropertiesLoader prop = new PropertiesLoader();
		try {
			prop.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(prop.getLvl() != 0)
			setLevel(Levels.values()[prop.getLvl()].toString().toLowerCase().charAt(0));
		
		if(prop.getDestination() != 'a')
			this.setDestination(prop.getDestination());
		
		if(prop.getPath() != null)
			this.setPath(prop.getPath());
		
		StackTraceElement [] s = new RuntimeException().getStackTrace();
		this.loggingFrom = "("+s[1].getClassName()+")";
	}
	
	public void error(String msg){
		if(this.lvl <= Levels.valueOf("e").ordinal()){
			StackTraceElement [] s = new RuntimeException().getStackTrace();
			lb.LogginBuilder(this.df, this.loggingFrom, msg, this.destination, "e", s[1].getLineNumber(), path);
		}
	}
	
	public void debug(String msg){
		if(this.lvl <= Levels.valueOf("d").ordinal()){
			StackTraceElement [] s = new RuntimeException().getStackTrace();
			lb.LogginBuilder(this.df, this.loggingFrom, msg, this.destination, "d", s[1].getLineNumber(), path);
		}
	}
	
	public void info(String msg){
		if(this.lvl <= Levels.valueOf("i").ordinal()){
			StackTraceElement [] s = new RuntimeException().getStackTrace();
			lb.LogginBuilder(this.df, this.loggingFrom, msg, this.destination, "i", s[1].getLineNumber(), path);
		}
	}
	
	public void wtf(String msg){
		if(this.lvl <= Levels.valueOf("w").ordinal()){
			StackTraceElement [] s = new RuntimeException().getStackTrace();
			lb.LogginBuilder(this.df, this.loggingFrom, msg, this.destination, "w", s[1].getLineNumber(), path);
		}
	}

	public void setDestination(char c) { //Destination as console, file or rotative files
		switch(c){
		case 't':
			this.destination = c;
			break;
		case 'f':
			this.destination = c;
			break;
		case 'r':
			this.destination = c;
			break;
		default:
			this.destination = 't';
		}		
	}

	public void setLevel(char lvl) { //logs filter
		switch(lvl){
		case 'd':
			this.lvl = 0;
			break;
		case 'i':
			this.lvl = 1;
			break;
		case 'e':
			this.lvl = 2;
			break;
		default:
			this.lvl = 0;
			break;
		}
	}
	public void setPath(String path){ //Define the logs folder NOT THE FILE(S)
		this.path = "/"+path;
	}
}
