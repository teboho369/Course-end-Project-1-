package com.services;

import java.io.File;

import com.services.Directoryservices;

import com.entities.Directory;


public class Directoryservices {

	 private static Directory fileDirectory = new Directory();
	    
	    public static void PrintFiles() {
	    	
	    	fileDirectory.fillFiles();

	        for (File file : Directoryservices.getFileDirectory().getFiles())
	        {
	            System.out.println(file.getName());
	        }
	    }
	    public static Directory getFileDirectory() {
	        return fileDirectory;
	    }

	    public static void setFileDirectory(Directory fileDirectory) {
	        Directoryservices.fileDirectory = fileDirectory;
	    }

	
}
