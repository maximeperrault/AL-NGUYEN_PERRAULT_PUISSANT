package LogEsiea;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

// Building the log string before writing it where the user wants it to

class LogBuilder {

	public void LogginBuilder(DateFormat df, String loggingFrom, String msg, ArrayList<Character> destination, String lvl, int line, String path){
		Date d = new Date();
		
		StringBuilder sb = new StringBuilder();
		sb.append(df.format(d));
		sb.append(" [CLASS=");
		sb.append(loggingFrom+":");
		sb.append(line);
		sb.append(" LEVEL=");
		sb.append(Levels.valueOf(lvl));
		sb.append(" MESSAGE= ");
		sb.append(msg);
		sb.append("]");
		WriteLog w = new WriteLog();
		w.write(destination, sb.toString(), path);
	}	
}