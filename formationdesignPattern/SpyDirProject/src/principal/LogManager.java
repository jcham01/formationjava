package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

public class LogManager {

	private File log;
	
	public LogManager(String logName) {
		log = new File(logName);
	}
	
	public synchronized void writeLine(String line) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(log);
			pw.println(new Date() + " : " + line);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
