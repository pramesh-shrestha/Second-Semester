package Robot.Strategy;

import Robot.Strategy.Context.GameBoard;

import java.awt.geom.Point2D;

public interface Behaviour
{
  int moveCommand(GameBoard board, Point2D robotLocation);
}
