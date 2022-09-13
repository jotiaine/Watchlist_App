public class Show {
  private String title;
  private int publishYear;
  private String directors;
  private String actors;

  // Constructor
  public Show() {
    this.title = "title";
    this.publishYear = 1;
    this.directors = "directors";
    this.actors = "actors";
  }

  // Getters
  public String getTitle() {
    return title;
  }

  public int getPublishYear() {
    return publishYear;
  }

  public String getDirectors() {
    return directors;
  }

  public String getActors() {
    return actors;
  }

  // Setters
  public void setTitle(String title) {
    this.title = title;
  }

  public void setPublishYear(int publishYear) {
    this.publishYear = publishYear;
  }

  public void setDirectors(String directors) {
    this.directors = directors;
  }

  public void setActors(String actors) {
    this.actors = actors;
  }

  public void getShowInfo() {
    System.out.println("Show: " + title + " | Published: " + publishYear + " | Directors: " + directors + " | Actors: "
        + actors);
  }
}
