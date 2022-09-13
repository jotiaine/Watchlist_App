public class Movie extends Show {
  private int movieLengthMin;

  // Constructor
  public Movie() {
    this.movieLengthMin = 1;
  }

  // Getter
  public int getMovieLengthMin() {
    return movieLengthMin;
  }

  // Setter
  public void setMovieLengthMin(int movieLengthMin) {
    this.movieLengthMin = movieLengthMin;
  }
}
