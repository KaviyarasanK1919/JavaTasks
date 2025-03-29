package task10.movie;

class Movie {
    protected String title;

    public Movie(String title) {
        this.title = title;
    }

    public void playTrailer() {
        System.out.println("Playing the generic movie trailer for: " + title);
    }
}

class RomanticMovie extends Movie {
    public RomanticMovie(String title) {
        super(title);
    }

    @Override
    public void playTrailer() {
        System.out.println("Playing a light-hearted and funny trailer for: " + title);
    }
}

class ThrillerMovie extends Movie {
    public ThrillerMovie(String title) {
        super(title);
    }

    @Override
    public void playTrailer() {
        System.out.println("Playing an intense and suspenseful trailer for: " + title);
    }
}

class HorrorMovie extends Movie {
    public HorrorMovie(String title) {
        super(title);
    }

    @Override
    public void playTrailer() {
        System.out.println("Playing a scary and eerie trailer for: " + title);
    }
}


public class MovieController {

	public static void main(String[] args) {
		Movie myRomCom = new RomanticMovie("Pannaiyarum pathminiyum");
        Movie myThriller = new ThrillerMovie("Black");
        Movie myHorror = new HorrorMovie("Aranmanai");

        myRomCom.playTrailer();  
        myThriller.playTrailer();
        myHorror.playTrailer();
	}

}
