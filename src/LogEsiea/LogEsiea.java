package LogEsiea;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LogEsiea {

	private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private String loggingFrom;
	private ArrayList<Character> destination = new ArrayList<Character>();
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
		
		if(prop.getDestination() != null)
			this.destination = prop.getDestination();
		
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

	public void setDestination(char c){
		this.destination.clear();
		addDestination(c);
	}
	
	public void addDestination(char c){
		switch(c){
		case 't':
			if(!this.destination.contains(c))
				this.destination.add(c);
			break;
		case 'f':
			if(!this.destination.contains(c))
				this.destination.add(c);
			break;
		case 'r':
			if(!this.destination.contains(c))
				this.destination.add(c);
			break;
		default:
			if(!this.destination.contains('t'))
				this.destination.add('t');
			break;
		}
	}

	public void setLevel(char lvl) { // Logs filter
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
	public void setPath(String path){ // Define the logs folder, NOT THE FILE(S)
		this.path = "/"+path;
	}
}