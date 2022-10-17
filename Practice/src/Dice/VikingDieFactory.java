package Dice;

public class VikingDieFactory extends Factory
{
  @Override public Dice makeDice()
  {
    return new VikingDie();
  }
}
