package producer_consumer_adapter;

import singleton.SingletonLog;
import utility.collection.ArrayList;
import utility.collection.ListADT;

public class Deposit<T> implements DepositValuables<T> {
  private ListADT<T> list;
  private int capacity;

  public Deposit(int capacity) {
    this.capacity = capacity;
    list = new ArrayList<>();
  }

  @Override
  public synchronized void add(T element) {
    while(list.size() >= capacity){
      try {
        SingletonLog.getInstance().addLog(Thread.currentThread().getName() + " is waiting.");
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    list.add(element);
    notifyAll();
  }

  @Override
  public synchronized T take() {
    while(list.isEmpty()){
      try {
        SingletonLog.getInstance().addLog(Thread.currentThread().getName() + " is waiting");
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    T valuable = list.get(0);
    list.remove(0);
    return valuable;
  }

  @Override
  public synchronized T get(int index) {
    if(index > 0)
      return list.get(index);
    else
      throw new IllegalArgumentException("Invalid index");
  }

  @Override
  public synchronized boolean contains(T element) {
    return list.contains(element);
  }

  @Override
  public synchronized boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public synchronized int getSize() {
    return list.size();
  }

  @Override
  public int getCapacity() {
    return capacity;
  }
}
