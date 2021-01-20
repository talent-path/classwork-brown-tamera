import java.util.Random;

public class TicTacToe {

    static int userWins=0;
    static int computerWins=0;
    static int draws=0;


    public static void main(String[] args) {


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
    boolean gameEnded=false;

     boolean player=DecideWhoGoesFirst();

    while (!gameEnded) {
        PrintBoard(board);


        //Print out players turn
        if (player) {
            System.out.println("User's Turn (x)");
            getPlayerMove(board);
        } else {
            System.out.println("Computer's Turn (o)");
            getComputerMove(board);
        }
        player = !player;

        gameEnded=TrackRecord(board);

    }

        DisplayStats();



        }




    public static void getComputerMove(char[][] board) {
        char symbol = 'o';
        int row = 0;
        int col = 0;





        Random rand=new Random();
        row=rand.nextInt(3);
        col=rand.nextInt(3);

        while (true) {



             if (board[row][col] != '-'){
                 rand=new Random();
                 row=rand.nextInt(3);
                 col=rand.nextInt(3);
             }
            else break;
        }
        board[row][col]=symbol;

        }




    public static void getPlayerMove(char[][] board) {
        char symbol='x';
        int row=0;
        int col=0;

        while (true) {

            row = Console.readInt("Enter a a row number (0-2)");
            col = Console.readInt("Enter a col num (0-2)");

            if (row < 0 || col < 0 || row > 2 || col > 2) System.out.println("Row and Cols are out of bounds");
            else if (board[row][col] != '-') System.out.println("Position already filled");
            else break;
        }

   board[row][col]=symbol;

    }

    public static int GetRounds() {

        int rounds = Console.readInt("Enter number of rounds",0,10);

        return rounds;
    }

    public static void PlayGame(){

        int NumOfRounds=GetRounds();


        int i=0;
        while(NumOfRounds!=i) {
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
public static boolean DecideWhoGoesFirst(){
    boolean CoinFlipResult= Rng.coinFlip();


        return CoinFlipResult;
    }
public static void DisplayStats(){
    System.out.println("User: " + userWins);
    System.out.println("Computer: " + computerWins);
    System.out.println("Draw: " + draws);


}

public static boolean TrackRecord(char[][] board){
        boolean end=false;

    if (IfWon(board) == 'x') {
        System.out.println("User Won");
        userWins++;
        PrintBoard(board);
        end= true;
    } else if (IfWon(board) == 'o') {
        System.out.println("Computer Won");
        computerWins++;
        PrintBoard(board);
        end = true;
    } else {
        if (IsFull(board)) {
            System.out.println("Draw");
            draws++;
            PrintBoard(board);
            end = true;
        }

    }
    return end;
}
}

