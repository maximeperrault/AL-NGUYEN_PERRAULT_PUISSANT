package LogEsiea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class PropertiesLoader {
	private String lvl;
	private ArrayList<String> destination = new ArrayList<>();
	private String path;
	
	public Properties load () throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		
		FileInputStream input = new FileInputStream("AL.properties");
		properties.load(input);
		
		if(properties.getProperty("logger.LogEsiea.level") != null)
			this.lvl = properties.getProperty("logger.LogEsiea.level");
		
		if(properties.getProperty("logger.LogEsiea.setDestination") != null)
				this.destination.add(properties.getProperty("logger.LogEsiea.setDestination"));
		
		for(int i = 1; i < 3; i++){
			if(properties.getProperty("logger.LogEsiea.addDestination"+i) != null)
				this.destination.add(properties.getProperty("logger.LogEsiea.addDestination"+i));
		}
		
		if(properties.getProperty("logger.LogEsiea.destination.path") != null)
			this.path = properties.getProperty("logger.LogEsiea.destination.path");
		
		input.close();
		
		return properties;
	}
	
	public int getLvl(){
		if(this.lvl == null)
			return(0);
		
		return(Integer.parseInt(this.lvl));
	}
	
	public ArrayList<Character> getDestination(){
		ArrayList<Character> c = new ArrayList<>();
		
		if(this.destination.size() == 0)
			return(null);
		
		for(int i = 0; i < this.destination.size(); i++)
			c.add(i, this.destination.get(i).charAt(0));
		
		return(c);
	}
	
	public String getPath(){	
		return(this.path);
	}
}