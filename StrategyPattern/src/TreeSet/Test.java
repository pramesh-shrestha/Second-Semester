package TreeSet;

import TreeSet.ConcreteStrategy.AgeComparator;
import TreeSet.ConcreteStrategy.LastnameComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Test
{
  public static void main(String[] args)
  {
    Person person1 = new Person("Rajib", "Paudyal", 21);
    Person person2 = new Person("Suhani", "Pandey", 78);
    Person person3 = new Person("Pramesh", "Shrestha", 21);

    TreeSet<Person> lastname = new TreeSet<>(new LastnameComparator());
    lastname.add(person1);
    lastname.add(person2);
    lastname.add(person3);
    System.out.println(lastname);

    TreeSet<Person> age = new TreeSet<>(new AgeComparator());
    age.add(person1);
    age.add(person2);
    age.add(person3);
    System.out.println(age);

  }
}
