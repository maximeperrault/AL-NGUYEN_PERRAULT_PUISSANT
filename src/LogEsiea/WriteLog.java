package LogEsiea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteLog {

	public void write(char lvl, String msg) {
		switch(lvl){
		case 't':
			System.out.println(msg);
			break;
		case 'f':
			try {
				File f = new File(System.getProperty("user.dir"));
				if(!f.exists())
					f.createNewFile();
				
				FileWriter fw = new FileWriter(f.getAbsoluteFile()+"/log.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(msg);
				bw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 'r':
			break;
		}
	}
}
