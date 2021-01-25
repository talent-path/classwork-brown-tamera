import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        int reveerse=digitReverse(3427854);
        System.out.println(reveerse);

    }

    public static int digitReverse(int digits){
        int reverseNum=0;
        while(digits!=0){
            reverseNum=reverseNum*10;
            reverseNum=reverseNum + (digits%10);

            digits=digits/10;

        }

        return reverseNum;
    }



}
