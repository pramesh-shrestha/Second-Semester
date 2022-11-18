package queueContainingStrings;

import java.util.ArrayList;

public class Queue implements StringQueue{

  private ArrayList<String> list;
  private int capacity;

  public Queue(int capacity) {
    this.capacity = capacity;
    list = new ArrayList<>(capacity);
  }

  @Override
  public void enqueue(String element) {
    if(list.size() < capacity)
      list.add(element);
    else if(element == null)
      throw new IllegalArgumentException();
    else
      throw new IllegalStateException();
  }

  @Override
  public String dequeue() {
    if(list.size() == 0)
      throw new IllegalArgumentException();
    return list.remove(0);
  }

  @Override
  public String first() {
    if(!list.isEmpty())
      return list.get(0);
    else
      throw new IllegalStateException();
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public boolean isEmpty() {
    if(list.size() == 0)
      return true;
    return false;
  }

  @Override
  public int indexOf(String element) {
    if(list.contains(element))
      return list.indexOf(element);
    return -1;
  }

  @Override
  public boolean contains(String element) {
    return list.contains(element);
  }

  @Override
  public String toString() {
    return "Queue{" + "list=" + list + '}';
  }
}
