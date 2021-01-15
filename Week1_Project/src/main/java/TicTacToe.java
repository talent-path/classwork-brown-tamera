

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static int userWins=0;
    static int computerWins=0;
    static int draws=0;


    public static void main(String[] args) {

        //getComputerChoice();
        //getUserPlacement(b);
        PlayGame();


    }

    public static char[][] SetBoard() {
        int rows = 3;
        int cols = 3;

        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '-';

            }

        }

        return board;


    }

    public static void PrintBoard(char[][] b) {

        for (int i = 0; i < b.length; i++) {

            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + "");
            }
            System.out.println();

        }

    }



    public static void Turns(char [][] board) {

    boolean player = true;
    boolean gameEnded=false;

    int row=0;
    int col=0;

    while (!gameEnded) {
        PrintBoard(board);

        // keep track of the symbol
        char symbol = ' ';
        if (player) symbol = 'x';
        else symbol = 'o';

        //Print out players turn
        if (player) System.out.println("User's Turn (x)");
        else System.out.println("Computer's Turn (o)");

        while (true) {

            //Get Placements
            if (player) {
                int rnum = Console.readInt("Enter a a row number (0-2)");

                row = rnum;
                int cnum = Console.readInt("Enter a col num (0-2)");
                col = cnum;

                //check if row and col are valid
                if (row < 0 || col < 0 || row > 2 || col > 2) System.out.println("Row and Cols are out of bounds");
                else if (board[row][col] != '-') System.out.println("Position already filled");
                else break;

            }
        }

        board[row][col] = symbol;
        if (IfWon(board) == 'x') {
            System.out.println("User Won");
            userWins++;
            gameEnded=true;
        }
        else if (IfWon(board) == 'o') {
            System.out.println("Computer Won");
            computerWins++;
            gameEnded=true;
        }
        else {
            if (IsFull(board)) {
                System.out.println("Tie");
                draws++;
                gameEnded=true;
            }
            else{
                player=!player;
                int ccol=0;
                int crow=0;
                crow=getComputerChoice();
                ccol=getComputerChoice2();
                System.out.println(crow);
                System.out.println(ccol);


            }


        }

    }
        System.out.println("User: " + userWins);
        System.out.println("Computer: " + computerWins);
        System.out.println("Draw: " + draws);
}

    public static int getComputerChoice() {
        Random rand=new Random();

        int row = rand.nextInt(3);
        //int cols=rand.nextInt(3);
       // System.out.println(row);
        //System.out.println(cols);

        return  row;
    }
    public static int getComputerChoice2() {
        Random rand=new Random();

        //int row = rand.nextInt(3);
        int cols=rand.nextInt(3);
        // System.out.println(row);
        //System.out.println(cols);

        return cols;
    }

    public static int GetRounds() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many rounds of Tic Tac Toe would you like to play?");
        int rounds = scanner.nextInt();

        return rounds;
    }

    public static void PlayGame(){

        int NumofRounds=GetRounds();


        int i=0;
        while(NumofRounds!=i) {
            char [][] b=SetBoard();
            Turns(b);
            i++;
            System.out.println("end of round " + i);
        }
        System.out.println("Thanks for playing");
        }

public static char IfWon(char [][] board) {
    //check each row
    for (int i = 0; i < board.length; i++) {
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
            return board[i][0];
        }

    }
    //check each column
    for (int j = 0; j < board.length; j++) {
        if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
            return board[0][j];
        }
        // check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != '-') {
            return board[2][0];
        }

    }
    return '-';

}
public static boolean IsFull(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='-') return false;
            }
        }
        return true;
}

}

