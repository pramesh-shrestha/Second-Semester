package jUnit;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ArrayListTestTest {
  private ArrayList<String> list;

  @org.junit.Before
  public void setUp() throws Exception {
    list = new ArrayList<>();
  }

  @Test
  public void testingNull(){
    assertEquals(false,list.contains(null));
  }

  //	add(int index, T element)
  @Test
  public void addingELementAtSpecifiedIndex(){
    list.add(0,"Java");
    list.add(1, "SWE");
    String text = list.get(1);
    assertEquals("SWE", text);
  }

  @Test
  public void addingNewElementToAlreadyAssignedIndex(){
    list.add(0,"Java");
    list.add(1, "SWE");
    list.add(1,"DBS");

    assertEquals(2, list.indexOf("SWE"));
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
    try {
      list.add(null);
    } catch (Exception e) {
      fail("Should not throw any exception");
    }
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