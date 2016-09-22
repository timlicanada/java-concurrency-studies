package RRScheduler;

import java.io.*;//imported for ioexception and bufferedreader

/**RRScheduler class
 * @author TLI
 * According to LTSA setup, this class combines all parts of the RRScheduler, 
 * Therefore, there are no logical components besides order of class creation and prompts for input (for ease of testing)
 */
public class RRScheduler {
	//main method runs entire program by creation of all parts of RRScheduler
	public static void main (String args[ ]) throws IOException{
		int processCount, quantum;//input variables
		final int queueLimit = 5;//limit of queue is set of 5 right here
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//two user prompts, for number of processes to be generated and quantum to be set
		while(true){
			System.out.print("Enter number of processes to be generated:");
			input = br.readLine();
			processCount = Integer.parseInt(input);
			if(processCount < queueLimit | processCount >=0){
				System.out.println("Process number accepted.");
				break;
			}
			else{
				System.out.println("Process number entered will cause overflow/underflow error");
			}
			
		}
		
		
		
		System.out.print("Enter quantum in seconds:");
		input = br.readLine();
		quantum = Integer.parseInt(input)*1000;//convert to milliseconds
		
		Generator generator = new Generator(processCount);//create generator, give number of processes to generate
		ReadyQueue queue = new ReadyQueue(generator.processSet,queueLimit);//create queue, give processes generated and count		
		GrimReaper grimreaper = new GrimReaper();//create grim reaper
		CPU cpu = new CPU(grimreaper,quantum);//create CPU, take grim reaper to kill tasks, give quantum number
		Dispatcher dispatcher = new Dispatcher(queue, cpu,processCount);//create dispatcher, bring in queue of processes and cpu to give processes
	}
}
