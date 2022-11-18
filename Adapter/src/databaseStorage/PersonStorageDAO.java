package databaseStorage;

public interface PersonStorageDAO {
  void addPerson(Person person);
  Person getPerson(int ssn);
}
