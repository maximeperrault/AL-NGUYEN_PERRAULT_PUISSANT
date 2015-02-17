package LogEsiea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteLog {
	
	public void write(char lvl, String msg) {
		File dir = new File("Log");
		if(!dir.exists())
			dir.mkdir();
		
		switch(lvl){
		case 't': //terminal
			System.out.println(msg);
			break;
		case 'f': //fichier simple
			try {
				File f = new File(System.getProperty("user.dir")+"/Log/log.txt");
				
				if(!f.exists()){
					f.createNewFile();
					FileWriter fw = new FileWriter(f.getAbsoluteFile(), true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("0\r\n");
					bw.close();
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
				File f = new File(System.getProperty("user.dir")+"/Log/logRot_0.txt");
				File ff = filerot(f, 0);
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
	
	
	private File filerot(File f, int i){
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
				BufferedReader br = new BufferedReader(new FileReader(f.getAbsoluteFile()));
				file = br.readLine();
				int i1 = Character.getNumericValue(file.charAt(0));
				i1++;
				return filerot(new File(System.getProperty("user.dir")+"/Log/logRot_"+i1+".txt"), i1);
			}else{
				return f;
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		return f;
	}
}
