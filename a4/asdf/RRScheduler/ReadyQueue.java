package RRScheduler;

import java.util.LinkedList;

/**Queue class
 * @author TLI
 * Implements queue logic from ltsa diagram (enqueue and dequeue sequences)
 */
public class ReadyQueue{
	static LinkedList<Process> Threadholder = new LinkedList<Process>();//ThreadHolder represents queue structure
	
	//Queue constructor enqueues set of Process classes passed in, as well as process count for the forloop below
	public ReadyQueue(Process[] defaultSet, int queueLimit){
		for (int i =0; i<queueLimit;i++){
			enqueue(defaultSet[i]);//throw in processes based on set processCount
		}
	}
	
	//dequeue method pops Process class at front of queue (FIFO) and, in this case, off LinkedLIst
	public static void dequeue(){	
		Threadholder.pop();	
	}
	
	//enqueue method pushes onto queue (FIFO) by adding onto LinkedList
	public static void enqueue(Process k){
		Threadholder.add(k);
	}
	
	//peek method returns Process at the front of the queue
	public Process peek(){
		return Threadholder.peek();//peek method from LinkedList takes a look at the front of the queue
	}

}
