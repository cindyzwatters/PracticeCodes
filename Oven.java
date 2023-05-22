
package com.smarthome2;

import java.util.Scanner;


public class Oven extends Appliance {
    private boolean ovenIsOn; // controls on/off for oven
    private int temperature = 350; // defaults value of temperature to 350 degrees
    private int timerInMinutes = 20; // defaults timer to 60 minutes
    
    // Allows user to enter commands
    Scanner console = new Scanner(System.in);
    
    public Oven(String room, boolean ovenIsOn, int temperature, int timerInMinutes) {
        // Using variables ovenIsOn to define on/off command for room
        // Using ovenIsOn for better clarity in comparison to default power status
        super(room, ovenIsOn, temperature);
        // using to control temperature
        this.temperature = temperature;
        //using to control timer for cooking/baking
        this.timerInMinutes = timerInMinutes;
    }
    
    // Controls boolean for oven on/off from user
    public boolean isOvenOn() {
        return ovenIsOn;
    }
    
    // Commands to turn on oven and preset oven temperature
    public void turnOnOven() {
        if (ovenIsOn == false) {
            ovenIsOn = true; // Saves oven to on status
            // Returns value based on the room user enters and appliances are on boolean
            System.out.println("The oven is now on. What would you like to preheat the oven to?");
            int tempInput = console.nextInt(); // Immediately asks for user input for temperature
            if (tempInput >= 175 && tempInput <= 450) { // General oven range
                this.temperature = tempInput; // Updates to new temp
                // Note, despite default temp being at 350, system will not give error msg
                // Smart Home should always command user to give temp prompt for safety reasons
                System.out.println("The oven is now preheating to: " + this.temperature);
            } else { // if int value falls outside of the 175 - 450 degree range
                    System.out.println("Sorry, that was not a valid input. Please try again.");
            }
        } else { // Error msg
            System.out.println("The oven is already on. Please try again.");
        }
    }

    // commands to turn off oven
    public void turnOffOven() {
        if (ovenIsOn == true) {
            ovenIsOn = false; // Returns and saves oven to off status
            System.out.println("The oven is now off.");
        } else { // Error message
            System.out.println("The oven is already off. Please try again.");
        }
    }
    
    // Change temperature command for oven
    public void changeTemperature() {
        // Only works if oven is on
        if (ovenIsOn == true) {
            System.out.println("Ok, what would you like to change the temperature to?");
            // Accepts user input
            int tempInput = console.nextInt(); // Immediately asks for user input for temperature
            if (tempInput >= 175 && tempInput <= 450) { // General oven range
                if (tempInput > this.temperature) { // if temp is warmer than prev temp
                    this.temperature = tempInput; // Updates to new temp
                    System.out.println("The oven is now preheating to: " + this.temperature);
                } else if (tempInput < this.temperature) { // If temp is colder than prev temp
                    this.temperature = tempInput; // Updates to new temp
                    System.out.println("Decreasing the oven temperature to: " + this.temperature);
                } else if (tempInput == this.temperature) { // If oven already set to temperature
                    System.out.println("The temperature is already set to: " + this.temperature + ". Please try again");
                }
            } else { // if int value falls outside of the 175 - 450 degree range
                    System.out.println("Sorry, that was not a valid input. Please try again.");
            }
        } else { // Error msg
            System.out.println("The oven is already on. Please try again.");
        }
    }
    
    public void setTimer() {
        // Only works if oven is on
        if (ovenIsOn == true) {
            System.out.println("Ok, what would you like to set the timer to? (in minutes)");
            // Accepts user input
            int timerInput = console.nextInt();
            // Ensures volume parameters are met
            if (timerInput >= 1 && timerInput <= 720) { // between 1 minute and 12 hours (720 min) only
                this.timerInMinutes = timerInput; // Updates to new timer in minutes
                System.out.println("The timer is now set to: " + this.timerInMinutes);
            } else if (timerInput == this.timerInMinutes) { // If user's entered timer is the same as what system has saved
                System.out.println("The timer is already set to: " + this.timerInMinutes + ". Please try again.");
            } else { // if int value falls outside of the 1 - 720 min range
                 System.out.println("Sorry, that was not a valid input. Please try again.");
            }
        // if oven not already on
        } else {
            System.out.println("Sorry, the oven is turned off. Please turn it on first and try again.");
        }
    }
}
