/**
 * TikTacToe Game
 * @author Gazi MD Wasi-UL-Hoque Eusha
 * @version 10 July 2022
 */
import java.util.Scanner;;
public class TikTacToe {

    /*
     * To create the table for the first time before the game begins
     */
    public static void initialTable(char[] table) {

        for(int i = 0; i < table.length; i++){
            table[i] = '#';
        }        
    }
    
    /**
     * To show the created table to the user
     * @param table an array of character where the table is stored
     */
    public static void displayTable(char[] table) {

        for(int i = 0; i < 3; i++){
            System.out.print(table[i] + " ");
        }
        System.out.println();
        for(int i = 3; i < 6; i++){
            System.out.print(table[i] + " ");
        }
        System.out.println();
        for(int i = 6; i < 9; i++){
            System.out.print(table[i] + " ");
        }        
    }

    /**
     * take user input to update their moves in the table
     * @param table the array of character where the table is stored
     * @param userInput the index position where the user wants to place his move
     * @param userSymbol the symbol for the two different users 
     */
    public static void tableInput(char[] table, int userInput, char userSymbol) {

        switch (userInput) 
        {
            case 1:
                table[0] = userSymbol;
                break;
            case 2:
                table[1] = userSymbol;
                break;
            case 3:
                table[2] = userSymbol;
                break;
            case 4: 
                table[3] = userSymbol;
                break;
            case 5:
                table[4] = userSymbol;
                break;
            case 6:
                table[5] = userSymbol;
                break;
            case 7:
                table[6] = userSymbol;
                break;
            case 8:
                table[7] = userSymbol;
                break;
            case 9:
                table[8] = userSymbol;
                break;
            default:
                System.out.println("Invalid Choice!");
                break;       
        }            
    }

    /**
     * Method to take in user input
     * @param table array of characters
     * @param input Scanner variable for user input
     */
    public static void userInput(char[] table, Scanner input) {

        // variable declaration
        char move = 'X'; // initial move of 1st player
        int userInput; // co ordianates of the grid
        boolean gameOver; // if anyone has won the game
        boolean moveNotMade; // to check if the place selected alrady has a value
        displayTable(table);

        for(int i = 1; i < 10; i++){
           
            System.out.println();
            // player 1 move
            if((i % 2) != 0){ // every odd turn is player 1
                System.out.println();
                System.out.println("1 2 3\n4 5 6\n7 8 9");                    
                System.out.print("Enter the corresponding number of that position player 1: ");
                userInput = input.nextInt();
                moveNotMade = isOccupied(table, userInput);
                // validating for index input
                while (moveNotMade) { // checking to see if there is already a value in that index
                    System.out.println("That place is already taken!");
                    System.out.println("1 2 3\n4 5 6\n7 8 9");                    
                    System.out.print("Enter the corresponding number of that position player 1: ");
                    userInput = input.nextInt();
                    moveNotMade = isOccupied(table, userInput);
                }
                tableInput(table, userInput, move);
                gameOver = gameWon(table, move);
                // checking to see if player 1 won
                if (gameOver) {
                    displayTable(table);
                    System.out.println();
                    System.out.println("Congratulations Player 1!");
                    break;
                } 
            }
            // player 2 move
            else{ // even turns are for player 2
                move = '0'; // changing the symbol for player 2
                System.out.println();
                System.out.println("1 2 3\n4 5 6\n7 8 9");                    
                System.out.print("Enter the corresponding number of that position player 2: ");
                userInput = input.nextInt();
                moveNotMade = isOccupied(table, userInput);
                // validating index input
                while (moveNotMade) { // checking to see if there is already a value in that index
                    System.out.println("That place is already taken!");
                    System.out.println("1 2 3\n4 5 6\n7 8 9");                    
                    System.out.print("Enter the corresponding number of that position player 2: ");
                    userInput = input.nextInt();
                    moveNotMade = isOccupied(table, userInput);
                }
                tableInput(table, userInput, move);
                gameOver = gameWon(table, move);
                // checking to see if player 2 won
                if (gameOver) {
                    displayTable(table);
                    System.out.println();
                    System.out.println("Congratulations Player 2!");
                    break;
                } 
                move = 'X'; // changing the symbol for player 1
            }
            displayTable(table); 
            
            if (i == 9 && !gameOver) {
                System.out.println();
                System.out.println("Game draw");
                break;
            }             
        }
    }

    /**
     * To check if the selected index already has a value
     * @param table array of character
     * @param userInput index position input
     * @return true or false
     */
    public static boolean isOccupied(char[] table, int userInput) {
        userInput = userInput - 1;
        if (table[userInput] != '#') {
            return true;
            
        }
        else{
            return false;
        }
    }

    /**
     * Method to check if any user has won the game or not
     * @param table array of characters
     * @param move the character symbol for the different players
     * @return true if the game is over, false if it is not
     */
    public static boolean gameWon(char[] table, char move) {
        
        // variable declaration
        boolean isWinner; // to check for winner
        
        // to check horizontally
        if(move == table[0] && table[0] == table[1] && table[0] == table[2]){
            isWinner = true;
            return isWinner;         
        }
        else if(move == table[3] && table[3] == table[4] && table[4] == table[5]){
            isWinner = true;
            return isWinner; 
        }
        else if(move == table[6] && table[6] == table[7] && table[7] == table[8]){
           isWinner = true;
           return isWinner; 
        }
        
        // to check vertically
        else if(move == table[0] && table[0] == table[3] && table[3] == table[6]){
            isWinner = true;
            return isWinner; 
            
        }
        else if(move == table[1] && table[1] == table[4] && table[4] == table[7]){
            isWinner = true;
            return isWinner; 
        }
        else if(move == table[2] && table[2] == table[5] && table[5] == table[8]){
            isWinner = true;
            return isWinner; 
        }     

        // to check the diagonals 
        else if (move == table[0] && table[0] == table[4] && table[4] == table[8]){
            isWinner = true;
            return isWinner;
        }
        else if(move == table[2] && table[2] == table[4] && table[4] == table[6]){
            isWinner = true;
            return isWinner;
        }
        else{
            isWinner = false;
            return isWinner;
        }

    }

    public static void main(String[] args) {

        // variable declaration
        Scanner input = new Scanner(System.in); // to take user input
        char[] table = new char[9];             // array instantiation with 9 indexes

        initialTable(table);
        System.out.println();
        userInput(table, input);            
    }    
}
