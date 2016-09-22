package RRScheduler;

/**GrimReaper class
 * @author TLI
 *Very simple class that "kills" a thread by setting their boolean stopFlag to true, indicating
 *that a process is dead.
 */
public class GrimReaper {
	//endThread method takes thread to be killed, and does so
	public void endThread(Process killThread){
		killThread.stopFlag = true;//here's the set true
	}
}
