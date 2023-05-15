// Cindy Watters
// 2.5 Programming Assignment
// CIS 2503
// 05/12/2023


package com.smarthome2;


public class Camera extends Security {
    // Sets recording session for camera
    private boolean isRecording;
    
    public Camera(String area, boolean cameraIsOn) {
        // Passes through area and camera
        super(area, cameraIsOn);
        //Defaults recording to off
        this.isRecording = false;
    }
    
    public boolean cameraIsOn(){
        // Returns whether or not security in original Security class is on before initiating
        return securityIsOn;
    }
    
    // Commands to record session
    public void isNowRecording() {
        if (isRecording == false) {
            isRecording = true;
            System.out.println("Now recording: " + getRoom() + " camera.");
        } else {
            System.out.println("The " + getRoom() + " camera is already recording. Please try again.");
        }
    }
    // Commands to stop recording record session
    public void stopRecording() {
        if (isRecording == true) {
            isRecording = false;
            System.out.println("Ending recording for: " + getRoom() + " camera.");
        } else {
            System.out.println("The " + getRoom() + " camera is not recording. Please try again.");
        }
    }
}


//The code for this programming assignment for Advanced Java,
//SmartHome2, is my own original submission (unless otherwise cited) in accordance with
//the Academic Honesty Policy of the Florida Institute of Technology.
//Faithfully submitted by Cindy Watters, on 5/5/2023.