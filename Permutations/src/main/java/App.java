import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

List<List<Integer>> result=permute(new int[]{1,2,3});
        System.out.println(result);

        List<List<Integer>> result2=permute(new int[]{0,1});
        System.out.println(result2);

        List<List<Integer>> result3=permute(new int[]{1});
        System.out.println(result3);


    }
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ListOfPermutations= new ArrayList<>();
        PermutationHelper(nums,0,ListOfPermutations);
        return ListOfPermutations;

    }
    public static void PermutationHelper(int[] nums,int startingIndex,List<List<Integer>> ListOfPermutations){
        if(startingIndex== nums.length-1){
            ArrayList<Integer> numsList=new ArrayList<>();
            for(int Num: nums){
                numsList.add(Num);
            }
            ListOfPermutations.add(numsList);
            return;
        }
        else {
            for(int i=startingIndex;i<nums.length;i++){
                swap(nums,i,startingIndex);
                PermutationHelper(nums,startingIndex+1,ListOfPermutations);
                swap(nums,i,startingIndex);
            }
        }

    }
    public static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
