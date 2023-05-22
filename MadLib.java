

package com.madlib;

//Imports random and imports Scanner
import java.util.*;
//To read files
import java.io.*;

public class MadLib {
    
    // Imports scanner
    Scanner scanner = new Scanner(System.in);
    
    // Creates array list for names, nouns, adjectives, verbs, and places
    // Privating for encapsulation
    private ArrayList<String> namesList = new ArrayList<>();
    private ArrayList<String> nounsList = new ArrayList<>();
    private ArrayList<String> adjList = new ArrayList<>();
    private ArrayList<String> verbsList = new ArrayList<>();
    private ArrayList<String> placesList = new ArrayList<>();
    
    
    
    public MadLib() throws FileNotFoundException { // Prevents error caused if file is not found
        
        // Still getting filenotfoundexception error
        // calls text file names
        File nameFile = new File("names.txt"); 
        // calls text file nouns
        File nounFile = new File("nouns.txt"); 
        // calls text file adjectives
        File adjFile = new File("adjectives.txt");
        // calls text file verbs
        File verbsFile = new File("verb.txt"); 
        // calls text file places
        File placesFile = new File("places.txt"); 
        
        Scanner names = new Scanner(nameFile); // reads names text file for input
        Scanner nouns = new Scanner(nounFile); // reads nouns text file for input
        Scanner adjectives = new Scanner(adjFile); // reads adjectives text file for input
        Scanner verbs = new Scanner(verbsFile); // reads verbs text file for input
        Scanner places = new Scanner(placesFile); // reads places text file for input
        
        while (names.hasNextLine()) {
            namesList.add(names.nextLine()); // adds words from names file to names array list
        }
        
        while (nouns.hasNextLine()) {
            nounsList.add(nouns.nextLine()); // adds words from nouns file to nouns array list
        }
        
        while (adjectives.hasNextLine()) {
            adjList.add(adjectives.nextLine()); // adds words from adjectives file to adjectives array list
        }
        
        while (verbs.hasNextLine()) {
            verbsList.add(verbs.nextLine()); // adds words from verbs file to verbs array list
        }
        
        while (places.hasNextLine()) {
            placesList.add(places.nextLine()); // adds words from places file to places array list
        }   
    }
    
    // Utilizes random and returns a word from a randomly chosen index
    // Using list to apply parameter to all above ArrayLists
    private int getRandomizeMadLibIndex(ArrayList<String> list) {
        return (int) (Math.random() * list.size());
    }
    
    // Creates game
    public void playMadLib() throws FileNotFoundException {
        // Calling random for namesList
        String names = namesList.get(getRandomizeMadLibIndex(namesList)); // Calling random for namesList
        String names2 = namesList.get(getRandomizeMadLibIndex(namesList)); 
        String names3 = namesList.get(getRandomizeMadLibIndex(namesList)); 
        
        // Calling random for nounsList
        String nouns = nounsList.get(getRandomizeMadLibIndex(nounsList)); 
        String nouns2 = nounsList.get(getRandomizeMadLibIndex(nounsList)); 
        String nouns3 = nounsList.get(getRandomizeMadLibIndex(nounsList)); 
        String nouns4 = nounsList.get(getRandomizeMadLibIndex(nounsList)); 
        String nouns5 = nounsList.get(getRandomizeMadLibIndex(nounsList)); 
        String nouns6 = nounsList.get(getRandomizeMadLibIndex(nounsList)); 
        String nouns7 = nounsList.get(getRandomizeMadLibIndex(nounsList)); 
        String nouns8 = nounsList.get(getRandomizeMadLibIndex(nounsList)); 
        String nouns9 = nounsList.get(getRandomizeMadLibIndex(nounsList)); 
        String nouns10 = nounsList.get(getRandomizeMadLibIndex(nounsList)); 
        
        // Calling random for adjList
        String adjectives = adjList.get(getRandomizeMadLibIndex(adjList)); 
        String adjectives2 = adjList.get(getRandomizeMadLibIndex(adjList)); 
        String adjectives3 = adjList.get(getRandomizeMadLibIndex(adjList)); 
        String adjectives4 = adjList.get(getRandomizeMadLibIndex(adjList)); 
        String adjectives5 = adjList.get(getRandomizeMadLibIndex(adjList));
        
        // Calling random for verbsList
        String verbs = verbsList.get(getRandomizeMadLibIndex(verbsList)); 
        String verbs2 = verbsList.get(getRandomizeMadLibIndex(verbsList)); 
        
        // Calling random for placesList
        String places = placesList.get(getRandomizeMadLibIndex(placesList));
        String places2 = placesList.get(getRandomizeMadLibIndex(placesList));
        
        // Printing madlib
        System.out.println("Once upon a time, in a far away land of " + places + ",");
        System.out.println("There was a wonderful, " + adjectives + " " + nouns + " named " + names + ".");
        System.out.println("They lived with their loyal " + nouns2 + " named " + names2 + ".");
        System.out.println("One day, while " + names + " was " + verbs + "-ing in " + places + ", they stumbled");
        System.out.println("upon a mysterious " + nouns3 + ".");
        System.out.println();
        System.out.println("With their curiosity piqued, " + names + " approached the " + nouns3 + " cautiously.");
        System.out.println("As they touched it, a(n) " + adjectives2 + " light engulfed them, transporting them to " + places2  + ".");
        System.out.println("In this realm, everything was " + adjectives3 + ".");
        System.out.println("The trees whispered secrets, and the sky shimmered with a million " + nouns4 + "s.");
        System.out.println();
        System.out.println(names + " embarked on a quest to find the legendary " + nouns5 + ", said to possess the unimaginable power.");
        System.out.println("Along the way, they encountered a wise old " + nouns6 + " named " + names3+ " who offered guidance");
        System.out.println("and bestowed upon " + names + " a magical " + nouns7 + ".");
        System.out.println();
        System.out.println("Through treacherous " + adjectives4 + " forests and across vast " + nouns8 + "s, " + names + " persevered.");
        System.out.println("They faced numerous challenges and battled the fearsome " + nouns9 + ".");
        System.out.println("With each triumph, their confidence grew, and their bond with their loyal " + nouns2 + " deepens.");
        System.out.println();
        System.out.println("Finally, after a long journey, " + names + " reached the heart of the " + places2 + ".");
        System.out.println("There, " + verbs2 + "-ing before the  majestic " + nouns10 + ", they realized that the true power");
        System.out.println("was not in possessing the " + nouns5 + ", but in the strength of their heart and the bonds they had formed.");
        System.out.println();
        System.out.println("Filled with newfound wisdom, " + names + " finally returned to " + places + " with a grateful heart.");
        System.out.println("They shared their " + adjectives5 + " tale with their friends and family,");
        System.out.println("to embrace adventure, courage, and the magic that lies within.");
        System.out.println();
        System.out.println("And so, " + names + "'s legend lives on, a testament to the power of dreams,");
        System.out.println("and the endless possibilities of the " + nouns + " spirit.");
        System.out.println();
        System.out.println("The End.");
    }
    
    public static void main(String[] args) throws FileNotFoundException { // Ensures code can be read
        // Brings forth original madlib class to apply to play madlib
        MadLib madLib = new MadLib();
        madLib.playMadLib(); // Initiates and prints randomized madlib
    }
}
