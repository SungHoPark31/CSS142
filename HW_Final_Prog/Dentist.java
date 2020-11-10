
import java.util.Scanner;
/**
 * This is where the Bill does a lot of the work. It will prompt the user to 
 * enter their name and the cost of each appointment. If a certain appointment
 * is not done, then enter 0. It will add all the appointment costs together
 * and the user has to pay. It must be higher than the total. After that, it 
 * will tell the user their change and the main method will take care of the
 * rest.
 *
 * @author Sung Ho Park
 * @version 1.0
 */
public class Dentist
{
    // instance variables 
    private double cavity;
    private double braces;
    private double whitening;
    private double gumSurgery;
    private double oralCancerExamination;
    private double total;
    private double customerPay;
    private double change;
    private String name;

    //Number 8 in the criteria: Class Design and Modifiers
    /**
     * Accessor Method to get access to the instance variables. In this case
     * it is the cavity.
     */
    public double getCavity()
    {
        return cavity;
    }

    /**
     * Accessor Method to get access to the instance variables. In this case
     * it is the braces.
     */
    public double getBraces()
    {
        return braces;
    }

    /**
     * Accessor Method to get access to the instance variables. In this case
     * it is the whitening.
     */
    public double getWhitening()
    {
        return whitening;
    }

    /**
     * Accessor Method to get access to the instance variables. In this case
     * it is the gum surgery.
     */
    public double getGumSurgery()
    {
        return gumSurgery;
    }

    /**
     * Accessor Method to get access to the instance variables. In this case
     * it is the oral cancer examination.
     */
    public double getOralCancer()
    {
        return oralCancerExamination;
    }

    /**
     * Accessor Method to get access to the instance variables. In this case
     * it is the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor Method to get access to the instance variables. In this case
     * it is the total.
     */
    public double getTotal()
    {
        return total;
    }

    /**
     * Accessor Method to get access to the instance variables. In this case
     * it is the customer pay.
     */
    public double getCustomerPay()
    {
        return customerPay;
    }

    /**
     * Accessor Method to get access to the instance variables. In this case
     * it is the change.
     */
    public double getChange()
    {
        return change;
    }

    /**
     * Mutator Method to set the instance variables to the object so that the
     * values inside the variables can be changed.
     */
    public void setCavity(double cavity)
    {
        //Number 4 in the criteria: If/Else
        if(cavity < 0)
        {
            System.out.println("Invalid Numbers");
            System.exit(0);
        }
        else
        {
            //Set the variables from the accessor methods to change the 
            //values.
            this.cavity = cavity;
        }
    }

    /**
     * Mutator Method to set the instance variables to the object so that the
     * values inside the variables can be changed.
     */
    public void setBraces(double braces)
    {
        //Number 4 in the criteria: If/Else
        if(braces < 0)
        {
            System.out.println("Invalid Numbers");
            System.exit(0);
        }
        else
        {
            //Set the variables from the accessor methods to change the 
            //values.
            this.braces = braces;
        }
    }

    /**
     * Mutator Method to set the instance variables to the object so that the
     * values inside the variables can be changed.
     */
    public void setWhitening(double whitening)
    {
        //Number 4 in the criteria: If/Else
        if(whitening < 0)
        {
            System.out.println("Invalid Numbers");
            System.exit(0);
        }
        else
        {
            //Set the variables from the accessor methods to change the 
            //values.
            this.whitening = whitening;
        }
    }

    /**
     * Mutator Method to set the instance variables to the object so that the
     * values inside the variables can be changed.
     */
    public void setGum(double gumSurgery)
    {
        //Number 4 in the criteria: If/Else
        if(gumSurgery < 0)
        {
            System.out.println("Invalid Numbers");
            System.exit(0);
        }
        else
        {
            //Set the variables from the accessor methods to change the 
            //values.
            this.gumSurgery = gumSurgery;
        }
    }

    /**
     * Mutator Method to set the instance variables to the object so that the
     * values inside the variables can be changed.
     */
    public void setOralCancer(double oralCancerExamination)
    {
        //Number 4 in the criteria: If/Else
        if(oralCancerExamination < 0 )
        {
            System.out.println("Invalid Numbers");
            System.exit(0);
        }
        else
        {
            //Set the variables from the accessor methods to change the 
            //values.
            this.oralCancerExamination = oralCancerExamination;
        }
    }

    /**
     * Mutator Method to set the instance variables to the object so that the
     * values inside the variables can be changed.
     */
    public void setValues(String name)
    {
        //Number 4 in the criteria: If/Else
        if(name.equals(""))
        {
            System.out.println("Must have a name");
            System.exit(0);
        }
        else
        {
            //Set the variables from the accessor methods to change the 
            //values.
            this.name = name;
        }
    }

    /**
     * Mutator Method to set the instance variables to the object so that the
     * values inside the variables can be changed.
     */
    public void setPayment(double total, double customerPay, double change)
    {
        //Invalid numbers.
        if(total == 0 || total < 0 || customerPay < 0 
        || customerPay == 0 || change == 0 || change < 0)
        {
            System.out.println("Invalid Values");
            System.exit(0);
        }
        else
        {
            //Set the variables from the accessor methods to change the 
            //values.
            this.total = total;
            this.customerPay = customerPay;
            this.change = change;
        }
    }

    //Number 1 in the criteria: Functional Decomposition
    /**
     * Description: This is where the user will be prompted with name, cavity,
     * braces, whitening, gum surgery, and oral cancer examination.
     *
     * Precondition: All the instance variables that has this. in front should
     * have values.
     * 
     * Postcondition: It should execute each line with the current values.
     * @return void 
     */
    public void reportDentist()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hello, ");
        System.out.println("Welcome to UW Bothell Dental Care!");
        System.out.println("Please state your name (First and Last): ");
        this.name = keyboard.nextLine();

        //Quick description.
        System.out.println("\nHere you will pay for your dentist "
            + "appointment.");
        System.out.println("The doctor should've given you a paper to enter"
            + " the amount of money each appointment.");

        System.out.println("\nIf you didn't get the paper, you must get it."
            + " If you do, please continue.");
        System.out.println("Enter how much the doctor wants you to pay. ");
        System.out.println("If you didn't schedule an appointment, " + 
            "then enter 0.");

    }

    /**
     * Description: This should check if the numbers are invalid. If they are, the user 
     * must reenter their values.
     * 
     * Precondition: The values should all be positive.
     * Postcondition: Displays the values.
     */
    public void checkNumbersValid()
    {
        Scanner keyboard = new Scanner(System.in);
        //User inputs all the appointments. If not then enter 0

        //They all will execute once and once the while condition is 
        //not met, then it will exit the loop and go on.
        do
        {
            //This is if the user inputs a wrong input.
            System.out.print("\nCavity: ");
            this.cavity = keyboard.nextDouble();
            //cavity less than 0
            if(this.cavity < 0)
            {
                System.out.println("Please enter a valid payment");
            }
        }while(this.cavity < 0);

        do
        {
            //This is if the user inputs a wrong input.
            System.out.print("Braces: ");
            this.braces = keyboard.nextDouble();
            //braces less than 0
            if(this.braces < 0)
            {
                System.out.println("Please enter a valid payment");
            }
        }while(this.braces < 0);

        do
        {
            //This is if the user inputs a wrong input.
            System.out.print("Teeth Whitening: ");
            this.whitening = keyboard.nextDouble();
            //Teeth Whitening less than 0
            if(this.whitening < 0)
            {
                System.out.println("Please enter a valid payment");
            }
        }while(this.whitening < 0);

        do
        {
            //This is if the user inputs a wrong input.
            System.out.print("Gum Surgery: ");
            this.gumSurgery = keyboard.nextDouble();
            //gum surgery less than 0
            if(this.gumSurgery < 0)
            {
                System.out.println("Please enter a valid payment");
            }
        }while(this.gumSurgery < 0);

        do
        {
            //This is if the user inputs a wrong input.
            System.out.print("Oral Cancer Examination: ");
            this.oralCancerExamination = keyboard.nextDouble();
            //Oral cancer exam less than 0
            if(this.oralCancerExamination < 0)
            {
                System.out.println("\nPlease enter a valid payment");
            }
        }while(this.oralCancerExamination < 0);
    }

    /**
     * Description: This is the calculation. Taking the reportDentist method
     * this will take those values and add them together for a total. After
     * the total, it'll prompt the user to enter their payment. If the 
     * payment is lower than the total, then the user has to input another 
     * number. It will then calculate the change. 
     * 
     * Precondition: All instance variables should have values.
     * Postcondition: It should print out total, customer pay, and change.
     */
    public void calculateBill()
    {
        Scanner keyboard = new Scanner(System.in);

        //Calculate the total and print it out.
        this.total = this.cavity + this.braces + this.whitening
        + this.gumSurgery + this.oralCancerExamination;
        System.out.printf("\nHere is your total: $%.2f%n", this.total); 

        //Initialize change.
        this.change = 0;

        System.out.printf("Enter Customer Payment: "); 
        this.customerPay = keyboard.nextDouble(); 
        this.change = (this.customerPay - this.total) ;
        //Number 2 in the criteria: Use Loops.
        while(this.change < 0)
        {
            //This is if the user inputs a wrong input.
            System.out.println("Please enter a customer payment that is" 
                + " greater than the total");
            System.out.printf("Enter Customer Payment: "); 
            this.customerPay = keyboard.nextDouble();
            this.change = (this.customerPay - this.total) ;

            //If the change is less than the total. Loop back again until
            //the user enters a number greater than the total.
        }

        //After the loop is over and we have a value that is true from the 
        //loop, it'll calculate the change. 
        this.change = this.customerPay - this.total;
        System.out.printf("Change: $%.2f%n", this.change);
    }
}
