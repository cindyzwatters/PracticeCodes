
package com.smarthome2;

import java.util.Scanner;


public class HVAC extends Appliance {
    private boolean hvacIsOn; // controls on/off for HVAC
    private int temperature = 72; // defaults value of temperature to 72
    String acSetting = "cool"; // defaults acSetting to cool
    
    Scanner console = new Scanner(System.in);
    
    public HVAC(String room, boolean hvacIsOn, int temperature, String acSetting) {
        // Using variable hvacIsOn to define on/off command for room
        super(room, hvacIsOn, temperature);
        // using to control temperature
        this.temperature = temperature;
        this.acSetting = acSetting; // Controls whether AC setting will be set to heat or cool
    }
    
    // Controls boolean for hvac on/off
    public boolean isHVACOn() {
        return hvacIsOn;
    }
    
    // Turns on HVAC to later initiate set temperature command
    public void turnOnHVAC() {
        if (hvacIsOn == false) {
            hvacIsOn = true;
            // Returns value based on the room user enters and appliances are on boolean
            System.out.println("The HVAC system is now on.");
        } else {
            System.out.println("The HVAC system is already on. Please try again.");
        }
    }

    // Turns off HVAC system
    public void turnOffHVAC() {
        if (hvacIsOn == true) {
            hvacIsOn = false;
            // Returns value based on the room user enters and appliances are on boolean
            System.out.println("The HVAC system is now off.");
        } else {
            System.out.println("The HVAC system is already off. Please try again.");
        }
    }
    
    // Commands to adjust temperature control in house
    public void setTemperature() {
        // Only works if HVAC is on
        if (hvacIsOn == true) {
            System.out.println("Ok, what would you like to change the temperature to?");
            // Accepts user input
            int tempInput = console.nextInt();
            // Ensures volume parameters are met
            if (tempInput >= 60 && tempInput <= 85) {
                if (tempInput > this.temperature) { // if temp is warmer than prev temp
                    this.temperature = tempInput; // Updates to new temp
                    System.out.println("The temperature is now: " + this.temperature);
                    acSetting = "heat"; // switches acSetting to heat
                    System.out.println("The HVAC setting is now set to " + acSetting);
                } else if (tempInput < this.temperature) { // If temp is colder than prev temp
                    this.temperature = tempInput; // Updates to new temp
                    System.out.println("The temperature is now: " + this.temperature);
                    acSetting = "cool"; // sets acSetting to cool
                    System.out.println("The HVAC setting is now set to " + acSetting);
                } else if (tempInput == this.temperature) { // If user's entered volume is the same as what system has saved
                    System.out.println("The temperature is already set to: " + this.temperature + ". Please try again.");
                }
            } else { // if int value falls outside of the 60 - 85 degree range
                    System.out.println("Sorry, that was not a valid input. Please try again.");
            }
        // if HVAC not already on
        } else {
            System.out.println("Sorry, the HVAC system is turned off. Please turn it on first and try again.");
        }
    }
}
