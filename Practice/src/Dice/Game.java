package Dice;

import EddiesDiner.src.DinnerFactory;
import EddiesDiner.src.LunchFactory;
import EddiesDiner.src.Meal;

public class Game
{
  protected boolean isSixSides = true;
  protected Factory factory = new RegularDieFactory();

  public void changeDice(){
    if (isSixSides) {
      System.out.println("\nIt is a Regular die");
      factory = new RegularDieFactory();
      isSixSides = false;
    }
    else {
      System.out.println("\nIt is a Viking die");
      factory = new VikingDieFactory();
      isSixSides = true;
    }
  }

  public void makeDice()
  {
    Dice dice = factory.makeDice();
  }


  public Game() {

    changeDice();
    makeDice();
    makeDice();
    makeDice();

    changeDice();
    makeDice();
    makeDice();
    makeDice();

  }
}
