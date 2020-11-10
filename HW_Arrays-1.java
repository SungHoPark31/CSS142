import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * This program will calculate the velocity of a sky diver at a time. The 
 * weight, cross sectional area, drag coefficient, air density, time,
 * time step and gravity towards the earth are all given. If needed, there
 * is an Excel graph that goes through this. Make sure that you use the 
 * given. 
 * 
 * Known bugs: No known bugs detected.
 * 
 * @author sunghopark
 * @version 1.0
 */
public class HW_Arrays 
{
    //Naming Constants
    public static final double EARTH_GRAVITY = 9.81;
    public static final double AIR_DENSITY = 1.14;

    /**
     * Most of the code will be in the main method. This will create a csv
     * file, calculate, store the values in an array, display the values in 
     * a csv file.
     * 
     */
    public static void main(String[] args) 
    {
        //Initialize the response
        String response;

        //Execute the program at least once.
        do
        {
            //Prompt the user and user input
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter the mass of the skydiver (kg): " );
            double mass = keyboard.nextDouble();
            System.out.print("Enter the cross-sectional "
                + "area of the skydiver (m^2): ");
            double crossSectionalArea = keyboard.nextDouble();
            System.out.print("Enter the drag coefficient of the skydiver: ");
            double dragCoefficient = keyboard.nextDouble();
            System.out.print("Enter the ending time (sec): ");
            double seconds = keyboard.nextDouble();
            System.out.print("Enter the time step: ");
            double timeStep = keyboard.nextDouble();
            System.out.print("Enter the output filename (add .csv in the "
                + "end): ");
            String name = keyboard.next();
            String fileNameWithExtension = name + ".csv";
            //This creates the csv file
            PrintWriter outputStream = null;
            try
            {
                outputStream = new PrintWriter
                (new FileOutputStream(fileNameWithExtension));
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File cannot be created!");
                System.exit(0);
            }

            /* This is the test
            test(mass, crossSectionalArea, dragCoefficient, 
            seconds, timeStep); */

            System.out.println("Writing the out file. Here are the"
                + " first few lines:");

            //This the equation (CpaA)/2m 
            double partialDrag = ((dragCoefficient * crossSectionalArea 
                        * AIR_DENSITY) / (2 * mass));

            //This will be the starting time (which will be t in the equation)
            //so that velocity initially starts at 0.
            double velocityAtCurrentTime = 0.0;

            //Since velocity has to be 0 initially, everything should cancel
            //out but the gravitational pull of the person from the earth so 
            //it'll be just 9.81 * 0.1... (0.1 is delta T)
            double velocityAtStartingTime = 0.1 * EARTH_GRAVITY;

            //This is the length of the array and typecast it because you 
            //can't have a double length of the array.
            double totalLength = seconds / timeStep;
            int intTotalLength = (int)totalLength;

            double[] timeArray = new double[intTotalLength];
            double[] velocityArray = new double[intTotalLength];

            //Goes through each line and prints out the calculations 
            //in each line.
            for(int i = 0; i < intTotalLength; i++)
            {
                //This will print to the console and still make sure
                //to put it in the csv file.
                if(i < 9)
                {
                    //Calculation using the formula.
                    velocityAtCurrentTime = velocityAtStartingTime + 
                    ((EARTH_GRAVITY - (partialDrag * 
                                Math.pow((velocityAtStartingTime), 2))) * 0.1);

                    //Store it in an array
                    timeArray[i] = timeStep;
                    velocityArray[i] = velocityAtCurrentTime;

                    //Print to console
                    System.out.printf("%.3f, %.4f", timeStep,
                        velocityAtStartingTime);
                    System.out.println("");

                    //Print to the csv file
                    outputStream.printf("%.3f, %.4f", timeStep,
                        velocityAtStartingTime);

                    outputStream.println("");
                }
                else
                {
                    //This will calculate but only print out in the 
                    //csv file.
                    velocityAtCurrentTime = velocityAtStartingTime + 
                    ((EARTH_GRAVITY - (partialDrag * 
                                Math.pow((velocityAtStartingTime), 2))) * 0.1);

                    timeArray[i] = timeStep;
                    velocityArray[i] = velocityAtCurrentTime;

                    outputStream.printf("%.3f, %.4f", timeStep,
                        velocityAtStartingTime);

                    outputStream.println("");
                }

                timeStep += 0.1;

                velocityAtStartingTime = velocityAtCurrentTime;
            }

            System.out.print("Enter another dive? (y/n): ");
            response = keyboard.next();

            //This will terminate the program if "n" is typed and it'll keep 
            //looping if "y" is typed.

            //Close the outputStream file.
            outputStream.close();
        } while(response.equalsIgnoreCase("y"));
    }

    /**
     * This is a method that is called in the main. It's sole purpose is to 
     * make sure that it traces these variables and what the terminal 
     * velocity is. Which means after the calculation done in main, 
     * the answer in main should equal to the answer expected in the main.
     * 
     * @param mass
     * @param crossSectionalArea
     * @param dragCoefficient
     * @param time
     * @param timeStep 
     * 
     * Example:
     * 80       mass
     * 1.035    crossSectionalArea
     * 0.581    dragCoefficient 
     * 16       time
     * 0.1      timeStep
     * 
     * This should be the velocity: 46.74m/s.
     */
    public static void test(double mass, double crossSectionalArea, 
    double dragCoefficient, double time, double timeStep)
    {
        System.out.println(mass);
        System.out.println(crossSectionalArea);
        System.out.println(dragCoefficient);
        System.out.println(time);
        System.out.println(timeStep);

        double force = mass * EARTH_GRAVITY;
        double velocitySquared = force / ((dragCoefficient * crossSectionalArea 
                    * AIR_DENSITY) / (2));
        double velocityExpectation = Math.sqrt(velocitySquared);
        System.out.printf("This should be the velocity at %.1f seconds: "
            + "%4.2f m/s", time, velocityExpectation);
        System.out.println(""); 
    }
}
