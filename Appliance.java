
package com.smarthome2;


public class Appliance extends Device {
    public boolean applianceIsOn; // on/off for appliance
    public int temperature; // introduces temperature variable
    
    public Appliance(String room, boolean applianceIsOn, int temperature) {
        // Using variable securityIsOn to define on/off command for room
        // Using securityIsOn for better clarity in comparison to default power status
        super(room, applianceIsOn);
        // Using to differentiate from on/off variables
        this.applianceIsOn = applianceIsOn;
        this.temperature = temperature;
    }
    public boolean applianceIsOn() {
        return applianceIsOn;
    }
    
    // Get/set temperatures based on user controls
    public int getTemperature() {
        return temperature;
    }
    
    public void setTemperature(int temperatureControl) {
        temperature = temperatureControl;
    }
    
    // Command for turning on lights and variable
    public void turnOnAppliance() {
        if (applianceIsOn == false) {
            applianceIsOn = true;
            // Returns value based on the room user enters and appliances are on boolean
            System.out.println("The appliance in the " + getRoom() + " is now on.");
        } else {
            System.out.println("The appliance in the " + getRoom() + " is already on. Please try again.");
        }
    }
    
    public void turnOffAppliance() {
        if (applianceIsOn == true) {
            applianceIsOn = false;
            // Returns value based on the room user enters and appliances are on boolean
            System.out.println("The appliance in the " + getRoom() + " has been turned off.");
        } else {
            System.out.println("The appliance in the " + getRoom() + " has already been turned off. Please try again.");
        }
    }
}

