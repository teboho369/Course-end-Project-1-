package com.screens;

import com.services.screenServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;


public class WelcomeScreen implements screen {

	private String welcomeText = "Welcome to LockedMe.com Prototype Application";
    private String developerText = "Developer: Teboho Innocent Mosiea";

    private ArrayList<String> options = new ArrayList<>();
	private Scanner in;


    public WelcomeScreen() {
        options.add("1. Browse Files");
        options.add("2. File Options Menu");
        options.add("3. Leave");

    }
    
    public void introWS() {
    	System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("\n");
        Show();
    }
	
	
	
    @Override
    public void Show() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
    	System.out.println("Select Option By entering 1,2 or 3");
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    
    public void NavigateOption(int option) {
        switch(option) {

            case 1: 
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: 
            	screenServices.setCurrentScreen(screenServices.FileOptionsScreen);
                screenServices.getCurrentScreen().Show();
                screenServices.getCurrentScreen().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void ShowFiles() {

        System.out.println("List of Files: ");
    	String FolderPath = "C:\\Users\\Student_0011\\Documents\\ProjectFiles";
    	File Folder = new File(FolderPath);
    	File[] FileNames = Folder.listFiles();
    	Arrays.sort(FileNames);
    	for (File t: FileNames) {
    		if (t.isFile()) {
    			System.out.println(t.getName());
    		}
    		
    	}
    	

    }
    
    private int getOption() {
         in = new Scanner(System.in);
			int returnOption = 0;
			try {
			    returnOption = in.nextInt();
			}
			catch (InputMismatchException ex) {

			}
			return returnOption;
		}

    }


	
	

