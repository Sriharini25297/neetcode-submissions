class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 && j==0)
                    ans[i][j] = grid[i][j];
                else if(i==0)
                    ans[i][j] = ans[i][j-1]+grid[i][j];
                else if(j==0)
                    ans[i][j] = ans[i-1][j]+grid[i][j];
                else
                    ans[i][j] = grid[i][j] + Math.min(ans[i-1][j],ans[i][j-1]);
            }
        }
        return ans[n-1][m-1];
    }
}