// Cindy Watters
// 2.5 Programming Assignment
// CIS 2503
// 05/12/2023


package com.smarthome2;



public class Security extends Device {
    //Sets on and off for security system
    public boolean securityIsOn;
    
    public Security(String room, boolean securityIsOn) {
        // Using variable securityIsOn to define on/off command for room
        // Using securityIsOn for better clarity in comparison to default power status
        super(room, securityIsOn);
        // Using to differentiate from on/off variables
        this.securityIsOn = securityIsOn;
    }
    // Returns command from security on/off for child classes
    public boolean securityIsOn() {
        return securityIsOn;
    }
    
    // Command for arming security and variable
    public void armSecurity() {
        if (securityIsOn == false) {
            securityIsOn = true;
        }
    }
    
    // Command for disarming security and variable
    public void disarmSecurity() {
        if (securityIsOn == true) {
            securityIsOn = false;
        }
    }
}


//The code for this programming assignment for Advanced Java,
//SmartHome2, is my own original submission (unless otherwise cited) in accordance with
//the Academic Honesty Policy of the Florida Institute of Technology.
//Faithfully submitted by Cindy Watters, on 5/5/2023.