// Cindy Watters
// 2.5 Programming Assignment
// CIS 2503
// 05/9/2023


package com.smarthome2;

import java.util.*; // initializes scanner for user input command


public class Music extends Entertainment {
    private boolean musicIsOn; // controls on/off for sound bar
    private int volume = 15; // defaults value of tv volume to 15
    private Television television; // uses for tv (on/off commands)
    private String[] songs = { // Changing to array as system would not allow me to throw exception for .txt file
        "22 by taylor swift",
        "safe and sound by capital cities",
        "africa by toto",
        "december by collective soul",
        "black and yellow by wiz khalifa",
        "kill bill by sza",
        "out of my league by fitz and the tantrums",
        "die young by kesha"
    };
    
    Scanner console = new Scanner(System.in); // initializes scanner for user input command
    
    public Music(String room, boolean musicIsOn, int volume, Television television) {
        // Using variable musicIsOn to define on/off command
        super(room, musicIsOn, volume);
        // Using to differentiate from on/off variables
        this.musicIsOn = musicIsOn;
        // using this to initialize and use television later
        this.television = television;
        // using to control volume
        this.volume = volume;
    }
    
    // Controls boolean for music on/off
    public boolean isMusicOn() {
        return musicIsOn;
    }
    
    // Controls boolean for tv on/off
    public boolean turnTVOff() {
        return true;
    }

    // Commands to turn on sound bar
    public void turnSoundBarOn() {
        if (musicIsOn == false) {
            musicIsOn = true;
            System.out.println("The sound bar is now on.");
            if (television.isTvOn() == true) { // commands to confirm if user wants to turn off tv for better viewing experience
                System.out.println("The TV is on. Would you like to turn it off?");
                String userInput = console.nextLine();
                if (userInput.equalsIgnoreCase("Yes")) { // confirm commands to turn off lights
                    television.turnTVOff();
                    System.out.println("Enjoy the music.");
                } else if (userInput.equalsIgnoreCase("no")) { // confirms settings will remain the same
                    System.out.println("Ok, keeping the TV on.");
                }
            }
        } else { // error if user tries to duplicate command
            System.out.println("The sound bar is already on. Please try again.");
        }
    }
    // Commands to turn off sound bar
    public void turnSoundBarOff() {
        if (musicIsOn == true) {
            musicIsOn = false;
            System.out.println("The sound bar is now off.");
        } else { // error if user tries to duplicate command
            System.out.println("The sound bar is already off. Please try again.");
        }
    }
    
    //Controls to adjust volume
    public void changeSoundBarVolume() {
        // Only works if sound bar is on
        if (musicIsOn == true) {
            System.out.println("Ok, what would you like to change the volume to?");
            // Accepts user input
            int volumeInput = console.nextInt();
            // Ensures volume parameters are met
            if (volumeInput >= 0 && volumeInput <= 100) {
                if (volumeInput != this.volume) {
                    this.volume = volumeInput; // Updates to new volume
                    System.out.println("The volume is now: " + this.volume);
                } else if (volumeInput == this.volume) { // If user's entered volume is the same as what system has saved
                    System.out.println("The volume is already set to " + this.volume + ". Please try again.");
                } 
            } else { // if int value falls outside of 0-100 range
                System.out.println("Sorry, that was not a valid input. Please try again.");
            }
        // if sound bar is not already on
        } else {
            System.out.println("Sorry, the sound bar is turned off. Please turn it on first and try again.");
        }
    }
    
    // Accepts songs to choose from
    public void changeSong() {
        if (musicIsOn == true) { // Condition must be met to change song
            System.out.println("Here are the available songs to choose from:");
            for (int i=0; i < songs.length; i++) { // Gives list of available songs from array above
                System.out.println(i + 1 + "." + songs[i]);
            }
            
            System.out.println("Please select a song to play");
                
            String songChoice = console.nextLine(); // Allows user input for channel choice
                
            boolean songFound = false; // Will remain false until user input matches available song in array
                
            for (String song : songs) { // If user selects available choice successfully
                if (song.equalsIgnoreCase(songChoice)) {
                    songFound = true;
                    System.out.println("Now playing: " + song + ".");
                    break;
                }
            }
            if (songFound == true) {
                // follows prompt above and starts for (String song : songs) command
            } else { // will iniitate command saying channel not found
                System.out.println("That is an invalid song, please try again.");
            }
        } else {
            System.out.println("Sorry, the sound bar is off. Please try again.");
        }
    }
}


//The code for this programming assignment for Advanced Java,
//SmartHome2, is my own original submission (unless otherwise cited) in accordance with
//the Academic Honesty Policy of the Florida Institute of Technology.
//Faithfully submitted by Cindy Watters, on 5/5/2023.