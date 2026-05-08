class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int r = 0; r < 9; r += 3){
            for(int c = 0; c < 9; c += 3){
                if(!isValid_block(board, r, c)) return false;
            }
        }
        for(int r = 0; r < 9; r++){
            if(!isValidRow(board, r)) return false;
        }
        for(int c = 0; c < 9; c++) if(!isValid_column(board, c)) return false;

        return true;
    }
    boolean isValid_block(char[][] board, int row, int col){
        Set<Character> set = new HashSet<>();
        for(int r = row; r < row + 3; r++){
            for(int c = col; c < col + 3; c++){
                if(board[r][c] == '.') continue;
                if(set.contains(board[r][c])) return false;
                set.add(board[r][c]);
            }
        }
        return true;
    }
    boolean isValidRow(char[][] board, int row){
        Set<Character> set = new HashSet<>();
        for(int c = 0; c < 9; c++){
            if(board[row][c] == '.') continue;
            if(set.contains(board[row][c])) return false;
            set.add(board[row][c]);
        }
        return true;
    }
    boolean isValid_column(char[][] board, int col){
        Set<Character> set = new HashSet<>();
        for(int r = 0; r < 9; r++){
            if(board[r][col] == '.') continue;
            if(set.contains(board[r][col])) return false;
            set.add(board[r][col]);
        }
        return true;
    }
}
