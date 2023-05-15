// Cindy Watters
// 2.5 Programming Assignment
// CIS 2503
// 05/9/2023

package com.smarthome2;

// Setting up power and room control under parent class Device
public class Device {
    // Controls each room, used later for lights and security
    private String room;
    // Controls the power (on/off) function of each device, used later for entertainment and appliance
    private boolean powerStatus;
    
    // Passes through controls of devices and rooms
    public Device(String room, boolean powerStatus) {
        // Using this to differentiate between variables
        this.room = room;
        this.powerStatus = powerStatus;
    }
    
    // Get/set for rooms
    // Retrieves room name from user command
    public String getRoom() {
        return room;
    }
    
    // Changes and places variable called from return
    public void setRoom(String roomName) {
        room = roomName;
    }
    
    // Get/set for power status
    // Retrieves power status (on/off)
    public boolean getPowerStatus() {
        return powerStatus;
    }
    
    // Changes and places variable called from return
    public void setPowerStatus(boolean devicePowerStatus) {
        powerStatus = devicePowerStatus;
    }
}


//The code for this programming assignment for Advanced Java,
//SmartHome2, is my own original submission (unless otherwise cited) in accordance with
//the Academic Honesty Policy of the Florida Institute of Technology.
//Faithfully submitted by Cindy Watters, on 5/5/2023.