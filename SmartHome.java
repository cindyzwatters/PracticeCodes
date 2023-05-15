// Cindy Watters
// 1.7 Programming Exercise #1
// CIS 1502
// 05/1/2023

package com.smarthome;

// For Scanner
import java.util.*;
// To read files
import java.io.*;

public class SmartHome {

    public static void main(String[] args) throws FileNotFoundException { // avoids error caused if system cannot find song.txt or channels.txt
        
        
        Scanner console = new Scanner(System.in);
        
        // Setting default room temperature and AC for smart home
        int currentTemperature = 72;
        String acSetting = "cool";
        
        // Initializing command for songs
        String song;
        // Setting music player to off, defaulting to false
        boolean musicPlayer = false;
        // System will turn true once song has been found and recognized
        boolean songFound = false;
        // Calling text files for songs
        File songFile = new File("song.txt");
        
        // Initializing command for tv channels
        String channel;
        // Setting tv to off, defaulting to false
        boolean tv = false;
        boolean tvChannelFound = false;
        // Calling text files for tv channels
        File channelFile = new File("channels.txt");
        
        // Setting as no ongoing phone calls
        boolean phoneCallMade = false;
        
        // Setting as no answer at the doorbell
        boolean doorbellAnswered = false;
        
        // initializing command for room lights
        String roomLights;
        
        // defaulting room lights to off/false
        boolean mainBedroomLights = false;
        boolean kidsBedroomLights = false;
        boolean livingRoomLights = false;
        boolean kitchenLights = false;
        boolean bathroomLights = false;
        boolean garageLights = false;
        boolean basementLights = false;
        boolean homeOfficeLights = false;
        boolean atticLights = false;
        
        
        System.out.println("Welcome home! What would you like me to do?");

        // Starts loop in case user has multiple commands
        while (true) {
            String command = console.nextLine();
            // Command for temperature control and A/C
            if (command.equalsIgnoreCase("Change temperature")) {
                System.out.print("Ok, what temperature would you like? ");
                // Creating new variable that will be used to replace current temperature
                int newTemperature = console.nextInt();
                if (newTemperature > currentTemperature) { // will make room warmer
                    // Saves to new temp
                    currentTemperature = newTemperature;
                    acSetting = "heat";
                    System.out.println("The temperature is now " + currentTemperature + " degress.");
                    System.out.println("The A/C setting is now set to " + acSetting + ".");
                } else if (newTemperature < currentTemperature) { // will make room cooler
                    // Saves to new temp
                    currentTemperature = newTemperature;
                    acSetting = "cool";
                    System.out.println("The temperature is now " + currentTemperature + " degress.");
                    System.out.println("The A/C setting is now set to " + acSetting + ".");
                } else {
                    System.out.println("The temperature is already set to " + currentTemperature + " degrees.");
                }
                // Allows system to now await a String command.
                console.nextLine(); 
            } 
            // Commands for songs/playlist
            if (command.equalsIgnoreCase("Play music")) {
                // turns on the music player if this is the first time initializing or initially turned off
                if (musicPlayer == false) {
                    System.out.println("Ok, turning on the music player.");
                    musicPlayer = true;
                }
                if (tv == true) { // commands to turn off music player if on
                    System.out.print("The tv is on. Would you like to turn it off? ");
                    String answerToTV = console.nextLine();
                    if (answerToTV.equalsIgnoreCase("yes")) {
                        tv = false;
                        System.out.println("Ok, the tv has been turned off.");
                    }
                    if (answerToTV.equalsIgnoreCase("no")) {
                        System.out.println("Ok, the tv will stay on.");
                    }
                }
                String songChoice = ""; // Sets variable as a String
                // Reads file to confirm match from user input
                Scanner input = new Scanner(songFile);
                System.out.println("What would you like to play?");
                System.out.println("The available songs are: ");
                while (input.hasNextLine()) { // displays available songs that was called using the input new Scanner
                    songChoice = input.nextLine(); // pastes all songs from .txt file
                    System.out.println("- " + songChoice); 
                }
                song = console.nextLine(); // initiates user response for song request
                // resets the song found back to false so when it is recalled, it can look for songs again.
                songFound = false;
                while (songFound == false) { // initiates while loop until user chooses a song from playlist
                    input = new Scanner(songFile); // Calls the file so it can be read and displayed in while loop
                    while (input.hasNextLine()) { // pastes all songs from .txt file
                        songChoice = input.nextLine();
                        if (songChoice.equalsIgnoreCase(song)) { // if user's choice is available
                            songFound = true; // initiates process to end loop
                            System.out.println("Now playing: " + song);
                            break;
                        }
                    }
                    if (songFound == false) { // if song choice is not available or user's entry was invalid
                        System.out.println("Sorry, the song cannot be found. Please try again.");
                        System.out.println("The available songs are: ");
                        input = new Scanner(songFile); // displays available songs once more
                        while (input.hasNextLine()) { // displays available songs that was recalled using the input new Scanner
                            songChoice = input.nextLine(); // pastes all songs from .txt file as a list
                            System.out.println("- " + songChoice); 
                        }
                        // initiates choice for user that will loop back if incorrect
                        System.out.println("What would you like to play from the available songs?");
                        song = console.nextLine(); // accepts user input for song
                    }
                }
                // Closes scanner that was needed to read the file
                input.close();
            }
            if (command.equals("Turn off music")) { // command to manually turn off music player
                if (musicPlayer == false) {
                    System.out.println("The music player is already off");
                } else {
                    musicPlayer = false;
                    System.out.println("The music player has been turned off");
                }
            }
            // Commands for tv
            if (command.equalsIgnoreCase("Watch tv")) {
                // turns on the tv if this is the first time initializing or initially turned off
                if (tv == false) {
                    System.out.println("Ok, turning on the tv.");
                    tv = true;
                }
                if (livingRoomLights == true) { // commands to turn off lights if it is on
                    System.out.print("The living room lights are on. Would you like to turn it off? ");
                    String answerToLights = console.nextLine();
                    if (answerToLights.equalsIgnoreCase("yes")) {
                        livingRoomLights = false;
                        System.out.println("Ok, the lights have been turned off.");
                    }
                    if (answerToLights.equalsIgnoreCase("no")) {
                        System.out.println("Ok, the lights will stay on.");
                    }
                }
                if (musicPlayer == true) { // commands to turn off music player if it is on
                    System.out.println("The music player is on. Would you like to turn it off? ");
                    String answerToMusic = console.nextLine();
                    if (answerToMusic.equalsIgnoreCase("yes")) {
                        musicPlayer = false;
                        System.out.println("Ok, the music has been turned off.");
                    }
                    if (answerToMusic.equalsIgnoreCase("no")) {
                        System.out.println("Ok, the music will stay on.");
                    }
                }
                String tvChannelChoice = ""; // Sets variable as a String
                // Reads file to confirm match from user input
                Scanner input = new Scanner(channelFile);
                System.out.println("What would you like to watch?");
                System.out.println("The available channels are: ");
                while (input.hasNextLine()) { // displays available channel that was called using the input new Scanner
                    tvChannelChoice = input.nextLine(); // pastes all channels from .txt file
                    System.out.println("- " + tvChannelChoice); 
                }
                channel = console.nextLine(); // initiates user response for song request
                // resets the channel found back to false so when it is recalled, it can look for channels again.
                tvChannelFound = false;
                while (tvChannelFound == false) { // initiates while loop until user chooses a channels from list
                    input = new Scanner(channelFile); // calls system to pull .txt file
                    while (input.hasNextLine()) { // pastes all channels from .txt file
                        tvChannelChoice = input.nextLine();
                        if (tvChannelChoice.equalsIgnoreCase(channel)) { // if user's choice is available
                            tvChannelFound = true; // initiates process to end loop
                            System.out.println("Now watching: " + channel);
                            break;
                        }
                    }
                    if (tvChannelFound == false) { // commands if tv channel choice is invalid or not found
                        System.out.println("Sorry, the channel cannot be found. Please try again.");
                        System.out.println("The available channels are: ");
                        input = new Scanner(channelFile); // displays available channel once more
                        while (input.hasNextLine()) { // displays available channels that was recalled using the input new Scanner
                            tvChannelChoice = input.nextLine(); // pastes all channels from .txt file as a list
                            System.out.println("- " + tvChannelChoice); 
                        }
                        // initiates choice for user that will loop back if incorrect
                        System.out.println("What would you like to play from the available channels?");
                        channel = console.nextLine(); // accepts user input for channel
                    }
                }
                // Closes scanner that was needed to read the file
                input.close();
            }
            if (command.equals("Turn off tv")) { // command to manually stop tv
                if (tv == false) {
                    System.out.println("The tv is already off");
                } else {
                    tv = false;
                    System.out.println("The tv has been turned off");
                }
            }
            // Commands for phone
            if (command.equalsIgnoreCase("Make a phone call")) {
                if (musicPlayer == true) { // turns off music player in order to make phone call
                        musicPlayer = false;
                        System.out.println("Turning off the music.");
                    }
                if (tv == true) { // turns off tv in order to make phone call
                        tv = false;
                        System.out.println("Turning off the tv.");
                    }
                if (phoneCallMade == false) { // initiates the phone call
                    System.out.print("Please provide a phone number to call: ");
                    String phoneNumber = console.nextLine(); // accepts as a string since output message is a string
                        if (phoneNumber.length() != 10) { // phone number length must be 10 digits long
                            System.out.println("Sorry, you have provided an invalid phone number. Please try again.");
                        } else {
                            phoneCallMade = true; // keeps phone call going until ends by user
                            System.out.println("Ok, calling +1" + phoneNumber + " now.");
                        }
                    } else {
                    System.out.print("You are already on a call. Would you like to end the call? "); // provides error that call is still going
                    String phoneCallAnswered = console.nextLine(); // accepting user input for ending the phone call
                        if (phoneCallAnswered.equalsIgnoreCase("yes")) {
                            System.out.println("Ok, ending the phone call");
                            phoneCallMade = false;
                        } else if (phoneCallAnswered.equalsIgnoreCase("no")) {
                            System.out.println("Ok, I'll keep the call going");
                        }
                }
            }
            // Commands for doorbell
            if (command.equalsIgnoreCase("Answer the doorbell")) {
                doorbellAnswered = false; // resets back to false even if command already made earlier
                System.out.println("Ok, answering the doorbell");
                if (musicPlayer == true) { // turns off music player in order to answer doorbell
                        musicPlayer = false;
                        System.out.println("Turning off the music.");
                    }
                if (tv == true) { // turns off tv in order to answer doorbell
                        tv = false;
                        System.out.println("Turning off the tv.");
                    }
                if (doorbellAnswered == false) { // initiates doorbell commands
                    System.out.println("What message would you like me to give to our visitor?");
                    String doorbellMessage = console.nextLine(); // accepts answer for doorbell message
                    System.out.println("You want me to tell our visitor: " + doorbellMessage + "."); 
                    boolean acceptedDoorbellMessage = false; // answer not accepted (false) until user approves message
                    while (acceptedDoorbellMessage == false) {
                        System.out.print("Is this message acceptable? ");
                        String doorbellAnswer = console.nextLine(); // initiates for user input
                        if (doorbellAnswer.equalsIgnoreCase("yes")) { // if user accepts message
                            System.out.println("Ok, relaying the message to our visitor");
                            doorbellAnswered = true; // completes loop
                            acceptedDoorbellMessage = true; //completes loop
                        } else if (doorbellAnswer.equalsIgnoreCase("no")) { // restarts while loop, user declines message
                            System.out.println("Ok, what message would you like me to give instead?");
                            doorbellMessage = console.nextLine(); // prepares for new message for while loop
                            System.out.println("You want me to tell our visitor: " + doorbellMessage + "?");
                        } else { // restarts while loop, user did not choose yes or no
                            System.out.println("Invalid response. Please try again.");
                            doorbellMessage = console.nextLine();
                        }
                    }
                }
            }
            // Commands for turning on room lights
            // Choice between main bedroom, kids bedroom, living room, kitchen,
            // bathroom, garage, home office, basement, or attic
            if (command.equalsIgnoreCase("Turn on lights")) {
                System.out.print("Ok, what room would you like to turn on? ");
                roomLights = console.nextLine();
                if (roomLights.equals("main bedroom")) {
                    if (mainBedroomLights == true) {
                        System.out.println("The main bedroom lights are already on.");
                        System.out.println("Please try again.");
                    } else {
                        mainBedroomLights = true;
                        System.out.println("The main bedroom lights are now on.");
                    }
                }
                if (roomLights.equals("kids bedroom")) {
                    if (kidsBedroomLights == true) {
                        System.out.println("The kid's bedroom lights are already on.");
                        System.out.println("Please try again.");
                    } else {
                        mainBedroomLights = true;
                        System.out.println("The kid's bedroom lights are now on.");
                    }
                }
                if (roomLights.equals("living room")) {
                    if (livingRoomLights == true) {
                        System.out.println("The living room lights are already on.");
                        System.out.println("Please try again.");
                    } else {
                        livingRoomLights = true;
                        System.out.println("The living room lights are now on.");
                    }
                }
                if (roomLights.equals("kitchen")) {
                    if (kitchenLights == true) {
                        System.out.println("The kitchen lights are already on.");
                        System.out.println("Please try again.");
                    } else {
                        kitchenLights = true;
                        System.out.println("The kitchen lights are now on.");
                    }
                }
                if (roomLights.equals("bathroom")) {
                    if (bathroomLights == true) {
                        System.out.println("The bathroom lights are already on.");
                        System.out.println("Please try again.");
                    } else {
                        bathroomLights = true;
                        System.out.println("The bathroom lights are now on.");
                    }
                }
                if (roomLights.equals("garage")) {
                    if (garageLights == true) {
                        System.out.println("The garage lights are already on.");
                        System.out.println("Please try again.");
                    } else {
                        garageLights = true;
                        System.out.println("The garage lights are now on.");
                    }
                }
                if (roomLights.equals("basement")) {
                    if (basementLights == true) {
                        System.out.println("The basement lights are already on.");
                        System.out.println("Please try again.");
                    } else {
                        basementLights = true;
                        System.out.println("The basement lights are now on.");
                    }
                }
                if (roomLights.equals("home office")) {
                    if (homeOfficeLights == true) {
                        System.out.println("The home office lights are already on.");
                        System.out.println("Please try again.");
                    } else {
                        homeOfficeLights = true;
                        System.out.println("The home office lights are now on.");
                    }
                }
                if (roomLights.equals("attic")) {
                    if (atticLights == true) {
                        System.out.println("The attic lights are already on.");
                        System.out.println("Please try again.");
                    } else {
                        atticLights = true;
                        System.out.println("The attic lights are now on.");
                    }
                }
            }
            // Commands for turning off room lights
            // Choice between main bedroom, kids bedroom, living room, kitchen,
            // bathroom, garage, home office, basement, or attic
                if (command.equalsIgnoreCase("Turn off lights")) {
                    System.out.print("Ok, what room would you like to turn off? ");
                    roomLights = console.nextLine();
                    if (roomLights.equals("main bedroom")) {
                        if (mainBedroomLights == false) {
                            System.out.println("The main bedroom lights are already off.");
                            System.out.println("Please try again.");
                        } else {
                            mainBedroomLights = false;
                            System.out.println("The main bedroom lights are now off.");
                        }
                    }
                    if (roomLights.equals("kids bedroom")) {
                    if (kidsBedroomLights == false) {
                        System.out.println("The kid's bedroom lights are already off.");
                        System.out.println("Please try again.");
                    } else {
                        mainBedroomLights = false;
                        System.out.println("The kid's bedroom lights are now off.");
                    }
                }
                if (roomLights.equals("living room")) {
                    if (livingRoomLights == false) {
                        System.out.println("The living room lights are already off.");
                        System.out.println("Please try again.");
                    } else {
                        livingRoomLights = false;
                        System.out.println("The living room lights are now off.");
                    }
                }
                if (roomLights.equals("kitchen")) {
                    if (kitchenLights == false) {
                        System.out.println("The kitchen lights are already off.");
                        System.out.println("Please try again.");
                    } else {
                        kitchenLights = false;
                        System.out.println("The kitchen lights are now off.");
                    }
                }
                if (roomLights.equals("bathroom")) {
                    if (bathroomLights == false) {
                        System.out.println("The bathroom lights are already off.");
                        System.out.println("Please try again.");
                    } else {
                        bathroomLights = false;
                        System.out.println("The bathroom lights are now off.");
                    }
                }
                if (roomLights.equals("garage")) {
                    if (garageLights == false) {
                        System.out.println("The garage lights are already off.");
                        System.out.println("Please try again.");
                    } else {
                        garageLights = false;
                        System.out.println("The garage lights are now off.");
                    }
                }
                if (roomLights.equals("basement")) {
                    if (basementLights == false) {
                        System.out.println("The basement lights are already off.");
                        System.out.println("Please try again.");
                    } else {
                        basementLights = false;
                        System.out.println("The basement lights are now off.");
                    }
                }
                if (roomLights.equals("home office")) {
                    if (homeOfficeLights == false) {
                        System.out.println("The home office lights are already off.");
                        System.out.println("Please try again.");
                    } else {
                        homeOfficeLights = false;
                        System.out.println("The home office lights are now on.");
                    }
                }
                if (roomLights.equals("attic")) {
                    if (atticLights == false) {
                        System.out.println("The attic lights are already off.");
                        System.out.println("Please try again.");
                    } else {
                        atticLights = false;
                        System.out.println("The attic lights are now off.");
                    }
                }
            }
            // Commands if user wants to end home system.
            if (command.equalsIgnoreCase("Close system")) {
                System.out.println("Shutting down. Good-bye.");
                console.close(); // ends loop and ends smart home system
                break;
            }
            System.out.println("What else would you like me to do?");
        }
    }
}

//The code for this programming assignment for Advanced Java,
//SmartHome, is my own original submission (unless otherwise cited) in accordance with
//the Academic Honesty Policy of the Florida Institute of Technology.
//Faithfully submitted by Cindy Watters, on 5/5/2023.
