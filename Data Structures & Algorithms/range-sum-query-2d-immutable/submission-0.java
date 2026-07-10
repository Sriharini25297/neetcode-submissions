class NumMatrix {
    int pref[][];
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        pref = new int[n][m];
        for(int j=0;j<m;j++)
        {
            for(int i=0;i<n;i++)
            {
                if(i==0)
                    pref[i][j] = matrix[i][j];
                else{
                    pref[i][j] = matrix[i][j] + pref[i-1][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if(row1 == 0)
        {
            for(int i=col1;i<=col2;i++)
                sum += pref[row2][i];
        }else{
            for(int i=col1;i<=col2;i++)
            {
                sum += (pref[row2][i] - pref[row1-1][i]);
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */