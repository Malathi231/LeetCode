import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        nqueens(board, 0, ans);
        return ans;
    }

    static void nqueens(char[][] board, int i, List<List<String>> ans) {

        if (i == board.length) {

            List<String> temp = new ArrayList<>();

            for (int r = 0; r < board.length; r++) {
                temp.add(new String(board[r]));
            }

            ans.add(temp);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe_place(board, i, j)) {
                board[i][j] = 'Q';
                nqueens(board, i + 1, ans);
                board[i][j] = '.';
            }
        }
    }

    static boolean isSafe_place(char[][] board, int r, int c) {

        // top
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }

        // top right
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // top left
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}