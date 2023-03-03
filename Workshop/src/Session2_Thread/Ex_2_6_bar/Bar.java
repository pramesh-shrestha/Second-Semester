package Session2_Thread.Ex_2_6_bar;

import java.util.ArrayList;

public class Bar {
  private ArrayList<Beer> beers;
  private int maxBeers;
  private boolean isOpen;

  public Bar(int maxBeers) {
    beers = new ArrayList<>(maxBeers);
    isOpen = true;
  }

  public synchronized void placeBeer(Beer b){
    while(beers.size() >= maxBeers && isOpen){
      try {
        wait();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if(isOpen){
      beers.add(b);
      notifyAll();
    }
  }

  public synchronized Beer takeBeer(){
    while(isOpen && beers.isEmpty()) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (isOpen) {
      Beer beer = beers.remove(0);
      notifyAll();
      return beer;
    }
    return null;
  }

  public boolean isOpen() {
    return isOpen;
  }
  public synchronized void close() {
    isOpen = false;
    notifyAll();
  }
}
