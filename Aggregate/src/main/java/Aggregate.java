public class Aggregate {
    public static int min(int[] arr){
        int min=arr[0];
        for(int i =0; i< arr.length-1;i++){

            if(arr[i+1]<min) min=arr[i+1];
            else if(arr[i+1]==min) min=arr[i+1];
            else min=min;
        }
        return  min;
    }
    public static int max(int[] arr){
        int max=arr[0];
        for(int i =0; i< arr.length-1;i++){

            if(arr[i+1]>max) max=arr[i+1];
            if(arr[i+1]==max) max=arr[i+1];
            else max=max;
        }
        return  max;
    }
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }
    public static double average(int[] arr){
        double sum = sum(arr);
        double average;

         average=sum / arr.length;
        return average;
    }

    public static double StandardDeviation(int[] arr) {
        double sum=0;
        double SquareDiff=0.0;
        double a= average(arr);



        for (int i = 0; i < arr.length-1; i++) {
            sum += arr[i];


            double diif = arr[i] - a;
            diif *= diif;
            sum += diif;
        }

             SquareDiff = sum / (arr.length-1);
            SquareDiff=Math.sqrt(SquareDiff);


return SquareDiff;
    }

}
