package Robot.Strategy.Context;

import Robot.Strategy.Behaviour;

import java.awt.*;

public class Robot
{
  private String name;
  private GameBoard board;
  private Behaviour behaviourStrategy;

  public Robot(String name, GameBoard board)
  {
    this.name = name;
    this.board = board;
  }

  public Behaviour getBehaviourStrategy()
  {
    return behaviourStrategy;
  }

  public void setBehaviourStrategy(Behaviour behaviourStrategy)
  {
    this.behaviourStrategy = behaviourStrategy;
  }

  public void move()
  {
    behaviourStrategy.moveCommand(board, new Point(2, 3));
    System.out.println(name + " moved 2 steps horizontally and 3 steps vertically.");
  }


}
