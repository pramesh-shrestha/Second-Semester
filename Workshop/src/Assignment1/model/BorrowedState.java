package Assignment1.model;



public class BorrowedState implements VinylState{
  @Override
  public void reserve(Vinyl vinyl) {

  }

  @Override
  public void borrow(Vinyl vinyl) {
    System.out.println(vinyl.getTitle() + " is already borrowed");
  }

  @Override
  public void returnVinyl(Vinyl vinyl) {
    vinyl.setCurrentState(new AvailableState());
  }

  @Override
  public void remove(Vinyl vinyl) {

  }
}
