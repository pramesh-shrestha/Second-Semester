package fileWriter;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    PersonStorage personStorage = new Storage(new InMemoryPersonStorage());
    Scanner input = new Scanner(System.in);
    for (int i = 0; i < 2; i++) {
      System.out.println("Enter your name: ");
      String name = input.nextLine();
      System.out.println("Enter your dob: ");
      String dob = input.nextLine();
      System.out.println("Enter your ssn: ");
      int ssn = input.nextInt();
      input.nextLine();
      personStorage.addPerson(new Person(name, dob, ssn));
    }
    System.out.println("Enter ssn number you want to find the name of");
    System.out.println(personStorage.getPerson(input.nextInt()));
  }
}
