class Solution {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void solveSudoku(char[][] board) {
        List<Pair> arr = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    arr.add(new Pair(i, j));
                }
            }
        }

        solve(board, arr, 0);
    }

    static boolean solve(char[][] board, List<Pair> arr, int idx) {

        if (idx == arr.size()) {
            return true; // solved
        }

        Pair p = arr.get(idx);
        int row = p.row;
        int col = p.col;

        for (char ch = '1'; ch <= '9'; ch++) {

            if (isValid(board, row, col, ch)) {

                board[row][col] = ch;

                if (solve(board, arr, idx + 1)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

    static boolean isValid(char[][] board, int row, int col, char ch) {

        // row check
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == ch) {
                return false;
            }
        }

        // column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) {
                return false;
            }
        }

        // 3x3 box check
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }
}