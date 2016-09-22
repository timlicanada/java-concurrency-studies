package RRScheduler;

import java.util.Random;


/**Generator class
 * @author TLI
 * Uses the process count entered by the user and generates that number of Process class instances
 * It then returns it all in a Process array.
 */
public class Generator {
	int Low = 1;  //Shortest possible runtime in seconds
	int High = 8;  //Highest possible runtime in seconds
	Random r = new Random();
	public int processCounter; // indicates the id number
	public int R;//random operation time
	Process[] processSet;
	
	//given process count, set up an array of Process count with that size
	public Generator(int processCount){
		processCounter=0; 
		processSet = new Process[processCount];
		processSet = setCreate(processCount);//use setCreate method below to fill Process array
	}
	
	//actually create one Process instance with unique ID (from processCounter) and randomized runtime
	public Process createProcess(){ 
		processCounter++;
		R = r.nextInt(High) + Low;//random formula for Java
		System.out.println("Process ID "+processCounter+" has execution time of "+R);
		Process itemProcess = new Process(R,processCounter);
		return itemProcess;
	}
	
	//uses CreateProcess method to create a Process array given the size as parameter (orderCount)
	public Process[] setCreate(int orderCount){
		Process[] processSet = new Process[orderCount];
		for (int i=0; i<orderCount;i++){
			processSet[i]= createProcess();//uses createProcess method above for each individual Process
		}
		return processSet;
	}

}
