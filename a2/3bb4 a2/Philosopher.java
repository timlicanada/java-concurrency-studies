package concurrency.diners;

import java.awt.*;

class Philosopher extends Thread {
  private int identity;
  private PhilCanvas view;
  private Diners controller;
  private Fork left;
  private Fork right;
  boolean forkRight, forkLeft;
  
  Philosopher(Diners ctr, int id, Fork l, Fork r) {
    controller = ctr; view = ctr.display;
    identity = id; left = l; right = r;
  }

  public void run() {
    try {
      while (true) {//while loop heavily changed
        //thinking
        view.setPhil(identity,view.THINKING);
        sleep(controller.sleepTime());
        //hungry
        view.setPhil(identity,view.HUNGRY);
        forkRight = right.get();
        if (forkRight){//if right fork is taken, do GOTRIGHT view and sleep for 0.5 seconds
            view.setPhil(identity,view.GOTRIGHT);
            sleep(500);
        }
        else{//if right fork is not there, replace fork request
        	right.put();
        }
        forkLeft = left.get();//try getting left fork
        if (forkLeft && forkRight){//check again for both forks, do EATING view if true and eat for a time
            view.setPhil(identity,view.EATING);
            sleep(controller.eatTime());           
        }//otherwise, do nothing
        right.put();//return both forks
        left.put();
        
        
      }
    } catch (java.lang.InterruptedException e) {}
  }
}