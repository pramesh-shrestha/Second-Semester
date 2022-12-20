package Robot.Strategy.ConcreteStrategy;

import Robot.Strategy.Context.GameBoard;
import Robot.Strategy.Behaviour;

import java.awt.geom.Point2D;

public class AggressiveBehaviour implements Behaviour
{
  @Override public int moveCommand(GameBoard board, Point2D robotLocation)
  {
    System.out.println("Aggressive movement " + robotLocation.getX() + " on X-axis " + robotLocation.getY() + " on Y-axis.");
    return 1;
  }
}
