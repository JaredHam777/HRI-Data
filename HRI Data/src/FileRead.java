import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class FileRead {
	public static String pathTemplate = "Data/HRI-01-003_<ID>_<LS>.txt";

	
	public static Experiment fetchExperimentFromFile(int ID) {
		String fileName = pathTemplate;
		fileName = fileName.replace("<ID>", Integer.toString(ID));
		fileName = fileName.replace("<LS>", Integer.toString(ID%4));
		System.out.println("file name: " + fileName);
	
		
		Experiment experiment = new Experiment(ID%4);
		FileReader file;
		Scanner sc;
		try {
			int iterationNum = 0;
			int trialNum = 0;
			
			
			
			file = new FileReader(fileName);
			sc = new Scanner(file);
			String header = sc.nextLine();
			header = header.substring(header.indexOf(": ") + 2, header.length());
			System.out.println("HEADER: " + header);
			
			experiment.LS = Main.LSDictionary.get(header);
			
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				if(line.length()>0) {	//if line is not blank
					if(line.contains("Iteration"))	{
						iterationNum = Integer.parseInt(line.substring(line.indexOf("Iteration")+10, 1));
						int correctObj = Integer.parseInt(line.substring(line.indexOf("obj: ") + 5, 1));
						line = sc.nextLine();
						int tappedObj = Integer.parseInt(line.substring(line.indexOf("obj") + 3, 1));
						double time = Double.parseDouble(line.substring(line.indexOf("time ") + 5, line.length()));
						
						Iteration it = new Iteration();
						it.time = time;
						it.correctObj = correctObj;
						if(tappedObj==correctObj) {
							it.userCorrect = true;
						}	else	{
							it.userCorrect = false;
						}
						
						experiment.trials[trialNum].iterations[iterationNum] = it;
						
						
					}	else if(line.contains("Trial "))	{
						trialNum = Integer.parseInt(line.substring(line.indexOf("Trial")+6, 1));
					}
					
				}
			}
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return experiment;
				

	}
}