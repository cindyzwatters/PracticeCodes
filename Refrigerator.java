// Cindy Watters
// 2.5 Programming Assignment
// CIS 2503
// 05/9/2023


package com.smarthome2;

import java.util.Scanner;


public class Refrigerator extends Appliance {
    private boolean fridgeIsOnPowerSaver; // controls power saver mode on/off for refrigerator
    private int temperature = 32; // defaults value of temperature to 32 degrees
    private String[] inventory = { // Array to display what is in the fridge
        "milk",
        "eggs",
        "orange juice",
        "strawberries",
        "ground beef",
        "pepsi",
        "mountain dew",
        "shredded cheese",
        "lunchables"
    };
    
    // Allows user to enter commands
    Scanner console = new Scanner(System.in);
    
    public Refrigerator(String room, boolean fridgeIsOnPowerSaver, int temperature) {
        // Using variables fridgeIsOnPowerSaver to define on/off command for room
        // Using fridgeIsOnPowerSaver for better clarity in comparison to default power status
        super(room, fridgeIsOnPowerSaver, temperature);
        // using to control temperature
        this.temperature = temperature;
        // using to control and save power saver mode option
        this.fridgeIsOnPowerSaver = fridgeIsOnPowerSaver;
    }
    
    // Controls boolean for fridge on/off power saving mode
    public boolean isFridgeOnPowerSaver() {
        return fridgeIsOnPowerSaver;
    }
    
    // Command to turn on power saver mode
    public void turnOnPowerSaver() {
        if (fridgeIsOnPowerSaver == false) {
            fridgeIsOnPowerSaver = true; // Saves fridge to power saver status
            // Returns confirmation msg
            System.out.println("The fridge is on power saving mode.");
        } else { // Error msg
            System.out.println("The fridge is already on power saving mode. Please try again.");
        }
    }

    // command to turn off power saver mode
    public void turnOffPowerSaver() {
        if (fridgeIsOnPowerSaver == true) {
            fridgeIsOnPowerSaver = false; // Returns and saves fridge power saver mode to off
            System.out.println("Power saving mode has been turned off.");
        } else { // Error message
            System.out.println("The fridge is not on power saving mode. Please try again.");
        }
    }
    
    // command to change temperature
    public void changeTemperature() {
        // Only works if fridge is on
        if (fridgeIsOnPowerSaver == false) {
            System.out.println("Ok, what would you like to change the temperature to?");
            // Accepts user input
            int tempInput = console.nextInt(); // Immediately asks for user input for temperature
            if (tempInput >= 20 && tempInput <= 40) { // General fridge range
                if (tempInput > this.temperature || tempInput < this.temperature) { // if temp is warmer than prev temp
                    this.temperature = tempInput; // Updates to new temp
                    System.out.println("The refrigerator's temperature has now been adjusted to: " + this.temperature);
                } else if (tempInput == this.temperature) { // If fridge already set to temperature
                    System.out.println("The temperature is already set to: " + this.temperature + ". Please try again");
                }
            } else { // if int value falls outside of the 20 - 40 degree range
                    System.out.println("Sorry, that was not a valid input. Please try again.");
            }
        } else { // Error msg
            System.out.println("The fridge is on power saving mode and is set to a predefined temperature to conserve energy.");
            System.out.println("Please turn off power saving mode and try again.");
        }
    }
    
    public void reviewInventory() {
        System.out.println("Here are the items currently in the fridge:");
        for (String groceries : inventory) { // displays groceries already in the fridge
            System.out.println("- " + groceries);
        }
    }
}


//The code for this programming assignment for Advanced Java,
//SmartHome2, is my own original submission (unless otherwise cited) in accordance with
//the Academic Honesty Policy of the Florida Institute of Technology.
//Faithfully submitted by Cindy Watters, on 5/5/2023.