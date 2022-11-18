package fileWriter;

public interface PersonStorage {
  void addPerson(Person person);
  Person getPerson(int ssn);
}
