public class App {
    public static void main(String[] args) {

        int result=minDays(10);

        System.out.println(result);
    }
    public static int minDays(int n) {
        int countDays=0;

        while(n>0){
            if(n%2==0){
                countDays++;
                n=n/2;
            }
            else if(n%3==0){
                countDays++;
                n=2*(n/3);
            }
            else{
                countDays++;
                n=n-1;
            }
        }
        return countDays;
    }
}
