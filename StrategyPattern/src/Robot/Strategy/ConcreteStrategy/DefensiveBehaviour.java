package Robot.Strategy.ConcreteStrategy;

import Robot.Strategy.Context.GameBoard;
import Robot.Strategy.Behaviour;

import java.awt.geom.Point2D;

public class DefensiveBehaviour implements Behaviour
{
  @Override public int moveCommand(GameBoard board, Point2D robotLocation)
  {
    System.out.println("Defensive");
    return -1;
  }
}
