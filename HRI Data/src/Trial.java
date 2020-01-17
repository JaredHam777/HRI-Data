import java.util.ArrayList;

public class Trial {
	public enum type {ARM_FAR, ARM_CLOSE, ARROW_FAR, ARROW_CLOSE};
	public Iteration[] iterations;
	
	public double avgTime;
	public double percentCorrect;
	
	public Trial() {
		iterations = new Iteration[10];
	}

}
