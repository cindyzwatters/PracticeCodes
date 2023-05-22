
package com.smarthome2;


public class Light extends Device {
    // Sets on/off values for lights
    private boolean lightsAreOn;
    
    public Light(String room, boolean lightsAreOn) {
        // Using variable lightsAreOn to define on/off command for room
        // Using lightsAreOn for better clarity in comparison to default power status
        super(room, lightsAreOn);
        // Using to differentiate from on/off variables
        this.lightsAreOn = lightsAreOn;
    }
    
    // Changes name of variable power status to lights are on to differentiate
    // from other power status commands later
    public boolean lightsAreOn() {
        return lightsAreOn;
    }
    
    // Command for turning on lights and variable
    public void turnOnLights() {
        if (lightsAreOn == false) {
            lightsAreOn = true;
            // Returns value based on the room user enters and lights are on boolean
            System.out.println("The " + getRoom() + " lights are now on.");
        } else {
            System.out.println("The " + getRoom() + " lights are already on. Please try again.");
        }
    }
    
    // Command for turning off lights and variable
    public void turnOffLights() {
        if (lightsAreOn == true) {
            lightsAreOn = false;
            // Returns value based on the room user enters and lights are on boolean
            System.out.println("The " + getRoom() + " lights are now off.");
        } else {
            System.out.println("The " + getRoom() + " lights are already off. Please try again.");
        }
    }
}
