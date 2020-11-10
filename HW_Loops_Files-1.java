import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program will read from a file: "courseData.txt" and it will take 
 * a class and display the student id, program score, midterm score,
 * final score and it in a formatted screen and loop it so that it gets each 
 * student. It will break the loop if a 0 is met and start the process again 
 * on a new class. It will also calculate the weighted average for each student
 * and calculate a class average.
 * 
 * @author sunghopark
 * @version 1.0
 */
public class HW_Loops_Files 
{
    //Class constants. In this case, the weights.
    public static final double PROGRAM_WEIGHT = 0.30;
    public static final double MIDTERM_WEIGHT = 0.30;
    public static final double FINAL_WEIGHT = 0.40;

    /**
     * This is the main method that will take the file and read the inputs as 
     * integers. It will then display those inputs and it will calculate the 
     * weighted average and take the average of the class.
     * The calculation will be provided in the main. 
     */
    public static void main(String[] args)
    {
        //Scanner is used to read an input file.
        Scanner input = null;  

        //try-catch method to see if the file can be read or created.
        try
        {
            //Read the file.
            input = new Scanner (new FileInputStream("courseData.txt"));

            //This will iterate how many classes there are.
            for(int i = 0; i < 3; i++)
            {
                //This will iterate the course and display each student.
                while(input.hasNextLine())
                {
                    int courseNumber; 

                    //This will skip the decimals in the beginning of the 
                    //Text file.
                    String skipDecimals = input.nextLine(); 

                    //This is checking if input has an integer that can be 
                    //read as an int. Also this will prevent any errors.
                    if(input.hasNextInt())
                    {
                        courseNumber = input.nextInt();
                        System.out.printf("\nGrade Data for Class %d%n", 
                            courseNumber);
                        System.out.println("\n ID   Programs  Midterm  Final"
                            + "   Weighted " + "Average  Programs Grade");
                        System.out.println(" --   --------  -------  -----" + 
                            "   --------" + "-------   --------------");

                        //initialization.
                        int ID = 0;
                        int programScore = 0;
                        int midtermScore = 0;
                        int finalScore = 0;
                        double weightedAverage = 0;
                        int numOfAverage = 0;

                        double classSum = 0 ;
                        double classAverage = 0;

                        // Loop to handle one class:
                        // For each student in the class, get and print their
                        // information, compute their avg, and sum the avgs. 
                        while (input.hasNextLine())
                        {
                            //Get the inputs from the text file.
                            ID = input.nextInt();
                            if(ID == 0)
                            {
                                break;
                            }
                            programScore = input.nextInt();
                            midtermScore = input.nextInt();
                            finalScore = input.nextInt();

                            input.nextLine();

                            
                            weightedAverage = (PROGRAM_WEIGHT * programScore)
                            + (MIDTERM_WEIGHT * midtermScore) + 
                            (finalScore * FINAL_WEIGHT);

                            if(programScore >= 70)
                            {
                                System.out.printf("%-8d%-9d%-8d%-11d%-13.2f "
                                    + "Pass%n", ID,programScore, midtermScore,
                                    finalScore, weightedAverage);
                            }
                            else
                            {
                                System.out.printf("%-8d%-9d%-8d%-11d%-13.2f "
                                    + "Fail%n", ID,programScore, midtermScore,
                                    finalScore, weightedAverage);
                            } 
                            //calculate the sum of the classes weighted 
                            //average.
                            classSum = classSum + weightedAverage;

                            //counts each number of averages
                            numOfAverage++;

                            /*This is the test to see what is outputted

                            testVariables(ID, programScore, midtermScore, 
                            finalScore,classAverage);
                             */ 
                        }
                        // compute and print class average
                        classAverage = classSum / numOfAverage;
                        System.out.printf("Class Average: %.2f%n", 
                            classAverage);
                    }
                    else 
                    {
                        courseNumber = 0;
                    }
                }
            }
            //Close the input file
            input.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File has not been found!");
            System.exit(0);
        }
    }

    /**
     * This will display the numbers that the will output the inputted 
     * numbers, but the purpose is to see what is outputed. This will output
     * everything in the next line and to be sure, it'll print after the 
     * first iteration of each student. Again, this is to make sure that
     * everything is outputting correctly.
     * 
     * @param int ID, int programScore, int midtermScore,
     *                              int finalScore, double classAverage
     * Ex.
     * 7777     Student Id
     * 90       program Score
     * 90       midterm score
     * 90       final score
     * 83.65    Weighted average
     */
    public static void testVariables(int ID, int programScore, 
    int midtermScore, int finalScore, double classAverage)
    {
        System.out.println(ID);
        System.out.println(programScore);
        System.out.println(midtermScore);
        System.out.println(finalScore);
        System.out.println(classAverage);
    }
}
