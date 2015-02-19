package LogEsiea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteLog {
	
	public void write(ArrayList<Character> destination, String msg, String path) {
		File dir = new File("Log");
		if(!dir.exists())
			dir.mkdir();
		
		if(destination.size() == 0){
			System.out.println(msg);
		}else{
			for(int index = 0; index < destination.size(); index++){
				switch(destination.get(index)){
				case 't': //terminal
					System.out.println(msg);
					break;
				case 'f': //fichier simple
					try {
						File f = new File(System.getProperty("user.dir")+path+"/log.txt");
						
						if(!f.exists()){
							f.createNewFile();
						}
						FileWriter fw = new FileWriter(f.getAbsoluteFile(), true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(msg+"\r\n");
						bw.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 'r': //fichier rotatif
					try{
						File f = new File(System.getProperty("user.dir")+path+"/logRot_0.txt");
						File ff = filerot(f, 0, path);
						FileWriter fw = new FileWriter(ff.getAbsoluteFile(), true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(msg+"\r\n");
						bw.close();
					}catch(IOException e){
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	
	
	private File filerot(File f, int i, String path){
		try{
			if(!f.exists()){
				f.createNewFile();
				FileWriter fw = new FileWriter(f.getAbsoluteFile(), true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(i+"\r\n");
				bw.close();
				return f;
			}
			double bytes = f.length();
			if(bytes > 52428800){
				String file;
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(new FileReader(f.getAbsoluteFile()));
				file = br.readLine();
				int i1 = Character.getNumericValue(file.charAt(0));
				i1++;
				return filerot(new File(System.getProperty("user.dir")+path+"/logRot_"+i1+".txt"), i1, path);
			}else{
				return f;
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		return f;
	}
}
