package TreeSet.ConcreteStrategy;

import TreeSet.Person;

import java.util.Comparator;

public class LastnameComparator implements Comparator<Person>
{
  @Override public int compare(Person p1, Person p2)
  {
    return p1.getLastname().compareTo(p2.getLastname());
  }
}
