package jUnit;

public interface ArrayListTest<T> {
  void add(int index, T element); //
  void add(T element);
  boolean contains(T element);
  T get(int index);
  boolean isEmpty();
  T remove(int index);
  Object remove(Object element);
  int size();
  void set(int index, T element);
}
