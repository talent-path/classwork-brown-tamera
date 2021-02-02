import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12},9));
    }
//    public int search(int[] nums, int target) {
//        if(target<nums[0]){
//            return -1;
//        }
//        int value=Arrays.binarySearch(nums,target);
//        return value;
//    }



    public static int search(int [] nums,int target){
        return Bsearch(nums,target,0,nums.length-1);

    }
    public static int Bsearch(int[] nums, int target,int first, int last) {

        // int first=0;
        // int last=nums.length-1;
        int MiddleIndex;

        if(last<first){
            return -1;
        }
        MiddleIndex=last +(first - last) / 2;
        if(nums[MiddleIndex]==target){


            return MiddleIndex;
        }
        if(nums[MiddleIndex]>target){
            return Bsearch(nums,target,first,MiddleIndex-1);
        }

        return Bsearch(nums,target,MiddleIndex+1,last);
    }

    //     while(first <=last){
    //         MiddleIndex=last +(first - last) / 2;
    //         if(nums[MiddleIndex]==target) return MiddleIndex;
    //         if(target < nums[MiddleIndex]) last=MiddleIndex-1;
    //         else first= MiddleIndex + 1;
    //     }
    //     return -1;
    //     // //  if(target<nums[0]){
    //     // //     return -1;
    //     // // }
    //     // int value=Arrays.binarySearch(nums,target);
    //     // return value;
    // }
}


