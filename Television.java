
package com.smarthome2;

import java.util.*;


public class Television extends Entertainment {
    private boolean tvIsOn; // controls on/off for tv
    private int volume = 15; // defaults value of tv volume to 15
    private Light light; // control lights in living room on/off
    private String[] channels = { // Changing to array as system would not allow me to throw exception for .txt file
        "hbo",
        "tbs",
        "tnt",
        "comedy central",
        "abc",
        "espn",
        "cartoon network",
        "nickelodeon"
    };
    
    Scanner console = new Scanner(System.in);
    
    public Television(String room, boolean tvIsOn, int volume, Light light) {
        // Using variable tvIsOn to define on/off command for room
        super(room, tvIsOn, volume);
        this.tvIsOn = tvIsOn; // controls on/off for tv
        this.volume = volume; // controls volume levels
        this.light = light; // controls on/off for lights
    }
    
    // Controls boolean for tv on/off
    public boolean isTvOn() {
        return tvIsOn;
    }
    
    // controls lights functions for turn off tv commands
    public boolean turnOnLights() {
        light.turnOnLights();
        return true;
    }
    //controls lights function for turn on tv commands
    public boolean turnOffLights() {
        light.turnOffLights();
        return true;
    }

    // Commands to turn on tv
    // must be set to boolean to control music system
    public boolean turnTVOn() {
        if (tvIsOn == false) {
            tvIsOn = true;
            if (light.lightsAreOn() == true) { // commands to confirm if user wants to turn off tv for better viewing experience
                System.out.println("The TV is on. Would you like to turn off the lights?");
                String userInput = console.nextLine();
                if (userInput.equalsIgnoreCase("Yes")) { // confirm commands to turn off lights
                    light.turnOffLights();
                    System.out.println("Enjoy the show.");
                } else if (userInput.equalsIgnoreCase("no")) { // confirms settings will remain the same
                    System.out.println("Ok, keeping the lights on.");
                }
            } else { // if lights already off, will confirm command was executed
                System.out.println("The TV is now on.");
            }
            return true;
        } else { // error if user tries to duplicate command
            System.out.println("The TV is already on. Please try again.");
            return false;
        }
    }
    // Commands to turn off tv
    // must be set to boolean to control music system
    public boolean turnTVOff() {
        if (tvIsOn == true) {
            tvIsOn = false;
            if (light.lightsAreOn() == false) { // commands to confirm if user wants to turn on lights now that user is not watching tv
                System.out.println("The TV is now off. Would you like to turn the lights back on?");
                String userInput = console.nextLine();
                if (userInput.equalsIgnoreCase("Yes")) { // confirm commands to turn on lights
                    light.turnOnLights();
                } else if (userInput.equalsIgnoreCase("no")) { // confirms settings will remain the same
                    System.out.println("Ok, keeping the lights off.");
                }
            } else { // if lights already on, will confirm command was executed
                System.out.println("The TV is off.");
            }
            return true;
        } else { // error if user tries to duplicate command
            System.out.println("The tv is already off. Please try again.");
            return false;
        }
    }
    
    //Controls to adjust volume
    public void changeTVVolume() {
        // Only works if tv is on
        if (tvIsOn == true) {
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
        // if Tv is not already on
        } else {
            System.out.println("Sorry, the tv is turned off. Please turn it on first and try again.");
        }
    }
    
    // Accepts channels to choose from
    public void changeChannel() {
        if (tvIsOn == true) { // Condition must be met to change channels
            System.out.println("Here are the available channels to choose from:");
            for (int i=0; i < channels.length; i++) { // Gives list of available channels from array above
                System.out.println(i + 1 + "." + channels[i]); // lists from 1 to end of array
            }
            
            System.out.println("Please select a channel name to watch");
                
            String channelChoice = console.nextLine(); // Allows user input for channel choice
                
            boolean channelFound = false; // Will remain false until user input matches available channel in array
                
            for (String tvChannels : channels) { // If user selects available choice successfully
                if (tvChannels.equalsIgnoreCase(channelChoice)) {
                    channelFound = true;
                    System.out.println("Now watching: " + tvChannels + "."); // displays choice
                    break; //ends loop
                }
            }
            if (channelFound == true) {
                // follows prompt above and starts for (String tvChannels) command
            } else { // will iniitate command saying channel not found
                System.out.println("That is an invalid channel name, please try again.");
            }
        } else { // Error message if tv is set to false
            System.out.println("Sorry, the tv is off. Please try again.");
        }
    }
}

