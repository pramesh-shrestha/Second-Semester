package Assignment1.model;



public class Vinyl {
  private String title;
  private String artist;
  private int year;
  private String state;
  private VinylState currentState;


  public Vinyl(String title, String artist, int year, String state) {
    this.title = title;
    this.artist = artist;
    this.year = year;
    this.state = state;
  }

  public Vinyl(VinylState currentState){
    this.currentState = currentState;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public VinylState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(VinylState currentState) {
    this.currentState = currentState;
  }
}
