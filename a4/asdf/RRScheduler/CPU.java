package RRScheduler;

/**CPU class
 * @author TLI
 * Class takes in a Process object, and either runs for a quantum time before returning to queue,
 * or finishes runtime if below quantum time and gives to GrimReaper for destruction.
 */
public class CPU {
	final int QUANTUM; //in milliseconds
	GrimReaper grimreaper;
	//constructor takes in GrimReaper and a quantum time to be set
	public CPU(GrimReaper grimreaper, int quantum){
		QUANTUM = quantum;
		this.grimreaper = grimreaper;//takes in GrimReaper
	}
	
	public Process throwProcess(Process activeProcess) {//throws in object of process
		if (activeProcess.time>QUANTUM){
			//simulate work for quantum seconds, return to queue
			System.out.println("\tRunning for Quantum time of "+QUANTUM/1000+ " seconds, then return to Queue...");
			activeProcess.run(activeProcess.time);
			activeProcess.time = activeProcess.time - QUANTUM;//subtract quantum from total time
			return activeProcess;
		}
		else{
			//simulate work for duration for time, give to grim reaper 
			System.out.println("\tRunning for "+(activeProcess.time/1000) +" seconds then give to GrimReaper...");
			activeProcess.run(QUANTUM);
			grimreaper.endThread(activeProcess);//kill thread using GrimReaper
			return null;//return null as a flag for destroyed process to Dispatcher
		}
	}

}
