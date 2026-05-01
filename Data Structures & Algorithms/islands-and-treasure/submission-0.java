class Solution {
    int m, n;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    dfs(grid, i, j, 1);
                }
            }
        }
    }
    public void dfs(int[][] grid, int r, int c, int distance){

        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] != -1 && grid[nr][nc] != 0 && grid[nr][nc] > distance){
                grid[nr][nc] = distance;
                dfs(grid, nr, nc, distance + 1);
            }
        }
    }
}
