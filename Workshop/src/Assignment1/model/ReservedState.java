package Assignment1.model;


public class ReservedState implements VinylState{
  private String reservedBy;
  @Override
  public void reserve(Vinyl vinyl) {
    System.out.println(vinyl.getTitle() + " is already reserved");
  }

  @Override
  public void borrow(Vinyl vinyl) {
    if (reservedBy != null) {
      System.out.println("Borrowing " + vinyl.getTitle() + " reserved by " + reservedBy);
      vinyl.setCurrentState(new BorrowedState());
      reservedBy = null;
    } else {
      System.out.println("Borrowing " + vinyl.getTitle());
      vinyl.setCurrentState(new BorrowedState());
    }
  }

  @Override
  public void returnVinyl(Vinyl vinyl) {

  }

  @Override
  public void remove(Vinyl vinyl) {

  }

  public String getReservedBy() {
    return reservedBy;
  }

  public void setReservedBy(String reservedBy) {
    this.reservedBy = reservedBy;
  }
}
