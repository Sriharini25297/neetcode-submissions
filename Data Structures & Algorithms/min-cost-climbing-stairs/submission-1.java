class Solution {
    int dp[];
    int startFrom(int cost[],int start,int n)
    {
        if(start >= n)
            return 0;
        if(dp[start]!=-1)
            return dp[start];
        return dp[start]=cost[start] + Math.min(startFrom(cost,start+1,n),startFrom(cost,start+2,n));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(startFrom(cost,0,n),startFrom(cost,1,n));
    }
}
