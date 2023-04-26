package com.screens;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.entities.Directory;
import com.services.screenServices;


public class Fileoptionscreen implements screen {
	
private Directory dir = new Directory();
	
	private ArrayList<String> options = new ArrayList<>();

    public Fileoptionscreen() {
    	
    	options.add("1. Add a New File");
        options.add("2. Delete      ");
        options.add("3. Search ");
        options.add("4. Return Back to Menu");
	
    }
	
    public void Show() {
    	System.out.println("File Options Menu");
        for (String s : options) {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    public void NavigateOption(int option) {
        
    	switch(option) {

            case 1: // Adding a file
                this.AddFile();
                
                this.Show();
                break;
            case 2: // Deleting  File
                this.DeleteFile();
                
                this.Show();
                break;
            case 3: // Searching for File
                this.SearchFile();
                this.Show();
                break;
            
               
            case 4: // Return to Menu
            	
            	screenServices.setCurrentScreen(screenServices.WelcomeScreen);
                screenServices.getCurrentScreen().Show();
                screenServices.getCurrentScreen().GetUserInput();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
                
                
        }

    }
    
    

    public void AddFile() {
        System.out.println("Please Enter New Filename:");

        String fileName = this.getInputString();

        System.out.println("New File Added: " + fileName);
        
		try {
			File file = new File(dir.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	  dir.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("File Already Exits");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    
    public void DeleteFile() {
    	
    	System.out.println("Enter Filename to Be Deleted:");

        String fileName = this.getInputString();

        System.out.println("You are about to Delete this File : " + fileName);
        
        
		Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("File Deleted: " + file.getName());
	    	  dir.getFiles().remove(file);
	      } else {
	        System.out.println("Unable to Delete File:" + fileName + ", Does not Exist.");
	      }
    }
    
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("Enter the Name of the File:");

        String fileName = this.getInputString();

        System.out.println("Searching for: " + fileName);
        
        
        ArrayList<File> files = dir.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("Error!!! The Following File can not be Found");
        }
    }
    
    private String getInputString() {

        try (Scanner in = new Scanner(System.in)) {
			return(in.nextLine());
		}

    }
    
    private int getOption() {
        try (Scanner in = new Scanner(System.in)) {
			int returnOption = 0;
			try {
			    returnOption = in.nextInt();
			}
			catch (InputMismatchException ex) {
				System.out.println("Error!!! Invalid input");
			}
			return returnOption;
		}

    }

}

	

	


