

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

