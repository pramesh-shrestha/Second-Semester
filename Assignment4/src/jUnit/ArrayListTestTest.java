package jUnit;

import org.junit.Test;

import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ArrayListTestTest {
  private ArrayList<String> list;
  private int maxSize = 5;

  @org.junit.Before
  public void setUp() throws Exception {
    list = new ArrayList<>(maxSize);
  }

  @Test
  public void testingEmptyArrayList(){
    assertEquals(0,list.size());
  }

  //	add(int index, T element)

  @Test
  public void addingOneELementAtSpecifiedIndex(){
    if(list.size() < 5)
      list.add(0,"Java");
    String text = list.get(0);
    assertEquals("Java", text);
  }

  @Test
  public void addingMoreELementsAtSpecifiedIndex(){
    if (list.size() < 5) {
      list.add(0,"Java");
      list.add(1, "SWE");
    }
    String text = list.get(1);
    assertEquals("SWE", text);
  }

  //Boundary and branch test
  @Test
  public void addingFourElements() {
    if (list.size() < 5) {
      list.add(0, "Java");
      list.add(1, "SWE");
      list.add(2, "DBS");
      list.add(3, "SEP");
    }
    assertEquals(4, list.size());
  }

  @Test
  public void addingFiveElements() {
    if (list.size() < 5) {
      list.add(0, "Java");
      list.add(1, "SWE");
      list.add(2, "DBS");
      list.add(3, "SEP");
      list.add(4, "C#");
    }
    assertEquals(5, list.size());
  }

  @Test
  public void addingSixElements() {
      list.add(0, "Java");
      list.add(1, "SWE");
      list.add(2, "DBS");
      list.add(3, "SEP");
      list.add(4, "C#");
    try {
      if (list.size() < 6) {
        list.add(5, "Python");
        assertEquals(6, list.size());

      } else {
        throw new Exception("Cannot add more than 5 elements");
      }
    }
    catch (Exception e) {
      assertEquals("Cannot add more than 5 elements", e.getMessage());
    }
  }

  //Exceptional situation test
  @Test
  public void addingNewElementToAlreadyAssignedIndex(){
    if (list.size() < 5) {
      list.add(0,"Java");
      list.add(1, "SWE");
      list.add(2,"DBS");
      list.add(1,"SEP");
    }

    assertEquals(1, list.indexOf("SEP"));
    assertEquals(2, list.indexOf("SWE"));
    assertEquals(3, list.indexOf("DBS"));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getElementNotSpecifiedByIndex(){
    list.get(2);
  }

  //add(T element)
  @Test
  public void addElementAtTheRearEndOfTheList(){
    list.add(0,"Java");
    list.add(1, "SWE");
    list.add("SEP");
    list.add("DBS");
    assertEquals(3,list.indexOf("DBS"));
  }

  @Test
  public void elementIsAddedAtTheEndOfList(){
    list.add("SEP");
    list.add("DBS");
    int index = list.indexOf("DBS");
    assertFalse(index == 0);
  }

  @Test
  public void addNullToTheList(){

    list.add(null);
    assertEquals(null,list.get(0));

  }

  //contains(T element)
  @Test
  public void testingListContainsJavaAsString(){
    list.add("Java");
    list.add("SEP");
    list.add("DBS");
    assertTrue(list.contains("Java"));
  }

  @Test
  public void testingStringNotInTheList(){
    list.add("Java");
    list.add("SEP");
    list.add("DBS");
    assertFalse(list.contains("Mountains"));
  }

  @Test
  public void testingEmptyList(){
    assertFalse(list.contains("Java"));
  }

  //	get(int index)
  @Test
  public void getElementOfSpecifiedIndex(){
    list.add(0,"Java");
    list.add(1, "SWE");
    list.add(2, "DBS");
    list.add(3, "SEP");
    assertEquals("DBS", list.get(2));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getIndexNotDefinedInTheList(){
    list.add(0,"Java");
    list.add(1, "SWE");
    list.add(2, "DBS");
    list.add(3, "SEP");
    list.get(4);
  }

  //indexOf(T element)

  @Test
  public void getIndexOfElementInTheList(){
    list.add(0,"Java");
    list.add(1, "SWE");

    assertEquals(1,list.indexOf("SWE"));
  }

  @Test
  public void getIndexOfElementNotPresentInTheList(){
    list.add(0,"Java");
    list.add(1, "SWE");

    assertEquals(-1, list.indexOf("DBS"));
  }

  @Test
  public void getIndexOfNull(){
    list.add(0,"Java");
    list.add(1, "SWE");
    list.add(null);

    assertEquals(2, list.indexOf(null));
  }

  @Test
  public void checkIndexOfRemovedElement(){
    list.add(0,"Java");
    list.add(1, "SWE");
    list.remove("SWE");
    assertEquals(-1, list.indexOf("SWE"));
  }

  //isEmpty()
  @Test
  public void listWithNoElements(){
    assertTrue(list.isEmpty());
  }

  @Test
  public void listWithSomeElements(){
    list.add(0,"Java");
    list.add(1, "SWE");
    assertFalse(list.isEmpty());
  }

  @Test
  public void listWithNull(){
    list.add(null);
    assertFalse(list.isEmpty());
  }

  @Test
  public void listWithEmptySpace(){
    list.add("");
    assertFalse(list.isEmpty());
  }

  //remove(Object element)
  @Test
  public void removeElementFromEmptyList(){
    assertFalse(list.remove("SDJ"));
  }

  @Test
  public void removeElementFromList(){
    list.add(0,"Java");
    list.add(1, "SWE");
    assertTrue(list.remove("SWE"));
  }

  @Test
  public void checkIfElementPresentInListAfterRemoving(){
    list.add(0,"Java");
    list.add(1, "SWE");
    list.remove("SWE");
    assertFalse(list.contains("SWE"));
  }

  //	remove(int index)
  @Test(expected = IndexOutOfBoundsException.class)
  public void removeElementOfEmptyList(){
      list.remove(0);
  }

  @Test
  public void removeElementOfFirstIndex(){
    list.add(0,"Java");
    list.add(1, "SWE");
    assertEquals("Java", list.remove(0));
  }

  @Test
  public void elementNotAvailableInTheListAfterRemoving(){
    list.add(0,"Java");
    list.add(1, "SWE");
    list.remove(1);
    assertFalse(list.contains("SWE"));
  }

  @Test
  public void removeNull(){
    list.add(null);
    assertTrue(list.remove(null));
  }


  //size()
  @Test
  public void sizeOfEmptyList(){
    assertEquals(0, list.size());
  }

  @Test
  public void sizeOfNonEmptyList(){
    list.add("Java");
    list.add("SEP");
    list.add("DBS");
    assertEquals(3, list.size());
  }

  @Test
  public void getSizeOfTheListAfterAddingNewElementToAlreadyAssignedIndex(){
    list.add(0,"Java");
    list.add(1, "SWE");
    list.add(1,"DBS");

    assertEquals(3, list.size());
  }

  @Test
  public void sizeOfTheListAfterAddingNullToTheList(){
    list.add(null);
    assertEquals(1, list.size());
  }

  //set(int index, T element)

  @Test
  public void setElementToGivenIndex(){
    list.add(0, "DBS");
    list.set(0,"SDJ");
    assertEquals("SDJ", list.get(0));
  }

  @Test
  public void setNullToGivenIndex(){
    list.add(0, "DBS");
    list.set(0,null);
    assertEquals(null, list.get(0));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void setValueToUnassignedIndex(){
    list.add(0, "DBS");
    list.add(1, "SWE");
    list.set(2,"SDJ");
  }

  //toString()

  @Test
  public void emptyList() {
    assertEquals("[]", list.toString());
  }

  @Test
  public void listWithOneElement() {
    list.add("SDJ");
    assertEquals("[SDJ]", list.toString());
  }

  @Test
  public void listWithManyElements() {
    list.add("SDJ");
    list.add("DBS");
    assertEquals("[SDJ, DBS]", list.toString());
  }
}