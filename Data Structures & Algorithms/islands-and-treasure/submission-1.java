class Solution {
    int m, n;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j, 1});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            for(int[] dir : directions){
                int nr = dir[0] + r, nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] != -1 && grid[nr][nc] != 0 && grid[nr][nc] > d){
                    grid[nr][nc] = d;
                    queue.offer(new int[]{nr, nc, d + 1});
                }
            }
        }
    }
    
}
