package myWorkSpace.interfaceSample;

public class ButtonPhone implements Browser, MusicPlayer{

	@Override
	public void playMusic() {
		System.out.println("Playing a song in old model Browser");
	}


	@Override
	public void openWebsite(String url) {
		System.out.println("Opening url "+ url + " in button phone browser.");
	}

}
