package Exercises_part1.ex9_RabbitAndTurtle;

public class Test
{
  public static void main(String[] args)
  {
    Turtle turtle = new Turtle(1);
    //Starting thread for both rabbit and turtle
    Thread turtleThread = new Thread(turtle);
    Thread rabbitThread = new Thread(new Rabbit(1,turtle));
    turtleThread.start();
    rabbitThread.start();

  }
}
