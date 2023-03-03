package Assignment1.model;


public interface VinylState {
  void reserve(Vinyl vinyl);
  void borrow(Vinyl vinyl);
  void returnVinyl(Vinyl vinyl);
  void remove(Vinyl vinyl);
}
