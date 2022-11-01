package clock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClockTest
{
  private Clock clock;

  @Before public void setUp() throws Exception
  {
    clock = new Clock(0,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestSetMinute60()
  {
    clock.set(1, 1, 60);

  }

  @Test public void getHour()
  {

  }
}