package Cookie;

import java.util.ArrayList;

public class CookieBaker implements Runnable
{
  private CookieJar cookieJar;
  private ArrayList<Cookie> cookies;

  public CookieBaker(CookieJar cookieJar)
  {
    this.cookieJar = cookieJar;
    cookies = new ArrayList<>();
  }

  @Override
  public void run()
  {
    for (int i = 0; i < 10; i++)
    {
      cookies.add(new Cookie("Chocolate"));
    }
    while (true)
    {
      cookieJar.startBaking(cookies);
    }
  }
}
