import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static final int NUM_FILES = 7;

	public static Map<Integer, String> LSDictionary;
	
	public static void main(String[] args) {
		LSDictionary = new HashMap<Integer, String>();
		LSDictionary.put(0, "ACRFRCAF");
		LSDictionary.put(1, "AFACRFRC");
		LSDictionary.put(2, "RCAFACRF");
		LSDictionary.put(3, "RFRCAFAC");

		FileRead.fetchExperimentFromFile(0);
		
		
	}

}
