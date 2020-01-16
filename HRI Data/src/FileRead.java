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
			file = new FileReader(fileName);
			sc = new Scanner(file);
			String header = sc.nextLine();
			header = header.substring(header.indexOf(": ") + 2, header.length());
			System.out.println("HEADER: " + header);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
			}
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return experiment;
				

	}
}