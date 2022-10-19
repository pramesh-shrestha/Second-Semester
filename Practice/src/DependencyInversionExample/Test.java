package DependencyInversionExample;

public class Test
{
  public static void main(String[] args)
  {
    User user = new User(new MySqlDatabase());
    User user1 = new User(new OracleDatabase());

    user.add("This is some data.");
    user1.add("This is some data.");
  }
}
