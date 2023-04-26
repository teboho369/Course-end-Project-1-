package com.Application;

import com.screens.WelcomeScreen;

public class Application {

	public static void main(String[] args) {
		
		WelcomeScreen welcome = new WelcomeScreen();
    	welcome.introWS();
    	welcome.GetUserInput();

	}

}
