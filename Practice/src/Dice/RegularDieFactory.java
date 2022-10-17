package Dice;

public class RegularDieFactory extends Factory
{
  @Override
  public RegularDie makeDice()
  {
    return new RegularDie();
  }
}
