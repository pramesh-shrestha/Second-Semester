package UnitTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearTest
{
  LeapYear leapYear = new LeapYear();

  @Test void isLeapYear()
  {
  }
  @Test
  void test2024()
  {
    assertTrue(leapYear.isLeapYear(2024));
  }

  @Test
  void test2000()
  {
    assertFalse(leapYear.isLeapYear(2022));
  }
}