package LogEsiea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
	private String lvl;
	private String destination;
	private String path;
	
	public Properties load () throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		
		FileInputStream input = new FileInputStream("src/LogEsiea/AL.properties");
		properties.load(input);
		
		this.lvl = properties.getProperty("logger.LogEsiea.level");
		this.destination = properties.getProperty("logger.LogEsiea.destination");
		this.path = properties.getProperty("logger.LogEsiea.destination.path");
		
		input.close();
		
		return properties;
	}
	
	public int getLvl(){
		if(this.lvl == null)
			return(0);
		
		return(Integer.parseInt(this.lvl));
	}
	
	public char getDestination(){
		if(this.destination == null)
			return('a');
		
		return(this.destination.charAt(0));
	}
	
	public String getPath(){	
		return(this.path);
	}
}