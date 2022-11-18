package Cookie;

public class CookieEater implements Runnable
{
  private CookieJar cookieJar;

  public CookieEater(CookieJar cookieJar)
  {
    this.cookieJar = cookieJar;
  }
  @Override
  public void run()
  {
    while (true)
    {
      cookieJar.eat();
    }
  }
}
