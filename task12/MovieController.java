package task12;

abstract class Movie {
 protected String title;
 protected String director;

 public Movie(String title, String director) {
     this.title = title;
     this.director = director;
 }

 public abstract String getGenre();
 public abstract int getDuration();

 public void displayDetails() {
     System.out.println("Title: " + title);
     System.out.println("Director: " + director);
     System.out.println("Genre: " + getGenre());
     System.out.println("Duration: " + getDuration() + " minutes");
 }
}

class ActionMovie extends Movie {
 private int duration;

 public ActionMovie(String title, String director, int duration) {
     super(title, director);
     this.duration = duration;
 }

 @Override
 public String getGenre() {
     return "Action";
 }

 @Override
 public int getDuration() {
     return duration;
 }
}

class ComedyMovie extends Movie {
 private int duration;

 public ComedyMovie(String title, String director, int duration) {
     super(title, director);
     this.duration = duration;
 }

 @Override
 public String getGenre() {
     return "Comedy";
 }

 @Override
 public int getDuration() {
     return duration;
 }
}

public class MovieController {
 public static void main(String[] args) {
     Movie actionMovie = new ActionMovie("Hulk", "Tanjiro", 120);
     Movie comedyMovie = new ComedyMovie("The Avengers", "Kaviyarasan", 100);

     actionMovie.displayDetails();
     System.out.println();
     comedyMovie.displayDetails();
 }
}
