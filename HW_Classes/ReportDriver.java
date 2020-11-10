import java.util.Scanner;
/**
 * Description: Race day. In this program, it will prompt the user to enter 
 * 3 times. It doesn't matter if the times are integers or double, it will
 * typecast to a double automatically. After the user enters in 3 times, the 
 * program will compute which times is the smallest (1st place), the middle 
 * (2nd place), and the largest (3rd place). It will then calculate the range
 * and the average of the 3 racer times. 
 * 
 * Known bugs: No known bugs found. 
 * 
 * @author Sung Ho Park
 * @version 1.0
 */
public class ReportDriver
{
    /**
     * Description: This is the main method. What this will do is to create 
     * an object and call it's methods. This will allow for displaying the 
     * information/report of the user input. After the user inputs the 
     * times, it will then ask the user if they want to enter another race.
     * If yes, loop and restart, if no, end the program.
     */
    public static void main(String[] args)
    {
        //Declare and initialize the response 
        String response = "";

        //Execute at least once
        do
        {
            //Create/Construct the object
            RaceReport input = new RaceReport();

            //Call the method by having the object first followed by a dot.
            input.writeReport();

            //Prompt the user to Enter another race using a Scanner class.
            Scanner keyboard = new Scanner(System.in);
            System.out.println();
            System.out.print("Enter another race? (y/n): ");
            response = keyboard.next();
            System.out.println();
        }while (response.equalsIgnoreCase("y"));
    }

    /**
     * Description: This is a test method. It's only purpose is to test/trace
     * the variables. It will ask you to enter the times again and it will 
     * display the times.
     * 
     * Output: 
     * Enter the race times (in seconds): 
     * 2 3 4
     * 
     * 2 
     * 3
     * 4
     */
    public void test()
    {
        //Call the object 
        Race test = new Race();
        //Get the method
        test.readInTimes();
        //Print the output.
        System.out.println(test.getTime1());
        System.out.println(test.getTime2());
        System.out.println(test.getTime3());
    }
}
