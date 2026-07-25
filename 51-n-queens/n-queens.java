class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> finalAns = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(n, 0, board, finalAns);
        return finalAns;
    }

    public void solve(int n, int col, char[][] board, List<List<String>> finalAns) {
        if (col == n) {
            List<String> ans = constructBoard(board);
            finalAns.add(ans);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafeToAdd(board, row, col)) {
                board[row][col] = 'Q';
                solve(n, col + 1, board, finalAns);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafeToAdd(char[][] board, int row, int col) {
        // row check
        for (int i = col - 1; i >= 0; i--) {
            if (board[row][i] != '.') {
                return false;
            }
        }

        // upper left diagnol
        int r = row, c = col;
        while (r >= 0 && c >= 0) {
            if (board[r--][c--] != '.') {
                return false;
            }
        }

        // low left diagnol
        r = row; c = col;
        while (r < board.length && c >= 0) {
            if (board[r++][c--] != '.') {
                return false;
            }
        }
        return true;
    }

    private List<String> constructBoard(char[][] board) {
        List<String> finalAns = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[j][i]);
            }
            finalAns.add(sb.toString());
        }
        return finalAns;
    }

}