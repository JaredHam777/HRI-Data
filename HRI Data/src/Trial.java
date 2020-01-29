import java.util.ArrayList;

public class Trial {
	
	
	public Condition condition;
	public Iteration[] iterations;
	
	
	public double percentCorrect;
	
	
	//computed metrics:
	
	public double avgTime;
	
	//constructor:
	public Trial() {
		iterations = new Iteration[10];
	}
	
	
	//computation functions:
	public void calculateMetrics()	{
		int sum = 0;
		for(Iteration it : iterations)	{
			if(it.userCorrect) {sum++;}
		}
		percentCorrect = sum/10.0;		
		sum = 0;
		
		for(Iteration it : iterations) {
			sum+=it.time;
		}
		avgTime = sum/10.0;
		sum=0;
	}
		

}
