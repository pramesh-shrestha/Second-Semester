package Exercises_part1.ex6_Bear;

public class BearPokingRun
{
  public static void main(String[] args)
  {
    Thread bearThread = new Thread(new Bear());
    Thread pokingManThread = new Thread(new PokingMan(bearThread));

    bearThread.start();
    pokingManThread.start();
  }
}
