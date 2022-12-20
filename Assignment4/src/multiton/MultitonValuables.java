package multiton;

import singleton.SingletonLog;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MultitonValuables {
  private static Map<String, MultitonValuables> map = new HashMap<>();
  private int valueWorth;
  private int totalWorthInTreasure;
  Random random = new Random();

  private MultitonValuables(){
    valueWorth = 0;
    totalWorthInTreasure = 0;
  }

  public static MultitonValuables getInstance(String key){
    MultitonValuables instance = map.get(key);
    if(instance == null){
      synchronized (map){

        if (instance == null) {
          instance = new MultitonValuables();
          map.put(key, instance);
        }
      }
    }
    return instance;
  }

  public static MultitonValuables item(String item){
    MultitonValuables valuables = MultitonValuables.getInstance(item); //this will give the value of the key provided as an argument
    SingletonLog.getInstance().addLog(Thread.currentThread().getName() + " added " + item + " to the deposit");
    return valuables;
  }

  public int getValueWorth() {
    valueWorth = random.nextInt(150) + 50;
    totalWorthInTreasure += valueWorth;
    return valueWorth;
  }

  public int getTotalWorthInTreasure() {
    return totalWorthInTreasure;
  }
}
