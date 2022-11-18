package fileWriter;

public class Person {
  private String name;
  private String dateOfBirth;
  private int socialSecurityNumber;

  public Person(String name, String dateOfBirth, int socialSecurityNumber) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.socialSecurityNumber = socialSecurityNumber;
  }

  public String getName() {
    return name;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public int getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  @Override public String toString() {
    return "Person{" + "name='" + name + '\'' + ", dateOfBirth='" + dateOfBirth
        + '\'' + ", socialSecurityNumber=" + socialSecurityNumber + '}';
  }
}
