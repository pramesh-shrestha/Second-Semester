package fileWriter;

public interface DataStorage {
  void addPerson(Person person);
  Person getPerson(int ssn);
}
