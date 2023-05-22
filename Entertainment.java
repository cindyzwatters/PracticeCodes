

package com.smarthome2;


public class Entertainment extends Device {
    private boolean electronicsAreOn;
    private int volume; // introducing the volume variable
    
    public Entertainment(String room, boolean electronicsAreOn, int volume) {
        // Using variable electronicsAreOn to define on/off command for room
        // Using electronicsAreOn for better clarity in comparison to default power status
        super(room, electronicsAreOn);
        // Using to differentiate from on/off variables
        this.electronicsAreOn = electronicsAreOn;
        // using to control volume
        this.volume = volume;
    }
    
    // creating get/set for volume based on user controls
    public int getVolume() {
        return volume;
    }
    
    // Sets volume control for television/volume class
    public void setVolume(int volumeControl) {
        volume = volumeControl;
    }
    
    // Command for turning on device and variable for music/television class
    public void turnOnDevice() {
        if (electronicsAreOn == false) {
            electronicsAreOn = true;
        }
    }
    
    // Command for turning off device and variable for music/television class
    public void turnOffDevice() {
        if (electronicsAreOn == true) {
            electronicsAreOn = false;
        }
    }
    
    
}

