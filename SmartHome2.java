
package com.smarthome2;

// For Scanner
import java.util.*;
// To read files
import java.io.*;

public class SmartHome2 {

    public static void main(String[] args) {
        
        // Initiating scanner to accept user command
        Scanner console = new Scanner(System.in);
        
        // Creating array to help user choose which command to make
        String[] help = {
            "Turn On lights",
            "Turn Off lights",
            "Start Recording Security Camera",
            "Stop Recording Security Camera",
            "Turn on motion sensors",
            "Turn off motion sensors",
            "Turn on TV",
            "Turn off TV",
            "Adjust TV volume",
            "Change the channel",
            "Turn on sound bar",
            "Turn off sound bar",
            "Adjust sound bar volume",
            "Change the song",
            "Turn on central air",
            "Turn off central air",
            "Change the home temperature",
            "Turn on oven",
            "Turn off oven",
            "Change the oven timer",
            "Change the oven temperature",
            "Turn on power saver mode for the fridge",
            "Turn off power saver mode for the fridge",
            "Change the fridge temperature",
            "Tell me what is in the fridge",
            "Close System"
        };
        
        // Setting separate constructors for each room for lights
        Light mainBedroomLight = new Light("main Bedroom", false);
        Light kidsBedroomLight = new Light("kids Bedroom", false);
        Light livingRoomLight = new Light("living Room", false);
        Light kitchenLight = new Light("kitchen", false);
        Light bathroomLight = new Light("bathroom", false);
        Light garageLight = new Light("garage", false);
        Light basementLight = new Light("basement", false);
        Light homeOfficeLight = new Light("home office", false);
        Light atticLight = new Light("attic", false);
        
        // Removing security arm/disarm settings
        // Setting separate constructors for each camera. 
        Camera doorbellCamera = new Camera("doorbell", false);
        Camera frontLawnCamera = new Camera("front lawn", false);
        Camera drivewayCamera = new Camera("driveway", false);
        Camera sideHouseCamera = new Camera("side house", false);
        Camera backyardCamera = new Camera("backyard", false);
        Camera backDoorCamera = new Camera("back door", false);
        Camera sideDoorCamera = new Camera("side door", false);
        Camera frontDoorCamera = new Camera("front door", false);
        
        // Setting separate constructors for each motion sensor room
        MotionSensor mainBedroomMotionSensor = new MotionSensor("main Bedroom", true, false, mainBedroomLight);
        MotionSensor kidsBedroomMotionSensor = new MotionSensor("kids Bedroom", true, false, kidsBedroomLight);
        MotionSensor livingRoomMotionSensor = new MotionSensor("living Room", true, false, livingRoomLight);
        MotionSensor kitchenMotionSensor = new MotionSensor("kitchen", true, false, kitchenLight);
        MotionSensor bathroomMotionSensor = new MotionSensor("bathroom", true, false, bathroomLight);
        MotionSensor garageMotionSensor = new MotionSensor("garage", true, false, garageLight);
        MotionSensor basementMotionSensor = new MotionSensor("basement", true, false, basementLight);
        MotionSensor homeOfficeMotionSensor = new MotionSensor("home office", true, false, homeOfficeLight);
        MotionSensor atticMotionSensor = new MotionSensor("attic", true, false, atticLight);
        
        // Setting separate constructor for tv
        Television television = new Television("living room", false, 15, livingRoomLight);
        
        // Setting separate constructor for sound bar
        Music music = new Music("living room", false, 15, television);
        
        // Setting constructor for HVAC
        HVAC hvac = new HVAC("home", false, 72, "cool");
        
        // Setting constructor for oven
        Oven oven = new Oven("kitchen", false, 350, 20);
        
        // Setting constructor for refrigerator
        Refrigerator refrigerator = new Refrigerator("kitchen", true, 32);
        
        // Starts system, introduces user to smart home commands
        System.out.println("Welcome home! What would you like me to do?");
        
        while (true) {
            //Accepting initial command from user
            String userCommand = console.nextLine();
            //  Turn on lights sequence and option for room
            if (userCommand.equalsIgnoreCase("Turn on lights")) {
                System.out.println("Ok, which room would you like to turn on?");
                String lightUserCommand = console.nextLine();
                if (lightUserCommand.equalsIgnoreCase("Main Bedroom")) {
                    mainBedroomLight.turnOnLights();
                } else if (lightUserCommand.equalsIgnoreCase("Kids Bedroom")) {
                    kidsBedroomLight.turnOnLights();
                } else if (lightUserCommand.equalsIgnoreCase("Living room")) {
                    livingRoomLight.turnOnLights();
                } else if (lightUserCommand.equalsIgnoreCase("Kitchen")) {
                    kitchenLight.turnOnLights();
                } else if (lightUserCommand.equalsIgnoreCase("Bathroom")) {
                    bathroomLight.turnOnLights();
                } else if (lightUserCommand.equalsIgnoreCase("Garage")) {
                    garageLight.turnOnLights();
                } else if (lightUserCommand.equalsIgnoreCase("Basement")) {
                    basementLight.turnOnLights();
                } else if (lightUserCommand.equalsIgnoreCase("Home Office")) {
                    homeOfficeLight.turnOnLights();
                } else if (lightUserCommand.equalsIgnoreCase("Attic")) {
                    atticLight.turnOnLights();
                } else {
                    System.out.println("Sorry, I did not recognize that, please try again.");
                }
            }
            // Accepting turn off lights sequence and room option
            if (userCommand.equalsIgnoreCase("Turn off lights")) {
                System.out.println("Ok, which room would you like to turn off?");
                String lightUserCommand = console.nextLine();
                if (lightUserCommand.equalsIgnoreCase("Main Bedroom")) {
                    mainBedroomLight.turnOffLights();
                } else if (lightUserCommand.equalsIgnoreCase("Kids Bedroom")) {
                    kidsBedroomLight.turnOffLights();
                } else if (lightUserCommand.equalsIgnoreCase("Living room")) {
                    livingRoomLight.turnOffLights();
                } else if (lightUserCommand.equalsIgnoreCase("Kitchen")) {
                    kitchenLight.turnOffLights();
                } else if (lightUserCommand.equalsIgnoreCase("Bathroom")) {
                    bathroomLight.turnOffLights();
                } else if (lightUserCommand.equalsIgnoreCase("Garage")) {
                    garageLight.turnOffLights();
                } else if (lightUserCommand.equalsIgnoreCase("Basement")) {
                    basementLight.turnOffLights();
                } else if (lightUserCommand.equalsIgnoreCase("Home Office")) {
                    homeOfficeLight.turnOffLights();
                } else if (lightUserCommand.equalsIgnoreCase("Attic")) {
                    atticLight.turnOffLights();
                } else {
                    System.out.println("Sorry, I did not recognize that, please try again.");
                }
            }
            // removing arm/disarm security
            // Commands for recording security cameras
            if (userCommand.equalsIgnoreCase("Start Recording Security Camera")) {
                System.out.println("Ok, which area would you like to record?");
                String securityUserCommand = console.nextLine();
                if (securityUserCommand.equalsIgnoreCase("doorbell")) {
                    doorbellCamera.isNowRecording();
                } else if (securityUserCommand.equalsIgnoreCase("front lawn")) {
                    frontLawnCamera.isNowRecording();
                } else if (securityUserCommand.equalsIgnoreCase("driveway")) {
                    drivewayCamera.isNowRecording();
                } else if (securityUserCommand.equalsIgnoreCase("side house")) {
                    sideHouseCamera.isNowRecording();
                } else if (securityUserCommand.equalsIgnoreCase("backyard")) {
                    backyardCamera.isNowRecording();
                } else if (securityUserCommand.equalsIgnoreCase("front lawn")) {
                    frontLawnCamera.isNowRecording();
                } else if (securityUserCommand.equalsIgnoreCase("back door")) {
                    backDoorCamera.isNowRecording();
                } else if (securityUserCommand.equalsIgnoreCase("side door")) {
                    sideDoorCamera.isNowRecording();
                } else if (securityUserCommand.equalsIgnoreCase("front door")) {
                    frontDoorCamera.isNowRecording();
                } else {
                    System.out.println("Sorry, I did not recognize that, please try again.");
                }
            }
            // Commands to stop recording from security camera
            // Includes each area
            if (userCommand.equalsIgnoreCase("Stop Recording Security Camera")) {
                System.out.println("Ok, which area would you like to stop the recording?");
                String securityUserCommand = console.nextLine();
                if (securityUserCommand.equalsIgnoreCase("doorbell")) {
                    doorbellCamera.stopRecording();
                } else if (securityUserCommand.equalsIgnoreCase("front lawn")) {
                    frontLawnCamera.stopRecording();
                } else if (securityUserCommand.equalsIgnoreCase("driveway")) {
                    drivewayCamera.stopRecording();
                } else if (securityUserCommand.equalsIgnoreCase("side house")) {
                    sideHouseCamera.stopRecording();
                } else if (securityUserCommand.equalsIgnoreCase("backyard")) {
                    backyardCamera.stopRecording();
                } else if (securityUserCommand.equalsIgnoreCase("front lawn")) {
                    frontLawnCamera.stopRecording();
                } else if (securityUserCommand.equalsIgnoreCase("back door")) {
                    backDoorCamera.stopRecording();
                } else if (securityUserCommand.equalsIgnoreCase("side door")) {
                    sideDoorCamera.stopRecording();
                } else if (securityUserCommand.equalsIgnoreCase("front door")) {
                    frontDoorCamera.stopRecording();
                } else {
                    System.out.println("Sorry, I did not recognize that, please try again.");
                }
            }
            // Commands to control motion sensors for each room
            if (userCommand.equalsIgnoreCase("Turn on motion sensors")) {
                System.out.println("Ok, which room would you like to turn on?");
                String motionSensorUserCommand = console.nextLine();
                if (motionSensorUserCommand.equalsIgnoreCase("Main Bedroom")) {
                    mainBedroomMotionSensor.detectMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Kids Bedroom")) {
                    kidsBedroomMotionSensor.detectMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Living room")) {
                    livingRoomMotionSensor.detectMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Kitchen")) {
                    kitchenMotionSensor.detectMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Bathroom")) {
                    bathroomMotionSensor.detectMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Garage")) {
                    garageMotionSensor.detectMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Basement")) {
                    basementMotionSensor.detectMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Home Office")) {
                    homeOfficeMotionSensor.detectMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Attic")) {
                    atticMotionSensor.detectMotion();
                } else {
                    System.out.println("Sorry, I did not recognize that, please try again.");
                }
            }
            // Commands to turn off motion sensors then manually choose lights on for each room
            if (userCommand.equalsIgnoreCase("Turn off motion sensors")) {
                System.out.println("Ok, which room would you like to turn off?");
                String motionSensorUserCommand = console.nextLine();
                if (motionSensorUserCommand.equalsIgnoreCase("Main Bedroom")) {
                    mainBedroomMotionSensor.stopMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Kids Bedroom")) {
                    kidsBedroomMotionSensor.stopMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Living room")) {
                    livingRoomMotionSensor.stopMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Kitchen")) {
                    kitchenMotionSensor.stopMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Bathroom")) {
                    bathroomMotionSensor.stopMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Garage")) {
                    garageMotionSensor.stopMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Basement")) {
                    basementMotionSensor.stopMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Home Office")) {
                    homeOfficeMotionSensor.stopMotion();
                } else if (motionSensorUserCommand.equalsIgnoreCase("Attic")) {
                    atticMotionSensor.stopMotion();
                } else {
                    System.out.println("Sorry, I did not recognize that, please try again.");
                }
            }
            // Commands for TV including turn on/off, adjust volume, and change channels
            if (userCommand.equalsIgnoreCase("Turn on TV")) {
                television.turnTVOn();
            }
            if (userCommand.equalsIgnoreCase("Turn off TV")) {
                television.turnTVOff();
            }
            if (userCommand.equalsIgnoreCase("Adjust TV volume")){
                television.changeTVVolume();
            }
            if (userCommand.equalsIgnoreCase("Change the channel")) {
                television.changeChannel();
            }
            // Commands for sound bar/music including turn on/off, adjust volume, and change songs
            if (userCommand.equalsIgnoreCase("Turn on sound bar")) {
                music.turnSoundBarOn();
            }
            if (userCommand.equalsIgnoreCase("Turn off sound bar")) {
                music.turnSoundBarOff();
            }
            if (userCommand.equalsIgnoreCase("Adjust sound bar volume")){
                music.changeSoundBarVolume();
            }
            if (userCommand.equalsIgnoreCase("Change the song")) {
                music.changeSong();
            } 
            // Commands for HVAC on/off, temperature control
            if (userCommand.equalsIgnoreCase("Turn on central air")) {
                hvac.turnOnHVAC();
            }
            if (userCommand.equalsIgnoreCase("Turn off central air")) {
                hvac.turnOffHVAC();
            }
            if (userCommand.equalsIgnoreCase("Change the home temperature")) {
                hvac.setTemperature();
            }
            // Commands for oven on/off, temperature control, and cook time timer
            if (userCommand.equalsIgnoreCase("Turn on oven")) {
                oven.turnOnOven();
            }
            if (userCommand.equalsIgnoreCase("Turn off oven")) {
                oven.turnOffOven();
            }
            if (userCommand.equalsIgnoreCase("Change the oven timer")) {
                oven.setTimer();
            }
            if (userCommand.equalsIgnoreCase("Change the oven temperature")) {
                oven.changeTemperature();
            }
            // Commands for fridge power saver modes, temperature control, and fridge inventory
            if (userCommand.equalsIgnoreCase("Turn on power saver mode for the fridge")) {
                refrigerator.turnOnPowerSaver();
            }
            if (userCommand.equalsIgnoreCase("Turn off power saver mode for the fridge")) {
                refrigerator.turnOffPowerSaver();
            }
            if (userCommand.equalsIgnoreCase("Change the fridge temperature")) {
                refrigerator.changeTemperature();
            }
            if (userCommand.equalsIgnoreCase("Tell me what is in the fridge")) {
                refrigerator.reviewInventory();
            }
            // Help command
            if (userCommand.equalsIgnoreCase("Help")) {
                System.out.println("Here are the following options you can choose from:");
                for (String instructions : help) {
                    System.out.println(instructions);
                }
            }
            // Command to end system
            if (userCommand.equalsIgnoreCase("Close system")) {
                System.out.println("Shutting down. Good-bye.");
                console.close(); // ends loop and ends smart home system
                break;
            }
            // Returns loop back to beginning until end system command has been made.
            System.out.println("What else would you like me to do?");
        }
    }
}
