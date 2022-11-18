package fileWriter;

import java.util.ArrayList;

public class InMemoryPersonStorage implements DataStorage{
  private ArrayList<Person> persons;

  public InMemoryPersonStorage() {
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
