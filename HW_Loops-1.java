import java.util.Scanner;
/**
 * This is a program that will prompt the user to enter a String of
 * DNA Sequences (A for adenine, T for thymine, G for guanine,
 * and C for cytosine). And using various methods, this program will tell 
 * the user how many cytosines are in a dna sequence, the ratio of
 * C and G, the alignment and the score.
 * 
 * Known bugs: The alignment will display all the alignment, not the 
 * best alignment.
 * 
 * @author sunghopark
 * @version 1.0
 */
public class HW_Loops
{
    /**
     * This is the main method and it calls for other methods that 
     * does what the description above tells.
     * @param args 
     */
    public static void main(String[] args)
    {
        //This will call the methods 
        String seq1 = sequenceOne();
        String seq2 = sequenceTwo();
        System.out.println(alignmentScore(seq1, seq2));
    }

    /**
     * This program will prompt the user to enter a String of characters
     * that make up the DNA sequence (A,C,G,T), and makes sure to 
     * validate that what the user entered.
     * 
     * @return dna1 
     * Ex. ACGTCGATGCTA
     */
    public static String sequenceOne()
    {
        //Prompt the user
        System.out.println("Enter a single DNA Sequence for Sequence 1("
            + "Consists of A, C, G, T): ");
        //Get user input
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Sequence 1: ");
        String dna1 = keyboard.next();

        //Call methods
        validationOfString(dna1);
        System.out.println(" C-count: " + countCytosine(dna1));
        System.out.printf(" CG-Ratio: %1.2f%n", CGRatio(dna1));
        compliment(dna1);

        return dna1;
    }

    /**
     * This program will prompt the user to enter a String of characters
     * that make up the DNA sequence (A,C,G,T), and makes sure to 
     * validate that what the user entered. (This is for sequence 2)
     * 
     * @return dna2
     * Ex. ACGTCGATGCTA
     */
    public static String sequenceTwo()
    {
        //Same thing for sequence 1 but this is sequence 2.
        System.out.println("\nEnter a single DNA Sequence for Sequence 2 ("
            + "Consists of A, C, G, T): ");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Sequence 2: ");
        String dna2 = keyboard.next();

        validationOfString(dna2);
        System.out.println(" C-count: " + countCytosine(dna2));
        System.out.printf(" CG-Ratio: %1.2f%n", CGRatio(dna2));
        compliment(dna2);     

        return dna2;
    }

    /**
     * This checks if the user input is valid.
     * 
     * @param dna, This is the input from the sequenceOne and Two method.
     * @return true, if the input is valid.
     * Example: ACGTCG is valid. S is not.
     */
    public static boolean validationOfString(String dna)
    {
        Scanner keyboard = new Scanner(System.in);
        //This will validate if the string has C,A,G,T.
        for(int i = 0; i < dna.toUpperCase().length(); i++)
        {
            char character = dna.charAt(i); //Character at the dna String.
            if(character != 'C' && character != 'A' && character != 'G'
            && character != 'T')
            {
                while(character != 'C' && character != 'A' && character != 
                'G' && character != 'T')
                {
                    //If input is not valid, reprompt the user.
                    System.out.println("Invalid input: ");
                    keyboard.next();
                    keyboard.nextLine();
                    return false;
                }
            } 
            return true;
        }
        return true;
    } 

    /**
     * This will count how many Cytosines are there in the user input.
     * 
     * @param dna, This is the input from the sequenceOne and Two method.
     * @return count
     * Example: ACCCGTGTGC will return 4 because there are 4 C's.
     */
    public static int countCytosine(String dna)
    {
        int count = 0;
        for(int i = 0; i < dna.toUpperCase().length(); i++)
        {
            char character = dna.charAt(i);
            if (character == 'C')
            {
                //This will count 0 from 1 and keep incrementing 
                //because C is found.
                count = count + 1;
            }   
        }
        return count;
    }

    /**
     * This will find the ratio of C and G to the total length of the 
     * string.
     * 
     * @param dna, This is the input from the sequenceOne and Two method.
     * @return total, this returns the ratio of C and G of the total.
     * Example: CGTGCTG, There are 2 C's and 3 G's, and the length of
     * the String is 7. so it would be 5/7.
     */
    public static double CGRatio(String dna)
    {
        double CGCounter = 0.0; //Initialize and declare outside
        double total = 0.0;
        for(int i = 0; i < dna.toUpperCase().length(); i++)
        {
            char character = dna.charAt(i);
            if (character == 'C' || character == 'G')
            {
                //This will make check if there is C and G,
                //add them together and divide by total.

                //CGCounter pretty much counts how many C and G's there 
                //are
                CGCounter++;
                total = CGCounter / dna.length();
            } 
        }
        return total;
    }

    /**
     * This will tell which DNA part is complimentary to another one.
     * C = G, G = C, A = T, T = A and display the complimentary of the
     * entire string.
     * 
     * @param dna, This is the input from the sequenceOne and Two method.
     * Example: ACGTCGTA = TGCAGCAT
     */
    public static void compliment(String dna)
    {
        System.out.print(" Compliment: ");
        for(int i = 0; i < dna.toUpperCase().length(); i++)
        {
            char character = dna.charAt(i);
            //This is the complimentary meaning that it'll print
            //out the complimentary letter for that letter.

            if (character == 'C')
            {
                System.out.print("G");
            }
            else if (character == 'A')
            {
                System.out.print("T");
            }
            else if (character == 'G')
            {
                System.out.print("C");
            }
            else if (character == 'T')
            {
                System.out.print("A");
            } 
        }
        System.out.println("");
    }

    /**
     * This will align sequence 1 input and sequence 2 input and 
     * align them to see which line has the same characters. If they
     * have the same characters, then the score will be added. They 
     * will keep realigning until it produces a final score. All the 
     * scores will be compared and the output will be the best 
     * alignment and the highest score.
     * 
     * @param seq1, This is whatever input we got from sequenceOne
     * @param seq2, This is whatever input we got from sequenceTwo
     * @return ACTCTAT
     *          CACTGT  This will return 3.
     */
    public static int alignmentScore(String seq1, String seq2)
    {
        int difference = 0;
        String longerSequence;
        String shorterSequence;

        System.out.println("\nBest Alignment Score: ");

        //This calculates which sequence that the user inputted is 
        //bigger so that the larger sequence goes on top.
        if(seq1.length() > seq2.length())
        {
            longerSequence = seq1;
            shorterSequence = seq2;
            difference = longerSequence.length() - shorterSequence.length();
        }
        else
        {
            shorterSequence = seq1;
            longerSequence = seq2;
            difference = longerSequence.length() - shorterSequence.length();
        }

        //This is the score that is being added if there is 
        //an alignment.
        int score = 0;
        int maxScore = 0;
        for(int i = 0; i < difference + 1; i++)
        {
            System.out.println(longerSequence + '\n' + shorterSequence);

            for(int j = i; j < difference; j++)
            {
                //THis checks if the character at index j of both
                //longChar and shortChar are equal.
                char longerChar = longerSequence.charAt(j);
                char shorterChar = shorterSequence.charAt(j);
                if(longerChar == shorterChar)
                {
                    //If they are equal, then the score increases by one.
                    score++;
                } 
            }  
            //This adds the spaces so that it goes on to the next
            //Alignment.
            shorterSequence = " " + shorterSequence;

            if(maxScore < score)
            {
                //Changes score to max score if a bigger number is 
                //displayed.
                maxScore = score;   
            }  
        }
        return maxScore; 
    }
}