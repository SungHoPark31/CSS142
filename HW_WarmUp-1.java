import java.util.Scanner;

public class HW_WarmUp 
{
    //Driver for if statement warm up
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        //TODO 1
        System.out.println("Enter a number: ");
        int input = keyboard.nextInt();
      
        if(input < 0)
        {
            System.out.println("This number is negative. ");
        }
        else 
        {
            System.out.println("This number is positive. ");
        }
        
        //TODO 2
        System.out.println('\n' + "Enter a second number: ");
        int number = keyboard.nextInt();
        
        if(number == 0)
        {
            System.out.println("The number is a zero."); 
        }
        else 
        {
            System.out.println("This is not zero.");
        }
        
        //TODO 3
        System.out.println('\n' + "Enter a third number, a double, for "
                            + "the class average: ");
        double average = keyboard.nextDouble();
        
        if(average >= 65)
        {
            System.out.println("A passing grade.");
        }
        else
        {
            System.out.println("Not a passing grade.");
        }
        
        //TODO 4 & TODO 5
        System.out.println('\n' + "Is the user reported true? Enter a boolean"
                            + " value (True or False): ");
        boolean answer = keyboard.nextBoolean();
        
        if(answer == true)
        {
            System.out.println("The value was correct.");
        }
        else
        {
            System.out.println("The value was false.");
        }
        
        //TODO 6
        System.out.println('\n' + "Enter a number as an integer and we'll "
                             + "determine whether it is even or odd: ");
        int number1 = keyboard.nextInt();
        
        if (number1 % 2 == 0)
        {
            System.out.println(number1 + " is even.");
        }
        else
        {
            System.out.println("The number is odd.");
        }
        
        //TODO 7 & TODO 8
        System.out.println('\n' + "Enter a float value (It is represented "
                            + "as a grade): ");
        float grade = keyboard.nextFloat();
        
        if(grade >= 90)
        { 
            System.out.println(grade + " is above an A. ");
        }
        else if(grade >= 80 && grade < 90)
        {
            System.out.println(grade + " is a B.");
        }
        else
        {
            System.out.println("The grade is lower than a B.");
        }
        
        //TODO 9
        System.out.println('\n' + "Enter a number for the temperature: ");
        double temperature  = keyboard.nextDouble();
        
        if(temperature > 78)
        {
            System.out.println(temperature + " is higher than 78 degrees");
        }
        else
        {
            System.out.println(temperature + " is less than or equal"
                               + " to 78 degrees.");
        }
        
        //TODO 10
        System.out.println('\n' + "Enter a number for temperature\nIs the tempe"
                + "rature positive and odd or zero and even?:");
        double temp1 = keyboard.nextDouble();
        
        if((temp1 > 0 && temp1 % 2 == 1) || (temp1 == 0 && temp1 % 2 == 0))
        {
            System.out.println("Yes; It is positive and odd or zero "
                    + "and even.");
        }
        else
        {
            System.out.println("No; It is not positive and odd or zero "
                    + "and even.");
        }
        
        //TODO 11
        System.out.println( '\n' + "Enter a letter grade:  ");
        String letter = keyboard.next();
        char letterGrade = letter.charAt(0);
    
        if(letterGrade == 'A' || letterGrade == 'a')
        {
            System.out.println("The grade is an A.");
        }
        else if(letterGrade == 'B' || letterGrade == 'b')
        {
            System.out.println("The grade is a B.");
        }
        else if(letterGrade == 'C' || letterGrade == 'c')
        {
            System.out.println("The grade is a C.");
        }
        else if(letterGrade == 'D' || letterGrade == 'd')
        {
            System.out.println("The grade is a D.");
        }
        else if(letterGrade == 'F' || letterGrade == 'f')
        {
            System.out.println("The grade is a F.");
        }
        else
        {
            System.out.println("A non-existant grade was entered.");
        }
        
          //TODO 12
          System.out.println('\n' + "We will find which is bigger between"
                  + " 5 and 6. ");
          int num1 = 5;
          int num2 = 6;
          int maxNum = max(5, 6);
          
          System.out.println("The bigger number is " + maxNum);
          
          //TODO 13
          System.out.println('\n'+ "Enter 2 numbers and we'll determine"
                  + " which number is bigger and smaller: ");
          int input1 = keyboard.nextInt();
          int input2 = keyboard.nextInt();
          int maxInput = max(input1, input2);
          int minInput = -max(-input1 ,-input2);
          
          
          System.out.println("The larger number is " + maxInput);
          System.out.println("The smaller number is " + minInput);
    }
    
    
    /**
     * This will display the maximum.
     * 
     * This is a method that will take two inputs of integers and return 
     * the number that is greater.
     * 
     * @param num1
     * @param num2
     * @return A bigger number
     * 
     * Example: input 1 = 2 & input 2 = 5
     *          it'll return 5 because 5 > 2
     */
    public static int max(int num1, int num2)
    {
        if(num1 > num2)
        {
            return num1;
            
        }
        return num2;
        //int maximumNumber = Math.max(num1 , num2);
    }
}
