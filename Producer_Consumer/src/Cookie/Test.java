package Cookie;

public class Test
{
  public static void main(String[] args)
  {
    CookieJar cookieJar = new CookieJar(10);
    Thread thread1 = new Thread(new CookieBaker(cookieJar));
    Thread thread2 = new Thread(new CookieEater(cookieJar));

    thread1.start();
    thread2.start();
  }
}
