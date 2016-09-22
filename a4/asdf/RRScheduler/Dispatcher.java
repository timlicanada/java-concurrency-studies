package RRScheduler;

/**Dispatcher class
 * @author TLI
 * This class extracts Process from front of queue and puts it into CPU
 * It will continue to do so until the queue is empty.
 */
public class Dispatcher {
	Process extractedProcess;//this Process represents the one extracted from front of queue
	Process cycledProcess;//this Process represents one that has exceeded quantum time and will be returned to queue, is null if does not exist
	static int openQSpots;//available queue spots
	
	//constructor takes in queue and cpu objects for manipulation
	public Dispatcher(ReadyQueue queue,CPU cpu, int processCount){
		openQSpots = processCount-1;//subtract one for first iteration
		System.out.println("");//formatting line break
		while (queue.Threadholder.size() !=0){//check for anything still left in queue (LinkedList)
			extractedProcess = dequeue(queue);//dequeue method used to extract front of queue
			openQSpots++;//one more queue spot
			System.out.println("Process "+extractedProcess.id+" extracted from queue.");
			cycledProcess = cpu.throwProcess(extractedProcess);//uses Process returned from CPU throwProcess method to see if any runtime left
			if (cycledProcess != null){//if null, no runtime left
				if(openQSpots>0){
					queue.enqueue(cycledProcess);//if runtime left, enqueue Process again
				}
				else{
					System.out.println("Overflow/Underflow error");
					break;
				}
				openQSpots--;
			}
		}
		System.out.println("");//line break
		System.out.println("RRSCHEDULER COMPLETE");
	}
	
	//dequeue is a simple method that returns the Process being dequeued
	public Process dequeue(ReadyQueue target){
		Process topProcess = target.peek();//use LinkedList peek method to get Process before dequeue removes it from queue
		target.dequeue();
		return topProcess;
	}
	
}
