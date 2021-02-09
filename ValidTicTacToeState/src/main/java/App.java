public class App {
    public static void main(String[] args) {

    }

    public boolean validTicTacToe(String[] board) {
        char[][] Gborad = new char[3][3];
        int numOfXmoves = 0;
        int numOfOmoves = 0;

        for (int i = 0; i < 3; i++) {
            Gborad[i] = board[i].toCharArray();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char move = Gborad[i][j];

                if (move == 'X') numOfXmoves++;
                else numOfOmoves++;
            }
        }

        if (numOfOmoves > numOfXmoves || numOfXmoves - numOfOmoves > 1) return false;

        if (numOfOmoves - numOfXmoves == 1) {
            if (Won(Gborad, 'O')) return false;
        }
        if (numOfXmoves == numOfOmoves) {
            if (Won(Gborad, 'X')) return false;
        }


        return false;
    }

    private boolean Won(char[][] gborad, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gborad[i][0] == symbol && gborad[i][1] == gborad[i][0]
                    && gborad[i][2] == gborad[i][1]) {
                return true;
            }
            if (gborad[0][i] == symbol && gborad[1][i] == gborad[0][i]
                    && gborad[2][i] == gborad[1][i]) {
                return true;
            }
            if (symbol == gborad[0][0] && gborad[0][0] == gborad[1][1]
                    && gborad[1][1] == gborad[2][2]) {
                return true;
            }
            if (symbol == gborad[0][2] && gborad[1][1] == gborad[0][2]
                    && gborad[1][1] == gborad[2][0]) {
                return true;
            }
        }

        return false;
    }
}
