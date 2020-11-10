import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
/**
 * Description: Welcome to the UW Bothell Student Dental Care! In this 
 * program, we will calculate your Dental Bill. To hide information from 
 * others, the doctors will give you a paper which tells you which appointment
 * you've chosen and how much they cost. (user input... it could be any number)
 * If you didn't file for an appointment then enter 0.
 * After you've entered all the appointment costs, we'll calculate the total
 * amount that you'll have to pay. If you entered more than the total, we'll 
 * give you your change back. After that, we'll give you the Bill in a txt 
 * File.(Keep in mind that we can only account for onevperson. SO One person,
 * one bill).
 * 
 * Known Bugs: None
 * 
 * @author Sung Ho Park
 * @version 1
 */
public class DentistDriver
{
    /**
     * This is the method that will output all the information given in the 
     * Dentist Class and put it in a text file.
     */
    public static void main(String[] args)
    {
        //Set PrintWriter to null as default initialization
        PrintWriter outputStream = null;

        //Number 5 in the criteria. Output to Text File 
        try
        {
            outputStream = new PrintWriter(new FileOutputStream
                ("DentistBill.txt"));

            //Call the Class Dentist and display the report
            Dentist getInfo = new Dentist();
            getInfo.reportDentist();
            getInfo.checkNumbersValid();
            getInfo.calculateBill();

            //Get all the instance variables in the class Dentist
            String name = getInfo.getName();
            double cavityCost = getInfo.getCavity();
            double bracesCost = getInfo.getBraces();
            double whiteningCost = getInfo.getWhitening();
            double gumSurgeryCost = getInfo.getGumSurgery();
            double oralCancerCost = getInfo.getOralCancer();
            double totalCost = getInfo.getTotal();
            double customerCost = getInfo.getCustomerPay();
            double changeBack = getInfo.getChange();
            String dollarSign = "$";

            //Output information to the file "DentalBill.txt"
            //and the formatting
            outputStream.println(name + '\n');
            outputStream.println("       UW Bothell Dental Care       ");
            outputStream.println("--------------------------------------");
            outputStream.printf("Cavity: %23s%.2f%n", dollarSign,
                cavityCost);
            outputStream.printf("Braces: %23s%.2f%n", dollarSign,
                bracesCost);
            outputStream.printf("Whiten: %23s%.2f%n", dollarSign, 
                whiteningCost);
            outputStream.printf("Gum Surgery: %18s%.2f%n", dollarSign,
                gumSurgeryCost);
            outputStream.printf("Oral Cancer Exam: %13s%.2f%n",dollarSign,
                oralCancerCost);  
            outputStream.println("--------------------------------------");
            outputStream.printf("Total: %24s%.2f%n",dollarSign, totalCost);
            outputStream.printf("Customer paid: %16s%.2f%n", dollarSign,
                customerCost);
            outputStream.printf("Change back: %18s%.2f%n", dollarSign,
                changeBack);

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot find file.");
            System.exit(0);
        }

        outputStream.close();
        System.out.println("\nAll information should be in the DentistBill.txt");

        //Number 10 on the criteria: Test Variables
        //test();
    }

    /**
     * The only purpose to this method is to trace the variables. Just to make
     * sure that what is being inputted works before it moves on to the 
     * calculation. It will ask the user to enter in values again. You can 
     * make the values the same as before or you can set the values as 
     * different numbers. 
     * 
     * Example:
     * Cavity: 12
     * Braces: 12
     * WhiteningTest: 12
     * Gum Surgery: 12
     * Oral Cancer Examination: 12
     * 
     * 12 12 12 12 12
     * 
     */
    public void test()
    {
        //Make a new object and call the instance method.
        Dentist test = new Dentist();
        test.checkNumbersValid();
        //Call the accessor method to get the instance variables.
        double cavityTest = test.getCavity();
        double bracesTest = test.getBraces();
        double whiteningTest = test.getWhitening();
        double gumSurgeryTest = test.getGumSurgery();
        double oralCancerTest = test.getOralCancer();
        //Display it.
        System.out.print(cavityTest + " " + bracesTest + " " 
            + whiteningTest + " " + gumSurgeryTest +
            " " + oralCancerTest );
    }
}
