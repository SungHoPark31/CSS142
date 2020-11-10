import java.util.Scanner;
/**
 * Description: This is the Class that will prompt the user to enter 3 values 
 * that will take those values, set it as instance variables, and sort the 
 * ascending order. 
 *
 * @author Sung Ho Park
 * @version 1.0
 */
public class Race
{
    // instance variables
    private double time1;
    private double time2;
    private double time3;

    /**
     * This is an accessor method. It's main purpose is to access the instance
     * variables so that it can be used. In this case, it is time1.
     */
    public double getTime1()
    {
        //Access to get the instance variables because private instance 
        //variables cannot be changed unless it is accessed.
        return time1;
    }

    /**
     * This is an accessor method. It's main purpose is to access the instance
     * variables so that it can be used. In this case, it is time2.
     */
    public double getTime2()
    {
        // initialize instance variables
        return time2;
    }

    /**
     * This is an accessor method. It's main purpose is to access the instance
     * variables so that it can be used. In this case, it is time3.
     */
    public double getTime3()
    {
        // initialize instance variables
        return time3;
    }

    /**
     * This is a mutator method. It's main purpose is to set the instance 
     * variable so that the values inside the instance variable changes. 
     * 
     * For an example: If the user enters 3 numbers then these instance 
     * variables are set to the values that the user inputted. After it is 
     * looped, then the instance variables will reset to 0, and will be set
     * to the new values that the user inputted.
     */
    public void setTime()
    {
        //Invalid times
        if(time1 < 0 || time1 == 0 || time2 < 0 || time2 == 0 
        || time3 < 0 || time3 == 0)
        {
            System.out.println("Invalid Numbers");
            System.exit(0);
        }
        else
        {
            //this. will set the instance variable to the current value that
            //the user assigned. 
            this.time1 = time1;
            this.time2 = time2;
            this.time3 = time3;
        }
    }

    /**
     * Description: Prompt the user to enter the race in times. Then it will 
     * store the values that the user inputted to instance variable.
     *
     * Precondition: All instance variables should have values.
     * Postcondition: It should return the 3 numbers that the user inputted.
     */
    public void readInTimes()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the race times (in seconds): ");
        this.time1 = keyboard.nextDouble();
        this.time2 = keyboard.nextDouble();
        this.time3 = keyboard.nextDouble();
    }

    /**
     * Description: This will sort the values that the user inputted to 
     * ascending order, smallest (1st place), middle (2nd place), and largest
     * (3rd place) and display the result.
     *
     * @param  double racer1, double racer2, double racer3
     * @return double maxNum, double middleNum, double minNum
     * 
     * Precondition: All racers should have values in the variables.
     * Postcondition: It should display the numbers that are ascending.
     */
    public void sortTimesAscending(double racer1, double racer2, double racer3)
    {
        //Initialize and declare the variable that will be used to 
        //find min, max, and middle number.
        double maxNum = 0.0;
        double minNum = 0.0;
        double middleNum = 0.0;

        //The minimum, 1st place.
        minNum = Math.min(this.time1, this.time2);
        minNum = Math.min(minNum, this.time3);

        //The maximum, 3rd place.
        maxNum = Math.max(this.time1, this.time2);
        maxNum = Math.max(maxNum, this.time3);

        //All the criteria for the middle number.
        if(this.time1 > this.time2 && this.time1 < this.time3)
        {
            middleNum = this.time1; 
        }
        else if(this.time1 < this.time2 && this.time1 > this.time3)
        {
            middleNum = this.time1; 
        }
        else if(this.time1 < this.time2 && this.time2 < this.time3)
        {
            middleNum = this.time2; 
        }
        else if(this.time1 > this.time2 && this.time2 > this.time3) 
        {
            middleNum = this.time2; 
        }
        else if(this.time1 > this.time2 && this.time2 < this.time3)
        {
            middleNum = this.time3; 
        }
        else if(this.time1 < this.time2 && this.time2 > this.time3)
        {
            middleNum = this.time3; 
        }
        else if(this.time1 == this.time2)
        {
            middleNum = minNum;
        }
        else
        {
            middleNum = maxNum;
        }

        //Print out to the screen.
        System.out.println("\nFirst Place (time in seconds): " + minNum);
        System.out.println("Second Place (time in seconds): " + middleNum);
        System.out.println("Third Place (time in seconds): " + maxNum + "\n");
    }

}
