class NumMatrix {
    int[][] preSum;
    int m, n;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        preSum = new int[m][n];
        compute(matrix);
    }
    void compute(int[][] matrix){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j > 0){
                   preSum[i][j] = preSum[i][j - 1] + matrix[i][j];
                } else {
                    preSum[i][j] = matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 < 0 || row1 >= m) return -1;
        if(row2 < 0 || row2 >= m) return -1;
        if(col1 < 0 || col1 >= n) return -1;
        if(col2 < 0 || col2 >= n) return -1;
        int ans = 0;

        for(int i = row1; i <= row2; i++){
            ans +=  preSum[i][col2] - (col1 > 0 ? preSum[i][col1 - 1] : 0 );
        }

        return ans; 
    }
}






















/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */