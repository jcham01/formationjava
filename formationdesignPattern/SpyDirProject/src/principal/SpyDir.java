package principal;
import java.io.*;
import java.util.Arrays;


public class SpyDir implements Runnable
{
	private File repertoire;
	private String[] fileNames;
	private boolean mustStop;
	private LogManager logManager;
	
	public void setMustStop(boolean mustStop) {this.mustStop = mustStop;}

	public SpyDir(String nomRep, LogManager logManager)
	{
		repertoire = new File(nomRep);
		fileNames = listeContenu();
		mustStop = false;
		this.logManager = logManager;
	}
	
	private String[] listeContenu()
	{
		return repertoire.list();
	}
	
	@Override
	public void run() {
		
		while(!mustStop)
		{
			String[] newFileNames = listeContenu();
			for (String fname : newFileNames)
			{
				boolean found = false;
				for (String oldFname : fileNames)
				{
					if (fname.equals(oldFname))
					{
						found = true;
						break;
					}
				}
				if (!found)
				{
					logManager.writeLine("nouveau fichier! dans " + repertoire.getName()
								+ " -> " + fname);
				}
			}

			for (String fname : fileNames)
			{
				boolean found = false;
				for (String newFname : newFileNames)
				{
					if (fname.equals(newFname))
					{
						found = true;
						break;
					}
				}
				if (!found)
				{
					logManager.writeLine("fichier supprimé! dans " + repertoire.getName()
								+ " -> " + fname);
				}
			}
			fileNames = newFileNames;
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
