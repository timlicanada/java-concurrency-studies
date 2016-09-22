package concurrency.diners;

import java.awt.*;

class Fork {

  private boolean taken=false;
  private PhilCanvas display;
  private int identity;

  Fork(PhilCanvas disp, int id)
    { display = disp; identity = id;}

  synchronized void put() {
    taken=false;
    display.setFork(identity,taken);
    notify();
  }

  synchronized boolean get() throws java.lang.InterruptedException {//this method is now boolean
	    if (taken) { 
	     wait(1000); //if taken, wait 1 second
	    }
	    
	    if (!taken){ //after wait, check for taken fork
	    	taken=true;
	    	display.setFork(identity,taken);
	    	return taken;//took a fork, return true
	    }else{
	    	taken=false;
	    	display.setFork(identity,taken);
	    	return taken;  //still taken, return false 

	  }
	}
}
