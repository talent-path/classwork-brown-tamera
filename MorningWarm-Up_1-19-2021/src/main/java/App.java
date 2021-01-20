public class App {
    public static void main(String[] args) {
int [] left = new int[100];
int [] right = new int[100];

for(int i =0; i<100;i++){
    left[i]=9;
    right[i]=9;
}

int [] sum =addBigNum(left,right);
for (int i=0;i<101;i++){
    System.out.print(sum[i]);
}
    }

    public static int[] addBigNum(int[] left, int[] right){
        int [] sumArray= new int[101];
        int carry=0;
        int sum=0;

       for(int i=0;i< left.length;i++) {

           sum = left[i] + right[i] + carry;
           sumArray[i] = (sum % 10);
           carry = sum / 10;


//           // add carry

//           sum = left[i] + carry;
//           sumArray[i] = (sum % 10);
//           carry = sum / 10;


       }
       sumArray[100]=carry;




        return sumArray;
    }
}
