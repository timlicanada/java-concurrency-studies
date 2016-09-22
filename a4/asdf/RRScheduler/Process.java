package RRScheduler;


/** Process class
 * @author TLI
 * The template for a process thread, it has a unique ID number (starting from 0), a boolean stopFlag that is true
 * if the Process is inactive, and a time in milliseconds representing remaining runtime for CPU.
 */
public class Process extends Thread {
	//Main method creates the threads to run https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html

	public boolean stopFlag = false;//represents active process with this boolean
	public int time=0;//time in milliseconds of runtime remaining
	public int id =0;//unique ID
	
	// Process constructor takes a randomized time remaining (timeGiven) and a set ID (idGiven)
	public Process(int timeGiven, int idGiven){
		time=timeGiven*1000;//turn into milliseconds
		id= idGiven;
	}
	
	//run method simulates runtime by sleeping for a given runtime
	public void run(int runtime) {
		// TODO Auto-generated method stub
		try {
			sleep(runtime);//sleep for a given runtime duration
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\t\tDone above operation (on Process "+id+")");
	}
	
	//stopProcess method is used to indicate Process is finished, it does this by setting stopFlag to true
	public void stopProcess(){
		stopFlag = true;
	}
}
