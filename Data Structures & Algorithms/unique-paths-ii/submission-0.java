class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        int n = o.length;
        int m = o[0].length;
        int ans[][] = new int[n][m];
        if(o[0][0] == 1 || o[n-1][m-1] == 1)
            return 0;
        int start=1;
        for(int i=0;i<m;i++){
            if(o[0][i] == 1)
            {
                start=0;
            }
            ans[0][i] = start;
        }
        start = 1;
        for(int i=0;i<n;i++)
        {
            if(o[i][0] == 1)
            {
                start=0;
            }
            ans[i][0] = start;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(o[i][j]!=1)
                {
                    ans[i][j] = ans[i-1][j]+ans[i][j-1];
                }
            }
        }
        return ans[n-1][m-1];
    }
}