package com.services;

import com.screens.Fileoptionscreen;
import com.screens.screen;
import com.screens.WelcomeScreen;
import com.entities.Directory;


public class screenServices {
	
	static Directory dir = new Directory();
	
	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
    public static Fileoptionscreen FileOptionsScreen = new Fileoptionscreen();
    
    

    public static screen CurrentScreen = WelcomeScreen;

    
    public static screen getCurrentScreen() {
        return CurrentScreen;
    }

    
    public static void setCurrentScreen(screen currentScreen) {
        CurrentScreen = currentScreen;
    }

}
