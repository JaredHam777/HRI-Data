
public class Experiment {
	public int LS;
	public String experimentStepOrder;
	
	public Trial[] trials;
	
	public Experiment(int LS) {
		this.LS = LS;
		trials = new Trial[4];
		
		
	}
	
	public void printDetails()	{
		
		for(int i=0; i<trials.length; i++)	{
			System.out.println("T" + i + ", " + trials[i].condition);
			for(int j=0; j<trials[i].iterations.length; j++)	{
				System.out.println("I" + j + ": " + trials[i].iterations[j].userCorrect + ", " + trials[i].iterations[j].time);
			}
			System.out.println();
		}
	}
}
