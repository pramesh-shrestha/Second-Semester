package Assignment1.model;



public class AvailableState implements VinylState{
  @Override
  public void reserve(Vinyl vinyl) {
    vinyl.setCurrentState(new ReservedState());
  }

  @Override
  public void borrow(Vinyl vinyl) {
    vinyl.setCurrentState(new BorrowedState());
  }

  @Override
  public void returnVinyl(Vinyl vinyl) {

  }

  @Override
  public void remove(Vinyl vinyl) {

  }
}
