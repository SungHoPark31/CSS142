import java.util.Scanner;
/**
 * This is a program that will use methods to display 3 Mario boards.
 * One for an example, one for my own and one for adding mario and the
 * coins.
 *
 * @sunghopark
 * @version1.1
 */
public class MethodsMario
{
    public static void main(String[] args)
    {
       //Calls the method 
       runProgramOne();         
       runProgramTwo();
    }
    
    /**
     * Displays the boards 1st and 2nd in a String sequence
     * 
     * This print out the boards 1 and 2 by taking the 
     * methods segments 1, 2 and 3 and displays the 
     * String in assigned segments.
     * 
     * Example: segment1 printed is...
     * ||
     * ||
     * ||
     * ||
     * ||
     * ||
     */
    public static void runProgramOne()
    {
        //This will print out Mario Board 1 and 2
        System.out.println("Mario Board 1: ");
        
        //Calls the method segment 1-3.
        segment1("");
        segment2("");
        segment2("");
        segment1("");
        segment3("");
        //The "" inside the parenthesis means "Display segment 1 
        //but don't add the coins or mario
        
        System.out.println('\n' + "Mario Board 2: ");
        segment1("");
        segment2("");
        segment2("");
        segment1("");
        segment2("");
        segment3("");
        
    }
    
      /**
     * Displays the third board in a String sequence
     * 
     * This prints out the third board that includes the
     * input of whatever the user wants to make Mario and 
     * the coins. It will take those inputs as Strings and 
     * put "Mario" and the "Coins" and place it in a designated
     * spot.
     * 
     * Example: segment2 is ...
     * ||
     * ||    |?|
     * ||
     * ||
     * ||    |?|
     * ||
     */
    public static void runProgramTwo()
    {
        //The Scanner enables the user to put inputs
        Scanner keyboard = new Scanner(System.in);
        
        //This makes it so that you can input Mario
        //and the coin as a string
        System.out.print("What does Mario look like? ");
        String mario = keyboard.next();
        System.out.print("What does a Coin look like? ");
        String coin = keyboard.next();
        System.out.println("Here is your level ... "); 
        
        //The coin and mario in the parenthesis makes it so that mario 
        //and the coins appear in the segment strings
        segment1("");
        segment2("");
        segment2(coin);
        segment1(coin);
        segment3(mario);
    }
    
    /**
     * This will display segment 1.
     * 
     * It is nothing more than just a string of characters that 
     * make up the ground. If it has a "" then it is just the floor,
     * but if it has coin then 
     * 
     * @param coin :The string of characters inputed by
     *        the user to create the coin.String
     * @return The board with the location of the coin.String
     * Example:
     * ||
     * ||
     * ||@
     * ||@
     * ||@
     * ||
     */
    public static void segment1(String coin)
    {
        //This will display the floor of the board with 
        //coins in a specific spot
        String x = "||";
        String y = "||" + coin;
        System.out.println(x + '\n' + x + '\n'    
               +  y + '\n' + y + '\n' + y + '\n' + x + 
               '\n' + '\n');
    }
    
      /**
     * This will display segment 2.
     * 
     * This will display the ground and the mystery boxes in 
     * the air. If it has a "" then it does not input the coin.
     * 
     * 
     * @param coin "The string of characters inputed by
     *        the user to create the coin.String
     * @return The board with the location of the coin
     *          with the mystery boxes.String
     * Example: 
     * ||
     * ||    |?|@
     * ||
     * ||
     * ||    |?|@
     * ||
     */
    public static void segment2(String coin)
    {
       //This will display the mystery boxes and the coins on top of 
       String x = "||";
       String a = "||      |?|" + coin;
       System.out.println(x + '\n' + a +  '\n' + x + 
                '\n' + x + '\n' + a + '\n' + x + '\n' + '\n');
        
    }
    
        /**
     * 
     * This will display segment 3
     * 
     * Segment 3 consists of the steps that "Mario" has 
     * to take to complete the mission. This will make the
     * steps, flag and Mario if mario is added in the input.
     * 
     * @param  coin :The string of characters inputed by
     *         the user to create Mario.
     * @return The board that has a latter,the steps and
     *          displays Mario if wanted.
     * Example:
     * ||
     * ||||
     * ||||||
     * ||||||||
     * ||||||||||>\o
     * ||
     * ||            ^
     * |--------------
     */
    public static void segment3(String mario)
    {
        //This displays the Flag, the steps and mario 
        String x = "||";
        String y = "||" + mario;
        String u = "||                ^";
        String o = "|------------------"; 
        System.out.println(x + '\n' +  x + x + '\n' +  x + x + x + 
                '\n' + x + x + x + x + '\n' + x + x + x + x + x + '\n' 
                + x + x + x + x + x + y + '\n' + x + '\n' + u + '\n' + o);
    }
}