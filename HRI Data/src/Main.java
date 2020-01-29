import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static final int NUM_FILES = 14;

	public static Map<String, Integer> LSDictionary;
	
	public static void main(String[] args) {
		LSDictionary = new HashMap<String, Integer>();
		LSDictionary.put("ACRFRCAF", 0);
		LSDictionary.put("AFACRFRC", 1);
		LSDictionary.put("RCAFACRF", 2);
		LSDictionary.put("RFRCAFAC", 3);
		
		ArrayList<Experiment> experimentData = new ArrayList<Experiment>();

		for(int i=0; i<NUM_FILES; i++)	{
			experimentData.add(FileRead.fetchExperimentFromFile(i));
			//experimentData.get(experimentData.size()-1).printDetails();
		}
		
		
		//find accurracy of arm vs arrow:
		
		double avgArmTime=0;
		double avgArrowTime=0;
		
		double avgArmSuccess=0;
		double avgArrowSuccess=0;
		
		for(Experiment exp : experimentData)	{
			
			for(Trial trial : exp.trials) {
				//Must call this function:
				trial.calculateMetrics();
				//
				
				
				if(trial.condition == Condition.AC || trial.condition == Condition.AF)	{
					avgArmTime += trial.avgTime;
					avgArmSuccess += trial.percentCorrect;
				}	else	{
					avgArrowTime += trial.avgTime;
					avgArrowSuccess += trial.percentCorrect;
				}
			}
			
			
		}
		System.out.println("test: " + avgArmSuccess);

		avgArmTime *= 1.0/(2*experimentData.size());
		avgArmSuccess *= 1.0/(2*experimentData.size());
		avgArrowTime *= 1.0/(2*experimentData.size());
		avgArrowSuccess *= 1.0/(2*experimentData.size());
		
		System.out.println("avg arm time: " + avgArmTime);
		System.out.println("avg arrow time: " + avgArrowTime);
		System.out.println("avg arm success rate: " + avgArmSuccess);
		System.out.println("avg arrow success rate: " + avgArrowSuccess);

		
		
	}

}
