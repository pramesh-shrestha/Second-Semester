package Exercises_part1.ex7_ManyBears;

public class BearPokingRun
{
  public static void main(String[] args)
  {
    Thread bear1 = new Thread(new Bear1());
    bear1.start();
    Thread bear2 = new Thread(new Bear2());
    bear2.start();
    Thread bear3 = new Thread(new Bear3());
    bear3.start();
    Thread pokingManThread = new Thread(new PokingMan(bear1));
    pokingManThread.start();
  }
}
