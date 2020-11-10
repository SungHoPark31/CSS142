import java.util.Scanner;

/**
 * HW_Branching prompts the user to enter the sales for 3 stores. After all 
 * the inputs are in for each store, the program will then ask for a 
 * threshold that the stores have reach. If the threshold is met, then the 
 * program will display which store met the threshold and the average sales 
 * of the stores that met the threshold. If no store met the threshold, then 
 * the program will display "No store met the threshold".
 *
 * @author Sung Ho Park
 * @version 1.0
 */
public class HW_Branching
{
    /** This is the main program itself. This will take inputs and 
     * put out if the stores made the threshold or if it didn't and
     * to check the average.
     */
    public static void main(String[] args) 
    {
        //Scanner is added for inputs.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the sales for Store 1: ");
        
        //Inputs the store sales as a double.
        double store1Sales = keyboard.nextDouble();

        System.out.println("Enter the sales for Store 2: ");
        double store2Sales = keyboard.nextDouble();

        System.out.println("Enter the sales for Store 3: ");
        double store3Sales = keyboard.nextDouble(); 

        System.out.println("Enter the sales threshold: ");
        double threshold = keyboard.nextDouble();

        /** Nested ifs are used to figure out which stores met the 
         * threshold if the stores meet the threshold, then it'll 
         * display which store met the threshold and the average of
         * each store. If none of the stores meet the threshold, 
         * then it'll say no store met the threshold.
         */
        
        if(store1Sales >= threshold && store2Sales >= threshold
                                        && store3Sales >= threshold)
        {
            //In the case if all the stores meet the threshold.
            System.out.println("All the stores did great!");
            //Take the average.
            double average = (store1Sales + store2Sales + store3Sales) / 3;
            System.out.printf("The average sales for exceeding stores:"
                                + " %1.2f%n", average);
        }
        else if(store1Sales >= threshold && store2Sales >= threshold)
        {
            //Only store 1 and 2 met the threshold.
            System.out.println("Store 1 and Store 2 did great!");
            double average = (store1Sales + store2Sales) / 2;
            System.out.printf("The average sales for exceeding stores:"
                                + " %1.2f%n", average);
        }
        else if(store2Sales >= threshold && store3Sales >= threshold)
        {
            //Only store 2 and 3 met the threshold.
            System.out.println("Store 2 and Store 3 did great!");
            double average = (store2Sales + store3Sales) / 2;
            System.out.printf("The average sales for exceeding stores:"
                                + " %1.2f%n", average);
        }
        else if(store1Sales >= threshold && store3Sales >= threshold)
        {
            //Only store 1 and 3 met the threshold.
            System.out.println("Store 1 and Store 3 did great!");
            double average = (store1Sales + store3Sales) / 2;
            System.out.printf("The average sales for exceeding stores:"
                                 + " %1.2f%n", average);
        }
        else if(store1Sales >= threshold)
        {
            //Only store 1 met the threshold.
            System.out.println("Store 1 did great!");
            double average = store1Sales;
            System.out.printf("The average sales for exceeding stores:"
                                 + " %1.2f%n", average);
        }
        else if(store2Sales >= threshold)
        {    
            //Only store 2 met the threshold.
            System.out.println("Store 2 did great!");
            double average = store2Sales;
            System.out.printf("The average sales for exceeding stores:"
                                 + " %1.2f%n", average);
        }
        else if(store3Sales >= threshold)
        {
            //Only store 3 met the threshold.
            System.out.println("Store 3 did great!");
            double average = store3Sales;
            System.out.printf("The average sales for exceeding stores:"
                                 + " %1.2f%n", average);
        }
        else 
        {
            //None of them met the threshold.
            System.out.println("No store met the threshold.");
        }
    }
}
