
package grades;

// Importing Scanner for console input
import java.util.*;

public class Grades {
    public static void main(String[] args) {
        
        //Initializing scanner to use for input values
        Scanner scanner = new Scanner(System.in);
        
        // Set up code here for inputs of weights of homeworks and exams
        // Entering input code to determine homework and exam 1 weights to
        // determine exam 2 weight.
        System.out.print("Homework and Exam 1 weights? ");
        // Set up input for homework weight
        int homeworkWeight = scanner.nextInt();
        // Set up input for exam 1 weight
        int examOneWeight = scanner.nextInt();
        // Syntax to determine exam 2 weight
        int examTwoWeight = 100 - homeworkWeight - examOneWeight;
        
        // Set up output to confirm weights of homework and exams
        System.out.println("Using weights of " + homeworkWeight + " " + examOneWeight + " " + examTwoWeight + "\nHomework: ");
        
        // Set up code here for number of homework assignments and final scores
        // Creating input line for number of assignments to include in grade
        System.out.print("Number of assignments? ");
        int numberOfAssignments = scanner.nextInt();
        // Creating default values for homework grades
        int totalPoints = 0;
        int earnedPoints = 0;
        // Need to use for loop to continue until number of assignments are fulfilled
        for (int i = 1; i <= numberOfAssignments; i++) {
            System.out.print("Assignment " + i + " score and max? ");
            // Created input syntax for earned homework score and max homework score
            int homeworkScore = scanner.nextInt();
            int maxHomeworkScore = scanner.nextInt();
            // Setting total points to the entered number of the max homework score
            totalPoints += maxHomeworkScore;
            // Setting total points to the entered number of actual homework score
            earnedPoints += homeworkScore;
        }
        
        // Set up code for sections attended and total homework score
        // Creating input line for sections attended
        System.out.print("Sections attended? ");
        // Creating syntax for sections attended
        int numberOfSections = scanner.nextInt();
        // Creating syntax for homework section of points including max of 20 points
        int sectionPoints = Math.min((numberOfSections * 4), 20);
        // Setting total points to entered number of maximum of 20 points per section
        totalPoints += 20;
        // Setting earned points to the calculated number of the section point
        earnedPoints += sectionPoints;
        
        // Calculating total score for homework weight
        System.out.println("Total points = " + earnedPoints + " / " + totalPoints);
        double weightedFinalScore = homeworkWeight * (double) earnedPoints / totalPoints;
        double weightedFinalScoreRounded = Math.ceil(weightedFinalScore * 100.0) / 100.0;
        System.out.println("Weighted score = " + weightedFinalScoreRounded);
        
        // Set up code here for exam 1 score and curve
        System.out.println("Exam 1:");
        // Creating input line for exam score
        System.out.print("Score? ");
        int examOneScore = scanner.nextInt();
        // Creating input line for scoring curve
        System.out.print("Curve? ");
        int examOneCurve = scanner.nextInt();
        // Adding in exam one curve to exam one score.
        examOneScore += examOneCurve;
        // Ensuring score does not exceed 100
        examOneScore = Math.min(examOneScore,100);
        // Total points result is exam one score divided by total score of 100.
        System.out.println("Total points = " + examOneScore + " / " + 100);
        // Determining weighted score
        double weightedFinalExamOneScore = examOneWeight * (double) examOneScore / 100;
        double weightedFinalExamOneScoreRounded = Math.ceil(weightedFinalExamOneScore * 100.0) / 100.0;
        System.out.println("Weighted score = " + weightedFinalExamOneScoreRounded);
        
        // Set up code here for exam 2 score and curve
        // Copying and pasting from exam 1. Making minor adjustments for exam 2.
        System.out.println("Exam 2:");
        // Creating input line for exam score
        System.out.print("Score? ");
        int examTwoScore = scanner.nextInt();
        // Creating input line for scoring curve
        System.out.print("Curve? ");
        int examTwoCurve = scanner.nextInt();
        // Adding in exam two curve to exam two score.
        examTwoScore += examTwoCurve;
        // Ensuring score does not exceed 100
        examTwoScore = Math.min(examTwoScore,100);
        // Print out results of exam
        // Total points result is exam one score divided by total score of 100.
        System.out.println("Total points = " + examTwoScore + " / " + 100);
        // Determining weighted score
        double weightedFinalExamTwoScore = examTwoWeight * (double) examTwoScore / 100;
        double weightedFinalExamTwoScoreRounded = Math.ceil(weightedFinalExamTwoScore * 100.0) / 100.0;
        System.out.println("Weighted score = " + weightedFinalExamTwoScoreRounded);

        // Final component
        // Output of all values and final grade here
        double courseGrade = weightedFinalExamTwoScore + weightedFinalExamOneScore + weightedFinalScore;
        double courseGradeRounded = Math.ceil(courseGrade * 100.0) / 100.0;
        System.out.println("Course grade = " + courseGradeRounded);
    }
    
}
