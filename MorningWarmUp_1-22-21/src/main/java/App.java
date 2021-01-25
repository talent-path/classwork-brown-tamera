import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        int size;
        int MaxNum=1;
        int counter=0;
        for(int i=2;i<1000000;i++){
            size=ChainSize(i);
            if(size>MaxNum){
                MaxNum=size;
                counter=i;
            }

        }
        System.out.println("Number to produce higest chain is " + counter);

    }

    public static int ChainSize(long n){
        List<Long> NumberChain=new ArrayList<>();
        while (n!=1){
                NumberChain.add(n);
            if(n%2==0){
                n=n/2;
                //NumberChain.add(n);
                //ChainSize(n);
            } else{
                n=(3*n)+1;
               // NumberChain.add(n);
               // ChainSize(n);
            }

        }
        return NumberChain.size();
    }
}
