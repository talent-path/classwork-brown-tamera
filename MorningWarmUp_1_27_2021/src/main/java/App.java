import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

    char [][] Sudku= {{
            {'5',"3",".",".","7",".",".",".","."},
            {"6",".",".","1","9","5",".",".","."},
            {".","9","8",".",".",".",".","6","."},
            {"8",".",".",".","6",".",".",".","3"},
            {"4",".",".","8",".","3",".",".","1"},
            {"7",".",".",".","2",".",".",".","6"},
            {".","6",".",".",".",".","2","8","."},
            {".",".",".","4","1","9",".",".","5"},
            {".",".",".",".","8",".",".","7","9"}}};
        System.out.println(isValidSudoku(Sudku);

    }
    public static boolean isValidSudoku(char[][] board) {
        List<Character> row=new ArrayList<>();
        List<Character> col=new ArrayList<>();
        List<Character> box=new ArrayList<>();

        boolean isValid=true;

        //check cols
        for(int i=0;i< 9;i++) {
            for (int j = 0; j < 9; j++) {
                if (col.contains(board[i][j])) {
                    isValid=false;
                }
                if (board[i][j]!='.') {
                    col.add(board[i][j]);
                    isValid=true;
                }
            }
        }

        //check rows

        for(int i=0;i< 9;i++){
            for(int j =0;j<9;j++) {

                if (row.contains(board[i][j])) {
                    isValid= false;
                }
                if (board[i][j]!='.') {
                    row.add(board[i][j]);
                    isValid=true;
                }
            }}


        // check 3*3 boxes
        for(int i=3;i<9;i+=3){
            for(int j=3;j<9;j+=3){


                if (box.contains(board[i][j])) {
                    isValid=false;
                }
                if (board[i][j]!='.') {
                    box.add(board[i][j]);
                    isValid=true;
                }
            }
        }





        return isValid;
    }
}
