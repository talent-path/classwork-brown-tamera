import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {


        System.out.println(letterCasePermutation("a1b2"));

    }
    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();

        if(S==null) return result;
        char[] charResult= S.toCharArray();
        helper(result,charResult,0);
        return result;
    }

    private static void helper(List<String> result, char[] charResult, int i) {
        if(i==charResult.length) {
            result.add(new String(charResult));
            return;
        }
        if(charResult[i]>='0' && charResult[i]<='9'){
            helper(result,charResult,i+1);
            return;
        }
        charResult[i]=Character.toUpperCase(charResult[i]);
        helper(result,charResult,i+1);

        charResult[i]=Character.toLowerCase(charResult[i]);
        helper(result,charResult,i+1);

    }
    }