package databaseStorage;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) throws SQLException {
    PersonStorageDAO personStorageDAO = new StorageDAO();
    Scanner input = new Scanner(System.in);
//    for (int i = 0; i < 2; i++) {
//      System.out.println("Enter your name: ");
//      String name = input.nextLine();
//      System.out.println("Enter your dob: ");
//      String dob = input.nextLine();
//      System.out.println("Enter your ssn: ");
//      int ssn = input.nextInt();
//      input.nextLine();
//      personStorageDAO.addPerson(new Person(name, dob, ssn));
//    }
    System.out.println("Enter ssn number you want to find the name of");
    System.out.println(personStorageDAO.getPerson(input.nextInt()));
  }
}
