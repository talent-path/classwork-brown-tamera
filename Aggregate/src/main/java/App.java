import java.util.Scanner;

public class App {
    final static int ROCK = 0;
    final static int PAPER = 1;
    final static int SCISSORS = 2;

    public static void main(String[] args) {

//        int[] arr = {82, 95, 71, 6, 34};
//
//        System.out.println("Min= "+ Aggregate.min(arr));
//        System.out.println("Max= "+Aggregate.max(arr));
//        System.out.println("Sum= "+Aggregate.sum(arr));
//        System.out.println("Average= "+Aggregate.average(arr));
//        System.out.println("Standard Deviation= "+Aggregate.StandardDeviation(arr));




        PlayGame();


    }

    public static int getComputerChoice() {
        int computeChoice = Rng.randInt(0, 3);

        return computeChoice;
    }

    public static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 2");
        int input = scanner.nextInt();

        return input;
    }

    public static void printChoice(int u, int c) {

        System.out.println("You Chose " + u);
        System.out.println("Computer Chose " + c);
    }

    public static int GetRounds() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many rounds of rock, paper, scissors would you like to play?");
        int rounds = scanner.nextInt();

        return rounds;

    }

    public static void PlayGame() {
        int NumOfRounds = GetRounds();

        int i = 0;
        while (NumOfRounds !=i) {
            int Computer = getComputerChoice();
            int userInput=getUserChoice();
            printChoice(userInput,Computer);

            if (userInput==Computer) System.out.println("tied!");
            else if ((userInput==ROCK && Computer==SCISSORS)|| (userInput==SCISSORS && Computer==PAPER)||(userInput==PAPER && Computer==ROCK))
                System.out.println("You Win!");
            else System.out.println("Computer Wins!");


                i++;
            System.out.println("end of round " + i);



        }
        System.out.println("Thanks for playing");

    }
}

