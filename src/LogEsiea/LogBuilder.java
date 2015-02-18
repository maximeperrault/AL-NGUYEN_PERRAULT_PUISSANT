/**
 * 
 */
package LogEsiea;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Antoine
 * Building the log string before writing it where the user want it to
 */
class LogBuilder {

	public void LogginBuilder(DateFormat df, String loggingFrom, String msg, char destination, String lvl, int line, String path){
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
