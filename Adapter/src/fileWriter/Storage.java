package fileWriter;

import java.util.ArrayList;

public class Storage implements PersonStorage{
  private DataStorage dataStorage;
  private ArrayList<Person> persons;

  public Storage(DataStorage dataStorage) {
    this.dataStorage = dataStorage;
    persons = new ArrayList<>();
  }

  @Override public void addPerson(Person person) {
    persons.add(person);
  }

  @Override public Person getPerson(int ssn) {
    for (int i = 0; i < persons.size(); i++) {
      if(persons.get(i).getSocialSecurityNumber() == ssn)
        return persons.get(i);
    }
    return null;
  }
}
