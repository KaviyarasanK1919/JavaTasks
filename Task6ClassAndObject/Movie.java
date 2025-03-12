package Task6ClassAndObject;

public class Movie {
	private String movieId;
    private String title;
    private String genre;
    private String director;
    private int releaseYear;
    private double rating;
    private double boxOfficeCollection;
    
    
    
	public Movie(String movieId, String title, String genre, String director, int releaseYear, double rating,
			double boxOfficeCollection) {
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.boxOfficeCollection = boxOfficeCollection;
	}
	
	
	public String getMovieId() {
		return movieId;
	}
	public String getTitle() {
		return title;
	}
	public String getGenre() {
		return genre;
	}
	public String getDirector() {
		return director;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public double getRating() {
		return rating;
	}
	public double getBoxOfficeCollection() {
		return boxOfficeCollection;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public void setBoxOfficeCollection(double boxOfficeCollection) {
		this.boxOfficeCollection = boxOfficeCollection;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", director=" + director
				+ ", releaseYear=" + releaseYear + ", rating=" + rating + ", boxOfficeCollection=" + boxOfficeCollection
				+ "]";
	}
    
    
}
