import java.util.Scanner;
/**
 * Description: The first thing that this class does is that it will create 
 * the object of the class Race. What this does is that it writes out the
 * report of the information that the user inputted.After it is created, it  
 * will call the methods that will display the prompt,the user input and the
 * ascending order. After the ascending order, it will then calculate the 
 * average and the range and display it on the screen.
 * 
 * @author Sung Ho Park
 * @version 1.0
 */
public class RaceReport
{
    //Instance variables.
    private double average;
    private double range;

    /**
     * This is an accessor method. It's main purpose is to access the instance
     * variables so that it can be used. In this case, it is the average.
     */
    public double getAverage()
    {
        //Access to get the instance variables because private instance 
        //variables cannot be changed unless it is accessed.
        return average;
    }

    /**
     * This is an accessor method. It's main purpose is to access the instance
     * variables so that it can be used. In this case, it is the range.
     */
    public double getRange()
    {
        // initialise instance variables
        return range;
    }

    /**
     * This is a mutator method. It's main purpose is to set the instance 
     * variable so that the values inside the instance variable changes. 
     * 
     * For an example: If the user enters 3 numbers then it'll find the range
     * of whatever the user inputted. After it is looped, the range is 
     * resetted to 0 and will find whatever the next 3 numbers that the user 
     * inputted.
     */
    public void setRange()
    {
        //If there is invalid values.
        if(range < 0 || range == 0)
        {
            System.out.println("Invalid Range.");
            System.exit(0);
        }
        else
        {
            //this . will set the instance variable to the current value that
            //the user assigned. 
            this.range = range; 
        }
    }

    /**
     * This is a mutator method. It's main purpose is to set the instance 
     * variable so that the values inside the instance variable changes. In
     * this case, it is the average.
     * 
     * For an example: If the user enters 3 numbers then it'll find the average
     * of whatever the user inputted. After it is looped, the average is 
     * resetted to 0 and will find whatever the next 3 numbers that the user 
     * inputted.
     * 
     */
    public void setAverage()
    {
        //If there is invalid values.
        if(average < 0 || average == 0)
        {
            System.out.println("Invalid Numbers");
            System.exit(0);
        }
        else
        {
            //this . will set the instance variable to the current value that
            //the user assigned. 
            this.average = average;
        }
    }

    /**
     * Description: This method is writting the report of the race. It creates
     * the object and calls the objects method. After it does that, it will
     * find the range of the 3 numbers (Maximum number - Minimum Number) and 
     * find the average of the 3 numbers. It will also display if the racers
     * are tied in some way.
     * 
     * Precondition: All the instance variables should have values. 
     * 
     * Postcondition: Display the information of the user input, Times 
     * ascending, range, and average.
     */
    public void writeReport()
    {
        //Create the object
        Race getInput = new Race();

        //Call the method that will prompt the user to enter times.
        getInput.readInTimes();

        //Using the accessor method, it will get the instance variables
        //after the user inputs the times.
        double racer1 = getInput.getTime1();
        double racer2 = getInput.getTime2();
        double racer3 = getInput.getTime3();

        //This will help with calculating the range later.
        double max = 0.0;
        double min = 0.0; 

        //The sorting method from the Race class. Make sure that the object
        //is called followed by a dot.
        getInput.sortTimesAscending(racer1, racer2, racer3);

        //This will display if they are tied.
        if(racer1 == racer2)
        {
            System.out.println("Two racers shared First Place");
        }
        else if(racer2 == racer3)
        {
            System.out.println("Two racers shared Second Place");
        }
        else
        {
            System.out.print("");
        }

        //Calculates the range.
        max = Math.max(racer1, Math.max(racer2, racer3));
        min = Math.min(racer1, Math.min(racer2, racer3));

        this.range = max - min;

        System.out.printf("The range of the race times " +
            "(in seconds): %.2f%n" , this.range);

        //Calculates the average.                    
        this.average = (racer1 + racer2 + racer3) / 3;
        System.out.printf("The average of the race times " +
            "(in seconds): %.2f%n" , this.average);

    }
}
