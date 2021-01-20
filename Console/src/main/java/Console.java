import java.util.Scanner;

public class Console {
    public static void print(String printString) {
        System.out.print(printString);
    }
public static void readInt(String msg, int min, int max){


            int num=readInt(msg);
            while ((num >max) || (num <min)){

                int N=readInt("Please Enter a number between" + min + "and" + max);

            }


}
    public static int readInt(String msg){
        //print(msg);
        Scanner input= new Scanner((System.in));
        boolean valid=false;
        int i=Integer.MIN_VALUE;
        while(!valid){

            print(msg);
            String userInput=input.next();
            try{
                i=Integer.parseInt(userInput);
                valid=true;


            }catch(NumberFormatException ex){

            };
        }


        return i;

    }
    public static double readDouble(String msg, double min, double max){
boolean range=false;
double output=Double.NaN;

        double num=readDouble(msg);
        while ((num >max) || (num <min)){

            int N=readInt("Please Enter a number between" + min + "and" + max);

        }
return  output;

    }

public static double readDouble(String msg){
        Scanner inuput2= new Scanner(System.in);
        boolean IsValid=false;
        double i=Double.NaN;
        while (!IsValid){
            String userInput=inuput2.next();
            try{
                i=Double.parseDouble(userInput);
                IsValid=true;

            }catch(NumberFormatException ex){

            };
        }
        return  i;
}

}
