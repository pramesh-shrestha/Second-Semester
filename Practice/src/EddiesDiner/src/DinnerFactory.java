package EddiesDiner.src;

public class DinnerFactory extends Factory{
	public Meal makeMeal()
	{
		return new Dinner();
	}
}
