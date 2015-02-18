package LogEsiea;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEsiea {

	private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private final String loggingFrom;
	private char destination = 't';
	private int lvl = 0;
	private LogBuilder lb = new LogBuilder();
	
	
	public LogEsiea() {
		StackTraceElement [] s = new RuntimeException().getStackTrace();
		this.loggingFrom = "("+s[1].getClassName()+")";
	}
	
	public void error(String msg){
		if(this.lvl <= Levels.valueOf("e").ordinal()){
			StackTraceElement [] s = new RuntimeException().getStackTrace();
			lb.LogginBuilder(this.df, this.loggingFrom, msg, this.destination, "e", s[1].getLineNumber());
		}
	}
	
	public void debug(String msg){
		if(this.lvl <= Levels.valueOf("d").ordinal()){
			StackTraceElement [] s = new RuntimeException().getStackTrace();
			lb.LogginBuilder(this.df, this.loggingFrom, msg, this.destination, "d", s[1].getLineNumber());
		}
	}
	
	public void info(String msg){
		if(this.lvl <= Levels.valueOf("i").ordinal()){
			StackTraceElement [] s = new RuntimeException().getStackTrace();
			lb.LogginBuilder(this.df, this.loggingFrom, msg, this.destination, "i", s[1].getLineNumber());
		}
	}
	
	public void wtf(String msg){
		if(this.lvl <= Levels.valueOf("w").ordinal()){
			StackTraceElement [] s = new RuntimeException().getStackTrace();
			lb.LogginBuilder(this.df, this.loggingFrom, msg, this.destination, "w", s[1].getLineNumber());
		}
	}

	public void setDestination(char c) {
		this.destination = c;		
	}

	public void setLevel(char lvl) {
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
}
