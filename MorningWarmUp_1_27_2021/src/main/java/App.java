import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;

public class App {

    public static void main(String[] args) {

        //Date year=;
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.YEAR));

    }

    public static boolean isValidSudoku(char[][] board) {

        // init data
        HashSet<Integer> [] rows = new HashSet[9];
        HashSet<Integer> [] columns = new HashSet[9];
        HashSet<Integer> [] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Integer>();
            columns[i] = new HashSet<Integer>();
            boxes[i] = new HashSet<Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    if((!rows[i].add(n))
                            ||
                            (!columns[j].add(n))
                            ||
                            (!boxes[box_index].add(n))){
                        return false;
                    }

                }
            }
        }

        return true;
    }
    public void solveSudoku(char[][] board) {
            int [] possibleNums= {1,2,3,4,5,6,7,8,9};
        for(int i=0;i<9; i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    board[i][j]=(char)possibleNums[i];
                }
            }
        }
        if(isValidSudoku(board)){

            solveSudoku(board);
        }
    }
    }

