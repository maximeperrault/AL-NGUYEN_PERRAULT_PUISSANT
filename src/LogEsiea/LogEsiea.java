package LogEsiea;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEsiea {

	private String level;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private final String loggingFrom;
	
	public LogEsiea() {
		StackTraceElement [] s = new RuntimeException().getStackTrace();
		this.loggingFrom = "("+s[1].getClassName()+")";
	}
	
	public void error(String msg){
		Date d = new Date();
		StackTraceElement [] s = new RuntimeException().getStackTrace();
		
		StringBuilder sb = new StringBuilder();
		sb.append(df.format(d));
		sb.append(" [CLASS=");
		sb.append(loggingFrom+":");
		sb.append(s[1].getLineNumber());
		sb.append(" LEVEL=");
		sb.append(Levels.valueOf("e"));
		sb.append(" MESSAGE= ");
		sb.append(msg);
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	public void debug(String msg){
		Date d = new Date();
		StackTraceElement [] s = new RuntimeException().getStackTrace();
		
		StringBuilder sb = new StringBuilder();
		sb.append(df.format(d));
		sb.append(" [CLASS=");
		sb.append(loggingFrom+":");
		sb.append(s[1].getLineNumber());
		sb.append(" LEVEL=");
		sb.append(Levels.valueOf("d"));
		sb.append(" MESSAGE= ");
		sb.append(msg);
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	public void info(String msg){
		Date d = new Date();
		StackTraceElement [] s = new RuntimeException().getStackTrace();
		
		StringBuilder sb = new StringBuilder();
		sb.append(df.format(d));
		sb.append(" [CLASS=");
		sb.append(loggingFrom+":");
		sb.append(s[1].getLineNumber());
		sb.append(" LEVEL=");
		sb.append(Levels.valueOf("i"));
		sb.append(" MESSAGE= ");
		sb.append(msg);
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	public void wtf(String msg){
		Date d = new Date();
		StackTraceElement [] s = new RuntimeException().getStackTrace();
		
		StringBuilder sb = new StringBuilder();
		sb.append(df.format(d));
		sb.append(" [CLASS=");
		sb.append(loggingFrom+":");
		sb.append(s[1].getLineNumber());
		sb.append(" LEVEL=");
		sb.append(Levels.valueOf("w"));
		sb.append(" MESSAGE= ");
		sb.append(msg);
		sb.append("]");
		System.out.println(sb.toString());
	}
}
