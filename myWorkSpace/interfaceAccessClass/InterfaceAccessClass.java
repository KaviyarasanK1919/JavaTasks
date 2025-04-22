package myWorkSpace.interfaceAccessClass;

import myWorkSpace.interfaceSample.ButtonPhone;
import myWorkSpace.interfaceSample.SmartPhone;

public class InterfaceAccessClass {

	public static void main(String[] args) {
		
		System.out.println("Button Phone : ");
		ButtonPhone btPhone = new ButtonPhone();
		btPhone.openWebsite("www.google.com");
		btPhone.playMusic();
		
		System.out.println("\nSmart Phone : ");
		SmartPhone stPhone = new SmartPhone();
		stPhone.enableAdsBlocker();
		stPhone.openWebsite("www.google.com");
		stPhone.playMusic();
		stPhone.playSongForFree();
		stPhone.playSongWithoutAds();
		stPhone.useChromeExtensions();
	}

}
