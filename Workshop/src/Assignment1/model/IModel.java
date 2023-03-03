package Assignment1.model;

import Assignment1.util.PropertyChangeSubject;

public interface IModel extends PropertyChangeSubject {
  void addVinyl(Vinyl vinyl);
  void reserve(Vinyl vinyl);
  void borrow(Vinyl vinyl);
}
