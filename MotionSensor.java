
package com.smarthome2;


public class MotionSensor extends Security {
    
    //Sets on/off for monitoring motion sensors
    private boolean isMonitoring;
    
    // Calls light from child class to control lights
    private Light light;
    
    public MotionSensor(String room, boolean securityIsOn, boolean isMonitoring, Light light) {
        // Passes through room and security
        super(room, securityIsOn);
        //Defaults monitoring to off
        this.isMonitoring = isMonitoring;
        this.light = light; // calls light class functions for use
    }
    
    // Initiates device to start detecting motion and turn on lights as a result of motion
    public void detectMotion(){
        if (isMonitoring == false) {
            light.turnOnLights();
            isMonitoring = true;
            System.out.println("Now detecting motion in " + getRoom() + ".");
        } else {
            System.out.println("Sorry, please try again.");
        }
    }
    
    // Initiates device to stop detecting motions which requires user to manually turn on/off lights
    public void stopMotion(){
        if (isMonitoring == true) {
            light.turnOffLights();
            isMonitoring = false;
            System.out.println("Detecting motion in " + getRoom() + " is now ending.");
        } else {
            System.out.println("Sorry, please try again.");
        }
    }
}

