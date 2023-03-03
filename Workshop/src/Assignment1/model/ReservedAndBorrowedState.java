package Assignment1.model;


public class ReservedAndBorrowedState implements VinylState{
  @Override
  public void reserve(Vinyl vinyl) {

  }

  @Override
  public void borrow(Vinyl vinyl) {

  }

  @Override
  public void returnVinyl(Vinyl vinyl) {
    vinyl.setCurrentState(new ReservedState());
  }

  @Override
  public void remove(Vinyl vinyl) {

  }
}
