import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static final int NUM_FILES = 7;

	public static Map<String, Integer> LSDictionary;
	
	public static void main(String[] args) {
		LSDictionary = new HashMap<String, Integer>();
		LSDictionary.put("ACRFRCAF", 0);
		LSDictionary.put("AFACRFRC", 1);
		LSDictionary.put("RCAFACRF", 2);
		LSDictionary.put("RFRCAFAC", 3);

		FileRead.fetchExperimentFromFile(0);
		
		
	}

}
