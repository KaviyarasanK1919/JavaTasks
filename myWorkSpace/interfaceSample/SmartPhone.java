package myWorkSpace.interfaceSample;

public class SmartPhone implements UCBrowser, ChromeBrowser, Spotify, Gaana{

	@Override
	public void openWebsite(String url) {
		System.out.println("Opening " + url + " in SmartPhone browser...");
	}

	@Override
	public void enableAdsBlocker() {
		System.out.println("Enjoy UC browser.This browser prevents Ads.");
	}

	@Override
	public void useChromeExtensions() {
		System.out.println("Enjoy Chrome Extensions.");
	}

	@Override
	public void playMusic() {
		System.out.println("Opening Music player in smart phone.");
	}

	@Override
	public void playSongWithoutAds() {
		System.out.println("Enjoy songs without Ads in Gaana");
	}

	@Override
	public void playSongForFree() {
		System.out.println("Play unlimited songs for free in Spotify.");
	}

}
