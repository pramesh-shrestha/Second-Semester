package Session2_Thread.Ex2_2_synchronized_list;

import java.util.ArrayList;
import java.util.List;

public class ListContainer {
  private List<Integer> list = new ArrayList<>();

  public synchronized void add(int i){
    list.add(i);
  }

  public synchronized int getLength(){
    return list.size();
  }


}

