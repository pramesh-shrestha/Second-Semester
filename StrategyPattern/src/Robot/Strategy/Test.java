package Robot.Strategy;

import Robot.Strategy.ConcreteStrategy.AggressiveBehaviour;
import Robot.Strategy.Context.GameBoard;
import Robot.Strategy.Context.Robot;

public class Test
{
  public static void main(String[] args)
  {
    GameBoard board = new GameBoard();
    Robot robot = new Robot("Rajib", board);
    robot.setBehaviourStrategy(new AggressiveBehaviour());
    robot.move();



  }

}
